package com.gmail.stefvanschiedev.buildinggame.managers.plots;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class LocationManager {

	private LocationManager() {}
	
	private static LocationManager instance = new LocationManager();
	
	public static LocationManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

				try {
					plot.setLocation(new Location(Bukkit.getWorld(arenas.getString(arena.getName() + "." + plot.getID() + ".world")),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".x"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".y"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".z")));
					if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
						Main.getInstance().getLogger().info("Loaded spawn for plot " + plot.getID() + " in arena " + arena.getName());
					}
				} catch (NullPointerException npe) {
					plot.setLocation(null);
				} catch (IllegalArgumentException iae) {
					plot.setLocation(null);
				}
			}
		}
	}
	
}