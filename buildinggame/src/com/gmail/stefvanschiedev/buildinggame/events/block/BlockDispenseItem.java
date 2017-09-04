package com.gmail.stefvanschiedev.buildinggame.events.block;

import com.gmail.stefvanschiedev.buildinggame.utils.Region;
import org.bukkit.Location;
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
        Location location = e.getBlock().getLocation();

        for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
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