package com.gmail.stefvanschiedev.buildinggame.events.block;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * Handles pistons moving blocks
 *
 * @since 4.0.4
 */
public class PistonBlockMove implements Listener {

    /**
     * Handles pistons extending
     *
     * @param e an event indicating that a piston extended
     * @see BlockPistonExtendEvent
     * @since 4.0.4
     */
	@EventHandler(ignoreCancelled = true)
	public static void onBlockPistonExtend(BlockPistonExtendEvent e) {
		if (isInside(e.getBlock().getLocation()) != null)
			e.setCancelled(true);
	}

    /**
     * Handles pistons retracting
     *
     * @param e an event indicating that a piston retracted
     * @see BlockPistonRetractEvent
     * @since 4.0.4
     */
	@EventHandler(ignoreCancelled = true)
	public static void onBlockPistonRetract(BlockPistonRetractEvent e) {
		if (isInside(e.getBlock().getLocation()) != null)
			e.setCancelled(true);
	}

	/**
     * Returns the plot by the given location based on the boundary
     *
     * @param location the location inside the boundary
     * @return the plot which boundary contains the given location
     * @see Plot
     * @since 4.0.4
     */
	@Nullable
    @Contract(pure = true)
    private static Plot isInside(Location location) {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getBoundary() == null) 
					continue;
				
				if (plot.getBoundary().isInside(location))
					return plot;
			}
		}
		
		return null;
	}
}