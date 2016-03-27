package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class CommandBlocker implements Listener {

	@EventHandler
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		if (e.getMessage().startsWith("/bg") || e.getMessage().startsWith("/buildinggame")) {
			return;
		}
		
		for (String string : config.getStringList("command-whitelist")) {
			String newString = string;
			
			if (!string.startsWith("/")) {
				newString = "/" + string;
			}
			if (e.getMessage().startsWith(newString)) {
				return;
			}
		}
		
		MessageManager.getInstance().send(player, messages.getStringList("in-game.command-blocked"));
		
		e.setCancelled(true);
	}
}