package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class handles all arena instances and contains useful methods for looking those up.
 *
 * @since 2.1.0
 */
public final class ArenaManager {

    /**
     * Construct a new ArenaManager. This shouldn't be called to keep this class a singleton.
     */
	private ArenaManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final ArenaManager INSTANCE = new ArenaManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return the instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static ArenaManager getInstance() {
		return INSTANCE;
	}

    /**
     * A list which stored all arena instances
     */
	private final List<Arena> arenas = new ArrayList<>();

	/**
     * Loads/Reloads all arena instances from the arenas.yml file
     *
     * @since 2.1.0
     */
	public void setup() {
		arenas.clear();
		Set<String> arenas = SettingsManager.getInstance().getArenas().getKeys(false);

		for (String arena : arenas) {
			if (!arena.equals("main-spawn")) {
				this.arenas.add(new Arena(arena));

				if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
					Main.getInstance().getLogger().info("Loaded arena " + arena);
			}
		}
	}

	/**
     * Returns a list of all registered arenas
     *
     * @return all arenas
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public List<Arena> getArenas() {
		return arenas;
	}

	/**
     * Returns the arena by the given name or null if the arena could not be found
     *
     * @param name the name of the arena
     * @return the arena by the given name
     * @see Arena
     * @since 2.1.0
     */
	@Nullable
    @Contract(value = "null -> null", pure = true)
    public Arena getArena(String name) {
		for (Arena arena : arenas) {
			if (arena.getName().equals(name))
				return arena;
		}

		return null;
	}

	/**
     * Returns the arena by the given player
     *
     * @param player the player in the arena
     * @return the arena by the given player
     * @see Arena
     * @since 2.1.0
     */
	@Nullable
    @Contract(value = "null -> null", pure = true)
    public Arena getArena(Player player) {
		for (Arena arena : arenas) {
			for (Plot plot : arena.getUsedPlots()) {
                GamePlayer gamePlayer = plot.getGamePlayer(player);

                if (gamePlayer != null) {
					if (gamePlayer.getPlayer().equals(player))
						return arena;
				}
			}
		}

		return null;
	}
}