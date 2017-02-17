package com.gmail.stefvanschiedev.buildinggame.events.entity;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class EntitySpawn implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		Entity entity = e.getEntity();
		
		Plot plot;
		if ((plot = isInside(entity.getLocation())) != null) {
			if (!plot.addEntity(entity))
				entity.remove();
		}
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onVehicleCreate(VehicleCreateEvent e) {
		Vehicle vehicle = e.getVehicle();
		
		Plot plot;
		if ((plot = isInside(vehicle.getLocation())) != null) {
			if (!plot.addEntity(vehicle))
				vehicle.remove();
		}
	}
	
	@EventHandler(ignoreCancelled = true)
	public void onHangingPlace(HangingPlaceEvent e) {
		if (ArenaManager.getInstance().getArena(e.getPlayer()) == null)
			return;
		
		Entity entity = e.getEntity();
		Plot plot;
		if ((plot = isInside(entity.getLocation())) != null) {
			if (!plot.addEntity(entity))
				e.setCancelled(true);
		} else
			e.setCancelled(true);
	}
	
	private Plot isInside(Location location) {
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