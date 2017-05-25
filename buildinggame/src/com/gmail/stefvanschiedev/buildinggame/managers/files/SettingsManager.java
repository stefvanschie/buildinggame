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

public final class SettingsManager {

	private SettingsManager() {}
	
	private static final SettingsManager INSTANCE = new SettingsManager();
	
	@Contract(pure = true)
    public static SettingsManager getInstance() {
		return INSTANCE;
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
	
	@Contract(pure = true)
    public YamlConfiguration getArenas() {
		return arenas;
	}
	
	@Contract(pure = true)
    public YamlConfiguration getConfig() {
		return config;
	}
	
	@Contract(pure = true)
    public YamlConfiguration getMessages() {
		return messages;
	}
	
	@Contract(pure = true)
    public YamlConfiguration getSigns() {
		return signs;
	}
	
	@Contract(pure = true)
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