package com.gmail.stefvanschiedev.buildinggame.utils.stats;

import org.bukkit.block.Sign;

public class StatSign {

	private Sign sign;
	private StatType type;
	private int number;
	
	public StatSign(Sign sign, StatType type, int number) {
		this.sign = sign;
		this.type = type;
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
	
	public Sign getSign() {
		return sign;
	}
	
	public StatType getType() {
		return type;
	}
}