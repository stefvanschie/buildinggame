package me.stefvanschie.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.Arena;

public class MaxPlayersManager {

	private MaxPlayersManager() {}
	
	private static MaxPlayersManager instance = new MaxPlayersManager();
	
	public static MaxPlayersManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
			try {
				arena.setMaxPlayers(arenas.getInt(arena.getName() + ".maxplayers"));
			} catch (NullPointerException npe) {
				arena.setMaxPlayers(0);
			}
		}
	}
}
