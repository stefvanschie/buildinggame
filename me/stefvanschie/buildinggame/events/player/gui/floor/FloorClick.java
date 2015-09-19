package me.stefvanschie.buildinggame.events.player.gui.floor;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
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
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		ItemStack currentItem = e.getCurrentItem();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
		
		if (!inventory.getName().equals(ChatColor.GREEN + "Options menu")) {
			return;
		}
		if (currentItem.getType() != Material.HARD_CLAY) {
			return;
		}
		if (!currentItem.hasItemMeta()) {
			return;
		}
		if (!currentItem.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Floor block")) {
			return;
		}
		
		for (Block block : plot.getFloor().getAllBlocks()) {
			block.setType(e.getCursor().getType());
			block.setData(e.getCursor().getData().getData());
		}
		
		e.setCancelled(true);
	}
}
