package com.gmail.stefvanschiedev.buildinggame.utils;

/**
 * Represents the different game states an arena cna be in
 *
 * @since 2.1.0
 */
public enum GameState {

    /**
     * The arena is waiting for more players to join
     *
     * @since 2.1.0
     */
	WAITING,

    /**
     * The arena is about to start
     *
     * @since 2.1.0
     */
    STARTING,

    /**
     * The arena is full
     *
     * @since 2.1.0
     */
    FULL,

    /**
     * The arena is in building phase
     *
     * @since 2.1.0
     */
    BUILDING,

    /**
     * The arena is in voting phase
     *
     * @since 2.1.0
     */
    VOTING,

    /**
     * The arena is in winning phase
     *
     * @since 2.1.0
     */
    RESETING
	
}