package me.stefvanschie.buildinggame.managers.plots;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.plot.Plot;

public class PlotManager {

	private PlotManager() {}
	
	private static PlotManager instance = new PlotManager();
	
	public static PlotManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (String plot : SettingsManager.getInstance().getArenas().getConfigurationSection(arena.getName()).getKeys(false)) {
				try {
					Integer.parseInt(plot);
				} catch (NumberFormatException e) {
					continue;
				}
				Plot p = new Plot(Integer.parseInt(plot));
				arena.addPlot(p);
				p.setArena(arena);
			}
		}
	}
}
