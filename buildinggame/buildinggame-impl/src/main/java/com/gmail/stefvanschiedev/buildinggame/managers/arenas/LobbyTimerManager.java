package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.LobbyTimer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles all lobby timers
 *
 * @since 2.3.0
 */
public final class LobbyTimerManager {

    /**
     * Loads/Reloads all lobby timers for all arenas
     *
     * @since 2.3.0
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (var arena : ArenaManager.getInstance().getArenas()) {
            var name = arena.getName();

            if (!arenas.contains(name + ".lobby-timer"))
				arenas.set(name + ".lobby-timer", config.getInt("timers.lobby"));
			
			arena.setLobbyTimer(new LobbyTimer(arenas.getInt(name + ".lobby-timer"), arena));
		}
	}

	/**
     * Constructs a new LobbyTimerManager. This shouldn't be called to keep this class a singleton.
     */
	private LobbyTimerManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final LobbyTimerManager INSTANCE = new LobbyTimerManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.3.0
     */
	@NotNull
	@Contract(pure = true)
    public static LobbyTimerManager getInstance() {
		return INSTANCE;
	}
}