package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.utils.CommandUtil;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

/**
 * This handles the win time
 *
 * @since 2.1.0
 */
public class WinTimer extends Timer {

	/**
     * The config.yml YAML configuration
     */
	private final YamlConfiguration config = SettingsManager.getInstance().getConfig();

	/**
     * Constructs a new WinTimer with the given amount of seconds
     *
     * @param seconds the amount of time
     * @param arena the arena this timer belongs to
     */
	public WinTimer(int seconds, Arena arena) {
	    super(arena);

		this.seconds = seconds;
	}

	/**
     * Called whenever a second has passed
     *
     * @since 2.1.0
     */
	@Override
	public void run() {
		if (!isActive())
			running = true;
		if (seconds <= 0) {
			arena.nextMatch();
			running = false;
			this.cancel();
			return;
		}
		//timings
		try {
            config.getConfigurationSection("timings.win-timer.at").getKeys(false).forEach(key -> {
                if (seconds == Integer.parseInt(key)) {
                    config.getStringList("timings.win-timer.at." + Integer.parseInt(key)).forEach(command ->
                        CommandUtil.dispatch(command.replace("%arena%", arena.getName())));
                }
            });
            config.getConfigurationSection("timings.win-timer.every").getKeys(false).forEach(key -> {
                if (seconds % Integer.parseInt(key) == 0) {
                    config.getStringList("timings.win-timer.every." + Integer.parseInt(key)).forEach(command ->
                        CommandUtil.dispatch(command.replace("%arena%", arena.getName())));
                }
            });
		} catch (NullPointerException | NumberFormatException ignore) {}
		seconds--;
	}
}