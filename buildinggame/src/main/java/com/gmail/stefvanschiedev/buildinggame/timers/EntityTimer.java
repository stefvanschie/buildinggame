package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.utils.Region;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

/**
 * This class handles entity movement (as there is no EntityMoveEvent)
 *
 * @since 4.0.0
 */
public class EntityTimer extends BukkitRunnable {

    /**
     * Checks to see if the entities are still in the correct plot and teleports them back if that's not the case
     *
     * @since 4.0.0
     */
	@Override
	public void run() {
        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            for (Plot plot : arena.getPlots()) {
                Region boundary = plot.getBoundary();

                if (boundary == null)
                    continue;

                for (Entity entity : plot.getEntities().keySet()) {
                    Location location = entity.getLocation();

                    if (!boundary.isInside(location))
                        entity.teleport(plot.getEntities().get(entity));
                    else
                        plot.getEntities().put(entity, location);
                }
            }
        }
	}
}