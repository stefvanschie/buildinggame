package com.gmail.stefvanschiedev.buildinggame.api;

import java.util.List;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A class which is meant to be sued by APIs. It contains getters for important elements of this plugin such as arenas.
 *
 * @since 2.2.0
 */
@SuppressWarnings({"WeakerAccess", "UtilityClassCanBeEnum"})
public final class BuildingGame {

    private BuildingGame() {}

    /**
     * Gets the arena by the given name.
     *
     * @param name the name of the arena
     * @return the arena by the given name or null if the arena doesn't exist
     * @see Arena
     * @since 2.2.0
     */
    @Nullable
    @Contract(pure = true)
    @SuppressWarnings("unused")
    public static Arena getArena(String name) {
		return ArenaManager.getInstance().getArena(name);
	}

    /**
     * Gets the arena by the given player.
     *
     * @param player the player which is currently in an arena
     * @return the arena by the given player or null if the player is null or not inside an arena right now
     * @see Arena
     * @since 2.2.0
     */
    @Nullable
    @Contract(pure = true)
	@SuppressWarnings("unused")
    public static Arena getArena(Player player) {
		return ArenaManager.getInstance().getArena(player);
	}

	/**
     * Gets a list of all existing arenas at this point in time.
     *
     * @return a list of all arenas
     * @see List
     * @since 2.2.0
     */
	@NotNull
    @Contract(pure = true)
	@SuppressWarnings("unused")
    public static List<Arena> getArenas() {
		return ArenaManager.getInstance().getArenas();
	}
}