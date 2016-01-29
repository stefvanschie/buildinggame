package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.blocks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

public class BlocksHeadsSkullClick implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Inventory inventory = e.getInventory();
		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		if (!inventory.getName().equals(ChatColor.GREEN + "Blocks")) {
			return;
		}
		
		if (item == null) {
			return;
		}
		
		if (item.getType() != Material.SKULL_ITEM) {
			return;
		}
		
		e.setCancelled(true);
		e.setCursor(item);
	}
}