package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class WinTimer extends Timer {

	private final Arena arena;
	private boolean running;
	private int seconds;
	
	private final YamlConfiguration config = SettingsManager.getInstance().getConfig();
	
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
                if (seconds == Integer.parseInt(key)) {
                    for (String command : config.getStringList("timings.win-timer.at." + Integer.parseInt(key)))
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
                }
			}
			for (String key : config.getConfigurationSection("timings.win-timer.every").getKeys(false)) {
                if (seconds % Integer.parseInt(key) == 0) {
                    for (String command : config.getStringList("timings.win-timer.every." + Integer.parseInt(key)))
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
                }
			}
		} catch (NullPointerException | NumberFormatException e) {}
		seconds--;
	}

	@Override
	public int getSeconds() {
		return seconds;
	}

	public boolean isActive() {
		return running;
	}
}