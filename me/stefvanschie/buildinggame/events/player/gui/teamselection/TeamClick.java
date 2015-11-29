package me.stefvanschie.buildinggame.events.player.gui.teamselection;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.utils.GamePlayer;
import me.stefvanschie.buildinggame.utils.arena.Arena;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TeamClick implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		Inventory inventory = e.getInventory();
		ItemStack item = e.getCurrentItem();
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			return;
		}
		
		if (!inventory.getName().equals(ChatColor.GREEN + "Team selection")) {
			return;
		}
		
		if (item == null) {
			return;
		}
		
		if (!item.hasItemMeta()) {
			return;
		}
		
		if (item.getType() != Material.PAPER) {
			return;
		}
		
		GamePlayer gamePlayer = arena.getPlot(player).getGamePlayer(player);
		
		boolean succes = arena.getPlot(Integer.parseInt(item.getItemMeta().getDisplayName().replace("Team ", ""))).join(gamePlayer);
		if (succes) {
			arena.getPlot(player).leave(gamePlayer);
		}
		
		player.closeInventory();
		e.setCancelled(true);
	}
}
