package com.gmail.stefvanschiedev.buildinggame.events.player.voting;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

/**
 * Handles interaction while voting
 *
 * @since 2.1.0
 */
public class Interact implements Listener {

    /**
     * Handles interaction while voting
     *
     * @param e an event that represents a player interacting
     * @see PlayerInteractEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena.getState() == GameState.VOTING)
			e.setCancelled(true);
	}
}