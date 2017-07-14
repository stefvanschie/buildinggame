package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

/**
 * Handles placement of water or lava buckets
 *
 * @since 2.1.0
 */
public class PlaceBucket implements Listener {

    /**
     * Handles placement of water and lava buckets
     *
     * @param e an event representing a player emptying a bucket
     * @see PlayerBucketEmptyEvent
     * @since 2.1.0
     */
	@EventHandler
	public static void onBucketEmpty(PlayerBucketEmptyEvent e) {
		Player player = e.getPlayer();
		Location clicked = e.getBlockClicked().getLocation();
		switch (e.getBlockFace()) {
			case UP:
				clicked.add(0, 1, 0);
				break;
			case DOWN:
				clicked.subtract(0, 1, 0);
				break;
			case NORTH:
				clicked.subtract(0, 0, 1);
				break;
			case EAST:
				clicked.add(1, 0, 0);
				break;
			case SOUTH:
				clicked.add(0, 0, 1);
				break;
			case WEST:
				clicked.subtract(1, 0, 0);
				break;
			default:
				break;
		}
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
		
		if (plot.getGamePlayer(player).getGamePlayerType() == GamePlayerType.SPECTATOR) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Spectators can't build");
			e.setCancelled(true);
			return;
		}
		
		if (!plot.getBoundary().isInside(clicked)) {
			e.setCancelled(true);
			MessageManager.getInstance().send(player, ChatColor.RED + "You can't place blocks outside your plot");
		}
	}
}