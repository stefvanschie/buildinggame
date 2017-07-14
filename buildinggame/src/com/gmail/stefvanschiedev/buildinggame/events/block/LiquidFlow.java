package com.gmail.stefvanschiedev.buildinggame.events.block;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

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
		Block from = e.getBlock();
		Block to = e.getToBlock();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getBoundary() == null)
					continue;
				
				if ((plot.getBoundary().isInside(from.getLocation()) && !plot.getBoundary().isInside(to.getLocation())) || (!plot.getBoundary().isInside(from.getLocation()) && plot.getBoundary().isInside(to.getLocation())))
					//checks if the source flows/goes out of the boundary and vice versa
					e.setCancelled(true);
			}
		}
	}
}