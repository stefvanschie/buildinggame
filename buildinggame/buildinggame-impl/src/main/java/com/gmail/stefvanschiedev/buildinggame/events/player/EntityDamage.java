package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

/**
 * Handles players damaging entities
 *
 * @since 2.1.0
 */
public class EntityDamage implements Listener {

    /**
     * Handles players damaging entities
     *
     * @param e an event representing an entity being damaged by another entity
     * @since 2.1.0
     */
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
        Entity damager = e.getDamager();

        if (!(damager instanceof Player) || ArenaManager.getInstance().getArena((Player) damager) == null)
			return;
		
		e.setCancelled(true);
	}
}