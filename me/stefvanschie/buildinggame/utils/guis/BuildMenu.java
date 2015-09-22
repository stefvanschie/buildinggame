package me.stefvanschie.buildinggame.utils.guis;

import java.util.ArrayList;
import java.util.List;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class BuildMenu {

	public BuildMenu() {
	}

	public void show(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 36, messages.getString("gui.options-title").replaceAll("&", "§"));
		try {
			// particles item
			ItemStack particle = new ItemStack(Material.getMaterial(config.getString("gui.particle-id").toUpperCase()), 1);
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
			ItemStack floor = new ItemStack(Material.getMaterial(config.getString("gui.floor-id").toUpperCase()), 1);
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
			ItemStack time = new ItemStack(Material.getMaterial(config.getString("gui.time-id").toUpperCase()), 1);
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
			ItemStack rain = new ItemStack(Material.getMaterial(config.getString("gui.rain-id").toUpperCase()), 1);
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
			ItemStack speed = new ItemStack(Material.getMaterial(config.getString("gui.fly-speed-id").toUpperCase()), 1);
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
				closeMeta.setDisplayName(ChatColor.GREEN + "Close menu");
				{
					List<String> closeLores = new ArrayList<String>();
					closeLores.add(ChatColor.GRAY + "Close the options menu");
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
