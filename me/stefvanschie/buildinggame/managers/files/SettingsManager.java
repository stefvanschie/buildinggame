package me.stefvanschie.buildinggame.managers.files;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import me.stefvanschie.buildinggame.Main;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

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
	
	public void setup(Plugin p) {
		if (!p.getDataFolder().exists())
			p.getDataFolder().mkdir();
		arenasFile = new File(p.getDataFolder(), "arenas.yml");
		configFile = new File(p.getDataFolder(), "config.yml");
		messagesFile = new File(p.getDataFolder(), "messages.yml");
		signsFile = new File(p.getDataFolder(), "signs.yml");
		
		arenas = YamlConfiguration.loadConfiguration(arenasFile);
		config = YamlConfiguration.loadConfiguration(configFile);
		messages = YamlConfiguration.loadConfiguration(messagesFile);
		signs = YamlConfiguration.loadConfiguration(signsFile);
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
				generateMessages();
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
		generateSettings();
		generateMessages();
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
	
	public void save() {
		try {
			arenas.save(arenasFile);
			config.save(configFile);
			messages.save(messagesFile);
			signs.save(signsFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public void generateSettings() {
		InputStream defConfigStream = Main.getInstance().getResource("config.yml");
        if (defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			
			for (String string : defConfig.getKeys(true)) {
				if (!config.contains(string)) {
					config.set(string, defConfig.get(string));
				}
			}
			if (config.getBoolean("clean-files")) {
				for (String string : config.getKeys(true)) {
					if (!defConfig.contains(string)) {
						config.set(string, null);
					}
				}
			}
        }
        save();
	}
	
	@SuppressWarnings("deprecation")
	public void generateMessages() {
		InputStream defMessagesStream = Main.getInstance().getResource("messages.yml");
        if (defMessagesStream != null) {
			YamlConfiguration defMessages = YamlConfiguration.loadConfiguration(defMessagesStream);
			
			for (String string : defMessages.getKeys(true)) {
				if (!messages.contains(string)) {
					messages.set(string, defMessages.get(string));
				}
			}
			if (config.getBoolean("clean-files")) {
				for (String string : messages.getKeys(true)) {
					if (!defMessages.contains(string)) {
						messages.set(string, null);
					}
				}
			}
        }
        save();
	}
}
