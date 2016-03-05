package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.CustomBlock;

public class BuildMenu {

	public BuildMenu() {}

	public void show(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 36, messages.getString("gui.options-title")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"));
		try {
			// particles item
			CustomBlock particleBlock = IDDecompiler.getInstance().decompile(config.getString("gui.particles.id"));
			
			ItemStack particle = new ItemStack(particleBlock.getMaterial(), 1);
			particle.setDurability(particleBlock.getData());
			{
				ItemMeta particleMeta = particle.getItemMeta();
				particleMeta.setDisplayName(messages.getString("gui.particles.name")
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replaceAll("&", "§"));
				{
					List<String> particleLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.particles.lores")) {
						particleLores.add((lore)
								.replace("%:a%", "ä")
								.replace("%:e%", "ë")
								.replace("%:i%", "ï")
								.replace("%:o%", "ö")
								.replace("%:u%", "ü")
								.replace("%ss%", "ß")
								.replaceAll("&", "§"));
					}
					particleMeta.setLore(particleLores);
				}
				particle.setItemMeta(particleMeta);
			}

			// floor block item
			CustomBlock floorBlock = IDDecompiler.getInstance().decompile(config.getString("gui.floor.id"));
			
			ItemStack floor = new ItemStack(floorBlock.getMaterial(), 1);
			floor.setDurability(floorBlock.getData());
			{
				ItemMeta floorMeta = floor.getItemMeta();
				floorMeta.setDisplayName(messages.getString("gui.floor.name")
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replaceAll("&", "§"));
				{
					List<String> floorLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.floor.lores")) {
						floorLores.add((lore)
								.replace("%:a%", "ä")
								.replace("%:e%", "ë")
								.replace("%:i%", "ï")
								.replace("%:o%", "ö")
								.replace("%:u%", "ü")
								.replace("%ss%", "ß")
								.replaceAll("&", "§"));
					}
					floorMeta.setLore(floorLores);
				}
				floor.setItemMeta(floorMeta);
			}

			// plot time item
			CustomBlock timeBlock = IDDecompiler.getInstance().decompile(config.getString("gui.time.id"));
			
			ItemStack time = new ItemStack(timeBlock.getMaterial(), 1);
			time.setDurability(timeBlock.getData());
			{
				ItemMeta timeMeta = time.getItemMeta();
				timeMeta.setDisplayName(messages.getString("gui.time.name")
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replaceAll("&", "§"));
				{
					List<String> timeLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.time.lores")) {
						timeLores.add((lore)
								.replace("%:a%", "ä")
								.replace("%:e%", "ë")
								.replace("%:i%", "ï")
								.replace("%:o%", "ö")
								.replace("%:u%", "ü")
								.replace("%ss%", "ß")
								.replaceAll("&", "§"));
					}
					timeMeta.setLore(timeLores);
				}
				time.setItemMeta(timeMeta);
			}

			// rain item
			CustomBlock rainBlock = IDDecompiler.getInstance().decompile(config.getString("gui.rain.id"));
			
			ItemStack rain = new ItemStack(rainBlock.getMaterial(), 1);
			rain.setDurability(rainBlock.getData());
			{
				ItemMeta rainMeta = rain.getItemMeta();
				rainMeta.setDisplayName(messages.getString("gui.rain.name")
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replaceAll("&", "§"));
				{
					List<String> rainLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.rain.lores")) {
						rainLores.add((lore)
								.replace("%:a%", "ä")
								.replace("%:e%", "ë")
								.replace("%:i%", "ï")
								.replace("%:o%", "ö")
								.replace("%:u%", "ü")
								.replace("%ss%", "ß")
								.replaceAll("&", "§"));
					}
					rainMeta.setLore(rainLores);
				}
				rain.setItemMeta(rainMeta);
			}

			//flight speed item
			CustomBlock speedBlock = IDDecompiler.getInstance().decompile(config.getString("gui.fly-speed.id"));
			
			ItemStack speed = new ItemStack(speedBlock.getMaterial(), 1);
			speed.setDurability(speedBlock.getData());
			{
				ItemMeta speedMeta = speed.getItemMeta();
				speedMeta.setDisplayName(messages.getString("gui.fly-speed.name")
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replaceAll("&", "§"));
				{
					List<String> speedLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.fly-speed.lores")) {
						speedLores.add((lore)
								.replace("%:a%", "ä")
								.replace("%:e%", "ë")
								.replace("%:i%", "ï")
								.replace("%:o%", "ö")
								.replace("%:u%", "ü")
								.replace("%ss%", "ß")
								.replaceAll("&", "§"));
					}
					speedMeta.setLore(speedLores);
				}
				speed.setItemMeta(speedMeta);
			}

			//heads item
			CustomBlock headsBlock = IDDecompiler.getInstance().decompile(config.getString("gui.heads.id"));
			
			ItemStack heads = new ItemStack(headsBlock.getMaterial(), 1);
			heads.setDurability(headsBlock.getData());
			{
				ItemMeta headsMeta = heads.getItemMeta();
				headsMeta.setDisplayName(messages.getString("gui.heads.name")
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replaceAll("&", "§"));
				{
					List<String> headsLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.heads.lores")) {
						headsLores.add(lore
								.replace("%:a%", "ä")
								.replace("%:e%", "ë")
								.replace("%:i%", "ï")
								.replace("%:o%", "ö")
								.replace("%:u%", "ü")
								.replace("%ss%", "ß")
								.replaceAll("&", "§"));
					}
					headsMeta.setLore(headsLores);
				}
				heads.setItemMeta(headsMeta);
			}
			// close item
			ItemStack close = new ItemStack(Material.BOOK, 1);
			{
				ItemMeta closeMeta = close.getItemMeta();
				closeMeta.setDisplayName(messages.getString("gui.close-menu.name")
						.replace("%:a%", "ä")
						.replace("%:e%", "ë")
						.replace("%:i%", "ï")
						.replace("%:o%", "ö")
						.replace("%:u%", "ü")
						.replace("%ss%", "ß")
						.replaceAll("&", "§"));
				{
					List<String> closeLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.close-menu.lores")) {
						closeLores.add(lore
								.replace("%:a%", "ä")
								.replace("%:e%", "ë")
								.replace("%:i%", "ï")
								.replace("%:o%", "ö")
								.replace("%:u%", "ü")
								.replace("%ss%", "ß")
								.replaceAll("&", "§"));
					}
					closeMeta.setLore(closeLores);
				}
				close.setItemMeta(closeMeta);
			}
			
			if (config.getBoolean("gui.particles.enabled") && player.hasPermission("bg.buildmenu.particles"))
				inventory.setItem(11, particle);
			if (config.getBoolean("gui.floor.enabled") && player.hasPermission("bg.buildmenu.floor"))
				inventory.setItem(13, floor);
			if (config.getBoolean("gui.time.enabled") && player.hasPermission("bg.buildmenu.time"))
				inventory.setItem(15, time);
			if (config.getBoolean("gui.rain.enabled") && player.hasPermission("bg.buildmenu.rain"))
				inventory.setItem(20, rain);
			if (config.getBoolean("gui.fly-speed.enabled") && player.hasPermission("bg.buildmenu.flyspeed"))
				inventory.setItem(22, speed);
			if (config.getBoolean("gui.heads.enabled") && player.hasPermission("bg.buildmenu.heads"))
				inventory.setItem(24, heads);
			//banners: 24
			inventory.setItem(31, close);
			
		} catch (NullPointerException e) {
			MessageManager.getInstance().send(player, ChatColor.RED + "There's a wrong id in your config. Please fix this in order to open the menu.");
		}

		player.openInventory(inventory);
	}

}
