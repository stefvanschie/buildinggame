package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class VoteBlocks {

	private YamlConfiguration config = SettingsManager.getInstance().getConfig();
	private YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public void give(Player player) {
		try {
			CustomBlock twoBlock = IDDecompiler.getInstance().decompile(config.getString("voting.second-slot.id"));
			
			ItemStack two = new ItemStack(twoBlock.getMaterial());
			two.setDurability(twoBlock.getData());
			ItemMeta twoMeta = two.getItemMeta();
			twoMeta.setDisplayName(messages.getString("voting.second-slot-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			two.setItemMeta(twoMeta);
			player.getInventory().setItem(1, two);
		
			CustomBlock threeBlock = IDDecompiler.getInstance().decompile(config.getString("voting.third-slot.id"));
			
			ItemStack three = new ItemStack(threeBlock.getMaterial());
			three.setDurability(threeBlock.getData());
			ItemMeta threeMeta = three.getItemMeta();
			threeMeta.setDisplayName(messages.getString("voting.third-slot-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			three.setItemMeta(threeMeta);
			player.getInventory().setItem(2, three);
		
			CustomBlock fourBlock = IDDecompiler.getInstance().decompile(config.getString("voting.fourth-slot.id"));
			
			ItemStack four = new ItemStack(fourBlock.getMaterial());
			four.setDurability(fourBlock.getData());
			ItemMeta fourMeta = four.getItemMeta();
			fourMeta.setDisplayName(messages.getString("voting.fourth-slot-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			four.setItemMeta(fourMeta);
			player.getInventory().setItem(3, four);
		
			CustomBlock fiveBlock = IDDecompiler.getInstance().decompile(config.getString("voting.fifth-slot.id"));
			
			ItemStack five = new ItemStack(fiveBlock.getMaterial());
			five.setDurability(fiveBlock.getData());
			ItemMeta fiveMeta = five.getItemMeta();
			fiveMeta.setDisplayName(messages.getString("voting.fifth-slot-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			five.setItemMeta(fiveMeta);
			player.getInventory().setItem(4, five);
		
			CustomBlock sixBlock = IDDecompiler.getInstance().decompile(config.getString("voting.sixth-slot.id"));
			
			ItemStack six = new ItemStack(sixBlock.getMaterial());
			six.setDurability(sixBlock.getData());
			ItemMeta sixMeta = six.getItemMeta();
			sixMeta.setDisplayName(messages.getString("voting.sixth-slot-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			six.setItemMeta(sixMeta);
			player.getInventory().setItem(5, six);
		
			CustomBlock sevenBlock = IDDecompiler.getInstance().decompile(config.getString("voting.seventh-slot.id"));
			
			ItemStack seven = new ItemStack(sevenBlock.getMaterial());
			seven.setDurability(sevenBlock.getData());
			ItemMeta sevenMeta = seven.getItemMeta();
			sevenMeta.setDisplayName(messages.getString("voting.seventh-slot-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			seven.setItemMeta(sevenMeta);
			player.getInventory().setItem(6, seven);
			
			CustomBlock eightBlock = IDDecompiler.getInstance().decompile(config.getString("voting.eighth-slot.id"));
			
			ItemStack eight = new ItemStack(eightBlock.getMaterial());
			eight.setDurability(eightBlock.getData());
			ItemMeta eightMeta = eight.getItemMeta();
			eightMeta.setDisplayName(messages.getString("voting.eighth-slot-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			eight.setItemMeta(eightMeta);
			player.getInventory().setItem(7, eight);
		} catch (NullPointerException npe) {
			MessageManager.getInstance().send(player, ChatColor.RED + "There's a wrong id in your config. Please fix this in order to receive the blocks.");
		}
	}
}