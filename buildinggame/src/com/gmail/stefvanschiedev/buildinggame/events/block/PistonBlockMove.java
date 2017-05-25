package com.gmail.stefvanschiedev.buildinggame.events.block;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPistonExtendEvent;
import org.bukkit.event.block.BlockPistonRetractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Nullable;

public class PistonBlockMove implements Listener {

	@EventHandler(ignoreCancelled = true)
	public static void onBlockPistonExtend(BlockPistonExtendEvent e) {
		if (isInside(e.getBlock().getLocation()) != null)
			e.setCancelled(true);
	}
	
	@EventHandler(ignoreCancelled = true)
	public static void onBlockPistonRetract(BlockPistonRetractEvent e) {
		if (isInside(e.getBlock().getLocation()) != null)
			e.setCancelled(true);
	}
	
	@Nullable
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