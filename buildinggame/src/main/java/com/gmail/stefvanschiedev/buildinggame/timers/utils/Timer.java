package com.gmail.stefvanschiedev.buildinggame.timers.utils;

import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Contract;

/**
 * The base timer class used to time events with precision of a second
 *
 * @since 2.1.0
 */
public abstract class Timer extends BukkitRunnable {

    /**
     * Amount of seconds this timer has left
     */
    protected int seconds;

    /**
     * Whether this timer is active or not
     */
    protected boolean running;

    /**
     * The arena this timer belongs to
     */
    protected final Arena arena;

    /**
     * Constructs a new {@link Timer} with the given Arena.
     *
     * @param arena the arena
     * @since 6.2.0
     */
    protected Timer(Arena arena) {
        this.arena = arena;
    }

    /**
     * Returns the amount of seconds left
     *
     * @return seconds left
     * @since 2.1.0
     */
    @Contract(pure = true)
	public int getSeconds() {
        return seconds;
    }

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

    /**
     * Returns whether this timer is running or not
     *
     * @return true if this timer is running, false otherwise
     * @since 2.1.0
     */
    @Contract(pure = true)
    public boolean isActive() {
        return running;
    }
	
}
