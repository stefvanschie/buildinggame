package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.characters.CharactersHeadsMenuOne;

public class CharactersHeadsClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Inventory inventory = e.getInventory();
		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		if (!inventory.getName().equals(ChatColor.GREEN + "Heads")) {
			return;
		}
		
		if (item == null) {
			return;
		}
		
		if (item.getType() != Material.SKULL_ITEM) {
			return;
		}
		
		if (!item.hasItemMeta()) {
			return;
		}
		
		if (!item.getItemMeta().getDisplayName().equals(ChatColor.GOLD + "Characters")) {
			return;
		}
		
		new CharactersHeadsMenuOne().show(player);
		e.setCancelled(true);
	}
}