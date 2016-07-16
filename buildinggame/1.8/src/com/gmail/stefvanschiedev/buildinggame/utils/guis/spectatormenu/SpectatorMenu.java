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

public class SpectatorMenu {

	public void show(Player player) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = Bukkit.createInventory(null, 36, MessageManager.translate(messages.getString("subject-gui.title")));
		
		ItemStack speed = new ItemStack(Material.FEATHER);
		ItemMeta speedMeta = speed.getItemMeta();
		speedMeta.setDisplayName(MessageManager.translate(messages.getString("subject-gui.fly-speed.name")));
		List<String> speedLores = new ArrayList<String>();
		for (String lore : MessageManager.translate(messages.getStringList("subject-gui.fly-speed.lores")))
			speedLores.add(lore);
		speedMeta.setLore(speedLores);
		speed.setItemMeta(speedMeta);
		
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("subject-gui.close-menu.name")));
		List<String> closeLores = new ArrayList<String>();
		for (String lore : MessageManager.translate(messages.getStringList("subject-gui.close-menu.lores")))
			closeLores.add(lore);
		closeMeta.setLore(closeLores);
		close.setItemMeta(closeMeta);
		
		inventory.setItem(13, speed);
		inventory.setItem(22, close);
		
		player.openInventory(inventory);
	}
}