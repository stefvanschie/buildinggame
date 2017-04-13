package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.timers.WinTimer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public final class WinTimerManager {

	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arenas.contains(arena.getName() + ".win-timer"))
				arenas.set(arena.getName() + ".win-timer", config.getInt("wintimer"));
			
			arena.setWinTimer(new WinTimer(arenas.getInt(arena.getName() + ".win-timer"), arena));
		}
	}
	
	private WinTimerManager() {}
	private static final WinTimerManager INSTANCE = new WinTimerManager();
	public static WinTimerManager getInstance() {
		return INSTANCE;
	}
}