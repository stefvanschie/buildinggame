package me.stefvanschie.buildinggame.events.player;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

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
		
		MessageManager.getInstance().send(player, messages.getString("in-game.command-blocked"));
		
		e.setCancelled(true);
	}
}
