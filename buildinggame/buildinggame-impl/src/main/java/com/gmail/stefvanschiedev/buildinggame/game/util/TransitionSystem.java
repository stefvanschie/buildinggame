package com.gmail.stefvanschiedev.buildinggame.game.util;

import org.jetbrains.annotations.NotNull;

/**
 * A transition system is a class that is capable of managing and transitioning between different game phases.
 *
 * @since 12.2.0
 */
public interface TransitionSystem {

    /**
     * Transitions to the next game phase. The transition system is responsible for correctly calling
     * {@link GamePhase#onPhaseStart()} whenever a phase should start.
     *
     * @param gamePhase the game phase to transition to
     * @since 12.2.0
     */
    void transition(@NotNull GamePhase gamePhase);
}
