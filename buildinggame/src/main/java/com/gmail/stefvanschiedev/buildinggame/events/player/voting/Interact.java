package com.gmail.stefvanschiedev.buildinggame.events.player.voting;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;

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
    //essential high priority so vote blocks are handled first
	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerInteract(PlayerInteractEvent e) {
        var arena = ArenaManager.getInstance().getArena(e.getPlayer());

        if (arena == null)
			return;
		
		if (arena.getState() == GameState.VOTING)
			e.setCancelled(true);
	}
}