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
     * The type of statistic this is
     */
	private final StatType type;

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
     * @param type the type of statistic this is
     * @param player the player who has this statistic
     * @param value the statistic value
     */
	public Stat(StatType type, OfflinePlayer player, int value) {
		this.type = type;
		this.player = player;
		this.value = value;
	}

	/**
     * Returns the statistic type
     *
     * @return the stat type
     */
	@NotNull
	@Contract(pure = true)
	public StatType getType() {
		return type;
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