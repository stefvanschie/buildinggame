package com.gmail.stefvanschiedev.buildinggame.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * An event which is called when the player attempts to join an arena. It is called just after checking if the arena
 * validates (e.g. the arena is setup correctly). If the setup isn't correct this event will not be thrown. The player will not actually be joined at this point in time and
 * nothing has changed yet.
 *
 * @since 2.2.0
 */
public class ArenaJoinEvent extends PlayerEvent implements Cancellable {

    /**
     * The arena which the player attempts to join
     */
	private final Arena arena;

	/**
     * If the event is cancelled or not
     */
	private boolean cancel;

	/**
     * The default handler list
     *
     * @see HandlerList
     */
	private static final HandlerList HANDLERS = new HandlerList();

	/**
     * Constructs a new join event with the arena and the player joining the specified arena.
     *
     * @param arena the arena the player attempts to join
     * @param player the player that attempts to join the arena
     * @since 2.2.0
     */
	public ArenaJoinEvent(Arena arena, Player player) {
		super(player);
		this.arena = arena;
		this.cancel = false;
	}

	/**
     * Gets the arena the player tries to join
     *
     * @return the arena the player attempts to join
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
     * Gets whether the event is cancelled or not
     *
     * @return if the event is cancelled
     * @since 2.2.0
     */
	@Contract(pure = true)
	@Override
	public boolean isCancelled() {
		return cancel;
	}

	/**
     * Sets the cancellation state of this event
     *
     * @param cancel change the cancellation state of this event
     * @since 2.2.0
     */
	@Override
	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
	}

	/**
     * Gets the handler list
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
     * Gets the handler list
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