package com.gmail.stefvanschiedev.buildinggame.utils.nms;

import org.jetbrains.annotations.NotNull;

/**
 * An exception indicating that the provided version is not supported.
 *
 * @since 12.1.0
 */
public class UnsupportedVersionException extends RuntimeException {

    /**
     * Constructs the exception with a given message.
     *
     * @param message the message to show
     * @since 12.1.0
     */
    public UnsupportedVersionException(@NotNull String message) {
        super(message);
    }
}
