package com.gmail.stefvanschiedev.buildinggame.managers.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import com.gmail.stefvanschiedev.buildinggame.Main;

public class SettingsManager {

	private SettingsManager() {}
	
	private static SettingsManager instance = new SettingsManager();
	
	public static SettingsManager getInstance() {
		return instance;
	}
	
	private YamlConfiguration arenas;
	private File arenasFile;
	private YamlConfiguration config;
	private File configFile;
	private YamlConfiguration messages;
	private File messagesFile;
	private YamlConfiguration signs;
	private File signsFile;
	private YamlConfiguration stats;
	private File statsFile;
	
	public void setup(Plugin p, boolean save) {
		if (!p.getDataFolder().exists())
			p.getDataFolder().mkdir();
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
				arenasFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!configFile.exists()) {
			try {
				configFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (!messagesFile.exists()) {
			try {
				messagesFile.createNewFile();
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
		if (!signsFile.exists()) {
			try {
				signsFile.createNewFile();
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		if (!statsFile.exists()) {
			try {
				statsFile.createNewFile();
				save();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		generateSettings(save);
		generateMessages(save);
	}
	
	public YamlConfiguration getArenas() {
		return arenas;
	}
	
	public YamlConfiguration getConfig() {
		return config;
	}
	
	public YamlConfiguration getMessages() {
		return messages;
	}
	
	public YamlConfiguration getSigns() {
		return signs;
	}
	
	public YamlConfiguration getStats() {
		return stats;
	}
	
	public void save() {
		try {
			arenas.save(arenasFile);
			config.save(configFile);
			messages.save(messagesFile);
			signs.save(signsFile);
			stats.save(statsFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void generateSettings(boolean save) {
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
	
	@SuppressWarnings("deprecation")
	public void generateMessages(boolean save) {
		int settings = 0;
		int addedSettings = 0;
		int removedSettings = 0;
		
		InputStream defMessagesStream = Main.getInstance().getResource("messages.yml");
        if (defMessagesStream != null) {
			YamlConfiguration defMessages = YamlConfiguration.loadConfiguration(defMessagesStream);
			
			for (String string : defMessages.getKeys(true)) {
				if (messages.isString(string) && defMessages.isList(string)) {
					List<String> list = new ArrayList<String>();
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
