package com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GuiPage;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class PreviousPage implements Listener {

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
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			return;
		}
		
		if (item == null) {
			return;
		}
		
		if (item.getType() != Material.SUGAR_CANE) {
			return;
		}
		
		if (!item.hasItemMeta()) {
			return;
		}
		
		if (!item.getItemMeta().getDisplayName().equals(messages.getString("subject-gui.previous-page.name")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			return;
		}
		
		arena.getSubjectMenu().show(player, new GuiPage(arena.getSubjectMenu().getPage(player).getPage() - 1));
		e.setCancelled(true);
	}
}