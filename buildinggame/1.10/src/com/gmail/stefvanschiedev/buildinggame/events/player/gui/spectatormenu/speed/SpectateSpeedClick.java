package com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu.speed;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.SpeedMenu;

public class SpectateSpeedClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		
		if (!inventory.getName().equals(ChatColor.GREEN + "Spectator menu"))
			return;
		
		if (e.getCurrentItem() == null)
			return;
		
		ItemStack currentItem = e.getCurrentItem();
		
		if (currentItem.getType() != Material.FEATHER)
			return;
		
		if (!currentItem.hasItemMeta())
			return;
			
		if (!currentItem.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Flight speed"))
			return;
		
		new SpeedMenu().show(player);
		e.setCancelled(true);
	}
}