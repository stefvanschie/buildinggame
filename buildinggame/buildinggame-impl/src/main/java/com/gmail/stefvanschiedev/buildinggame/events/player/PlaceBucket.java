package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBucketEmptyEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;

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
		var player = e.getPlayer();
        var arena = ArenaManager.getInstance().getArena(player);

        if (arena == null)
			return;
		
		var plot = arena.getPlot(player);
		
		if (plot.getGamePlayer(player).getGamePlayerType() == GamePlayerType.SPECTATOR) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Spectators can't build");
			e.setCancelled(true);
			return;
		}
		
		if (!plot.getBoundary().isInside(e.getBlockClicked().getRelative(e.getBlockFace()).getLocation())) {
			e.setCancelled(true);
			MessageManager.getInstance().send(player, ChatColor.RED + "You can't place blocks outside your plot");
		}
	}
}