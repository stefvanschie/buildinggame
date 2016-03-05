package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.particle;

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
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.BuildMenu;

public class ParticleBackClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		if (!inventory.getName().equals(messages.getString("gui.particles.title")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			return;
		}
		
		if (e.getCurrentItem() == null) {
			return;
		}
		
		ItemStack currentItem = e.getCurrentItem();
		
		if (currentItem.getType() != Material.BOOK) {
			return;
		}
		if (!currentItem.hasItemMeta()) {
			return;
		}
		if (!currentItem.getItemMeta().getDisplayName().equals(messages.getString("gui.particles.back.name")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			return;
		}
		
		BuildMenu menu = new BuildMenu();
		menu.show(player);
		
		e.setCancelled(true);
	}
	
}
