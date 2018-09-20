package com.gmail.stefvanschiedev.buildinggame.managers.files;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.logging.Logger;

import com.gmail.stefvanschiedev.buildinggame.timers.FileCheckerTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.JsonReaderUtil;
import com.gmail.stefvanschiedev.buildinggame.utils.TopStatHologram;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.InstanceCreator;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class handles all settings in all files
 *
 * @since 2.1.0
 */
public final class SettingsManager {

    /**
     * Constructs a new SettingsManager. This shouldn't be called to keep this class a singleton.
     */
	private SettingsManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final SettingsManager INSTANCE = new SettingsManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this singleton class
     */
	@NotNull
	@Contract(pure = true)
    public static SettingsManager getInstance() {
		return INSTANCE;
	}

	/**
     * The arenas.yml YAML configuration
     */
	private YamlConfiguration arenas;

	/**
     * The arenas.yml file
     */
	private File arenasFile;

	/**
     * The config.yml YAML configuration
     */
	private YamlConfiguration config;

    /**
     * The config.yml file
     */
	private File configFile;

	/**
     * The messages.yml YAML configuration
     */
	private YamlConfiguration messages;

	/**
     * The messages.yml file
     */
	private File messagesFile;

	/**
     * The signs.yml YAML configuration
     */
	private YamlConfiguration signs;

	/**
     * The signs.yml file
     */
	private File signsFile;

	/**
     * The stats.yml YAML configuration
     */
	private YamlConfiguration stats;

	/**
     * The stats.yml file
     */
	private File statsFile;

    /**
     * The schematics folder, may not yet be created when schematics.enable is false or the
     * {@link #setup(Plugin, boolean)} hasn't been called yet
     */
	private File schematicsFolder;

    /**
     * The file for storing holograms, may be null if the file does not yet exist
     */
    @Nullable
	private File hologramsFile;

    /**
     * The runnable used for managing the watch service
     */
	private FileCheckerTimer runnable;

    /**
     * A map containing the previous location of a key/value pair in the config.yml and the new location
     */
	private static final Map<String, String> RELOCATED_SETTINGS_LOCATIONS = new HashMap<>();

	/**
     * Loads/Reloads all files and YAML configurations
     *
     * @param p the main class
     * @param save whether the files should be saved after loading
     * @since 2.1.0
     */
	@Contract("null, _ -> fail")
	public void setup(Plugin p, boolean save) {
        File dataFolder = p.getDataFolder();
        Logger logger = p.getLogger();

        if (!dataFolder.exists()) {
            if (!dataFolder.mkdir())
                logger.warning("Unable to create data folder");
        }

        schematicsFolder = new File(dataFolder, "schematics");

		arenasFile = new File(dataFolder, "arenas.yml");
		configFile = new File(dataFolder, "config.yml");
		messagesFile = new File(dataFolder, "messages.yml");
		signsFile = new File(dataFolder, "signs.yml");
		statsFile = new File(dataFolder, "stats.yml");
        hologramsFile = new File(dataFolder, "holograms.json");

		arenas = YamlConfiguration.loadConfiguration(arenasFile);
		config = YamlConfiguration.loadConfiguration(configFile);
		messages = YamlConfiguration.loadConfiguration(messagesFile);
		signs = YamlConfiguration.loadConfiguration(signsFile);
		stats = YamlConfiguration.loadConfiguration(statsFile);

        if (!arenasFile.exists()) {
			try {
				if (!arenasFile.createNewFile())
				    logger.warning("Unable to create arenas file");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!configFile.exists()) {
			try {
				if (!configFile.createNewFile())
				    logger.warning("Unable to create config file");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!messagesFile.exists()) {
			try {
				if (!messagesFile.createNewFile())
				    logger.warning("Unable to create messages file");

				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		if (!signsFile.exists()) {
			try {
				if (!signsFile.createNewFile())
				    logger.warning("Unable to create signs file");

				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		if (!statsFile.exists()) {
			try {
				if (!statsFile.createNewFile())
				    logger.warning("Unable to create stats file");

				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		if (hologramsFile.exists()) {
            try {
                JsonReader jsonReader = new Gson().newJsonReader(new InputStreamReader(new FileInputStream(hologramsFile)));

                jsonReader.beginArray();

                while (jsonReader.hasNext())
                    TopStatHologram.load(jsonReader);

                jsonReader.endArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

		if (!schematicsFolder.exists() && config.getBoolean("schematics.enable") &&
            Bukkit.getPluginManager().isPluginEnabled("WorldEdit") && !schematicsFolder.mkdirs())
		    logger.warning("Unable to create schematics folder");

		generateSettings(save);
		generateMessages(save);

		if (runnable != null)
		    return;

        runnable = new FileCheckerTimer();
        runnable.runTaskTimerAsynchronously(p, 20L, 20L);
    }

    /**
     * Refreshes the config.yml file
     *
     * @since 5.8.4
     */
    public void refreshConfig() {
        config = YamlConfiguration.loadConfiguration(configFile);
        generateSettings(false);
    }

    /**
     * Refreshes the messages.yml file
     *
     * @since 5.8.4
     */
    public void refreshMessages() {
        messages = YamlConfiguration.loadConfiguration(messagesFile);
        generateMessages(false);
    }

	/**
     * Returns the arenas.yml YAML configuration
     *
     * @return the YAML configuration
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public YamlConfiguration getArenas() {
		return arenas;
	}

	/**
     * Returns the config.yml YAML configuration
     *
     * @return the YAML configuration
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public YamlConfiguration getConfig() {
		return config;
	}

	/**
     * Returns the messages.yml YAML configuration
     *
     * @return the YAML configuration
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public YamlConfiguration getMessages() {
		return messages;
	}

	/**
     * Returns the signs.yml YAML configuration
     *
     * @return the YAML configuration
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public YamlConfiguration getSigns() {
		return signs;
	}

	/**
     * Returns the stats.yml YAML configuration
     *
     * @return the YAML configuration
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public YamlConfiguration getStats() {
		return stats;
	}

    /**
     * Returns the schematic folder. The folder may not exist when either {@link #setup(Plugin, boolean)} hasn't been
     * run yet or when schematics.enable is false in the config.yml.
     *
     * @return the schematics folder
     * @since 5.5.0
     */
	@NotNull
    @Contract(pure = true)
    public File getSchematicsFolder() {
	    return schematicsFolder;
    }

    /**
     * Returns the runnable which is currently listening for file changes
     *
     * @return the runnable
     * @since 5.8.4
     */
    @Nullable
    @Contract(pure = true)
    public FileCheckerTimer getRunnable() {
	    return runnable;
    }

	/**
     * Saves all files. The holograms.json will be saved async when it exists.
     *
     * @since 2.1.0
     */
	public void save() {
        try {
            arenas.save(arenasFile);
            config.save(configFile);
            messages.save(messagesFile);
            signs.save(signsFile);
            stats.save(statsFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //we use a thread instead of a bukkitrunnable, because this method may be called when the plugin is disabling
        new Thread(() -> {
            try {
                if (!hologramsFile.exists() && !hologramsFile.createNewFile()) {
                    Main.getInstance().getLogger().warning("Unable to create holograms file");
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try (JsonWriter writer = new JsonWriter(new OutputStreamWriter(new FileOutputStream(hologramsFile)))) {
                writer.beginArray();

                TopStatHologram.getHolograms().forEach(hologram -> {
                    try {
                        writer.jsonValue(
                            new GsonBuilder().excludeFieldsWithoutExposeAnnotation().registerTypeAdapter(Location.class, new TypeAdapter<Location>() {
                                @Override
                                public void write(JsonWriter jsonWriter, Location location) throws IOException {
                                    jsonWriter
                                        .beginObject()
                                        .name("world").value(location.getWorld().getName())
                                        .name("x").value(location.getX())
                                        .name("y").value(location.getY())
                                        .name("z").value(location.getZ())
                                        .name("yaw").value(location.getYaw())
                                        .name("pitch").value(location.getPitch())
                                        .endObject();
                                }

                                @Override
                                public Location read(JsonReader jsonReader) throws IOException {
                                    return JsonReaderUtil.parseLocation(jsonReader);
                                }
                            }).create().toJson(hologram)
                        );
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

                writer.endArray();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

	/**
     * Compares the config.yml with the default config.yml and adds, removes and modifies key/value pairs when needed
     *
     * @param save whether all files should be saved when this execution is done
     * @since 2.1.0
     */
	private void generateSettings(boolean save) {
        //relocate settings
        RELOCATED_SETTINGS_LOCATIONS.forEach((originalKey, newKey) -> {
            //ignore already adjusted settings
            if (config.contains(newKey))
                return;

            config.set(newKey, config.get(originalKey));
            config.set(originalKey, null);
        });

		int settings = 0;
		int addedSettings = 0;
		
		InputStream defConfigStream = Main.getInstance().getResource("config.yml");

        if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream));
			
			for (String string : defConfig.getKeys(true)) {
				if (!config.contains(string)) {
					config.set(string, defConfig.get(string));

					if (config.getBoolean("debug"))
						addedSettings++;
				}
				
				if (config.getBoolean("debug") && !config.isConfigurationSection(string))
				    settings++;
			}
        }

        if (config.getBoolean("debug")) {
            Logger logger = Main.getInstance().getLogger();

            logger.info("Found " + settings + " settings");
        	logger.info("Added " + addedSettings + " new settings");
        }
        
        if (save)
        	save();
	}

    /**
     * Compares the messages.yml with the default messages.yml and adds, removes and modifies key/value pairs when
     * needed
     *
     * @param save whether all files should be saved when this execution is done
     * @since 2.1.0
     */
	private void generateMessages(boolean save) {
		int settings = 0;
		int addedSettings = 0;
		
		InputStream defMessagesStream = Main.getInstance().getResource("messages.yml");

        if (defMessagesStream != null) {
			YamlConfiguration defMessages = YamlConfiguration.loadConfiguration(new InputStreamReader(defMessagesStream));
			
			for (String string : defMessages.getKeys(true)) {
				if (messages.isString(string) && defMessages.isList(string)) {
					Collection<String> list = new ArrayList<>();
					list.add(messages.getString(string));
					messages.set(string, list);
				}

				if (!messages.contains(string)) {
					messages.set(string, defMessages.get(string));

					if (config.getBoolean("debug"))
						addedSettings++;
				}
				
				if (config.getBoolean("debug") && !config.isConfigurationSection(string))
                    settings++;
			}
        }

        if (config.getBoolean("debug")) {
            Logger logger = Main.getInstance().getLogger();

            logger.info("Found " + settings + " settings");
        	logger.info("Added " + addedSettings + " new settings");
        }
        
        if (save)
        	save();
	}

    static {
        RELOCATED_SETTINGS_LOCATIONS.put("timer", "timers.build");
        RELOCATED_SETTINGS_LOCATIONS.put("waittimer", "timers.lobby");
        RELOCATED_SETTINGS_LOCATIONS.put("votetimer", "timers.vote");
        RELOCATED_SETTINGS_LOCATIONS.put("wintimer", "timers.win");
        RELOCATED_SETTINGS_LOCATIONS.put("title.fade_in", "title.fade-in");
        RELOCATED_SETTINGS_LOCATIONS.put("title.fade_out", "title.fade-out");
        RELOCATED_SETTINGS_LOCATIONS.put("title.syncronize", "title.synchronize");
    }
}