package com.gmail.stefvanschiedev.buildinggame.managers.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import com.gmail.stefvanschiedev.buildinggame.timers.FileCheckerTimer;
import org.bukkit.Bukkit;
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
     * Saves all files
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