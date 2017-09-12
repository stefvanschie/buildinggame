package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * The base class for all scoreboards that belong to an arena
 *
 * @since 5.0.6
 */
public abstract class ArenaScoreboard {

    /**
     * The global scoreboard manager
     */
    private final ScoreboardManager manager = Bukkit.getScoreboardManager();

    /**
     * The scoreboard this class is a wrapper for
     */
    final Scoreboard scoreboard = manager.getNewScoreboard();

    /**
     * The objective used for this scoreboard
     */
    final Objective objective = scoreboard.registerNewObjective("bg-build", "dummy");

    /**
     * The arena this scoreboard belongs to
     */
    final Arena arena;

    /**
     * A list of the text to display on the scoreboard after the basic placeholders have been parsed
     */
    final List<String> strings = new ArrayList<>();

    /**
     * A list of teams that's used to hold the text
     */
    final List<Team> teams = new ArrayList<>();

    /**
     * Constructs a new arena scoreboard
     *
     * @param arena the arena this scoreboard belongs to
     */
    ArenaScoreboard(Arena arena) {
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(getHeader());

        this.arena = arena;

        List<String> strings = getLines();

        for (int i = 0; i < strings.size(); i++) {
            Team team = scoreboard.registerNewTeam(i + "");
            team.addEntry(ChatColor.values()[i].toString());
            team.setDisplayName("");

            teams.add(team);
            this.strings.add(MessageManager.translate(strings.get(i)));
        }
    }

    /**
     * Updates/Shows the scoreboard for the specified player
     *
     * @param player the player to show the scoreboard to
     * @since 5.0.6
     */
    public abstract void show(Player player);

    /**
     * Returns the header of this scoreboard
     *
     * @return the header
     * @since 5.0.6
     */
    @Nls
    @NotNull
    @Contract(pure = true)
    protected abstract String getHeader();

    /**
     * Returns a list of all displayed lines
     *
     * @return a list of lines
     * @since 5.0.6
     */
    @NotNull
    @Contract(pure = true)
    protected abstract List<String> getLines();
}