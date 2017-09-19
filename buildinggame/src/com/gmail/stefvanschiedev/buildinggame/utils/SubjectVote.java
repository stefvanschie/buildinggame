package com.gmail.stefvanschiedev.buildinggame.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a vote on a specific subject
 *
 * @since 2.1.0
 */
public class SubjectVote {

    /**
     * The subject this class keeps track of
     */
    private final String subject;

    /**
     * The amount of votes this subject has had
     */
	private int votes;

    /**
     * A collection of players who voted on this subject
     */
	private final Collection<Player> players = new ArrayList<>();

    /**
     * Creates a new SubjectVote with the given amount of votes
     *
     * @param votes the starting amount of votes
     */
	public SubjectVote(String subject, int votes) {
	    this.subject = subject;
		this.votes = votes;
	}

    /**
     * Adds a player to the collection of voters
     *
     * @param player the player who voted
     * @since 2.1.0
     */
	public void addPlayer(Player player) {
		players.add(player);
	}

    /**
     * Returns the amount of votes the subject has
     *
     * @return the amount of votes
     * @since 2.1.0
     */
    @Contract(pure = true)
	public int getVotes() {
		return votes;
	}

    /**
     * Returns a collection of the players who voted
     *
     * @return all players who voted on the subject
     * @since 4.0.6
     */
    @NotNull
    @Contract(pure = true)
	public Collection<Player> getPlayers() {
		return players;
	}

    /**
     * Returns the subject this class is keeping track of
     *
     * @return the subject
     * @since 5.2.0
     */
	@NotNull
    @Contract(pure = true)
	public String getSubject() {
        return subject;
    }

    /**
     * Removes a player from the collection of voters
     *
     * @param player the player to remove
     * @since 2.1.0
     */
	public void removePlayer(Player player) {
		players.remove(player);
	}

    /**
     * Sets the new amount of votes for the subject
     *
     * @param votes the new amount of votes
     * @since 2.1.0
     */
	public void setVotes(int votes) {
		this.votes = votes;
	}
}