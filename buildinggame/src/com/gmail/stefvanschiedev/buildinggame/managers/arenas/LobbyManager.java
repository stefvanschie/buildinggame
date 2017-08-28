package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Lobby;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This class handles all lobbies
 *
 * @since 2.1.0
 */
public final class LobbyManager {

    /**
     * Constructs a new LobbyManager. This shouldn't be called to keep this class a singleton.
     */
	private LobbyManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final LobbyManager INSTANCE = new LobbyManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static LobbyManager getInstance() {
		return INSTANCE;
	}

	/**
     * Loads/Reloads all lobbies for all arenas
     *
     * @since 2.1.0
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void setup() {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
			
			if (!arenas.contains(arena.getName() + ".lobby"))
				continue;
			
			arena.setLobby(new Lobby(new Location(Bukkit.getWorld(arenas.getString(arena.getName() + ".lobby.world")),
					arenas.getInt(arena.getName() + ".lobby.x"),
					arenas.getInt(arena.getName() + ".lobby.y"),
					arenas.getInt(arena.getName() + ".lobby.z"),
                    (float) arenas.getDouble(arena.getName() + ".lobby.yaw", 0),
                    (float) arenas.getDouble(arena.getName() + ".lobby.pitch", 0))));
			if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
				Main.getInstance().getLogger().info("Loaded lobby for " + arena.getName());
			}
		}
	}
	
}
