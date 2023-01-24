package com.gmail.stefvanschiedev.buildinggame.events.block;

import com.gmail.stefvanschiedev.buildinggame.utils.region.Region;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

/**
 * Handles liquid flowing
 *
 * @since 2.2.1
 */
public class LiquidFlow implements Listener {

    /**
     * Handles liquid flowing
     *
     * @param e an event indicating that a liquid has flown
     * @see BlockFromToEvent
     * @since 2.2.1
     */
	@EventHandler
	public void onBlockFromTo(BlockFromToEvent e) {
		Location from = e.getBlock().getLocation();
		Location to = e.getToBlock().getLocation();
		
		for (var arena : ArenaManager.getInstance().getArenas()) {
			for (var plot : arena.getPlots()) {
                Region boundary = plot.getBoundary();

                if (boundary == null)
					continue;
				
				if (boundary.isInside(from) != boundary.isInside(to))
					//checks if the source flows/goes out of the boundary and vice versa
					e.setCancelled(true);
			}
		}
	}
}