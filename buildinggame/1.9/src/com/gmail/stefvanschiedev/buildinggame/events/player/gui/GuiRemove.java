package com.gmail.stefvanschiedev.buildinggame.events.player.gui;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

public class GuiRemove implements Listener {
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		ItemStack item = e.getCurrentItem();
		
		if (ArenaManager.getInstance().getArena(player) == null)
			return;
		
		if (item == null)
			return;
		
		if (item.getType() != Material.EMERALD)
			return;
		
		if (!item.hasItemMeta())
			return;
		
		if (!item.getItemMeta().getDisplayName().equals(messages.getString("gui.options-emerald")
				.replaceAll("&", "§")))
			return;
		
		e.setCancelled(true);
	}
}