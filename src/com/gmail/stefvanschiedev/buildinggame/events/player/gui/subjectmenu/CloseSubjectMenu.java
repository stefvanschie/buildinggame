package com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class CloseSubjectMenu implements Listener {

	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getPlayer();
		Inventory inventory = e.getInventory();
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			return;
		}
		
		if (!inventory.getName().equals(messages.getString("subject-gui.title")
				.replaceAll("&", "§"))) {
			return;
		}
		
		arena.getSubjectMenu().removePlayer(player);
	}
}