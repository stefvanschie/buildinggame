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
import com.gmail.stefvanschiedev.buildinggame.utils.Time;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;

class TimeMenu extends Gui {

	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();
	
	TimeMenu() {
		super(null, 18, MessageManager.translate(MESSAGES.getString("gui.time.title")), 1);
		
		//midnight
		ItemStack midnight = new ItemStack(Material.WATCH, 1);
		ItemMeta midnightMeta = midnight.getItemMeta();
		midnightMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.midnight.name")));
		midnightMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.midnight.lores")));
		midnight.setItemMeta(midnightMeta);
		
		setItem(midnight, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.MIDNIGHT);
				return true;
			}
		}, 0);
		
		//2 AM
		ItemStack am2 = new ItemStack(Material.WATCH, 1);
		ItemMeta am2Meta = am2.getItemMeta();
		am2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.2am.name")));
		am2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.2am.lores")));
		am2.setItemMeta(am2Meta);
		
		setItem(am2, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.AM2);
				return true;
			}
		}, 1);
		
		//4 AM
		ItemStack am4 = new ItemStack(Material.WATCH, 1);
		ItemMeta am4Meta = am4.getItemMeta();
		am4Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.4am.name")));
		am4Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.4am.lores")));
		am4.setItemMeta(am4Meta);
		
		setItem(am4, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.AM4);
				return true;
			}
		}, 2);
		
		//6 AM
		ItemStack am6 = new ItemStack(Material.WATCH, 1);
		ItemMeta am6Meta = am6.getItemMeta();
		am6Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.6am.name")));
		am6Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.6am.lores")));
		am6.setItemMeta(am6Meta);
		
		setItem(am6, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.AM6);
				return true;
			}
		}, 3);
		
		//8 AM
		ItemStack am8 = new ItemStack(Material.WATCH, 1);
		ItemMeta am8Meta = am8.getItemMeta();
		am8Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.8am.name")));
		am8Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.8am.lores")));
		am8.setItemMeta(am8Meta);
		
		setItem(am8, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.AM8);
				return true;
			}
		}, 4);
		
		//10 AM
		ItemStack am10 = new ItemStack(Material.WATCH, 1);
		ItemMeta am10Meta = am10.getItemMeta();
		am10Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.10am.name")));
		am10Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.10am.lores")));
		am10.setItemMeta(am10Meta);
		
		setItem(am10, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.AM10);
				return true;
			}
		}, 5);
		
		//Midday
		ItemStack midday = new ItemStack(Material.WATCH, 1); 
		ItemMeta middayMeta = midday.getItemMeta();
		middayMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.midday.name")));
		middayMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.midday.lores")));
		midday.setItemMeta(middayMeta);
		
		setItem(midday, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.MIDDAY);
				return true;
			}
		}, 6);
		
		//2 PM
		ItemStack pm2 = new ItemStack(Material.WATCH, 1);
		ItemMeta pm2Meta = pm2.getItemMeta();
		pm2Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.2pm.name")));
		pm2Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.2pm.lores")));
		pm2.setItemMeta(pm2Meta);
		
		setItem(pm2, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.PM2);
				return true;
			}
		}, 7);
		
		//4 PM
		ItemStack pm4 = new ItemStack(Material.WATCH, 1);
		ItemMeta pm4Meta = pm4.getItemMeta();
		pm4Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.4pm.name")));
		pm4Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.4pm.lores")));
		pm4.setItemMeta(pm4Meta);
		
		setItem(pm4, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.PM4);
				return true;
			}
		}, 8);
		
		//6 PM
		ItemStack pm6 = new ItemStack(Material.WATCH, 1);
		ItemMeta pm6Meta = pm6.getItemMeta();
		pm6Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.6pm.name")));
		pm6Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.6pm.lores")));
		pm6.setItemMeta(pm6Meta);
		
		setItem(pm6, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.PM6);
				return true;
			}
		}, 9);
		
		//8 PM
		ItemStack pm8 = new ItemStack(Material.WATCH, 1);
		ItemMeta pm8Meta = pm8.getItemMeta();
		pm8Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.8pm.name")));
		pm8Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.8pm.lores")));
		pm8.setItemMeta(pm8Meta);
		
		setItem(pm8, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.PM8);
				return true;
			}
		}, 10);
		
		//10 PM
		ItemStack pm10 = new ItemStack(Material.WATCH, 1);
		ItemMeta pm10Meta = pm10.getItemMeta();
		pm10Meta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.10pm.name")));
		pm10Meta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.10pm.lores")));
		pm10.setItemMeta(pm10Meta);
		
		setItem(pm10, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
				if (arena == null)
					return false;
				
				arena.getPlot(player).setTime(Time.PM10);
				return true;
			}
		}, 11);
		
		//back
		ItemStack back = new ItemStack(Material.BOOK, 1);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.time.back.name")));
		backMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.time.back.lores")));
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