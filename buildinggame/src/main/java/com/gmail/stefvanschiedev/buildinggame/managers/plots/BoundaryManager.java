package com.gmail.stefvanschiedev.buildinggame.managers.plots;

import com.gmail.stefvanschiedev.buildinggame.utils.Region;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles the boundaries
 *
 * @since 2.1.0
 */
public final class BoundaryManager {

    /**
     * Constructs a new BoundaryManager. This shouldn't be called to keep this class a singleton.
     */
	private BoundaryManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final BoundaryManager INSTANCE = new BoundaryManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static BoundaryManager getInstance() {
		return INSTANCE;
	}

	/**
     * Loads/Reloads all boundaries for all plots
     *
     * @since 2.1.0
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

		ArenaManager.getInstance().getArenas().forEach(arena ->
			arena.getPlots().forEach(plot -> {
				try {
					plot.setBoundary(new Region(Bukkit.getWorld(
					        arenas.getString(arena.getName() + '.' + plot.getId() + ".high.world")),
							arenas.getInt(arena.getName() + '.' + plot.getId() + ".high.x"),
							arenas.getInt(arena.getName() + '.' + plot.getId() + ".high.y"),
							arenas.getInt(arena.getName() + '.' + plot.getId() + ".high.z"),
							arenas.getInt(arena.getName() + '.' + plot.getId() + ".low.x"),
							arenas.getInt(arena.getName() + '.' + plot.getId() + ".low.y"),
							arenas.getInt(arena.getName() + '.' + plot.getId() + ".low.z")));

					if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
                        var logger = Main.getInstance().getLogger();

                        if (plot.getBoundary().getWorld() == null)
                            logger.warning("Unable to load world for plot boundary");

                        logger.info("Loaded boundary for plot " + plot.getId() +
                            " in arena " + arena.getName());
                    }
				} catch (NullPointerException | IllegalArgumentException e) {
					plot.setBoundary(null);
				}
			})
		);
	}
}