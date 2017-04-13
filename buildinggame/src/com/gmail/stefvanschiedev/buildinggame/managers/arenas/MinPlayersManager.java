package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public final class MinPlayersManager {

	private MinPlayersManager() {}
	
	private static final MinPlayersManager INSTANCE = new MinPlayersManager();
	
	public static MinPlayersManager getInstance() {
		return INSTANCE;
	}
	
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
			try {
				arena.setMinPlayers(arenas.getInt(arena.getName() + ".minplayers"));
				if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
					Main.getInstance().getLogger().info("Loaded min players for " + arena.getName());
				}
			} catch (NullPointerException npe) {
				arena.setMinPlayers(0);
			}
		}
	}
}