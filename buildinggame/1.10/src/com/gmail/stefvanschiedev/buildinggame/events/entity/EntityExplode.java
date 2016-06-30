package com.gmail.stefvanschiedev.buildinggame.events.entity;

import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
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
		if (!(e.getEntity() instanceof TNTPrimed))
			return;
		
		TNTPrimed tnt = (TNTPrimed) e.getEntity();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getBoundary().isInside(tnt.getLocation())) {
					e.setCancelled(true);
					for (Chunk chunk : plot.getBoundary().getAllChunks()) {
						for (Entity entity : chunk.getEntities()) {
							if (entity instanceof TNTPrimed)
								entity.setVelocity(new Vector(0, 0, 0));
						}
					}
				}
			}
		}
	}
}