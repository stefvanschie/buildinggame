package com.gmail.stefvanschiedev.buildinggame.utils.bungeecord;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

/**
 * Class which has a UUID assigned to it and is used to call code after receiving bungee messages
 *
 * @since 4.0.6
 */
public abstract class IdentifiedCallable {

    /**
     * A uuid to keep track of this class
     */
    private final UUID uuid;

    /**
     * Constructs a new identified callable
     */
    protected IdentifiedCallable() {
        this.uuid = UUID.randomUUID();
    }

    /**
     * Returns the uuid assigned to this class instancer
     *
     * @return the uuid assigned to this instance
     * @since 4.0.6
     */
    @NotNull
    UUID getUuid() {
        return uuid;
    }

    /**
     * Method which gets called whenever there is a response from the other server
     *
     * @param response the response of the server
     */
    public abstract void call(String response);
}
