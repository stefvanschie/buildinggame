package com.gmail.stefvanschiedev.buildinggame.events.stats.unsaved.blocksplaced;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class UnsavedStatsPlace implements Listener {

	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null)
			return;
		
		if (arena.getState() != GameState.BUILDING)
			return;
		
		arena.getPlot(player).getGamePlayer(player).setBlocksPlaced(arena.getPlot(player).getGamePlayer(player).getBlocksPlaced() + 1);
	}
}