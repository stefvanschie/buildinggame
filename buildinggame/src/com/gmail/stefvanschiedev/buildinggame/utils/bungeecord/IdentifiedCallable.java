package com.gmail.stefvanschiedev.buildinggame.utils.bungeecord;

import java.util.UUID;

/**
 * Class which has a UUID assigned to it and is used to call code after receiving bungee messages
 */
public abstract class IdentifiedCallable {

    private final UUID uuid;

    protected IdentifiedCallable() {
        this.uuid = UUID.randomUUID();
    }

    UUID getUuid() {
        return uuid;
    }

    public abstract void call(String response);
}
