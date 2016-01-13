package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

public class Drop implements Listener {

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		Player player = e.getPlayer();

		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
	
		e.setCancelled(true);
	}
}
