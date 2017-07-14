package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.BuildTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles all build timers
 *
 * @since 2.3.0
 */
public final class BuildTimerManager {

    /**
     * Loads/Reloads all build timers for all arenas
     *
     * @since 2.3.0
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arenas.contains(arena.getName() + ".timer"))
				arenas.set(arena.getName() + ".timer", config.getInt("timer"));
			
			arena.setBuildTimer(new BuildTimer(arenas.getInt(arena.getName() + ".timer"), arena));
		}
	}

	/**
     * Constructs a new BuildTimerManager. This shouldn't be called to keep this class a singleton.
     */
	private BuildTimerManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final BuildTimerManager INSTANCE = new BuildTimerManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.3.0
     */
	@NotNull
	@Contract(pure = true)
    public static BuildTimerManager getInstance() {
		return INSTANCE;
	}
}