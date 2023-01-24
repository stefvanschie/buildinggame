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
     * Version 1.19.0
     *
     * @since 12.1.0
     */
    V1_19_0,

    /**
     * Version 1.19.1
     *
     * @since 12.1.0
     */
    V1_19_1,

    /**
     * Version 1.19.2
     *
     * @since 12.1.0
     */
    V1_19_2,

    /**
     * Version 1.19.3
     *
     * @since 12.1.0
     */
    V1_19_3;

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

        switch (version) {
            case "1.19":
                return V1_19_0;
            case "1.19.1":
                return V1_19_1;
            case "1.19.2":
                return V1_19_2;
            case "1.19.3":
                return V1_19_3;
            default:
                throw new UnsupportedVersionException("This server's version is not supported");
        }
    }
}
