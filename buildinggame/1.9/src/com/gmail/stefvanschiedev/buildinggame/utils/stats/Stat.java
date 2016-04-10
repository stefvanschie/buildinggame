package com.gmail.stefvanschiedev.buildinggame.utils.stats;

import org.bukkit.OfflinePlayer;

public class Stat {

	private StatType type;
	private OfflinePlayer player;
	private int value;
	
	public Stat(StatType type, OfflinePlayer player, int value) {
		this.type = type;
		this.player = player;
		this.value = value;
	}
	
	public StatType getType() {
		return type;
	}
	
	public OfflinePlayer getPlayer() {
		return player;
	}
	
	public int getValue() {
		return value;
	}
}