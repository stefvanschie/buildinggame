package com.gmail.stefvanschiedev.buildinggame.timers.utils;

import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Contract;

/**
 * The base timer class used to time events with precision of a second
 *
 * @since 2.1.0
 */
public abstract class Timer extends BukkitRunnable {

    /**
     * Returns the amount of seconds left
     *
     * @return seconds left
     * @since 2.1.0
     */
    @Contract(pure = true)
	public abstract int getSeconds();

	/**
     * Returns the amount of seconds until we're back at full minutes.
     * So for 150 seconds (2:30) it would return 30.
     *
     * @return the amount of seconds away from full minutes
     * @since 2.1.0
     */
	@Contract(pure = true)
	public int getSecondsFromMinute() {
		return (getSeconds() - getMinutes() * 60);
	}

	/**
     * Returns the amount of full minutes left
     *
     * @return the amount of minutes left
     * @since 2.1.0
     */
	@Contract(pure = true)
	public int getMinutes() {
		return getSeconds() / 60;
	}
	
}
