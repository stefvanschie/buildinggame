package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

/**
 * Handles players leaving the server
 *
 * @since 2.1.0
 */
public class Leave implements Listener {

    /**
     * Handles player disconnecting
     *
     * @param e an event representing a player disconnecting
     * @see PlayerQuitEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		arena.leave(player);
	}

	/**
     * Handles players getting kicked
     *
     * @param e an event representing a player getting kicked
     * @see PlayerKickEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onPlayerKick(PlayerKickEvent e) {
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		arena.leave(player);
	}
}