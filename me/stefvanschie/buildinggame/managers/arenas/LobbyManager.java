package me.stefvanschie.buildinggame.managers.arenas;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.Lobby;
import me.stefvanschie.buildinggame.utils.arena.Arena;

public class LobbyManager {

	private LobbyManager() {}
	
	private static LobbyManager instance = new LobbyManager();
	
	public static LobbyManager getInstance() {
		return instance;
	}
	
	public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
			
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
