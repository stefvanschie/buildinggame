package com.gmail.stefvanschiedev.buildinggame.managers.mainspawn;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

public final class MainSpawnManager {

	private MainSpawnManager() {}
	
	private static final MainSpawnManager INSTANCE = new MainSpawnManager();
	
	public static MainSpawnManager getInstance() {
		return INSTANCE;
	}
	
	private Location mainSpawn;
	private String server;
	
	public void setup() {
		mainSpawn = null;
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		try {
			if (!arenas.contains("main-spawn.server")) {
				arenas.set("main-spawn.server", Bukkit.getServer().getServerName());
				SettingsManager.getInstance().save();
			}
			
			setMainSpawn(new Location(Bukkit.getWorld(arenas.getString("main-spawn.world")),
					arenas.getInt("main-spawn.x"),
					arenas.getInt("main-spawn.y"),
					arenas.getInt("main-spawn.z")));
			
			setServer(arenas.getString("main-spawn.server"));
			if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
				Main.getInstance().getLogger().info("Loaded main spawn");
			}
		} catch (NullPointerException | IllegalArgumentException e) {
			setMainSpawn(null);
		}
	}

	public Location getMainSpawn() {
		return mainSpawn;
	}

	public String getServer() {
		return server;
	}
	
	public void setMainSpawn(Location mainSpawn) {
		this.mainSpawn = mainSpawn;
	}
	
	private void setServer(String server) {
		this.server = server;
	}
}