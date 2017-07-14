package com.gmail.stefvanschiedev.buildinggame.events.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

/**
 * Handles blocks dispensing items
 *
 * @since 4.0.4
 */
public class BlockDispenseItem implements Listener  {

    /**
     * Handles players breaking join signs
     *
     * @param e an event indicating that a block has dispensed an item
     * @see BlockDispenseEvent
     * @since 4.0.4
     */
	@EventHandler(ignoreCancelled = true)
	public void onBlockDispense(BlockDispenseEvent e) {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getBoundary() == null) 
					continue;
				
				if (plot.getBoundary().isInside(e.getBlock().getLocation())) {
					e.setCancelled(true);
					return;
				}
			}
		}
	}
}