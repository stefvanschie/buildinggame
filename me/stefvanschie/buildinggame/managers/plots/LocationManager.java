package me.stefvanschie.buildinggame.managers.plots;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.Plot;

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
				} catch (NullPointerException npe) {
					plot.setLocation(null);
				} catch (IllegalArgumentException iae) {
					plot.setLocation(null);
				}
			}
		}
	}
	
}
