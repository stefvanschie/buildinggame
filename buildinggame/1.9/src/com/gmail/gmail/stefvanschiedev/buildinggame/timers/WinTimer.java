package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class WinTimer extends Timer {

	private Arena arena;
	private boolean running = false;
	private int seconds;
	
	private YamlConfiguration config = SettingsManager.getInstance().getConfig();
	
	public WinTimer(int seconds, Arena arena) {
		this.arena = arena;
		this.seconds = seconds;
	}
	
	@Override
	public void run() {
		if (!isActive())
			running = true;
		if (seconds <= 0) {
			arena.stop();
			running = false;
			this.cancel();
			return;
		}
		//timings
		try {
			for (String key : config.getConfigurationSection("timings.win-timer.at").getKeys(false)) {
				try {
					if (seconds == Integer.parseInt(key)) {
						for (String command : config.getStringList("timings.win-timer.at." + Integer.parseInt(key)))
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
					}
				} catch (NumberFormatException e) {}
			}
			for (String key : config.getConfigurationSection("timings.win-timer.every").getKeys(false)) {
				try {
					if (seconds % Integer.parseInt(key) == 0) {
						for (String command : config.getStringList("timings.win-timer.every." + Integer.parseInt(key)))
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
					}
				} catch (NumberFormatException e) {}
			}
		} catch (NullPointerException e) {}
		seconds--;
	}

	@Override
	public int getSeconds() {
		return seconds;
	}

	@Override
	public boolean isActive() {
		return running;
	}

	@Override
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}