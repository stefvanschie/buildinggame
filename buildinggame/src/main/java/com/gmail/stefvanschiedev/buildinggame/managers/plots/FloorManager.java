package com.gmail.stefvanschiedev.buildinggame.managers.plots;

import com.gmail.stefvanschiedev.buildinggame.utils.Region;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

/**
 * This class handles all floors
 *
 * @since 2.1.0
 */
public final class FloorManager {

    /**
     * Creates a new FloorManager. This shouldn't be called to keep this class a singleton.
     */
	private FloorManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final FloorManager INSTANCE = new FloorManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static FloorManager getInstance() {
		return INSTANCE;
	}

	/**
     * Loads/Reloads all floors for all plots
     *
     * @since 2.1.0
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				try {
					plot.setFloor(new Region(Bukkit.getWorld(
					        arenas.getString(arena.getName() + '.' + plot.getID() + ".floor.high.world")),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.high.x"),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.high.y"),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.high.z"),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.low.x"),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.low.y"),
							arenas.getInt(arena.getName() + '.' + plot.getID() + ".floor.low.z")));

					if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
                        Logger logger = Main.getInstance().getLogger();

                        if (plot.getFloor().getWorld() == null)
                            logger.warning("Unable to load world for plot floor");

                        logger.info("Loaded floor for plot " + plot.getID() +
                            " in arena " + arena.getName());
                    }
				} catch (NullPointerException | IllegalArgumentException npe) {
					plot.setFloor(null);
				}
			}
		}
	}
}