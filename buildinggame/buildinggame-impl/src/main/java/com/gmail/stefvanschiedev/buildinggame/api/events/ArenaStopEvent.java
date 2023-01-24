package com.gmail.stefvanschiedev.buildinggame.api.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * An event which is called when an arena is about to stop. This event will also be called when the arena is forcefully
 * stopped. This event is called before any changes are made. Cancelling the event means the arena won't stop and will
 * be stuck until it's either started or stopped again.
 *
 * @since 2.2.0
 */
public class ArenaStopEvent extends Event implements Cancellable {

    /**
     * The arena which is about to stop
     */
	private final Arena arena;

	/**
     * The cancellation state of this event
     */
	private boolean cancel;

	/**
     * The default handler list
     */
	private static final HandlerList HANDLERS = new HandlerList();

	/**
     * Constructs a new stop event for the given arena.
     *
     * @param arena the arena which is about to stop
     * @since 2.2.0
     */
	public ArenaStopEvent(Arena arena) {
		this.arena = arena;
		this.cancel = false;
	}

	/**
     * Gets the arena which is about to stop.
     *
     * @return the arena which is about to stop
     * @see Arena
     * @since 2.2.0
     */
	@NotNull
    @Contract(pure = true)
	@SuppressWarnings("unused")
    public Arena getArena() {
		return arena;
	}

	/**
     * Gets the cancellation state of this event.
     *
     * @return the cancellation state
     * @since 2.2.0
     */
	@Contract(pure = true)
	@Override
	public boolean isCancelled() {
		return cancel;
	}

	/**
     * Changes the cancellation state of this event.
     *
     * @param cancel the new cancellation state
     * @since 2.2.0
     */
	@Override
	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
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