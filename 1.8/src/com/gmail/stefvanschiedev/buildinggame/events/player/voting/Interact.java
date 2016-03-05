package com.gmail.stefvanschiedev.buildinggame.events.player.voting;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class Interact implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena.getState() == GameState.VOTING) {
			e.setCancelled(true);
			return;
		}
	}
}