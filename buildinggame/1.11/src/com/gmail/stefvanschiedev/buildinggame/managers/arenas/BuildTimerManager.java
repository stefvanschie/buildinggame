package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.BuildTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class BuildTimerManager {

	public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arenas.contains(arena.getName() + ".timer"))
				arenas.set(arena.getName() + ".timer", config.getInt("timer"));
			
			arena.setBuildTimer(new BuildTimer(arenas.getInt(arena.getName() + ".timer"), arena));
		}
	}
	
	private BuildTimerManager() {}
	private static BuildTimerManager instance = new BuildTimerManager();
	public static BuildTimerManager getInstance() {
		return instance;
	}
}