package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a vote on a plot
 *
 * @since 2.1.0
 */
public class Vote {

    /**
     * The points given with this vote
     */
	private final int points;

    /**
     * The player who gave the vote
     */
	private final Player sender;

    /**
     * Constructs a new vote
     *
     * @param points the amount of points given with this vote
     * @param sender the player who gave the vote
     */
	public Vote(int points, Player sender) {
		this.points = points;
		this.sender = sender;
	}

    /**
     * Returns the amount of points given with this vote
     *
     * @return the amount of points
     * @since 2.1.0
     */
    @Contract(pure = true)
	public int getPoints() {
		return points;
	}

    /**
     * Returns the player who gave this vote
     *
     * @return the player
     * @since 2.1.0
     */
    @NotNull
    @Contract(pure = true)
	public Player getSender() {
		return sender;
	}
}