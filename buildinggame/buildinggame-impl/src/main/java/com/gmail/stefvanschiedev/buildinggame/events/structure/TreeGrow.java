package com.gmail.stefvanschiedev.buildinggame.events.structure;

import com.gmail.stefvanschiedev.buildinggame.utils.region.Region;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

/**
 * Handles trees growing
 *
 * @since 2.1.0
 */
public class TreeGrow implements Listener {

    /**
     * Handles trees growing
     *
     * @param e an event representing a structure growing
     * @see StructureGrowEvent
     * @since 2.1.0
     */
	@EventHandler
	public static void onStructureGrow(StructureGrowEvent e) {
		Plot plot = null;
		
		for (var arena : ArenaManager.getInstance().getArenas()) {
			for (Plot p : arena.getPlots()) {
                Region boundary = p.getBoundary();

                if (boundary == null)
					continue;
				
				if (boundary.isInside(e.getLocation())) {
					plot = p;
					break;
				}
			}
		}

		if (plot == null)
			return;

        Region boundary = plot.getBoundary();

        if (boundary == null)
            return;

        e.getBlocks().removeIf(blockState -> !boundary.isInside(blockState.getLocation()));
	}
}