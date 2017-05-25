package com.gmail.stefvanschiedev.buildinggame.api.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;

public class ArenaLeaveEvent extends PlayerEvent implements Cancellable {

	private final Arena arena;
	private boolean cancel;
	private static final HandlerList HANDLERS = new HandlerList();
	
	public ArenaLeaveEvent(Arena arena, Player player) {
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
	
	@Contract(pure = true)
    @SuppressWarnings("unused")
    public static HandlerList getHandlerList() {
		return HANDLERS;
	}
}