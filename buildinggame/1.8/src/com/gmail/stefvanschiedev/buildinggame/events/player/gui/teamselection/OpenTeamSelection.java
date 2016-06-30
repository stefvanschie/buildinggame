package com.gmail.stefvanschiedev.buildinggame.events.player.gui.teamselection;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class OpenTeamSelection implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		ItemStack item = player.getItemInHand();
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			return;
		}
		
		if (!IDDecompiler.getInstance().matches(config.getString("team-selection.item.id"), item))
			return;
		
		if (!item.hasItemMeta()) {
			return;
		}
		
		if (!item.getItemMeta().getDisplayName().equals(messages.getString("team-gui.item.name")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			return;
		}
		
		arena.getTeamSelection().show(player);
		e.setCancelled(true);
	}
}