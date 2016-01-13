package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.mobs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class MobsHeadsMenuTwo {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Mobs");
		
		ItemStack ferret = SkullItem.getSkull("http://textures.minecraft.net/texture/236edf7de9adca72308a94d1c38c358acc82918fe8fced25d474820f4cb784");
		ItemMeta ferretMeta = ferret.getItemMeta();
		ferretMeta.setDisplayName(ChatColor.GOLD + "Ferret");
		ferret.setItemMeta(ferretMeta);
		
		ItemStack elephant = SkullItem.getSkull("http://textures.minecraft.net/texture/7071a76f669db5ed6d32b48bb2dba55d5317d7f45225cb3267ec435cfa514");
		ItemMeta elephantMeta = elephant.getItemMeta();
		elephantMeta.setDisplayName(ChatColor.GOLD + "Elephant");
		elephant.setItemMeta(elephantMeta);
		
		//"Furby" is a product made by "Hasbro" and is not affiliated with this site.
		
		ItemStack furby = SkullItem.getSkull("http://textures.minecraft.net/texture/7bff527562889e16a544f2f996fba3d9541d0aacf81462bffc9fb5cad8aedd5");
		ItemMeta furbyMeta = furby.getItemMeta();
		furbyMeta.setDisplayName(ChatColor.GOLD + "Furby");
		furby.setItemMeta(furbyMeta);
		
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
		
		inventory.setItem(0, ferret);
		inventory.setItem(1, elephant);
		inventory.setItem(2, furby);
		
		inventory.setItem(47, previous);
		inventory.setItem(49, close);
		
		player.openInventory(inventory);
	}
}