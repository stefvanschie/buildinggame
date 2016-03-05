package com.gmail.stefvanschiedev.buildinggame.events.player.gui.buildmenu.heads.food;

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
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.food.FoodHeadsMenuOne;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.food.FoodHeadsMenuThree;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.food.FoodHeadsMenuTwo;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;

public class FoodHeadsPageClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Inventory inventory = e.getInventory();
		ItemStack item = e.getCurrentItem();
		Player player = (Player) e.getWhoClicked();
		
		if (ArenaManager.getInstance().getArena(player) == null)
			return;
		
		if (!(inventory.getName().equals(MessageManager.translate(messages.getString("gui.heads.food.page-1.title"))) ||
				inventory.getName().equals(MessageManager.translate(messages.getString("gui.heads.food.page-2.title"))) ||
				inventory.getName().equals(MessageManager.translate(messages.getString("gui.heads.food.page-3.title")))))
			return;
		
		if (item == null)
			return;
		
		if (item.getType() != Material.SUGAR_CANE)
			return;
		
		if (!item.hasItemMeta())
			return;
		
		switch (new NBTItem(item).getInteger("page")) {
			case 1:
				new FoodHeadsMenuOne().show(player);
				break;
			case 2:
				new FoodHeadsMenuTwo().show(player);
				break;
			case 3:
				new FoodHeadsMenuThree().show(player);
				break;
			default:
				break;
		}
		e.setCancelled(true);
	}
}