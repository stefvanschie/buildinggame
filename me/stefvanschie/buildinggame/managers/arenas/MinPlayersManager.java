package me.stefvanschie.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.Arena;

public class MinPlayersManager {

	private MinPlayersManager() {}
	
	private static MinPlayersManager instance = new MinPlayersManager();
	
	public static MinPlayersManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
			try {
				arena.setMinPlayers(arenas.getInt(arena.getName() + ".minplayers"));
			} catch (NullPointerException npe) {
				arena.setMinPlayers(0);
			}
		}
	}
}
