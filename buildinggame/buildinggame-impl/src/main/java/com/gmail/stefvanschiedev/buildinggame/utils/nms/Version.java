package com.gmail.stefvanschiedev.buildinggame.utils.nms;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The supported versions
 *
 * @since 12.1.0
 */
public enum Version {

    /**
     * Version 1.20.0
     *
     * @since 12.4.0
     */
    V1_20_0,

    /**
     * Version 1.20.1
     *
     * @since 12.4.0
     */
    V1_20_1,

    /**
     * Version 1.20.2
     *
     * @since 12.5.0
     */
    V1_20_2,

    /**
     * Version 1.20.3
     *
     * @since 12.5.0
     */
    V1_20_3,

    /**
     * Version 1.20.4
     *
     * @since 12.5.0
     */
    V1_20_4,

    /**
     * Version 1.20.5
     *
     * @since 12.5.0
     */
    V1_20_5,

    /**
     * Version 1.20.6
     *
     * @since 12.5.0
     */
    V1_20_6,

    /**
     * Version 1.21.0 - 1.21.1
     *
     * @since 12.5.0
     */
    V1_21_0_1,

    /**
     * Version 1.21.2 - 1.21.3
     *
     * @since 12.8.0
     */
    V1_21_2_3,

    /**
     * Version 1.21.4.
     *
     * @since 12.9.0
     */
    V1_21_4,

    /**
     * Version 1.21.5.
     *
     * @since 12.10.0
     */
    V1_21_5,

    /**
     * Version 1.21.6 - 1.21.8.
     *
     * @since 12.12.0
     */
    V1_21_6_8,

    /**
     * Version 1.21.9 - 1.21.10.
     *
     * @since 13.1.0
     */
    V1_21_9_10,

    /**
     * Version 1.21.11.
     *
     * @since 14.0.0
     */
    V1_21_11;

    /**
     * Checks whether the Minecraft version is the provided version or newer.
     *
     * @param version the version
     * @return true if this version is at least the given version, false otherwise
     * @since 12.5.0
     */
    public boolean isAtLeast(Version version) {
        return ordinal() >= version.ordinal();
    }

    /**
     * Gets the version the server is currently running, or throws an {@link UnsupportedVersionException} when the
     * version the server is running is not supported.
     *
     * @return the server's version
     * @since 12.1.0
     */
    @NotNull
    @Contract(pure = true)
    public static Version getVersion() {
        String version = Bukkit.getBukkitVersion().split("-")[0];

        return switch (version) {
            case "1.20" -> V1_20_0;
            case "1.20.1" -> V1_20_1;
            case "1.20.2" -> V1_20_2;
            case "1.20.3" -> V1_20_3;
            case "1.20.4" -> V1_20_4;
            case "1.20.5" -> V1_20_5;
            case "1.20.6" -> V1_20_6;
            case "1.21", "1.21.1" -> V1_21_0_1;
            case "1.21.2", "1.21.3" -> V1_21_2_3;
            case "1.21.4" -> V1_21_4;
            case "1.21.5" -> V1_21_5;
            case "1.21.6", "1.21.7", "1.21.8" -> V1_21_6_8;
            case "1.21.9", "1.21.10" -> V1_21_9_10;
            case "1.21.11" -> V1_21_11;
            default -> throw new UnsupportedVersionException("This server's version is not supported");
        };
    }
}
