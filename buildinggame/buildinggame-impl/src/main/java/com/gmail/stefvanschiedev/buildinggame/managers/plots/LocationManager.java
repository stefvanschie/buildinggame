package com.gmail.stefvanschiedev.buildinggame.managers.plots;

import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialLocation;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles the locations
 *
 * @since 2.1.0
 */
public final class LocationManager {

    /**
     * Creates a new LocationManager. This shouldn't be called to keep this class a singleton.
     */
	private LocationManager() {}

    /**
     * An instance of this class for the singleton principle
     */
	private static final LocationManager INSTANCE = new LocationManager();

    /**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static LocationManager getInstance() {
		return INSTANCE;
	}

    /**
     * Loads/Reloads all locations for all plots
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

                if (!arenas.contains(arenaName + '.' + plotId)) {
                    return;
                }

                ConfigurationSection plotSection = arenas.getConfigurationSection(arenaName + '.' + plotId);

                plot.setLocation(new PotentialLocation(() -> Bukkit.getWorld(
                    plotSection.getString("world")),
                    plotSection.getInt("x"),
                    plotSection.getInt("y"),
                    plotSection.getInt("z"),
                    (float) plotSection.getDouble("yaw", 0),
                    (float) plotSection.getDouble("pitch", 0)));

                if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
                    var logger = Main.getInstance().getLogger();

                    logger.info("Loaded spawn for plot " + plotId + " in arena " + arenaName);
                }
			})
		);
	}
	
}