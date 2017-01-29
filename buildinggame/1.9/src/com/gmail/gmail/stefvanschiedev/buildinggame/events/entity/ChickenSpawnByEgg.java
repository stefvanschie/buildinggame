package com.gmail.stefvanschiedev.buildinggame.events.entity;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class ChickenSpawnByEgg implements Listener {

	@EventHandler
	public void onPlayerEggThrowEvent(PlayerEggThrowEvent e) {
		Player player = e.getPlayer();
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null)
			return;
		
		if (e.isHatching())
			e.setHatching(false);
	}
}