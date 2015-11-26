package me.stefvanschie.buildinggame.events.player.gui.buildmenu;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CloseMenu implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		
		if (!inventory.getName().equals(messages.getString("gui.options-title")
				.replaceAll("&", "§"))) {
			return;
		}
		
		if (e.getCurrentItem() == null) {
			return;
		}
		
		ItemStack item = e.getCurrentItem();
		
		if (item.getType() != Material.BOOK) {
			return;
		}
		
		if (!item.hasItemMeta()) {
			return;
		}
		
		if (!item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Close menu")) {
			return;
		}
		
		player.closeInventory();
	}
}
