package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

/**
 * Handles blocked commands while in-game
 *
 * @since 2.1.0
 */
public class CommandBlocker implements Listener {

    /**
     * Handles blocked commands while in-game
     *
     * @param e an event representing a command executed
     * @see PlayerCommandPreprocessEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		var player = e.getPlayer();
        String message = e.getMessage();

        if (ArenaManager.getInstance().getArena(player) == null || message.startsWith("/bg") ||
                message.startsWith("/buildinggame"))
			return;
		
		for (var string : SettingsManager.getInstance().getConfig().getStringList("command-whitelist")) {
			if (string.charAt(0) != '/')
				string = '/' + string;

			if (message.startsWith(string))
				return;
		}
		
		MessageManager.getInstance().send(player, SettingsManager.getInstance().getMessages()
                .getStringList("in-game.command-blocked"));
		
		e.setCancelled(true);
	}
}