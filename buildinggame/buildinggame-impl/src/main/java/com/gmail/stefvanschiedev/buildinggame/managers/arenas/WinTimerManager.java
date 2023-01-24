package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.WinTimer;
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

		ArenaManager.getInstance().getArenas().forEach(arena -> {
            String name = arena.getName();

            if (!arenas.contains(name + ".win-timer"))
				arenas.set(name + ".win-timer", config.getInt("timers.win"));
			
			arena.setWinTimer(new WinTimer(arenas.getInt(name + ".win-timer"), arena));
		});
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