package com.gmail.stefvanschiedev.buildinggame.api.events;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;


/*
 *  Created by TomTheDeveloper on 24/07/2017
  */


/**
 * An event which is called whenever the voting inside an arena starts. This event cannot be cancelled!
 *
 * @since 2.2.0
 */
public class VotingStartEvent extends Event {

    /**
     * The arena which is about to start voting
     */
    private final Arena arena;


    /**
     * The default handler list
     */
    private static final HandlerList HANDLERS = new HandlerList();

    /**
     * Constructs a new start event for the specified arena.
     *
     * @param arena the arena which is about to start
     * @since 2.2.0
     */
    public VotingStartEvent(Arena arena) {
        this.arena = arena;
    }

    /**
     * Gets the arena which is about to start voting
     *
     * @return the arena which is about to start voting
     * @see Arena
     * @since 2.2.0
     */
    @NotNull
    @Contract(pure = true)
    public Arena getArena() {
        return arena;
    }





    /**
     * Gets the handler list for the event
     *
     * @return the handler list
     * @since 2.2.0
     */
    @NotNull
    @Contract(pure = true)
    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    /**
     * Gets the handler list for the event
     *
     * @return the handler list
     * @since 2.2.0
     */
    @NotNull
    @Contract(pure = true)
    @SuppressWarnings("unused")
    public static HandlerList getHandlerList() {
        return HANDLERS;
    }
}