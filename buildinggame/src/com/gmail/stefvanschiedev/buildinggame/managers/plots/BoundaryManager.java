package com.gmail.stefvanschiedev.buildinggame.managers.plots;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Boundary;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class BoundaryManager {

	private BoundaryManager() {}
	
	private static final BoundaryManager INSTANCE = new BoundaryManager();
	
	public static BoundaryManager getInstance() {
		return INSTANCE;
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
					if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
						Main.getInstance().getLogger().info("Loaded boundary for plot " + plot.getID() + " in arena " + arena.getName());
					}
				} catch (NullPointerException | IllegalArgumentException e) {
					plot.setBoundary(null);
				}
			}
		}
	}
}