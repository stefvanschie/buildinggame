package com.gmail.stefvanschiedev.buildinggame.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class ArenaJoinEvent extends PlayerEvent implements Cancellable {

	private final Arena arena;
	private boolean cancel;
	private static final HandlerList HANDLERS = new HandlerList();
	
	public ArenaJoinEvent(Arena arena, Player player) {
		super(player);
		this.arena = arena;
		this.cancel = false;
	}

	@SuppressWarnings("unused")
    public Arena getArena() {
		return arena;
	}

	@Override
	public boolean isCancelled() {
		return cancel;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.cancel = cancel;
	}
	
	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}
	
	@SuppressWarnings("unused")
    public static HandlerList getHandlerList() {
		return HANDLERS;
	}
}