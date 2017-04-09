package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.Location;

public class Lobby {

	private final Location location;
	
	public Lobby(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return location;
	}
}
