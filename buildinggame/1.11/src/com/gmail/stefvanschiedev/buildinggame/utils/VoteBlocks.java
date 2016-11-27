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
			ItemStack two = IDDecompiler.getInstance().decompile(config.getString("voting.second-slot.id"));
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
		
			ItemStack three = IDDecompiler.getInstance().decompile(config.getString("voting.third-slot.id"));
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
		
			ItemStack four = IDDecompiler.getInstance().decompile(config.getString("voting.fourth-slot.id"));
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
		
			ItemStack five = IDDecompiler.getInstance().decompile(config.getString("voting.fifth-slot.id"));
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
		
			ItemStack six = IDDecompiler.getInstance().decompile(config.getString("voting.sixth-slot.id"));
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
		
			ItemStack seven = IDDecompiler.getInstance().decompile(config.getString("voting.seventh-slot.id"));
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
			
			ItemStack eight = IDDecompiler.getInstance().decompile(config.getString("voting.eighth-slot.id"));
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