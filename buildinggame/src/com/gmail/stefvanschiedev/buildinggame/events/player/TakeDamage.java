package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

/**
 * Handles taking damage in the lobby
 *
 * @since 2.1.0
 */
public class TakeDamage implements Listener {

    /**
     * Handles taking damage in the lobby
     *
     * @param e an event representing an entity taking damage
     * @see EntityDamageEvent
     * @since 2.1.0
     */
	@EventHandler
	public static void onEntityDamage(EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		
		Player player = (Player) e.getEntity();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		e.setCancelled(true);
	}
}