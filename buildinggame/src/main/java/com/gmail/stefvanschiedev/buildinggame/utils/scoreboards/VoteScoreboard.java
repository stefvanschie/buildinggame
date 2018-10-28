package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import java.util.List;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * The scoreboard displayed when the arena is in voting phase
 *
 * @since 2.1.0
 */
public class VoteScoreboard extends ArenaScoreboard {

    /**
     * Constructs a new VoteScoreboard
     *
     * @param arena the arena this scoreboard belongs to
     */
	public VoteScoreboard(Arena arena) {
		super(arena);
	}

	/**
     * Sets the score for the specified text to the amount of points
     *
     * @param name the name of the player
     * @param points the ne amount of points
     * @since 2.1.0
     */
	public void setScore(String name, int points) {
		objective.getScore(name).setScore(points);
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public void show(Player player) {
		if (SettingsManager.getInstance().getConfig().getBoolean("scoreboards.vote.text"))
		    super.show(player);
		else
		    player.setScoreboard(scoreboard);
	}

    /**
     * {@inheritDoc}
     */
    @Nls
    @NotNull
    @Contract(pure = true)
    @Override
    public String getHeader() {
        return MessageManager.translate(SettingsManager.getInstance().getMessages()
                .getString("scoreboards.vote.header"));
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Contract(pure = true)
    @Override
    public List<String> getLines() {
        return SettingsManager.getInstance().getMessages().getStringList("scoreboards.vote.text");
    }
}