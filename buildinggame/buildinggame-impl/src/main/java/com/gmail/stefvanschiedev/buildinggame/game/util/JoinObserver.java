package com.gmail.stefvanschiedev.buildinggame.game.util;

import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import org.jetbrains.annotations.NotNull;

/**
 * Can be implemented by game phases. Will notify the game phase that a player has joined by calling
 * {@link #onJoin(GamePlayer)} if this happens.
 *
 * @since 12.2.0
 */
public interface JoinObserver {

    /**
     * This method is called whenever a player joins the game.
     *
     * @param player the player that joined the game
     * @since 12.2.0
     */
    void onJoin(@NotNull GamePlayer player);
}
