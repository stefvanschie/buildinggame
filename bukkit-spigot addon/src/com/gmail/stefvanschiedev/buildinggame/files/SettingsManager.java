package com.gmail.stefvanschiedev.buildinggame.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import com.gmail.stefvanschiedev.buildinggame.Main;

public class SettingsManager {

	private SettingsManager() {}
	
	private static final SettingsManager INSTANCE = new SettingsManager();
	
	private File configFile;
	private YamlConfiguration config;
	private File signsFile;
	private YamlConfiguration signs;
	
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
	
	public void save() {
		try {
			config.save(configFile);
			signs.save(signsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public YamlConfiguration getConfig() {
		return config;
	}
	
	public YamlConfiguration getSigns() {
		return signs;
	}
	
	@SuppressWarnings("deprecation")
	private void loadConfig() {
		InputStream defConfigStream = Main.getInstance().getResource("config.yml");
		if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			
			for (String key : defConfig.getKeys(true)) {
				if (!config.contains(key))
					config.set(key, defConfig.get(key));
			}
			
			save();
		}
	}
	
	public static SettingsManager getInstance() {
		return INSTANCE;
	}
}