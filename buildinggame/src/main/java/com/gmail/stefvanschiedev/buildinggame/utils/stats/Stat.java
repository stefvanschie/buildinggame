package com.gmail.stefvanschiedev.buildinggame.utils.stats;

import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a statistic
 *
 * @since 2.2.0
 */
public class Stat {

	/**
     * The player who has this statistic
     */
	private final OfflinePlayer player;

	/**
     * The statistic value
     */
	private final int value;

	/**
     * Constructs a new statistic for the given type, player and value
     *
     * @param player the player who has this statistic
     * @param value the statistic value
     */
	public Stat(OfflinePlayer player, int value) {
		this.player = player;
		this.value = value;
	}

	/**
     * Returns the offline player
     *
     * @return the player
     */
	@NotNull
	@Contract(pure = true)
	public OfflinePlayer getPlayer() {
		return player;
	}

	/**
     * Returns the statistic value
     *
     * @return the stat value
     */
	@Contract(pure = true)
	public int getValue() {
		return value;
	}
}