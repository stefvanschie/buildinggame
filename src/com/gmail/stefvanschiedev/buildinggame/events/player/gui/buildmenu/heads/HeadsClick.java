package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.utils.CustomBlock;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.HeadsMenu;

public class HeadsClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}

		if (!inventory.getName().equals(messages.getString("gui.options-title")
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
		
		CustomBlock block = IDDecompiler.getInstance().decompile(config.getString("gui.heads.id"));
		
		if (currentItem.getType() != block.getMaterial()) {
			return;
		}
		if (currentItem.getDurability() != block.getData()) {
			return;
		}
		
		if (!currentItem.hasItemMeta()) {
			return;
		}
		
		if (!currentItem.getItemMeta().getDisplayName().equals(messages.getString("gui.heads.name")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"))) {
			return;
		}
		
		new HeadsMenu().show(player);
		e.setCancelled(true);
	}
	
}
