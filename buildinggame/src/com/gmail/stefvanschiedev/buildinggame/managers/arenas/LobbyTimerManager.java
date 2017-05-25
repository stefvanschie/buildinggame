package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.WaitTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;

public final class LobbyTimerManager {

	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arenas.contains(arena.getName() + ".lobby-timer"))
				arenas.set(arena.getName() + ".lobby-timer", config.getInt("waittimer"));
			
			arena.setWaitTimer(new WaitTimer(arenas.getInt(arena.getName() + ".lobby-timer"), arena));
		}
	}
	
	private LobbyTimerManager() {}
	private static final LobbyTimerManager INSTANCE = new LobbyTimerManager();
	@Contract(pure = true)
    public static LobbyTimerManager getInstance() {
		return INSTANCE;
	}
}