package me.stefvanschie.buildinggame.events.player.gui.buildmenu.floor;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.id.IDDecompiler;
import me.stefvanschie.buildinggame.utils.CustomBlock;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class FloorClick implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInventoryClick (InventoryClickEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
		
		if (!inventory.getName().equals(messages.getString("gui.options-title")
				.replaceAll("&", "§"))) {
			return;
		}
		
		if (e.getCurrentItem() == null || !e.getCurrentItem().getType().isBlock()) {
			return;
		}
		
		ItemStack currentItem = e.getCurrentItem();
		
		CustomBlock cblock = IDDecompiler.getInstance().decompile(config.getString("gui.floor-id"));
		
		if (currentItem.getType() != cblock.getMaterial()) {
			return;
		}
		if (currentItem.getDurability() != cblock.getData()) {
			return;
		}
		
		if (!currentItem.hasItemMeta()) {
			return;
		}
		if (!currentItem.getItemMeta().getDisplayName().equals(messages.getString("gui.floor.name")
				.replaceAll("&", "§"))) {
			return;
		}
		
		if (e.getCursor().getType() == Material.WATER_BUCKET) {
			for (Block block : plot.getFloor().getAllBlocks()) {
				block.setType(Material.WATER);
			}
			e.setCancelled(true);
			return;
		}
		
		if (e.getCursor().getType() == Material.LAVA_BUCKET) {
			for (Block block : plot.getFloor().getAllBlocks()) {
				block.setType(Material.LAVA);
			}
			e.setCancelled(true);
			return;
		}
		
		for (Block block : plot.getFloor().getAllBlocks()) {
			block.setType(e.getCursor().getType());
			block.setData(e.getCursor().getData().getData());
		}
		
		e.setCancelled(true);
	}
}
