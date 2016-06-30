package com.gmail.stefvanschiedev.buildinggame.utils.guis.spectatormenu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class SpeedMenu {

	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 18, MessageManager.translate(messages.getString("gui.fly-speed.title")));
		
		//fly speed 1
		ItemStack speed1 = new ItemStack(Material.FEATHER, 1);
		{
			ItemMeta speed1Meta = speed1.getItemMeta();
			speed1Meta.setDisplayName(MessageManager.translate(messages.getString("gui.fly-speed.speed-1.name")));
			{
				List<String> speed1Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.fly-speed.speed-1.lores"))
					speed1Lores.add(MessageManager.translate(lore));
				speed1Meta.setLore(speed1Lores);
			}
			speed1.setItemMeta(speed1Meta);
		}
		
		//fly speed 2
		ItemStack speed2 = new ItemStack(Material.FEATHER, 1);
		{
			ItemMeta speed2Meta = speed2.getItemMeta();
			speed2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.fly-speed.speed-2.name")));
			{
				List<String> speed2Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.fly-speed.speed-2.lores"))
					speed2Lores.add(MessageManager.translate(lore));
				speed2Meta.setLore(speed2Lores);
			}
			speed2.setItemMeta(speed2Meta);
		}
		
		//fly speed 3
		ItemStack speed3 = new ItemStack(Material.FEATHER, 1);
		{
			ItemMeta speed3Meta = speed3.getItemMeta();
			speed3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.fly-speed.speed-3.name")));
			{
				List<String> speed3Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.fly-speed.speed-3.lores"))
					speed3Lores.add(MessageManager.translate(lore));
				speed3Meta.setLore(speed3Lores);
			}
			speed3.setItemMeta(speed3Meta);
		}
		
		//fly speed 4
		ItemStack speed4 = new ItemStack(Material.FEATHER, 1);
		{
			ItemMeta speed4Meta = speed4.getItemMeta();
			speed4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.fly-speed.speed-4.name")));
			{
				List<String> speed4Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.fly-speed.speed-4.lores"))
					speed4Lores.add(MessageManager.translate(lore));
				speed4Meta.setLore(speed4Lores);
			}
			speed4.setItemMeta(speed4Meta);
		}
		
		//fly speed 5
		ItemStack speed5 = new ItemStack(Material.FEATHER, 1);
		{
			ItemMeta speed5Meta = speed5.getItemMeta();
			speed5Meta.setDisplayName(MessageManager.translate(messages.getString("gui.fly-speed.speed-5.name")));
			{
				List<String> speed5Lores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.fly-speed.speed-5.lores"))
					speed5Lores.add(MessageManager.translate(lore));
				speed5Meta.setLore(speed5Lores);
			}
			speed5.setItemMeta(speed5Meta);
		}
		
		//back
		ItemStack back = new ItemStack(Material.BOOK, 1);
		{
			ItemMeta backMeta = back.getItemMeta();
			backMeta.setDisplayName(MessageManager.translate(messages.getString("gui.fly-speed.back.name")));
			{
				List<String> backLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.fly-speed.back.lores"))
					backLores.add(MessageManager.translate(lore));
				backMeta.setLore(backLores);
			}
			back.setItemMeta(backMeta);
		}
		
		inventory.setItem(2, speed1);
		inventory.setItem(3, speed2);
		inventory.setItem(4, speed3);
		inventory.setItem(5, speed4);
		inventory.setItem(6, speed5);
		inventory.setItem(17, back);
		
		player.openInventory(inventory);
	}
}