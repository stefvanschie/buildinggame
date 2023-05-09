package com.gmail.stefvanschiedev.buildinggame.events.stats.unsaved;

import com.gmail.stefvanschiedev.buildinggame.game.BuildingGamePhase;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

/**
 * Handles unsaved block placed
 *
 * @since 2.2.0
 */
public class UnsavedStatsPlace implements Listener {

    /**
     * Handles unsaved block placed
     *
     * @param e an event representing a block being placed
     * @see BlockPlaceEvent
     * @since 2.2.0
     */
	@EventHandler(ignoreCancelled = true)
	public static void onBlockPlace(BlockPlaceEvent e) {
		var player = e.getPlayer();
		var arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null || !(arena.getCurrentPhase() instanceof BuildingGamePhase)) {
            return;
        }

        var gamePlayer = arena.getPlot(player).getGamePlayer(player);

        gamePlayer.setBlocksPlaced(gamePlayer.getBlocksPlaced() + 1);
	}
}