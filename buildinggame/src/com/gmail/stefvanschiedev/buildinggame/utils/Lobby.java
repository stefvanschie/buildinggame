package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.Location;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The lobby used to identify the spawn location of an arena
 */
public class Lobby {

    /**
     * The location
     */
	private final Location location;

    /**
     * Constructs a new Lobby
     *
     * @param location the location
     */
	public Lobby(Location location) {
		this.location = location;
	}

    /**
     * Returns the spawn location of the arena
     *
     * @return the spawn location
     */
    @NotNull
    @Contract(pure = true)
	public Location getLocation() {
		return location;
	}
}
