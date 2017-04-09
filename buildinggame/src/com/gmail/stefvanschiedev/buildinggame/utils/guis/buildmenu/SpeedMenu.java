package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;

class SpeedMenu extends Gui {

	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();
	
	public SpeedMenu() {
		super(null, 18, MessageManager.translate(MESSAGES.getString("gui.fly-speed.title")), 1);
		
		//fly speed 1
		ItemStack speed1 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed1Meta = speed1.getItemMeta();
		speed1Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.speed-1.name")));
		speed1Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.speed-1.lores")));
		speed1.setItemMeta(speed1Meta);
		
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
		
		//fly speed 2
		ItemStack speed2 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed2Meta = speed2.getItemMeta();
		speed2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.speed-2.name")));
		speed2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.speed-2.lores")));
		speed2.setItemMeta(speed2Meta);
		
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
		
		//fly speed 3
		ItemStack speed3 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed3Meta = speed3.getItemMeta();
		speed3Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.speed-3.name")));
		speed3Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.speed-3.lores")));
		speed3.setItemMeta(speed3Meta);
		
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
		
		//fly speed 4
		ItemStack speed4 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed4Meta = speed4.getItemMeta();
		speed4Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.speed-4.name")));
		speed4Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.speed-4.lores")));
		speed4.setItemMeta(speed4Meta);
		
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
		
		//fly speed 5
		ItemStack speed5 = new ItemStack(Material.FEATHER, 1);
		ItemMeta speed5Meta = speed5.getItemMeta();
		speed5Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.speed-5.name")));
		speed5Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.speed-5.lores")));
		speed5.setItemMeta(speed5Meta);
		
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
		
		//back
		ItemStack back = new ItemStack(Material.BOOK, 1);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.fly-speed.back.name")));
		backMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.fly-speed.back.lores")));
		back.setItemMeta(backMeta);
		
		setItem(back, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				
				ArenaManager.getInstance().getArena(player).getPlot(player).getBuildMenu().open(player);
				removePlayer(player);
				return true;
			}
		}, 17);
	}
}