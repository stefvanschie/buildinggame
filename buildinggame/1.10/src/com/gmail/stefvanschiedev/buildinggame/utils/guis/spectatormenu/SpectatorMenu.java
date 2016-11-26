package com.gmail.stefvanschiedev.buildinggame.utils.guis.spectatormenu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;

public class SpectatorMenu extends Gui {

	private static YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public SpectatorMenu() {
		super(null, 36, MessageManager.translate(messages.getString("spectator-gui.title")), 1);
		
		ItemStack speed = new ItemStack(Material.FEATHER);
		ItemMeta speedMeta = speed.getItemMeta();
		speedMeta.setDisplayName(MessageManager.translate(messages.getString("spectator-gui.fly-speed.name")));
		List<String> speedLores = new ArrayList<String>();
		for (String lore : MessageManager.translate(messages.getStringList("spectator-gui.fly-speed.lores")))
			speedLores.add(lore);
		speedMeta.setLore(speedLores);
		speed.setItemMeta(speedMeta);
		
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("spectator-gui.close-menu.name")));
		List<String> closeLores = new ArrayList<String>();
		for (String lore : MessageManager.translate(messages.getStringList("spectator-gui.close-menu.lores")))
			closeLores.add(lore);
		closeMeta.setLore(closeLores);
		close.setItemMeta(closeMeta);
		
		setItem(speed, new GuiAction() {
			
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				new SpeedMenu().open((Player) event.getWhoClicked());
				return true;
			}
		}, 13);
		
		setItem(close, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				event.getWhoClicked().closeInventory();
				return true;
			}
		}, 22);
	}
}