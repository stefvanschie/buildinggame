package com.gmail.stefvanschiedev.buildinggame.timers.utils;

import org.bukkit.scheduler.BukkitRunnable;

public abstract class Timer extends BukkitRunnable {

	public abstract int getSeconds();
	
	public int getSecondsFromMinute() {
		return (getSeconds() - getMinutes() * 60);
	}
	
	public int getMinutes() {
		return getSeconds() / 60;
	}
	
}
