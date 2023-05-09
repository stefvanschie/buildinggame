package com.gmail.stefvanschiedev.buildinggame.game.util;

import org.bukkit.DyeColor;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Represents the phase of a game.
 *
 * @since 12.2.0
 */
public abstract class GamePhase {

    /**
     * Invoked when this phase is starting.
     *
     * @since 12.2.0
     */
    public abstract void onPhaseStart();

    /**
     * Invoked when this phase has ended.
     *
     * @since 12.2.0
     */
    public abstract void onPhaseEnd();

    /**
     * Forcefully ends the game, resetting everything back to its initial state.
     *
     * @since 12.2.0
     */
    public abstract void forceEnd();

    /**
     * Gets whether a player can join when in this phase.
     *
     * @return true if a player can join in this phase
     * @since 12.2.0
     */
    public abstract boolean canJoin();

    /**
     * Gets the dye color that represents this game phase.
     *
     * @return 12.2.0
     */
    @NotNull
    @Contract(pure = true)
    public abstract DyeColor getColor();

    /**
     * Gets the name of this phase.
     *
     * @return 12.2.0
     */
    @NotNull
    @Contract(pure = true)
    public abstract String getName();
}
