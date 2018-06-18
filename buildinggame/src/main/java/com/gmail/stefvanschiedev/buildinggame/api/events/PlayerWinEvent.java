package com.gmail.stefvanschiedev.buildinggame.api.events;

import java.util.Collection;
import java.util.List;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import com.gmail.stefvanschiedev.buildinggame.api.Win;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * An event which is called whenever a group of players win a match. This is called for each plot rather than each
 * player. This is called before the changes of the event are applied. This event is called for all possible {@link Win}
 * states.
 *
 * @since 2.2.0
 */
public class PlayerWinEvent extends Event {

    /**
     * The arena of the players which won
     */
	private final Arena arena;

	/**
     * The default handler list
     */
	private static final HandlerList HANDLERS = new HandlerList();

	/**
     * The list of gameplayers which won
     */
	private final List<GamePlayer> players;

	/**
     * The win positition
     */
	private final Win win;

    /**
     * Constructs a new win event for the given arena, players and win position.
     *
     * @param arena the arena in which the players are who won
     * @param players the list of gameplayers who won
     * @param win the win position of the players
     * @since 2.2.0
     */
	public PlayerWinEvent(Arena arena, List<GamePlayer> players, Win win) {
		this.arena = arena;
		this.players = players;
		this.win = win;
	}

	/**
     * Gets the arena in which the players are who won.
     *
     * @return the arena in which the players are who won.
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
     * Gets a collection of all winning players, represented as gameplayers.
     *
     * @return an iterable of gameplayers which won
     * @see Collection
     * @since 2.2.0
     */
	@NotNull
    @Contract(pure = true)
	public Collection<GamePlayer> getPlayers() {
		return players;
	}

	/**
     * Gets the win position of the players.
     *
     * @return the win position
     * @see Win
     * @since 2.2.0
     */
	@NotNull
    @Contract(pure = true)
	public Win getWin() {
		return win;
	}

	/**
     * Gets the handler list of the event
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
     * Gets the handler list of the event
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