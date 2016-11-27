package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class BuildMenu extends Gui {

	private static YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	private static YamlConfiguration config = SettingsManager.getInstance().getConfig();
	
	private ParticlesMenu particlesMenu;
	private TimeMenu timeMenu;
	private SpeedMenu flySpeedMenu;
	private HeadsMenu headsMenu;
	
	public BuildMenu() {
		super(null, 36, MessageManager.translate(messages.getString("gui.options-title")), 1);
		
		particlesMenu = new ParticlesMenu();
		timeMenu = new TimeMenu();
		flySpeedMenu = new SpeedMenu();
		headsMenu = new HeadsMenu();
		
		if (config.getBoolean("gui.particles.enabled")) {
			ItemStack particle = IDDecompiler.getInstance().decompile(config.getString("gui.particles.id"));
			ItemMeta particleMeta = particle.getItemMeta();
			particleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.particles.name")));
			List<String> particleLores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.particles.lores"))
				particleLores.add(MessageManager.translate(lore));
			particleMeta.setLore(particleLores);
			particle.setItemMeta(particleMeta);
			
			setItem(particle, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					
					particlesMenu.open((Player) event.getWhoClicked());
					return true;
				}
			}, 11);
		}
		
		if (config.getBoolean("gui.floor.enabled")) {
			ItemStack floor = IDDecompiler.getInstance().decompile(config.getString("gui.floor.id"));
			ItemMeta floorMeta = floor.getItemMeta();
			floorMeta.setDisplayName(MessageManager.translate(messages.getString("gui.floor.name")));
			List<String> floorLores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.floor.lores"))
				floorLores.add(MessageManager.translate(lore));
			floorMeta.setLore(floorLores);
			floor.setItemMeta(floorMeta);
			
			setItem(floor, new GuiAction() {
				@SuppressWarnings("deprecation")
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					Player player = (Player) event.getWhoClicked();
					
					if (ArenaManager.getInstance().getArena(player) == null)
						return false;
					
					Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
					
					if (event.getCursor().getType() == Material.AIR && !config.getBoolean("plots.floor.allow-air")) {
						for (String message : MessageManager.translate(messages.getStringList("plots.floor.incorrect")))
							player.sendMessage(message);
						
						return true;
					}
					
					for (String material : config.getStringList("blocks.blocked")) {
						if (IDDecompiler.getInstance().matches(material, event.getCursor())) {
							for (String message : MessageManager.translate(messages.getStringList("plots.floor.blocked")))
								player.sendMessage(message);
							
							return true;
						}
					}
					
					if (event.getCursor().getType() == Material.WATER_BUCKET) {
						for (Block block : plot.getFloor().getAllBlocks())
							block.setType(Material.WATER);
						
						return true;
					}
					
					if (event.getCursor().getType() == Material.LAVA_BUCKET) {
						for (Block block : plot.getFloor().getAllBlocks())
							block.setType(Material.LAVA);
						
						return true;
					}
					
					if (!event.getCursor().getType().isBlock()) {
						for (String message : MessageManager.translate(messages.getStringList("plots.floor.incorrect")))
							player.sendMessage(message);
						
						return true;
					}
					
					for (Block block : plot.getFloor().getAllBlocks()) {
						if (block.getType() == event.getCursor().getType() && block.getData() == event.getCursor().getData().getData())
							continue;
						
						block.setType(event.getCursor().getType());
						block.setData(event.getCursor().getData().getData());
					}
					
					return true;
				}
			}, 13);
		}
		
		if (config.getBoolean("gui.time.enabled")) {
			ItemStack time = IDDecompiler.getInstance().decompile(config.getString("gui.time.id"));
			ItemMeta timeMeta = time.getItemMeta();
			timeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.time.name")));
			List<String> timeLores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.time.lores"))
				timeLores.add(MessageManager.translate(lore));
			timeMeta.setLore(timeLores);
			time.setItemMeta(timeMeta);
			
			setItem(time, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					
					timeMenu.open((Player) event.getWhoClicked());
					return true;
				}
			}, 15);
		}
		
		if (config.getBoolean("gui.rain.enabled")) {
			ItemStack rain = IDDecompiler.getInstance().decompile(config.getString("gui.rain.id"));
			ItemMeta rainMeta = rain.getItemMeta();
			rainMeta.setDisplayName(MessageManager.translate(messages.getString("gui.rain.name")));
			List<String> rainLores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.rain.lores"))
				rainLores.add(MessageManager.translate(lore));
			rainMeta.setLore(rainLores);
			rain.setItemMeta(rainMeta);
			
			setItem(rain, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					Player player = (Player) event.getWhoClicked();
					
					if (ArenaManager.getInstance().getArena(player) == null)
						return false;
					
					Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
					
					plot.setRaining(!plot.isRaining());
					return true;
				}
			}, 20);
		}
		
		if (config.getBoolean("gui.fly-speed.enabled")) {
			ItemStack speed = IDDecompiler.getInstance().decompile(config.getString("gui.fly-speed.id"));
			ItemMeta speedMeta = speed.getItemMeta();
			speedMeta.setDisplayName(MessageManager.translate(messages.getString("gui.fly-speed.name")));
			List<String> speedLores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.fly-speed.lores"))
				speedLores.add(MessageManager.translate(lore));
			speedMeta.setLore(speedLores);
			speed.setItemMeta(speedMeta);
			
			setItem(speed, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					
					flySpeedMenu.open((Player) event.getWhoClicked());
					return true;
				}
			}, 22);
		}
		
		if (config.getBoolean("gui.heads.enabled")) {
			ItemStack heads = IDDecompiler.getInstance().decompile(config.getString("gui.heads.id"));
			ItemMeta headsMeta = heads.getItemMeta();
			headsMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.name")));
			List<String> headsLores = new ArrayList<String>();
			for (String lore : messages.getStringList("gui.heads.lores"))
				headsLores.add(MessageManager.translate(lore));
			headsMeta.setLore(headsLores);
			heads.setItemMeta(headsMeta);
			
			setItem(heads, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					
					headsMenu.open((Player) event.getWhoClicked());
					return true;
				}
			}, 24);
		}
		
		ItemStack close = new ItemStack(Material.BOOK, 1);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.close-menu.name")));
		List<String> closeLores = new ArrayList<String>();
		for (String lore : messages.getStringList("gui.close-menu.lores"))
			closeLores.add(MessageManager.translate(lore));
		closeMeta.setLore(closeLores);
		close.setItemMeta(closeMeta);
		
		setItem(close, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent e = (InventoryClickEvent) event;
				
				e.getWhoClicked().closeInventory();
				removePlayer((Player) e.getWhoClicked());
				return true;
			}
		}, 31);
	}
	
	@Override
	public void open(Player player, int page) {
		if (!player.hasPermission("bg.buildmenu.particles"))
			clear(11);
		if (!player.hasPermission("bg.buildmenu.floor"))
			clear(13);
		if (!player.hasPermission("bg.buildmenu.time"))
			clear(15);
		if (!player.hasPermission("bg.buildmenu.rain"))
			clear(20);
		if (!player.hasPermission("bg.buildmenu.flyspeed"))
			clear(22);
		if (!player.hasPermission("bg.buildmenu.heads"))
			clear(24);
		
		super.open(player, page);
	}
}