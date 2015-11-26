package me.stefvanschie.buildinggame.utils.guis.buildmenu;

import java.util.ArrayList;
import java.util.List;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.id.IDDecompiler;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.CustomBlock;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BuildMenu {

	public BuildMenu() {}

	public void show(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 36, messages.getString("gui.options-title")
				.replaceAll("&", "§"));
		try {
			// particles item
			CustomBlock particleBlock = IDDecompiler.getInstance().decompile(config.getString("gui.particle-id"));
			
			ItemStack particle = new ItemStack(particleBlock.getMaterial(), 1);
			particle.setDurability(particleBlock.getData());
			{
				ItemMeta particleMeta = particle.getItemMeta();
				particleMeta.setDisplayName(messages.getString("gui.particles.name")
						.replaceAll("&", "§"));
				{
					List<String> particleLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.particles.lores")) {
						particleLores.add((lore)
								.replaceAll("&", "§"));
					}
					particleMeta.setLore(particleLores);
				}
				particle.setItemMeta(particleMeta);
			}

			// floor block item
			CustomBlock floorBlock = IDDecompiler.getInstance().decompile(config.getString("gui.floor-id"));
			
			ItemStack floor = new ItemStack(floorBlock.getMaterial(), 1);
			floor.setDurability(floorBlock.getData());
			{
				ItemMeta floorMeta = floor.getItemMeta();
				floorMeta.setDisplayName(messages.getString("gui.floor.name")
						.replaceAll("&", "§"));
				{
					List<String> floorLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.floor.lores")) {
						floorLores.add((lore)
								.replaceAll("&", "§"));
					}
					floorMeta.setLore(floorLores);
				}
				floor.setItemMeta(floorMeta);
			}

			// plot time item
			CustomBlock timeBlock = IDDecompiler.getInstance().decompile(config.getString("gui.time-id"));
			
			ItemStack time = new ItemStack(timeBlock.getMaterial(), 1);
			time.setDurability(timeBlock.getData());
			{
				ItemMeta timeMeta = time.getItemMeta();
				timeMeta.setDisplayName(messages.getString("gui.time.name")
						.replaceAll("&", "§"));
				{
					List<String> timeLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.time.lores")) {
						timeLores.add((lore)
								.replaceAll("&", "§"));
					}
					timeMeta.setLore(timeLores);
				}
				time.setItemMeta(timeMeta);
			}

			// rain item
			CustomBlock rainBlock = IDDecompiler.getInstance().decompile(config.getString("gui.rain-id"));
			
			ItemStack rain = new ItemStack(rainBlock.getMaterial(), 1);
			rain.setDurability(rainBlock.getData());
			{
				ItemMeta rainMeta = rain.getItemMeta();
				rainMeta.setDisplayName(messages.getString("gui.rain.name")
						.replaceAll("&", "§"));
				{
					List<String> rainLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.rain.lores")) {
						rainLores.add((lore)
								.replaceAll("&", "§"));
					}
					rainMeta.setLore(rainLores);
				}
				rain.setItemMeta(rainMeta);
			}

			// flight speed item
			CustomBlock speedBlock = IDDecompiler.getInstance().decompile(config.getString("gui.fly-speed-id"));
			
			ItemStack speed = new ItemStack(speedBlock.getMaterial(), 1);
			speed.setDurability(speedBlock.getData());
			{
				ItemMeta speedMeta = speed.getItemMeta();
				speedMeta.setDisplayName(messages.getString("gui.fly-speed.name")
						.replaceAll("&", "§"));
				{
					List<String> speedLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.fly-speed.lores")) {
						speedLores.add((lore)
								.replaceAll("&", "§"));
					}
					speedMeta.setLore(speedLores);
				}
				speed.setItemMeta(speedMeta);
			}

			// close item
			ItemStack close = new ItemStack(Material.BOOK, 1);
			{
				ItemMeta closeMeta = close.getItemMeta();
				closeMeta.setDisplayName(messages.getString("gui.close-menu.name")
						.replaceAll("&", "§"));
				{
					List<String> closeLores = new ArrayList<String>();
					for (String lore : messages.getStringList("gui.close-menu.lores")) {
						closeLores.add(lore.replaceAll("&", "§"));
					}
					closeMeta.setLore(closeLores);
				}
				close.setItemMeta(closeMeta);
			}
			
			inventory.setItem(11, particle);
			inventory.setItem(13, floor);
			inventory.setItem(15, time);
			inventory.setItem(21, rain);
			inventory.setItem(23, speed);
			inventory.setItem(31, close);
			
		} catch (NullPointerException e) {
			MessageManager.getInstance().send(player, ChatColor.RED + "There's a wrong id in your config. Please fix this in order to open the menu.");
		}

		player.openInventory(inventory);
	}

}
