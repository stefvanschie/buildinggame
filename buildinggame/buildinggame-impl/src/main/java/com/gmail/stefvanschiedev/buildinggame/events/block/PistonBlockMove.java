package com.gmail.stefvanschiedev.buildinggame.events.block;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

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
	    if (!SettingsManager.getInstance().getConfig().getBoolean("blocks.piston-movement.enable")) {
	        e.setCancelled(true);
	        return;
        }

	    Plot plot = Plot.getPlot(e.getBlock().getLocation());

	    if (plot == null) {
	        return;
        }

        for (Block block : e.getBlocks()) {
            if (!plot.equals(Plot.getPlot(block.getRelative(e.getDirection())))) {
                e.setCancelled(true);
            }
        }
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
        if (!SettingsManager.getInstance().getConfig().getBoolean("blocks.piston-movement.enable")) {
            e.setCancelled(true);
            return;
        }

        Plot plot = Plot.getPlot(e.getBlock().getLocation());

        if (plot == null) {
            return;
        }

        for (Block block : e.getBlocks()) {
            if (!plot.equals(Plot.getPlot(block))) {
                e.setCancelled(true);
            }
        }
	}
}