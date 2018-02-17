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

import java.util.logging.Logger;

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
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            String name = arena.getName();

            if (!arenas.contains(name + ".lobby"))
				continue;
			
			arena.setLobby(new Lobby(new Location(Bukkit.getWorld(arenas.getString(name + ".lobby.world")),
					arenas.getInt(name + ".lobby.x"),
					arenas.getInt(name + ".lobby.y"),
					arenas.getInt(name + ".lobby.z"),
                    (float) arenas.getDouble(name + ".lobby.yaw", 0),
                    (float) arenas.getDouble(name + ".lobby.pitch", 0))));

			if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
                Logger logger = Main.getInstance().getLogger();

                if (arena.getLobby().getLocation().getWorld() == null)
			        logger.warning("Unable to load world for lobby");

                logger.info("Loaded lobby for " + name);
            }
		}
	}
}