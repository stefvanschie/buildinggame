package me.stefvanschie.buildinggame.events.entity;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EntityExplode implements Listener {

	@EventHandler
	public void onEntityExplode(EntityExplodeEvent e) {
		if (!(e.getEntity() instanceof TNTPrimed)) {
			return;
		}
		
		TNTPrimed tnt = (TNTPrimed) e.getEntity();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getBoundary().isInside(tnt.getLocation())) {
					e.setCancelled(true);
				}
			}
		}
	}
}
