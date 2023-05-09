package com.gmail.stefvanschiedev.buildinggame.game.util;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * Can be implemented by game phases. Will notify the game phase that a player has left by calling
 * {@link #onLeave(Player)} if this happens.
 *
 * @since 12.2.0
 */
public interface LeaveObserver {

    /**
     * This method is called whenever a player leaves the game.
     *
     * @param player the player that left the game
     * @since 12.2.0
     */
    void onLeave(@NotNull Player player);
}
