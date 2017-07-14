package com.gmail.stefvanschiedev.buildinggame.managers.plots;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles all plots
 */
public final class PlotManager {

    /**
     * Constructs a new PlotManager. This shouldn't be called to keep this class singleton.
     */
	private PlotManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final PlotManager INSTANCE = new PlotManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this singleton class
     */
	@NotNull
	@Contract(pure = true)
    public static PlotManager getInstance() {
		return INSTANCE;
	}

	/**
     * Loads/Reloads all plots
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			arena.getPlots().clear();
			for (String plot : SettingsManager.getInstance().getArenas().getConfigurationSection(arena.getName()).getKeys(false)) {
				int id;

				try {
					id = Integer.parseInt(plot);
				} catch (NumberFormatException e) {
					continue;
				}
				
				Plot p = new Plot(id);
				arena.addPlot(p);
				p.setArena(arena);
				if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
					Main.getInstance().getLogger().info("Loaded plot " + p.getID() + " in arena " + arena.getName());
				}
			}
		}
	}
}