package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import org.bukkit.scoreboard.Scoreboard;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * A utility class for scoreboards.
 *
 * @since 12.1.0
 */
final class ScoreboardUtil {

    /**
     * An empty, private constructor to prevent creation of this class.
     *
     * @since 12.1.0
     */
    private ScoreboardUtil() {}

    /**
     * Checks to see whether this scoreboard is still registered internally.
     *
     * @param scoreboard the scoreboard to check
     * @param teams the teams to check if they are registered to this scoreboard
     * @return true if this scoreboard is registered, false otherwise
     * @since 12.1.0
     */
    @Contract(pure = true)
    static boolean isRegistered(@NotNull Scoreboard scoreboard, @NotNull Iterable<? extends SafeTeam> teams) {
        for (SafeTeam team : teams) {
            if (scoreboard.getTeam(team.getName()) == null) {
                return false;
            }
        }

        return true;
    }
}
