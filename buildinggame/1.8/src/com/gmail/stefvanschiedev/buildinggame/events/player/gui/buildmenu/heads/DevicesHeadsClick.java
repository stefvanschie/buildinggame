package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.devices.DevicesHeadsMenuOne;

public class DevicesHeadsClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = e.getInventory();
		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		if (!inventory.getName().equals(MessageManager.translate(messages.getString("gui.heads.title")))) {
			return;
		}
		
		if (item == null) {
			return;
		}
		
		if (item.getType() != Material.SKULL_ITEM) {
			return;
		}
		
		if (!item.hasItemMeta()) {
			return;
		}
		
		if (!item.getItemMeta().getDisplayName().equals(MessageManager.translate(messages.getString("gui.heads.devices.name")))) {
			return;
		}
		
		new DevicesHeadsMenuOne().show(player);
		e.setCancelled(true);
	}
}