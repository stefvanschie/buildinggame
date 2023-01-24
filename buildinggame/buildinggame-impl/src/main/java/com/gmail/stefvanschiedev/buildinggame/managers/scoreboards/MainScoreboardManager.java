package com.gmail.stefvanschiedev.buildinggame.managers.scoreboards;

import java.util.Collection;
import java.util.HashSet;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.Bukkit;
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
	private final Collection<MainScoreboard> scoreboards = new HashSet<>();

	/**
     * Registers a new player. This player will get the main scoreboard once {@link #update()} is called.
     *
     * @param player the player to register
     * @since 3.1.1
     */
	public void register(Player player) {
	    if (scoreboards.stream().anyMatch(scoreboard -> scoreboard.getPlayer().equals(player)))
	        return;

        scoreboards.add(new MainScoreboard(player));
	}

	/**
     * Removes a player. This player will not get the main scoreboard applied any more. The scoreboard isn't removed
     * however.
     *
     * @param player the player to remove
     * @since 3.1.1
     */
	public void remove(Player player) {
        scoreboards.removeIf(mainScoreboard -> mainScoreboard.getPlayer().equals(player));
	}

	/**
     * Updates the main scoreboard for all players
     *
     * @since 3.1.1
     */
	public void update() {
        Collection<MainScoreboard> scheduledForRemoval = new HashSet<>();

        for (MainScoreboard scoreboard : this.scoreboards) {
            if (!scoreboard.isRegistered()) {
                scheduledForRemoval.add(scoreboard);
                scoreboard.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());

                Main.getInstance().getLogger().warning(
                    "Scoreboard for '" + scoreboard.getPlayer().getName() + "' was unexpectedly unregistered, " +
                        "they will temporarily be unable to see a scoreboard."
                );

                continue;
            }

            scoreboard.show();
        }

        this.scoreboards.removeAll(scheduledForRemoval);
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