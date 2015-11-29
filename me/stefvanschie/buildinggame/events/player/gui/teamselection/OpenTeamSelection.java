package me.stefvanschie.buildinggame.events.player.gui.teamselection;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OpenTeamSelection implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		ItemStack item = player.getItemInHand();
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			return;
		}
		
		if (item.getType() != Material.PAPER) {
			return;
		}
		
		if (!item.hasItemMeta()) {
			return;
		}
		
		if (!item.getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Team selection")) {
			return;
		}
		
		arena.getTeamSelection().show(player);
		e.setCancelled(true);
	}
}
