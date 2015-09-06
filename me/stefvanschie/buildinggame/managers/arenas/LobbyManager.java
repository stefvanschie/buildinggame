package me.stefvanschie.buildinggame.managers.arenas;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.Lobby;

public class LobbyManager {

	private LobbyManager() {}
	
	private static LobbyManager instance = new LobbyManager();
	
	public static LobbyManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
			
			try {
				arena.setLobby(new Lobby(new Location(Bukkit.getWorld(arenas.getString(arena.getName() + ".lobby.world")),
						arenas.getInt(arena.getName() + ".lobby.x"),
						arenas.getInt(arena.getName() + ".lobby.y"),
						arenas.getInt(arena.getName() + ".lobby.z"))));
			} catch (NullPointerException npe) {
				arena.setLobby(null);
			} catch (IllegalArgumentException iae) {
				arena.setLobby(null);
			}
		}
	}
	
}
