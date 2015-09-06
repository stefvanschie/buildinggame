package me.stefvanschie.buildinggame.utils;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VoteBlocks {

	private YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public void give(Player player) {
		ItemStack coal = new ItemStack(Material.COAL_BLOCK);
		ItemMeta coalMeta = coal.getItemMeta();
		coalMeta.setDisplayName(messages.getString("voting.coal-block")
				.replaceAll("&", "§"));
		coal.setItemMeta(coalMeta);
		player.getInventory().setItem(1, coal);
		
		ItemStack iron = new ItemStack(Material.IRON_BLOCK);
		ItemMeta ironMeta = iron.getItemMeta();
		ironMeta.setDisplayName(messages.getString("voting.iron-block")
				.replaceAll("&", "§"));
		iron.setItemMeta(ironMeta);
		player.getInventory().setItem(2, iron);
		
		ItemStack lapis = new ItemStack(Material.LAPIS_BLOCK);
		ItemMeta lapisMeta = lapis.getItemMeta();
		lapisMeta.setDisplayName(messages.getString("voting.lapis-block")
				.replaceAll("&", "§"));
		lapis.setItemMeta(lapisMeta);
		player.getInventory().setItem(3, lapis);
		
		ItemStack redstone = new ItemStack(Material.REDSTONE_BLOCK);
		ItemMeta redstoneMeta = redstone.getItemMeta();
		redstoneMeta.setDisplayName(messages.getString("voting.redstone-block")
				.replaceAll("&", "§"));
		redstone.setItemMeta(redstoneMeta);
		player.getInventory().setItem(4, redstone);
		
		ItemStack gold = new ItemStack(Material.GOLD_BLOCK);
		ItemMeta goldMeta = gold.getItemMeta();
		goldMeta.setDisplayName(messages.getString("voting.gold-block")
				.replaceAll("&", "§"));
		gold.setItemMeta(goldMeta);
		player.getInventory().setItem(5, gold);
		
		ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK);
		ItemMeta diamondMeta = diamond.getItemMeta();
		diamondMeta.setDisplayName(messages.getString("voting.diamond-block")
				.replaceAll("&", "§"));
		diamond.setItemMeta(diamondMeta);
		player.getInventory().setItem(6, diamond);
		
		ItemStack emerald = new ItemStack(Material.EMERALD_BLOCK);
		ItemMeta emeraldMeta = emerald.getItemMeta();
		emeraldMeta.setDisplayName(messages.getString("voting.emerald-block")
				.replaceAll("&", "§"));
		emerald.setItemMeta(emeraldMeta);
		player.getInventory().setItem(7, emerald);
	}
}
