package me.stefvanschie.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;

public class MaxPlayersManager {

	private MaxPlayersManager() {}
	
	private static MaxPlayersManager instance = new MaxPlayersManager();
	
	public static MaxPlayersManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
			YamlConfiguration config = SettingsManager.getInstance().getConfig();
			
			try {
				int maxPlayers = arenas.getInt(arena.getName() + ".maxplayers");
				
				arena.setMaxPlayers(maxPlayers);
				
				for (int i = 1; i <= maxPlayers; i++) {
					if (!config.contains("team-selection.team." + i)) {
						config.set("team-selection.team." + i + ".id", "paper");
					}
				}
				
				if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
					Main.getInstance().getLogger().info("Loaded max players for " + arena.getName());
				}
			} catch (NullPointerException npe) {
				arena.setMaxPlayers(0);
			}
		}
	}
}