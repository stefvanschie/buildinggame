package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

/**
 * A wrapper class for {@link Team} for which it is safe to get the team name, even when the
 * underlying team has been unregistered.
 *
 * @since 12.1.0
 */
public class SafeTeam {

    /**
     * The underlying team for which this object is a wrapper.
     */
    @NotNull
    private final Team team;

    /**
     * The name of the team.
     */
    @NotNull
    private final String name;

    /**
     * Creates a wrapper for the specified {@link Team} object. This team must be registered when calling this
     * constructor; it may be safely unregistered afterwards.
     *
     * @param team the team to wrap
     * @since 12.1.0
     */
    SafeTeam(@NotNull Team team) {
        this.team = team;
        this.name = team.getName();
    }

    /**
     * Gets the underlying team object. Operations on this object may not be safe if it has been unregistered.
     *
     * @return the wrapped team
     * @since 12.1.0
     */
    @NotNull
    public Team getTeam() {
        return this.team;
    }

    /**
     * Gets the name of this team. This will always be possible, even if the underlying team has been unregistered.
     *
     * @return the team's name
     * @since 12.1.0
     */
    @NotNull
    public String getName() {
        return this.name;
    }
}
