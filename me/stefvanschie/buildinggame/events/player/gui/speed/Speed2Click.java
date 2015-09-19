package me.stefvanschie.buildinggame.events.player.gui.speed;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Speed2Click implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		ItemStack currentItem = e.getCurrentItem();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		if (!inventory.getName().equals(ChatColor.GRAY + "Fly speed selection")) {
			return;
		}
		if (currentItem.getType() != Material.FEATHER) {
			return;
		}
		if (!currentItem.hasItemMeta()) {
			return;
		}
		if (!currentItem.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Fly speed 2")) {
			return;
		}
		
		player.setFlySpeed((float) 0.2);
		e.setCancelled(true);
	}
}
