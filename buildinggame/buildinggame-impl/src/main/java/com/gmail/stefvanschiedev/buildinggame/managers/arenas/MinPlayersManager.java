package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles the minimum players for arenas
 *
 * @since 2.1.0
 */
public final class MinPlayersManager {

    /**
     * Constructs a new MinPlayersManager. This shouldn't be called to keep this class a singleton.
     */
	private MinPlayersManager() {}

    /**
     * An instance of this class for the singleton principle
     */
	private static final MinPlayersManager INSTANCE = new MinPlayersManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     */
	@NotNull
	@Contract(pure = true)
    public static MinPlayersManager getInstance() {
		return INSTANCE;
	}

	/**
     * Loads/Reloads all minimum players for all arenas
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

		for (var arena : ArenaManager.getInstance().getArenas()) {
            var name = arena.getName();
            arena.setMinPlayers(arenas.getInt(name + ".minplayers", 0));

            if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
                Main.getInstance().getLogger().info("Loaded min players for " + name);
		}
	}
}