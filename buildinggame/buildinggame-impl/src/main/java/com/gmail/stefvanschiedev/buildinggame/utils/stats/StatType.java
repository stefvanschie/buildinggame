package com.gmail.stefvanschiedev.buildinggame.utils.stats;

import org.bukkit.configuration.file.YamlConfiguration;
import org.checkerframework.checker.units.qual.C;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents the different statistic types that can be used
 *
 * @since 2.2.0
 */
public enum StatType {

    /**
     * Keeps track of the amount of played games
     *
     * @since 2.2.0
     */
	PLAYS {
	    @Contract(pure = true)
	    @Override
        public boolean isEnabled(@NotNull YamlConfiguration config) {
	        return config.getBoolean("stats.enable.plays");
        }
    },

    /**
     * Keeps track of the amount of first places
     *
     * @since 2.2.0
     */
    FIRST {
        @Contract(pure = true)
        @Override
        public boolean isEnabled(@NotNull YamlConfiguration config) {
            return config.getBoolean("stats.enable.first");
        }
    },

    /**
     * Keeps track of the amount of second places
     *
     * @since 2.2.0
     */
	SECOND {
        @Contract(pure = true)
        @Override
        public boolean isEnabled(@NotNull YamlConfiguration config) {
            return config.getBoolean("stats.enable.second");
        }
    },

    /**
     * Keeps track of the amount of third places
     *
     * @since 2.2.0
     */
	THIRD {
        @Contract(pure = true)
        @Override
        public boolean isEnabled(@NotNull YamlConfiguration config) {
            return config.getBoolean("stats.enable.third");
        }
    },

    /**
     * Keeps track of the amount of broken blocks
     *
     * @since 2.2.0
     */
	BROKEN {
        @Contract(pure = true)
        @Override
        public boolean isEnabled(@NotNull YamlConfiguration config) {
            return config.getBoolean("stats.enable.broken");
        }
    },

    /**
     * Keeps track of the amount of placed blocks
     *
     * @since 2.2.0
     */
	PLACED {
        @Contract(pure = true)
        @Override
        public boolean isEnabled(@NotNull YamlConfiguration config) {
            return config.getBoolean("stats.enable.placed");
        }
    },

    /**
     * Keeps track of the amount of blocks walked
     *
     * @since 2.2.0
     */
	WALKED {
        @Contract(pure = true)
        @Override
        public boolean isEnabled(@NotNull YamlConfiguration config) {
            return config.getBoolean("stats.enable.walked");
        }
    },

    /**
     * Keeps track of the amount of points received
     *
     * @since 5.4.3
     */
    POINTS_RECEIVED {
        @Contract(pure = true)
        @Override
        public boolean isEnabled(@NotNull YamlConfiguration config) {
            return config.getBoolean("stats.enable.points-received");
        }
    },

    /**
     * Keeps track of the amount of points given
     *
     * @since 5.4.3
     */
    POINTS_GIVEN {
        @Contract(pure = true)
        @Override
        public boolean isEnabled(@NotNull YamlConfiguration config) {
            return config.getBoolean("stats.enable.points-given");
        }
    };

    /**
     * Checks whether this stat type is enabled.
     *
     * @param config the config.yml configuration
     * @return true if the stat is enabled, false otherwise
     * @since 8.0.1
     */
    @Contract(pure = true)
    public abstract boolean isEnabled(@NotNull YamlConfiguration config);
	
}