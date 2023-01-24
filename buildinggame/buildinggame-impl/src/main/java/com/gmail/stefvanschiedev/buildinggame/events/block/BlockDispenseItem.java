package com.gmail.stefvanschiedev.buildinggame.events.block;

import com.gmail.stefvanschiedev.buildinggame.utils.region.Region;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

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
        var location = e.getBlock().getLocation();

        for (var arena : ArenaManager.getInstance().getArenas()) {
			for (var plot : arena.getPlots()) {
                Region boundary = plot.getBoundary();

                if (boundary == null)
					continue;
				
				if (boundary.isInside(location)) {
					e.setCancelled(true);
					return;
				}
			}
		}
	}
}