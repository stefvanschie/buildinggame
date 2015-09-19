package me.stefvanschie.buildinggame.events.player.gui;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.utils.guis.BuildMenu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class OptionsMenu implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		if (!player.getItemInHand().hasItemMeta()) {
			return;
		}
		if (player.getItemInHand().getType() != Material.EMERALD) {
			return;
		}
		if (!player.getItemInHand().hasItemMeta()) {
			return;
		}
		if (!player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Options")) {
			return;
		}
		
		BuildMenu menu = new BuildMenu();
		menu.show(player);
		e.setCancelled(true);
	}
}
