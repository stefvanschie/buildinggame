package com.gmail.stefvanschiedev.buildinggame.events.player;

import java.util.Iterator;

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
		
		Iterator<Player> iterator = e.getRecipients().iterator();
		while (iterator.hasNext()) {
			Player p = iterator.next();
			if (!arena.contains(p))
				e.getRecipients().remove(p);
		}
	}
}