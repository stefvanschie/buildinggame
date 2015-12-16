package me.stefvanschie.buildinggame.managers.plots;

import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.plot.Plot;

public class PlotManager {

	private PlotManager() {}
	
	private static PlotManager instance = new PlotManager();
	
	public static PlotManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			arena.getPlots().clear();
			for (String plot : SettingsManager.getInstance().getArenas().getConfigurationSection(arena.getName()).getKeys(false)) {
				try {
					Integer.parseInt(plot);
				} catch (NumberFormatException e) {
					continue;
				}
				
				Plot p = new Plot(Integer.parseInt(plot));
				arena.addPlot(p);
				p.setArena(arena);
				if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
					Main.getInstance().getLogger().info("Loaded plot " + p.getID() + " in arena " + arena.getName());
				}
			}
		}
	}
}