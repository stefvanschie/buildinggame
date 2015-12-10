package me.stefvanschie.buildinggame.managers.plots;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.plot.Floor;
import me.stefvanschie.buildinggame.utils.plot.Plot;

public class FloorManager {

	private FloorManager() {}
	
	private static FloorManager instance = new FloorManager();
	
	public static FloorManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				try {
					YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
					plot.setFloor(new Floor(Bukkit.getWorld(arenas.getString(arena.getName() + "." + plot.getID() + ".floor.high.world")),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".floor.high.x"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".floor.high.y"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".floor.high.z"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".floor.low.x"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".floor.low.y"),
							arenas.getInt(arena.getName() + "." + plot.getID() + ".floor.low.z")));
					if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
						Main.getInstance().getLogger().info("Loaded floor for plot " + plot.getID() + " in arena " + arena.getName());
					}
				} catch (NullPointerException npe) {
					plot.setFloor(null);
				} catch (IllegalArgumentException iae) {
					plot.setFloor(null);
				}
			}
		}
	}
}