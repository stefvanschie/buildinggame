package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;

public class StatSaveTimer extends BukkitRunnable {

	@Override
	public void run() {
		StatManager.getInstance().saveToFile();
	}
}