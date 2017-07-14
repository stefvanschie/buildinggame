package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

/**
 * Handles chat events
 *
 * @since 2.2.1
 */
public class Chat implements Listener {

    /**
     * Handles chat events
     *
     * @param e an asynchronized event representing a player chatting
     * @see AsyncPlayerChatEvent
     * @since 2.2.1
     */
	@EventHandler
	public void onAsyncPlayerChat(AsyncPlayerChatEvent e) {
		Player player = e.getPlayer();
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null)
			return;

        //noinspection ArrayLengthInLoopCondition
        for (int i = 0; i < e.getRecipients().toArray().length; i++) {
			if (!arena.contains((Player) e.getRecipients().toArray()[i])) {
                //noinspection SuspiciousMethodCalls
                e.getRecipients().remove(e.getRecipients().toArray()[i]);
                //noinspection AssignmentToForLoopParameter
                i--;
            }
		}
	}
}