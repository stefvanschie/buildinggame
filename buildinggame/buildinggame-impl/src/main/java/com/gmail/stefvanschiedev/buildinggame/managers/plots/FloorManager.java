package com.gmail.stefvanschiedev.buildinggame.managers.plots;

import com.gmail.stefvanschiedev.buildinggame.utils.region.RegionFactory;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;
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

		ArenaManager.getInstance().getArenas().forEach(arena ->
			arena.getPlots().forEach(plot -> {
                String arenaName = arena.getName();
                int plotId = plot.getId();

                ConfigurationSection plotSection = arenas.getConfigurationSection(arenaName + '.' + plotId);

                if (!plotSection.contains("floor.high") || !plotSection.contains("floor.low")) {
                    return;
                }

                ConfigurationSection floorSection = plotSection.getConfigurationSection("floor");

                String worldName = floorSection.getString("high.world");
                Supplier<World> worldSupplier = () -> Bukkit.getWorld(worldName);
                int highX = floorSection.getInt("high.x");
                int highY = floorSection.getInt("high.y");
                int highZ = floorSection.getInt("high.z");
                int lowX = floorSection.getInt("low.x");
                int lowY = floorSection.getInt("low.y");
                int lowZ = floorSection.getInt("low.z");

                plot.setFloor(RegionFactory.createRegion(worldSupplier, highX, highY, highZ, lowX, lowY, lowZ));

                if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
                    Logger logger = Main.getInstance().getLogger();

                    logger.info("Loaded floor for plot " + plotId + " in arena " + arenaName);
                }
			})
		);
	}
}