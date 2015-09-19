package me.stefvanschie.buildinggame.events.player.gui.time;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.utils.Time;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PM4Click implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		ItemStack currentItem = e.getCurrentItem();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
		
		if (!inventory.getName().equals(ChatColor.GREEN + "Time selection")) {
			return;
		}
		if (currentItem.getType() != Material.WATCH) {
			return;
		}
		if (!currentItem.hasItemMeta()) {
			return;
		}
		if (!currentItem.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "4 PM")) {
			return;
		}
		
		plot.setTime(Time.PM4);
		e.setCancelled(true);
	}
}
