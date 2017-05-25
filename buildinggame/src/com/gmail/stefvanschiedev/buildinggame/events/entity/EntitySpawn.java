package com.gmail.stefvanschiedev.buildinggame.events.entity;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Nullable;

public class EntitySpawn implements Listener {

	@EventHandler(ignoreCancelled = true)
	public void onEntitySpawn(EntitySpawnEvent e) {
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

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (ArenaManager.getInstance().getArena(player) == null || e.getItem() == null || (e.getItem().getType() != Material.MONSTER_EGG && e.getItem().getType() != Material.ARMOR_STAND) || e.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;

        Location improvedLocation = e.getClickedBlock().getLocation();

        switch (e.getBlockFace()) {
            case UP:
                improvedLocation.add(0, 1, 0);
                break;
            case DOWN:
                improvedLocation.subtract(0, 1, 0);
                break;
            case NORTH:
                improvedLocation.subtract(0, 0, 1);
                break;
            case EAST:
                improvedLocation.add(1, 0, 0);
                break;
            case SOUTH:
                improvedLocation.add(0, 0, 1);
                break;
            case WEST:
                improvedLocation.subtract(1, 0, 0);
                break;
            default:
                break;
        }

        if (!ArenaManager.getInstance().getArena(player).getPlot(player).getBoundary().isInside(improvedLocation))
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