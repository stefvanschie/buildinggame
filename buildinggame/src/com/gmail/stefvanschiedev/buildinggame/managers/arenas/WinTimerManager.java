package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.WinTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles all win timers
 *
 * @since 2.3.0
 */
public final class WinTimerManager {

    /**
     * Loads/Reloads all win timers for all arenas
     *
     * @since 2.3.0
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arenas.contains(arena.getName() + ".win-timer"))
				arenas.set(arena.getName() + ".win-timer", config.getInt("wintimer"));
			
			arena.setWinTimer(new WinTimer(arenas.getInt(arena.getName() + ".win-timer"), arena));
		}
	}

	/**
     * Constructs a new WinTimerManager. This shouldn't be called to keep this class a singleton.
     */
	private WinTimerManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final WinTimerManager INSTANCE = new WinTimerManager();

	/**
     * Returns an instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.3.0
     */
	@NotNull
	@Contract(pure = true)
    public static WinTimerManager getInstance() {
		return INSTANCE;
	}
}