package me.stefvanschie.buildinggame.managers.mainspawn;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class MainSpawnManager {

	private MainSpawnManager() {}
	
	private static MainSpawnManager instance = new MainSpawnManager();
	
	public static MainSpawnManager getInstance() {
		return instance;
	}
	
	private Location mainSpawn;
	
	public void setup() {
		mainSpawn = null;
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		try {
			setMainSpawn(new Location(Bukkit.getWorld(arenas.getString("main-spawn.world")),
					arenas.getInt("main-spawn.x"),
					arenas.getInt("main-spawn.y"),
					arenas.getInt("main-spawn.z")));
		} catch (NullPointerException e) {
			setMainSpawn(null);
		} catch (IllegalArgumentException iae) {
			setMainSpawn(null);
		}
	}

	public Location getMainSpawn() {
		return mainSpawn;
	}

	public void setMainSpawn(Location mainSpawn) {
		this.mainSpawn = mainSpawn;
	}
	
}
