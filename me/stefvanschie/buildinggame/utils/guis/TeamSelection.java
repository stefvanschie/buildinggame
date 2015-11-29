package me.stefvanschie.buildinggame.utils.guis;

import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TeamSelection {

	private Arena arena;
	
	public TeamSelection(Arena arena) {
		this.arena = arena;
	}
	
	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, round(arena.getPlots().size()), ChatColor.GREEN + "Team selection");
		
		int iteration = 0;
		for (Plot plot : arena.getPlots()) {
			ItemStack item = new ItemStack(Material.PAPER);
			ItemMeta itemMeta = item.getItemMeta();
			itemMeta.setDisplayName("Team " + plot.getID());
			item.setItemMeta(itemMeta);
			
			inventory.setItem(iteration, item);
			
			iteration++;
		}
		
		player.openInventory(inventory);
	}
	
	public int round(int i) {
		while (i % 9 != 0) {
			i++;
		}
		return i;
	}
}
