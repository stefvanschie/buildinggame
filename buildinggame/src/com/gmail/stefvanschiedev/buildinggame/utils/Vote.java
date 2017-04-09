package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.entity.Player;

public class Vote {

	private final int points;
	private final Player sender;
	
	public Vote(int points, Player sender) {
		this.points = points;
		this.sender = sender;
	}
	
	public int getPoints() {
		return points;
	}
	
	public Player getSender() {
		return sender;
	}
}