package me.stefvanschie.buildinggame.events.player.gui.subjectmenu;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

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