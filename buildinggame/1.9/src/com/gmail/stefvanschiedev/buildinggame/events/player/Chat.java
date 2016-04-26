package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class Chat implements Listener {

	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null)
			return;
		
		
		for (int i = 0; i < e.getRecipients().toArray().length; i++) {
			if (!arena.contains((Player) e.getRecipients().toArray()[i]))
				e.getRecipients().remove((Player) e.getRecipients().toArray()[i]);
		}
	}
}