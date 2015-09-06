package me.stefvanschie.buildinggame.managers.plots;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.Boundary;
import me.stefvanschie.buildinggame.utils.Plot;

public class BoundaryManager {

	private BoundaryManager() {}
	
	private static BoundaryManager instance = new BoundaryManager();
	
	public static BoundaryManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				try {
					YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
					plot.setBoundary(new Boundary(Bukkit.getWorld(arenas.getString(arena.getName() + "." + plot.getID() + ".high.world")),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".high.x"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".high.y"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".high.z"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".low.x"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".low.y"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".low.z")));
				} catch (NullPointerException e) {
					plot.setBoundary(null);
				} catch (IllegalArgumentException iae) {
					plot.setBoundary(null);
				}
			}
		}
	}
}
