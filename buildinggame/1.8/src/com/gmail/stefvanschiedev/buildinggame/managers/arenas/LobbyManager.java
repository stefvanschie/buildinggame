package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Lobby;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class LobbyManager {

	private LobbyManager() {}
	
	private static LobbyManager instance = new LobbyManager();
	
	public static LobbyManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
			
			if (!arenas.contains(arena.getName() + ".lobby"))
				continue;
			
			arena.setLobby(new Lobby(new Location(Bukkit.getWorld(arenas.getString(arena.getName() + ".lobby.world")),
					arenas.getInt(arena.getName() + ".lobby.x"),
					arenas.getInt(arena.getName() + ".lobby.y"),
					arenas.getInt(arena.getName() + ".lobby.z"))));
			if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
				Main.getInstance().getLogger().info("Loaded lobby for " + arena.getName());
			}
		}
	}
	
}
