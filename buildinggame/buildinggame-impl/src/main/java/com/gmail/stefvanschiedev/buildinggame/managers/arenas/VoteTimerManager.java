package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.VoteTimer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles all vote timers
 *
 * @since 2.3.0
 */
public final class VoteTimerManager {

    /**
     * Loads/Reloads all vote timers for all arenas
     *
     * @since 2.3.0
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		ArenaManager.getInstance().getArenas().forEach(arena -> {
            String name = arena.getName();

            if (!arenas.contains(name + ".vote-timer"))
				arenas.set(name + ".vote-timer", config.getInt("timers.vote"));
			
			arena.setVoteTimer(new VoteTimer(arenas.getInt(name + ".vote-timer"), arena));
		});
	}

	/**
     * Constructs a new VoteTimerManager. This shouldn't be called to keep this class a singleton.
     */
	private VoteTimerManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final VoteTimerManager INSTANCE = new VoteTimerManager();

	/**
     * Returns an instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.3.0
     */
	@NotNull
	@Contract(pure = true)
    public static VoteTimerManager getInstance() {
		return INSTANCE;
	}
}