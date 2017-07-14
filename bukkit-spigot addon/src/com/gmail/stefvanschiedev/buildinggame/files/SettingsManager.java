package com.gmail.stefvanschiedev.buildinggame.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Handles all files and settings for this plugin
 *
 * @since 2.1.0
 */
public final class SettingsManager {

    /**
     * Private constructor to keep this class a singleton
     */
	private SettingsManager() {}

    /**
     * An instance of this class for the singleton pattern
     */
	private static final SettingsManager INSTANCE = new SettingsManager();

    /**
     * The config.yml file
     */
	private File configFile;

    /**
     * YAML configuration for the config.yml
     */
	private YamlConfiguration config;

    /**
     * The signs.yml file
     */
	private File signsFile;

    /**
     * YAML configuration for the signs.yml
     */
	private YamlConfiguration signs;

    /**
     * Loads and creates all files and folders and populates them
     *
     * @param p the plugin the load the files for
     * @since 2.1.0
     */
    @Contract("null -> fail")
	public void setup(Plugin p) {
		if (!p.getDataFolder().exists()) {
			if (!p.getDataFolder().mkdir())
				p.getLogger().warning("Unable to create data folder");
		}
		
		configFile = new File(p.getDataFolder(), "config.yml");
		signsFile = new File(p.getDataFolder(), "signs.yml");
		
		if (!configFile.exists()) {
			try {
				if (!configFile.createNewFile())
					p.getLogger().warning("Unable to create config file");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!signsFile.exists()) {
			try {
				if (!signsFile.createNewFile())
					p.getLogger().warning("Unable to create singns file");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		config = YamlConfiguration.loadConfiguration(configFile);
		signs = YamlConfiguration.loadConfiguration(signsFile);
		
		loadConfig();
	}

    /**
     * Saves all files
     *
     * @since 2.1.0
     */
	public void save() {
		try {
			config.save(configFile);
			signs.save(signsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * Returns the config.yml YAML configuration
     *
     * @return the YAML configuration
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
	public ConfigurationSection getConfig() {
		return config;
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
     * Populates the config.yml with its data
     *
     * @since 2.1.0
     */
	private void loadConfig() {
		InputStream defConfigStream = Main.getInstance().getResource("config.yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream));
			
			for (String key : defConfig.getKeys(true)) {
				if (!config.contains(key))
					config.set(key, defConfig.get(key));
			}
			
			save();
		}
	}

    /**
     * Returns an instance of this class for the singleton pattern
     *
     * @return an instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static SettingsManager getInstance() {
		return INSTANCE;
	}
}