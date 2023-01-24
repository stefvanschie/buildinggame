package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialLocation;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

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

        for (var arena : ArenaManager.getInstance().getArenas()) {
            var name = arena.getName();

            if (!arenas.contains(name + ".lobby"))
				continue;

            Supplier<World> world = () -> Bukkit.getWorld(arenas.getString(name + ".lobby.world"));
            int x = arenas.getInt(name + ".lobby.x");
            int y = arenas.getInt(name + ".lobby.y");
            int z = arenas.getInt(name + ".lobby.z");
            float yaw = (float) arenas.getDouble(name + ".lobby.yaw", 0);
            float pitch = (float) arenas.getDouble(name + ".lobby.pitch", 0);

            arena.setLobby(new PotentialLocation(world, x, y, z, yaw, pitch));

			if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
                Main.getInstance().getLogger().info("Loaded lobby for " + name);
            }
		}
	}
}