package com.gmail.stefvanschiedev.buildinggame.managers.plots;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
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
        ArenaManager.getInstance().getArenas().forEach(arena -> {
            arena.getPlots().clear();

            SettingsManager.getInstance().getArenas().getConfigurationSection(arena.getName()).getKeys(false)
                .forEach(plot -> {
                    int id;

                    try {
                        id = Integer.parseInt(plot);
                    } catch (NumberFormatException e) {
                        return;
                    }

                    Plot p = new Plot(arena, id);
                    arena.addPlot(p);

                    if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
                        Main.getInstance().getLogger().info("Loaded plot " + p.getId() + " in arena " +
                            arena.getName());
                });
        });
	}
}