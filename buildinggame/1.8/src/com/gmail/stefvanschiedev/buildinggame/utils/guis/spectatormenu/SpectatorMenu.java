package com.gmail.stefvanschiedev.buildinggame.utils.guis.spectatormenu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpectatorMenu {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 36, ChatColor.GREEN + "Spectator menu");
		
		ItemStack speed = new ItemStack(Material.FEATHER);
		ItemMeta speedMeta = speed.getItemMeta();
		speedMeta.setDisplayName(ChatColor.GREEN + "Flight speed");
		List<String> speedLores = new ArrayList<String>();
		speedLores.add(ChatColor.GRAY + "Change the speed which you fly at");
		speedMeta.setLore(speedLores);
		speed.setItemMeta(speedMeta);
		
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(ChatColor.GREEN + "Close menu");
		List<String> closeLores = new ArrayList<String>();
		closeLores.add(ChatColor.GRAY + "Close the spectator menu");
		closeMeta.setLore(closeLores);
		close.setItemMeta(closeMeta);
		
		inventory.setItem(13, speed);
		inventory.setItem(22, close);
		
		player.openInventory(inventory);
	}
}