package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.alphabet;

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

public class AlphabetHeadsSkullClick implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = e.getInventory();
		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		if (!(inventory.getName().equals(MessageManager.translate(messages.getString("gui.heads.alphabet.page-1.title"))) ||
				inventory.getName().equals(MessageManager.translate(messages.getString("gui.heads.alphabet.page-2.title"))) ||
				inventory.getName().equals(MessageManager.translate(messages.getString("gui.heads.alphabet.page-3.title"))))) {
			return;
		}
		
		if (item == null) {
			return;
		}
		
		if (item.getType() != Material.SKULL_ITEM) {
			return;
		}
		
		e.setCancelled(true);
		e.setCursor(item);
	}
}