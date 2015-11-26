package me.stefvanschie.buildinggame.events.stats.unsaved.blocksplaced;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.GameState;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class UnsavedStatsPlace implements Listener {

	@EventHandler(ignoreCancelled=true)
	public void onBlockPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			return;
		}
		
		if (arena.getState() != GameState.BUILDING) {
			return;
		}
		
		arena.getPlot(player).getGamePlayer().setBlocksPlaced(arena.getPlot(player).getGamePlayer().getBlocksPlaced() + 1);
	}
}
