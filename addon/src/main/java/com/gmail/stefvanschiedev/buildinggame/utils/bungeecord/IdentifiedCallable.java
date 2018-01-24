package com.gmail.stefvanschiedev.buildinggame.utils.bungeecord;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Class which has a UUID assigned to it and is used to call code after receiving bungee messages
 *
 * @since 4.0.6
 */
public abstract class IdentifiedCallable {

    /**
     * The UUID given to this callable
     */
    private final UUID uuid;

    /**
     * Constructs a new Identified Callable, which will assign a random UUID
     */
    protected IdentifiedCallable() {
        this.uuid = UUID.randomUUID();
    }

    /**
     * Returns the UUID that belongs to this class instance
     *
     * @return the UUID
     * @since 4.0.6
     */
    @NotNull
    @Contract(pure = true)
    UUID getUuid() {
        return uuid;
    }

    /**
     * Called whenever there is a response from a different server
     *
     * @param response the response received
     * @since 4.0.6
     */
    public abstract void call(String response);
}
