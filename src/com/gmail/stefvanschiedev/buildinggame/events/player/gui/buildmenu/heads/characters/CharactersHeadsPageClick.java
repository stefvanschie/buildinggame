package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.characters;

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
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.characters.CharactersHeadsMenuTwo;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;

public class CharactersHeadsPageClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Inventory inventory = e.getInventory();
		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if (ArenaManager.getInstance().getArena(player) == null)
			return;
		
		if (!inventory.getName().equals(ChatColor.GREEN + "Characters"))
			return;
		
		if (item == null)
			return;
		
		if (item.getType() != Material.SUGAR_CANE)
			return;
		
		if (!item.hasItemMeta())
			return;
		
		switch (new NBTItem(item).getInteger("page")) {
			case 1:
				new CharactersHeadsMenuOne().show(player);
				break;
			case 2:
				new CharactersHeadsMenuTwo().show(player);
				break;
			default:
				break;
		}
		e.setCancelled(true);
	}
}