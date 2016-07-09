package com.gmail.stefvanschiedev.buildinggame.events.structure;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class TreeGrow implements Listener {

	@EventHandler
	public void onStructureGrow(StructureGrowEvent e) {
		Plot plot = null;
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot p : arena.getPlots()) {
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
				i--;
			}
		}
	}
}