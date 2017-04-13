package com.gmail.stefvanschiedev.buildinggame.managers.plots;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Floor;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public final class FloorManager {

	private FloorManager() {}
	
	private static final FloorManager INSTANCE = new FloorManager();
	
	public static FloorManager getInstance() {
		return INSTANCE;
	}
	
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				try {
					YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
					plot.setFloor(new Floor(Bukkit.getWorld(arenas.getString(arena.getName() + '.' + plot.getID() + ".floor.high.world")),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.high.x"),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.high.y"),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.high.z"),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.low.x"),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.low.y"),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.low.z")));
					if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
						Main.getInstance().getLogger().info("Loaded floor for plot " + plot.getID() + " in arena " + arena.getName());
					}
				} catch (NullPointerException | IllegalArgumentException npe) {
					plot.setFloor(null);
				}
			}
		}
	}
}