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

class SpeedMenu extends Gui {

	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();
	
	public SpeedMenu() {
		super(null, 18, MessageManager.translate(MESSAGES.getString("spectator-gui.fly-speed.title")), 1);
		
		ItemStack speed1 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed1Meta = speed1.getItemMeta();
		speed1Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("spectator-gui.fly-speed.speed-1.name")));
		List<String> speed1Lores = new ArrayList<>();
		for (String lore : MESSAGES.getStringList("spectator-gui.fly-speed.speed-1.lores"))
			speed1Lores.add(MessageManager.translate(lore));
		speed1Meta.setLore(speed1Lores);
		speed1.setItemMeta(speed1Meta);
		
		ItemStack speed2 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed2Meta = speed2.getItemMeta();
		speed2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("spectator-gui.fly-speed.speed-2.name")));
		List<String> speed2Lores = new ArrayList<>();
		for (String lore : MESSAGES.getStringList("spectator-gui.fly-speed.speed-2.lores"))
			speed2Lores.add(MessageManager.translate(lore));
		speed2Meta.setLore(speed2Lores);
		speed2.setItemMeta(speed2Meta);
		
		ItemStack speed3 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed3Meta = speed3.getItemMeta();
		speed3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("spectator-gui.fly-speed.speed-3.name")));
		List<String> speed3Lores = new ArrayList<>();
		for (String lore : MESSAGES.getStringList("spectator-gui.fly-speed.speed-3.lores"))
			speed3Lores.add(MessageManager.translate(lore));
		speed3Meta.setLore(speed3Lores);
		speed3.setItemMeta(speed3Meta);
		
		ItemStack speed4 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed4Meta = speed4.getItemMeta();
		speed4Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("spectator-gui.fly-speed.speed-4.name")));
		List<String> speed4Lores = new ArrayList<>();
		for (String lore : MESSAGES.getStringList("spectator-gui.fly-speed.speed-4.lores"))
			speed4Lores.add(MessageManager.translate(lore));
		speed4Meta.setLore(speed4Lores);
		speed4.setItemMeta(speed4Meta);
		
		ItemStack speed5 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed5Meta = speed5.getItemMeta();
		speed5Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("spectator-gui.fly-speed.speed-5.name")));
		List<String> speed5Lores = new ArrayList<>();
		for (String lore : MESSAGES.getStringList("spectator-gui.fly-speed.speed-5.lores"))
			speed5Lores.add(MessageManager.translate(lore));
		speed5Meta.setLore(speed5Lores);
		speed5.setItemMeta(speed5Meta);
		
		ItemStack back = new ItemStack(Material.BOOK, 1);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("spectator-gui.fly-speed.back.name")));
		List<String> backLores = new ArrayList<>();
		for (String lore : MESSAGES.getStringList("spectator-gui.fly-speed.back.lores"))
			backLores.add(MessageManager.translate(lore));
		backMeta.setLore(backLores);
		back.setItemMeta(backMeta);
		
		setItem(speed1, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				((Player) event.getWhoClicked()).setFlySpeed(.1F);
				return true;
			}
		}, 2);
		
		setItem(speed2, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				((Player) event.getWhoClicked()).setFlySpeed(.2F);
				return true;
			}
		}, 3);
		
		setItem(speed3, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				((Player) event.getWhoClicked()).setFlySpeed(.3F);
				return true;
			}
		}, 4);
		
		setItem(speed4, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				((Player) event.getWhoClicked()).setFlySpeed(.4F);
				return true;
			}
		}, 5);
		
		setItem(speed5, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				((Player) event.getWhoClicked()).setFlySpeed(.5F);
				return true;
			}
		}, 6);
		
		setItem(back, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				new SpectatorMenu().open((Player) event.getWhoClicked()); 
				return true;
			}
		}, 17);
	}
}