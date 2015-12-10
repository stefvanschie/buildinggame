package me.stefvanschie.buildinggame.events.player;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

public class PlaceBucket implements Listener {

	@EventHandler
	public void onBucketEmpty(PlayerBucketEmptyEvent e) {
		Player player = e.getPlayer();
		Location clicked = e.getBlockClicked().getLocation();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
		
		if (!plot.getBoundary().isInside(clicked)) {
			e.setCancelled(true);
			MessageManager.getInstance().send(player, ChatColor.RED + "You can't place blocks outside your plot");
			return;
		}
		return;
	}
}