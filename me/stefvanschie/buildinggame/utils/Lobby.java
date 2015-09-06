package me.stefvanschie.buildinggame.utils;

import org.bukkit.Location;

public class Lobby {

	private Location location;
	
	public Lobby(Location location) {
		this.location = location;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
}
