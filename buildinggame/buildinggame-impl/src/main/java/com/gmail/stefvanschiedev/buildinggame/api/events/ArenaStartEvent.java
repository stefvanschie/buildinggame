package com.gmail.stefvanschiedev.buildinggame.api.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * An event which is called whenever the arena starts. This also includes a new match with the same players. This event
 * is called before any changes are made by the start method. Cancelling this event means that the arena will never
 * start and it will therefore be stuck until it is started by someone.
 *
 * @since 2.2.0
 */
public class ArenaStartEvent extends Event implements Cancellable {

    /**
     * The arena which is about to start
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
     * Constructs a new start event for the specified arena.
     *
     * @param arena the arena which is about to start
     * @since 2.2.0
     */
	public ArenaStartEvent(Arena arena) {
		this.arena = arena;
		this.cancel = false;
	}

	/**
     * Gets the arena which is about to start
     *
     * @return the arena which is about to start
     * @see Arena
     * @since 2.2.0
     */
	@NotNull
    @Contract(pure = true)
	public Arena getArena() {
		return arena;
	}

	/**
     * Gets the cancellation state of this event
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
     * Changes the cancellation state of this event
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