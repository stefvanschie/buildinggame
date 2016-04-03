package com.gmail.stefvanschiedev.buildinggame.utils.stats;

import org.bukkit.entity.Player;

public class Stat {

	private StatType type;
	private Player player;
	private int value;
	
	public Stat(StatType type, Player player, int value) {
		this.type = type;
		this.player = player;
		this.value = value;
	}
	
	public StatType getType() {
		return type;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public int getValue() {
		return value;
	}
}