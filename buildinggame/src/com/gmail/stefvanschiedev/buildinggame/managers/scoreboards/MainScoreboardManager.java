package com.gmail.stefvanschiedev.buildinggame.managers.scoreboards;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.utils.scoreboards.MainScoreboard;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles the main socreboard for all players
 *
 * @since 3.1.1
 */
public final class MainScoreboardManager {

    /**
     * A collection of players who should currently have the main scoreboard
     */
	private final Collection<Player> players = new ArrayList<>();

	/**
     * An instance of the main scoreboard
     */
	private final MainScoreboard scoreboard = new MainScoreboard();

	/**
     * Returns the main scoreboard
     *
     * @return the main scoreboard
     * @since 3.1.1
     */
	@NotNull
	@Contract(pure = true)
    public MainScoreboard getScoreboard() {
		return scoreboard;
	}

	/**
     * Registers a new player. This player will get the main scoreboard once {@link #update()} is called.
     *
     * @param player the player to register
     * @since 3.1.1
     */
	public void register(Player player) {
		if (!players.contains(player))
			players.add(player);
	}

	/**
     * Removes a player. This player will not get the main scoreboard applied any more. The scoreboard isn't removed
     * however.
     *
     * @param player the player to remove
     * @since 3.1.1
     */
	public void remove(Player player) {
		players.remove(player);
	}

	/**
     * Updates the main scoreboard for all players
     *
     * @since 3.1.1
     */
	public void update() {
		for (Player player : players)
			scoreboard.update(player);
	}

	/**
     * Constructs a new MainScoreboardManager. This shouldn't be called to keep this class a singleton.
     */
	private MainScoreboardManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final MainScoreboardManager INSTANCE = new MainScoreboardManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 3.1.1
     */
	@NotNull
	@Contract(pure = true)
    public static MainScoreboardManager getInstance() {
		return INSTANCE;
	}
}