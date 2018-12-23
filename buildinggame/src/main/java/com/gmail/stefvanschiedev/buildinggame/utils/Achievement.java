package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

/**
 * An achievement which can be achieved upon getting a certain amount of a statistic
 *
 * @since 6.3.0
 */
public final class Achievement {

    /**
     * The stat type to check for
     */
    @NotNull
    private final StatType statType;

    /**
     * The amount of times this stat has need to be gotten in order to receive the achievement
     */
    private final int amountRequired;

    /**
     * The message to send to the player when the achievement has been reached.
     */
    @NotNull
    private final String message;

    /**
     * A set of all achievements currently registered
     */
    @NotNull
    private static final Collection<Achievement> ACHIEVEMENTS = new HashSet<>();

    /**
     * Creates a new achievement
     *
     * @param statType the stat type, see {@link #statType}
     * @param amountRequired the amount required, see {@link #amountRequired}
     * @param message the message, see {@link #message}
     * @since 6.3.0
     */
    private Achievement(@NotNull StatType statType, int amountRequired, @NotNull String message) {
        this.statType = statType;
        this.amountRequired = amountRequired;
        this.message = message;
    }

    /**
     * Checks whether a stat has met the required conditions for being able to achieve this achievement.
     *
     * @param stat the stat to check the conditions for
     * @return true if the stat has met the conditions, false otherwise
     * @since 6.3.0
     */
    public boolean checkConditions(@Nullable StatType type, @Nullable Stat stat) {
        return stat != null && type == this.statType && stat.getValue() >= amountRequired;
    }

    /**
     * Grant a player this achievement. No checks will be made to validate whether this player actually has earned this
     * achievement.
     *
     * @param player the player to grant this achievement
     * @since 6.3.0
     */
    public void grant(@NotNull Player player) {
        player.sendMessage(MessageManager.translate(message, player));
    }

    /**
     * Loads all achievements from the config.yml
     *
     * @since 6.3.0
     */
    public static void loadAchievements() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        config.getConfigurationSection("achievements").getKeys(false).forEach(achievementSection -> {
            StatType statType = StatType.valueOf(
                config.getString("achievements." + achievementSection + ".stat").toUpperCase(Locale.getDefault())
            );
            int amountRequired = config.getInt("achievements." + achievementSection + ".amount-required");
            String message = config.getString("achievements." + achievementSection + ".message");

            ACHIEVEMENTS.add(new Achievement(statType, amountRequired, message));
        });
    }

    /**
     * Returns an immutable collection of all achievements with the same {@link StatType} as specified.
     *
     * @param type the type of the achievement
     * @return all achievements with the given type
     * @since 6.3.0
     */
    @NotNull
    @Contract(pure = true)
    public static Collection<Achievement> getAchievements(StatType type) {
        return ACHIEVEMENTS.stream()
            .filter(achievement -> achievement.statType == type)
            .collect(Collectors.toUnmodifiableSet());
    }
}
