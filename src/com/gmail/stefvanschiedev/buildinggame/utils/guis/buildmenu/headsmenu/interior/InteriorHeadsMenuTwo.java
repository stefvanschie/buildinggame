package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.interior;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class InteriorHeadsMenuTwo {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Interior");
		
		ItemStack present = SkullItem.getSkull("http://textures.minecraft.net/texture/bd7a9f6ed08dd217fdf09f4652bf6b7af621e1d5f8963605349da73998a443");
		ItemMeta presentMeta = present.getItemMeta();
		presentMeta.setDisplayName(ChatColor.GOLD + "Present");
		present.setItemMeta(presentMeta);
		
		ItemStack present2 = SkullItem.getSkull("http://textures.minecraft.net/texture/64abe81e6f4961e0f6bd82f2d4135b6b5fc845739e71cfe3b8943531d921e");
		ItemMeta present2Meta = present2.getItemMeta();
		present2Meta.setDisplayName(ChatColor.GOLD + "Present");
		present2.setItemMeta(present2Meta);
		
		ItemStack cdCase = SkullItem.getSkull("http://textures.minecraft.net/texture/c2412548ebd6897e808c1fcbbf5bf7a625fe15fa48fbff4cf822b0c8e57a8");
		ItemMeta cdCaseMeta = cdCase.getItemMeta();
		cdCaseMeta.setDisplayName(ChatColor.GOLD + "CD Case");
		cdCase.setItemMeta(cdCaseMeta);
		
		//previous page
		
		ItemStack previous = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previousMeta = previous.getItemMeta();
		previousMeta.setDisplayName(ChatColor.GREEN + "Previous Page");
		previous.setItemMeta(previousMeta);
		
		//close
		
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(ChatColor.GREEN + "Close Menu");
		close.setItemMeta(closeMeta);
		
		inventory.setItem(0, present);
		inventory.setItem(1, present2);
		inventory.setItem(2, cdCase);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}