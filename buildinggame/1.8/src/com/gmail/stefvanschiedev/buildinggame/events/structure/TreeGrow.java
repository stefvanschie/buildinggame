package com.gmail.stefvanschiedev.buildinggame.events.structure;

import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class TreeGrow implements Listener {

	@EventHandler
	public void onStructureGrow(StructureGrowEvent e) {
		for (BlockState blockState : e.getBlocks()) {
			for (Arena arena : ArenaManager.getInstance().getArenas()) {
				for (Plot plot : arena.getPlots()) {
					if (!plot.getBoundary().isInside(blockState.getLocation())) {
						e.setCancelled(true);
						return;
					}
				}
			}
		}
	}
}