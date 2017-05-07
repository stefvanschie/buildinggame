package com.gmail.stefvanschiedev.buildinggame.utils;

import java.util.UUID;

/**
 * Class which has a UUID assigned to it and is used to call code after receiving bungee messages
 */
public abstract class IdentifiedCallable {

    private final UUID uuid;

    public IdentifiedCallable() {
        this.uuid = UUID.randomUUID();
    }

    public UUID getUuid() {
        return uuid;
    }

    public abstract void call(String response);
}
