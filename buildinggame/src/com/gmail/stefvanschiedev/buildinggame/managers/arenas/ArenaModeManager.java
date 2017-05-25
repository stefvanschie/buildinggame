package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.ArenaMode;
import org.jetbrains.annotations.Contract;

public final class ArenaModeManager {

	private ArenaModeManager() {}
	
	private static final ArenaModeManager INSTANCE = new ArenaModeManager();
	
	@Contract(pure = true)
    public static ArenaModeManager getInstance() {
		return INSTANCE;
	}
	
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arenas.contains(arena.getName() + ".mode")) {
				arenas.set(arena.getName() + ".mode", "SOLO");
			}
			
			arena.setMode(ArenaMode.valueOf(arenas.getString(arena.getName() + ".mode")));
			
			if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
				Main.getInstance().getLogger().info("Loaded gamemode for " + arena.getName());
			}
		}
	}
}
