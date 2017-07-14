package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;

/**
 * This handles the win time
 *
 * @since 2.1.0
 */
public class WinTimer extends Timer {

    /**
     * The arena this timer belongs to
     */
	private final Arena arena;

	/**
     * Whether this timer is running or not
     */
	private boolean running;

	/**
     * The amount of seconds left
     */
	private int seconds;

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
		this.arena = arena;
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
			for (String key : config.getConfigurationSection("timings.win-timer.at").getKeys(false)) {
                if (seconds == Integer.parseInt(key)) {
                    for (String command : config.getStringList("timings.win-timer.at." + Integer.parseInt(key)))
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
                }
			}
			for (String key : config.getConfigurationSection("timings.win-timer.every").getKeys(false)) {
                if (seconds % Integer.parseInt(key) == 0) {
                    for (String command : config.getStringList("timings.win-timer.every." + Integer.parseInt(key)))
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
                }
			}
		} catch (NullPointerException | NumberFormatException e) {}
		seconds--;
	}

	/**
     * Returns the amount of seconds left
     *
     * @return the amount of seconds
     */
	@Contract(pure = true)
	@Override
	public int getSeconds() {
		return seconds;
	}

	/**
     * Rturns whether this timer is running or not
     *
     * @return true if this timer is active, otherwise false
     */
	@Contract(pure = true)
	public boolean isActive() {
		return running;
	}
}