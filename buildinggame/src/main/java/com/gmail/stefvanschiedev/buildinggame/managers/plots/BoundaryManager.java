package com.gmail.stefvanschiedev.buildinggame.managers.plots;

import com.gmail.stefvanschiedev.buildinggame.utils.region.RegionFactory;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

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
                    String arenaName = arena.getName();
                    int plotId = plot.getId();

                    String worldName = arenas.getString(arenaName + '.' + plotId + ".high.world");
                    Supplier<World> worldSupplier = () -> Bukkit.getWorld(worldName);
                    int highX = arenas.getInt(arenaName + '.' + plotId + ".high.x");
                    int highY = arenas.getInt(arenaName + '.' + plotId + ".high.y");
                    int highZ = arenas.getInt(arenaName + '.' + plotId + ".high.z");
                    int lowX = arenas.getInt(arenaName + '.' + plotId + ".low.x");
                    int lowY = arenas.getInt(arenaName + '.' + plotId + ".low.y");
                    int lowZ = arenas.getInt(arenaName + '.' + plotId + ".low.z");

                    plot.setBoundary(RegionFactory.createRegion(worldSupplier, highX, highY, highZ, lowX, lowY, lowZ));

					if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
                        var logger = Main.getInstance().getLogger();

                        logger.info("Loaded boundary for plot " + plotId + " in arena " + arenaName);
                    }
				} catch (NullPointerException | IllegalArgumentException e) {
					plot.setBoundary(null);
				}
			})
		);
	}
}