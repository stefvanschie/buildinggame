package me.stefvanschie.buildinggame.events.player.gui.subjectmenu;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.Arena;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ExitSubjectMenu implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		ItemStack item = e.getCurrentItem();
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			return;
		}
		
		if (!inventory.getName().equals(messages.getString("subject-gui.title")
				.replaceAll("&", "§"))) {
			return;
		}
		
		if (item == null) {
			return;
		}
		
		if (item.getType() != Material.BOOK) {
			return;
		}
		
		if (!item.hasItemMeta()) {
			return;
		}
		
		if (!item.getItemMeta().getDisplayName().equals(messages.getString("subject-gui.close-menu.name")
				.replaceAll("&", "§"))) {
			return;
		}
		
		player.closeInventory();
		arena.getSubjectMenu().removePlayer(player);
		e.setCancelled(true);
	}
}
