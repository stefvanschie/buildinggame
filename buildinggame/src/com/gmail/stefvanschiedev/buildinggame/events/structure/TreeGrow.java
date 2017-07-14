package com.gmail.stefvanschiedev.buildinggame.events.structure;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
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
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot p : arena.getPlots()) {
				if (p.getBoundary() == null)
					continue;
				
				if (p.getBoundary().isInside(e.getLocation())) {
					plot = p;
					break;
				}
			}
		}
		
		if (plot == null)
			return;
		
		for (int i = 0; i < e.getBlocks().size(); i++) {
			if (plot.getBoundary() == null)
				continue;
			if (!plot.getBoundary().isInside(e.getBlocks().get(i).getLocation())) {
				e.getBlocks().remove(e.getBlocks().get(i));
                //noinspection AssignmentToForLoopParameter
                i--;
			}
		}
	}
}