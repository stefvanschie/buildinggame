package me.stefvanschie.buildinggame.utils;

import org.bukkit.entity.Player;

public class Vote {

	private int points;
	private Player sender;
	
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
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void setSender(Player sender) {
		this.sender = sender;
	}
}
