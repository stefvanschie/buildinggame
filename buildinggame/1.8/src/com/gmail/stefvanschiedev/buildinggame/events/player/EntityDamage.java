package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

public class EntityDamage implements Listener {

	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		
		Player damager = (Player) e.getDamager();
		
		if (ArenaManager.getInstance().getArena(damager) == null) {
			return;
		}
		
		e.setCancelled(true);
	}
}