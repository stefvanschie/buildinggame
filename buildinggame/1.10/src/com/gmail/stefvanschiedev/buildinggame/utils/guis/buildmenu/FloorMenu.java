package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class FloorMenu extends Gui {
	
	private static ItemStack previousPage;
	private static ItemStack nextPage;
	private static ItemStack closeMenu;
	
	private static Material[] skipMaterials = {
		Material.ACACIA_DOOR,
		Material.AIR,
		Material.BED_BLOCK,
		Material.BEETROOT_BLOCK,
		Material.BIRCH_DOOR,
		Material.BREWING_STAND,
		Material.BURNING_FURNACE,
		Material.CAKE_BLOCK,
		Material.CARROT,
		Material.CAULDRON,
		Material.COCOA,
		Material.CROPS,
		Material.DARK_OAK_DOOR,
		Material.DAYLIGHT_DETECTOR_INVERTED,
		Material.DIODE_BLOCK_OFF,
		Material.DIODE_BLOCK_ON,
		Material.DOUBLE_STEP,
		Material.DOUBLE_STONE_SLAB2,
		Material.END_GATEWAY,
		Material.ENDER_PORTAL,
		Material.FIRE,
		Material.FLOWER_POT,
		Material.FROSTED_ICE,
		Material.GLOWING_REDSTONE_ORE,
		Material.IRON_DOOR_BLOCK,
		Material.JUNGLE_DOOR,
		Material.LAVA,
		Material.MELON_STEM,
		Material.NETHER_WARTS,
		Material.PISTON_EXTENSION,
		Material.PISTON_MOVING_PIECE,
		Material.PORTAL,
		Material.POTATO,
		Material.PUMPKIN_STEM,
		Material.PURPUR_DOUBLE_SLAB,
		Material.REDSTONE_COMPARATOR_OFF,
		Material.REDSTONE_COMPARATOR_ON,
		Material.REDSTONE_LAMP_ON,
		Material.REDSTONE_TORCH_OFF,
		Material.REDSTONE_WIRE,
		Material.SIGN_POST,
		Material.SKULL,
		Material.SPRUCE_DOOR,
		Material.STANDING_BANNER,
		Material.STATIONARY_LAVA,
		Material.STATIONARY_WATER,
		Material.SUGAR_CANE_BLOCK,
		Material.TRIPWIRE,
		Material.WALL_BANNER,
		Material.WALL_SIGN,
		Material.WATER,
		Material.WOOD_DOUBLE_STEP,
		Material.WOODEN_DOOR,
	};
	
	public FloorMenu(final Plot plot) {
		super(null, 54, ChatColor.GOLD + "Wybierz Podloge", (int) Math.ceil(getBlocks().size() / 45) + 1);
		
		for (int page = 0; page < pages; page++) {
			setStartingPoint(54 * page);
			
			for (int i = 0; i < 45; i++) {
				if (i + (45 * page) == getBlocks().size())
					break;
				
				final Material material = getBlocks().get(i + (45 * page));
				
				addItem(new ItemStack(material), new GuiAction() {
					@Override
					public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
						if (type != GuiActionType.CLICK)
							return false;
					
						for (Block b : plot.getFloor().getAllBlocks())
							b.setType(material);
					
						return true;
					}
				});
			}
			
			final int currentPage = page;
			
			if (page != 0)
				setItem(previousPage, new GuiAction() {
					@Override
					public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
						if (type != GuiActionType.CLICK)
							return false;
						
						InventoryClickEvent event = (InventoryClickEvent) e;
						
						open((Player) event.getWhoClicked(), currentPage);
						return true;
					}
				}, 47 + (54 * page));
			
			setItem(closeMenu, new GuiAction() {
				@Override
				public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
					if (type != GuiActionType.CLICK)
						return false;
					
					InventoryClickEvent event = (InventoryClickEvent) e;
					Player player = (Player) event.getWhoClicked();
					
					player.closeInventory();
					removePlayer(player);
					return true;
				}
			}, 49 + (54 * page));
			
			if (page != Math.ceil(getBlocks().size() / 45))
				setItem(nextPage, new GuiAction() {
					@Override
					public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
						if (type != GuiActionType.CLICK)
							return false;
						
						InventoryClickEvent event = (InventoryClickEvent) e;
						
						open((Player) event.getWhoClicked(), currentPage + 2);
						return true;
					}
				}, 51 + (54 * page));
		}
	}
	
	private static List<Material> getBlocks() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		List<Material> blocks = new ArrayList<>();
		
		for (Material material : Material.values()) {
			if (material.isBlock() && !Arrays.asList(skipMaterials).contains(material) && !config.getStringList("blocks.blocked").contains(material.toString().toLowerCase()) && !config.getStringList("gui.floor.excluded-blocks").contains(material.toString().toLowerCase()))
				blocks.add(material);
		}
		
		return blocks;
	}
	
	static {
		previousPage = new ItemStack(Material.SUGAR_CANE);
		ItemMeta previousPageMeta = previousPage.getItemMeta();
		previousPageMeta.setDisplayName(ChatColor.GREEN + "Poprzednia strona");
		previousPage.setItemMeta(previousPageMeta);
		
		nextPage = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextPageMeta = nextPage.getItemMeta();
		nextPageMeta.setDisplayName(ChatColor.GREEN + "Nastepna strona");
		nextPage.setItemMeta(nextPageMeta);
		
		closeMenu = new ItemStack(Material.BOOK);
		ItemMeta closeMenuMeta = closeMenu.getItemMeta();
		closeMenuMeta.setDisplayName(ChatColor.GREEN + "Zamknij menu");
		closeMenu.setItemMeta(closeMenuMeta);
	}
}
