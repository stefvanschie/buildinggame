package com.gmail.stefvanschiedev.buildinggame.managers.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

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
     * Loads/Reloads all files and YAML configurations
     *
     * @param p the main class
     * @param save whether the files should be saved after loading
     * @since 2.1.0
     */
	@Contract("null, _ -> fail")
	public void setup(Plugin p, boolean save) {
		if (!p.getDataFolder().exists()) {
            if (!p.getDataFolder().mkdir())
                p.getLogger().warning("Unable to create data folder");
        }
		arenasFile = new File(p.getDataFolder(), "arenas.yml");
		configFile = new File(p.getDataFolder(), "config.yml");
		messagesFile = new File(p.getDataFolder(), "messages.yml");
		signsFile = new File(p.getDataFolder(), "signs.yml");
		statsFile = new File(p.getDataFolder(), "stats.yml");
		
		arenas = YamlConfiguration.loadConfiguration(arenasFile);
		config = YamlConfiguration.loadConfiguration(configFile);
		messages = YamlConfiguration.loadConfiguration(messagesFile);
		signs = YamlConfiguration.loadConfiguration(signsFile);
		stats = YamlConfiguration.loadConfiguration(statsFile);
		if (!arenasFile.exists()) {
			try {
				if (!arenasFile.createNewFile())
				    p.getLogger().warning("Unable to create arenas file");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!configFile.exists()) {
			try {
				if (!configFile.createNewFile())
				    p.getLogger().warning("Unable to create config file");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!messagesFile.exists()) {
			try {
				if (!messagesFile.createNewFile())
				    p.getLogger().warning("Unable to create messages file");

				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		if (!signsFile.exists()) {
			try {
				if (!signsFile.createNewFile())
				    p.getLogger().warning("Unable to create signs file");

				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		if (!statsFile.exists()) {
			try {
				if (!statsFile.createNewFile())
				    p.getLogger().warning("Unable to create stats file");

				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		generateSettings(save);
		generateMessages(save);
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
	@SuppressWarnings("deprecation")
	private void generateSettings(boolean save) {
		int settings = 0;
		int addedSettings = 0;
		int removedSettings = 0;
		
		InputStream defConfigStream = Main.getInstance().getResource("config.yml");
        if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			
			for (String string : defConfig.getKeys(true)) {
				if (!config.contains(string)) {
					config.set(string, defConfig.get(string));
					if (config.getBoolean("debug"))
						addedSettings++;
				}
				
				if (config.getBoolean("debug")) {
					if (!config.isConfigurationSection(string))
						settings++;
				}
			}
			if (config.getBoolean("clean-files")) {
				for (String string : config.getKeys(true)) {
					if (!defConfig.contains(string)) {
						if (config.getBoolean("debug") && !config.isConfigurationSection(string))
							removedSettings++;
						config.set(string, null);
					}
				}
			}
        }
        if (config.getBoolean("debug")) {
        	Main.getInstance().getLogger().info("Found " + settings + " settings");
        	Main.getInstance().getLogger().info("Added " + addedSettings + " new settings");
        	Main.getInstance().getLogger().info("Removed " + removedSettings + " old settings");
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
	@SuppressWarnings("deprecation")
	private void generateMessages(boolean save) {
		int settings = 0;
		int addedSettings = 0;
		int removedSettings = 0;
		
		InputStream defMessagesStream = Main.getInstance().getResource("messages.yml");
        if (defMessagesStream != null) {
			YamlConfiguration defMessages = YamlConfiguration.loadConfiguration(defMessagesStream);
			
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
				
				if (config.getBoolean("debug")) {
					if (!config.isConfigurationSection(string))
						settings++;
				}
			}
			
			if (config.getBoolean("clean-files")) {
				for (String string : messages.getKeys(true)) {
					if (!defMessages.contains(string)) {
						if (config.getBoolean("debug") && !messages.isConfigurationSection(string))
							removedSettings++;
						messages.set(string, null);
					}
				}
			}
        }
        if (config.getBoolean("debug")) {
        	Main.getInstance().getLogger().info("Found " + settings + " settings");
        	Main.getInstance().getLogger().info("Added " + addedSettings + " new settings");
        	Main.getInstance().getLogger().info("Removed " + removedSettings + " old settings");
        }
        
        if (save)
        	save();
	}
}