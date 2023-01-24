package com.gmail.stefvanschiedev.buildinggame.events.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

/**
 * Handles entities exploding
 *
 * @since 3.1.0
 */
public class EntityExplode implements Listener {

    /**
     * Handles entities exploding
     *
     * @param e an event indicating that an entity is about to explode
     * @see EntityExplodeEvent
     * @since 3.1.0
     */
	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e) {	
		var plot = Plot.getPlot(e.getLocation());
		
		if (plot == null)
			return;

		var vector = new Vector(0, 0, 0);

		plot.getEntities().keySet().forEach(entity -> entity.setVelocity(vector));

        e.blockList().removeIf(block -> !plot.getBoundary().isInside(block.getLocation()));
	}
}