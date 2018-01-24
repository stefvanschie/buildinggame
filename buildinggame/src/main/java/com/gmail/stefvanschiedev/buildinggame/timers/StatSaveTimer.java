package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;

/**
 * Times all statistic saving
 *
 * @since 2.2.0
 */
public class StatSaveTimer extends BukkitRunnable {

    /**
     * Saves all statistics to either a MySQL database or a YAML file
     *
     * @since 2.2.0
     */
	@Override
	public void run() {
		if (StatManager.getInstance().getMySQLDatabase() == null)
			StatManager.getInstance().saveToFile();
		else
			StatManager.getInstance().saveToDatabase();
	}
}