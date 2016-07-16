package com.gmail.stefvanschiedev.buildinggame.events.player.gui.spectatormenu;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.spectatormenu.SpectatorMenu;

public class OpenSpectatorMenu implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null)
			return;
		
		if (!player.getInventory().getItemInHand().hasItemMeta())
			return;
		
		if (player.getInventory().getItemInHand().getType() != Material.EMERALD)
			return;
		
		if (!player.getInventory().getItemInHand().hasItemMeta())
			return;
		
		if (!player.getInventory().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Spectator menu"))
			return;
		
		new SpectatorMenu().show(player);
		e.setCancelled(true);
	}
}