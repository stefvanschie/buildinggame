package com.gmail.stefvanschiedev.buildinggame.events.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.util.Vector;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Nullable;

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
		Plot plot;
		
		if ((plot = isInside(e.getLocation())) == null)
			return;

		Vector vector = new Vector(0, 0, 0);

		for (Entity entity : plot.getEntities().keySet())
			entity.setVelocity(vector);

        e.blockList().removeIf(block -> !plot.getBoundary().isInside(block.getLocation()));
	}

    /**
     * Returns the plot by the given location based on the boundary
     *
     * @param location the location inside the boundary
     * @return the plot which boundary contains the given location
     * @see Plot
     * @since 4.0.0
     */
	@Nullable
    private static Plot isInside(Location location) {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getBoundary().isInside(location))
					return plot;
			}
		}
		
		return null;
	}
}