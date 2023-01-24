package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.BuildTimer;
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
		
		for (var arena : ArenaManager.getInstance().getArenas()) {
            var name = arena.getName();

            if (!arenas.contains(name + ".timer"))
				arenas.set(name + ".timer", config.getInt("timers.build"));
			
			arena.setBuildTimer(new BuildTimer(arenas.getInt(name + ".timer"), arena));
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