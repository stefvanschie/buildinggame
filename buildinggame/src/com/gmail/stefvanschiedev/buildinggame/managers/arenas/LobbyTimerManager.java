package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.WaitTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
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
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arenas.contains(arena.getName() + ".lobby-timer"))
				arenas.set(arena.getName() + ".lobby-timer", config.getInt("waittimer"));
			
			arena.setWaitTimer(new WaitTimer(arenas.getInt(arena.getName() + ".lobby-timer"), arena));
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