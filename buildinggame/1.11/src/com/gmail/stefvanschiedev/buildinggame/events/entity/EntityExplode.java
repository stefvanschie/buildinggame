package com.gmail.stefvanschiedev.buildinggame.events.entity;


import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class EntityExplode implements Listener {

	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e) {	
		Plot plot;
		
		if ((plot = isInside(e.getLocation())) == null)
			return;
		
		for (Entity entity : plot.getEntities().keySet())
			entity.setVelocity(new Vector(0, 0, 0));
		
		for (int i = 0; i < e.blockList().size(); i++) {
			Block block = e.blockList().get(i);
			
			if (!plot.getBoundary().isInside(block.getLocation())) {
				e.blockList().remove(block);
				i--;
			}
		}
	}
	
	public Plot isInside(Location location) {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getBoundary().isInside(location))
						return plot;
			}
		}
		
		return null;
	}
}