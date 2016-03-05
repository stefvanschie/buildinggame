package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.devices;

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
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.devices.DevicesHeadsMenuTwo;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;

public class DevicesHeadsPageClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = e.getInventory();
		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if (ArenaManager.getInstance().getArena(player) == null)
			return;
		
		if (!(inventory.getName().equals(MessageManager.translate(messages.getString("gui.heads.devices.page-1.title"))) ||
				inventory.getName().equals(MessageManager.translate(messages.getString("gui.heads.devices.page-2.title")))))
			return;
		
		if (item == null)
			return;
		
		if (item.getType() != Material.SUGAR_CANE)
			return;
		
		if (!item.hasItemMeta())
			return;
		
		switch (new NBTItem(item).getInteger("page")) {
			case 1:
				new DevicesHeadsMenuOne().show(player);
				break;
			case 2:
				new DevicesHeadsMenuTwo().show(player);
				break;
			default:
				break;
		}
		e.setCancelled(true);
	}
}
