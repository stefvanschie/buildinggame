package me.stefvanschie.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.arena.ArenaMode;

public class ArenaModeManager {

	private ArenaModeManager() {}
	
	private static ArenaModeManager instance = new ArenaModeManager();
	
	public static ArenaModeManager getInstance() {
		return instance;
	}
	
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
