package com.gmail.stefvanschiedev.buildinggame.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * This event is called whenever a player leaves the arena. This event is called just after checking if the player is
 * actually in an arena and the player hasn't actually left the arena yet.
 *
 * @since 2.2.0
 */
public class ArenaLeaveEvent extends PlayerEvent implements Cancellable {

    /**
     * The arena the player wants to leave
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
     * Constructs a new leave event with the specified arena and player
     *
     * @param arena the arena the player wants to leave from
     * @param player the player who wants to leave the arena
     * @since 2.2.0
     */
	public ArenaLeaveEvent(Arena arena, Player player) {
		super(player);
		this.arena = arena;
		this.cancel = false;
	}

	/**
     * Gets the arena the player wants to leave from
     *
     * @return the arena the player wants to leave from
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
     * Returns the handlers of the event
     *
     * @return the handler list
     * @see HandlerList
     * @since 2.2.0
     */
	@NotNull
    @Contract(pure = true)
	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}

	/**
     * Returns the handlers of the event
     *
     * @return the handler list
     * @see HandlerList
     * @since 2.2.0
     */
    @NotNull
	@Contract(pure = true)
    @SuppressWarnings("unused")
    public static HandlerList getHandlerList() {
		return HANDLERS;
	}
}