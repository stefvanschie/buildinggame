package com.gmail.stefvanschiedev.buildinggame.events.structure;

import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.StructureGrowEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class TreeGrow implements Listener {

	@EventHandler
	public void onStructureGrow(StructureGrowEvent e) {
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null)
			return;
		
		Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
		
		for (BlockState blockState : e.getBlocks()) {
			if (!plot.getBoundary().isInside(blockState.getLocation())) {
				e.setCancelled(true);
				return;
			}
		}
	}
}