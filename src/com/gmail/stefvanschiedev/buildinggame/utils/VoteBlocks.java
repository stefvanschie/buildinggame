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
			CustomBlock twoBlock = IDDecompiler.getInstance().decompile(config.getString("voting.two-points-id"));
			
			ItemStack two = new ItemStack(twoBlock.getMaterial());
			two.setDurability(twoBlock.getData());
			ItemMeta twoMeta = two.getItemMeta();
			twoMeta.setDisplayName(messages.getString("voting.two-points-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			two.setItemMeta(twoMeta);
			player.getInventory().setItem(1, two);
		
			CustomBlock threeBlock = IDDecompiler.getInstance().decompile(config.getString("voting.three-points-id"));
			
			ItemStack three = new ItemStack(threeBlock.getMaterial());
			three.setDurability(threeBlock.getData());
			ItemMeta threeMeta = three.getItemMeta();
			threeMeta.setDisplayName(messages.getString("voting.three-points-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			three.setItemMeta(threeMeta);
			player.getInventory().setItem(2, three);
		
			CustomBlock fourBlock = IDDecompiler.getInstance().decompile(config.getString("voting.four-points-id"));
			
			ItemStack four = new ItemStack(fourBlock.getMaterial());
			four.setDurability(fourBlock.getData());
			ItemMeta fourMeta = four.getItemMeta();
			fourMeta.setDisplayName(messages.getString("voting.four-points-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			four.setItemMeta(fourMeta);
			player.getInventory().setItem(3, four);
		
			CustomBlock fiveBlock = IDDecompiler.getInstance().decompile(config.getString("voting.five-points-id"));
			
			ItemStack five = new ItemStack(fiveBlock.getMaterial());
			five.setDurability(fiveBlock.getData());
			ItemMeta fiveMeta = five.getItemMeta();
			fiveMeta.setDisplayName(messages.getString("voting.five-points-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			five.setItemMeta(fiveMeta);
			player.getInventory().setItem(4, five);
		
			CustomBlock sixBlock = IDDecompiler.getInstance().decompile(config.getString("voting.six-points-id"));
			
			ItemStack six = new ItemStack(sixBlock.getMaterial());
			six.setDurability(sixBlock.getData());
			ItemMeta sixMeta = six.getItemMeta();
			sixMeta.setDisplayName(messages.getString("voting.six-points-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			six.setItemMeta(sixMeta);
			player.getInventory().setItem(5, six);
		
			CustomBlock sevenBlock = IDDecompiler.getInstance().decompile(config.getString("voting.seven-points-id"));
			
			ItemStack seven = new ItemStack(sevenBlock.getMaterial());
			seven.setDurability(sevenBlock.getData());
			ItemMeta sevenMeta = seven.getItemMeta();
			sevenMeta.setDisplayName(messages.getString("voting.seven-points-block")
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
					.replaceAll("&", "§"));
			seven.setItemMeta(sevenMeta);
			player.getInventory().setItem(6, seven);
			
			CustomBlock eightBlock = IDDecompiler.getInstance().decompile(config.getString("voting.eight-points-id"));
			
			ItemStack eight = new ItemStack(eightBlock.getMaterial());
			eight.setDurability(eightBlock.getData());
			ItemMeta eightMeta = eight.getItemMeta();
			eightMeta.setDisplayName(messages.getString("voting.eight-points-block")
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
			MessageManager.getInstance().send(player, ChatColor.RED + "There's a wrong id in your config. Please fix this in order to open the menu.");
		}
	}
}