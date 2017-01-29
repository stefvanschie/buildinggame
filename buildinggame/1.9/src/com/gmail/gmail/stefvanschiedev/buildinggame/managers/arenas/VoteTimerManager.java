package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.VoteTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class VoteTimerManager {

	public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arenas.contains(arena.getName() + ".vote-timer"))
				arenas.set(arena.getName() + ".vote-timer", config.getInt("votetimer"));
			
			arena.setVoteTimer(new VoteTimer(arenas.getInt(arena.getName() + ".vote-timer"), arena));
		}
	}
	
	private VoteTimerManager() {}
	private static VoteTimerManager instance = new VoteTimerManager();
	public static VoteTimerManager getInstance() {
		return instance;
	}
}