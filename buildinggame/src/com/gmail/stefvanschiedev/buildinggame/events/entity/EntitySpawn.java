package com.gmail.stefvanschiedev.buildinggame.events.entity;

import com.gmail.stefvanschiedev.buildinggame.utils.Region;
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
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

/**
 * Handles entity spawning
 *
 * @since 2.1.0
 */
public class EntitySpawn implements Listener {

    /**
     * Handles entity spawning
     *
     * @param e an event representing a spawned entity
     * @see EntitySpawnEvent
     * @since 2.1.0
     */
	@EventHandler(ignoreCancelled = true)
	public void onEntitySpawn(EntitySpawnEvent e) {
		Entity entity = e.getEntity();

		Plot plot;
		if ((plot = isInside(entity.getLocation())) != null) {
			if (!plot.addEntity(entity))
				entity.remove();
		}
	}

	/**
     * Handles vehicle spawning
     *
     * @param e an event representing a vehicle that has spawned
     * @see VehicleCreateEvent
     * @since 4.0.0
     */
	@EventHandler(ignoreCancelled = true)
	public void onVehicleCreate(VehicleCreateEvent e) {
		Vehicle vehicle = e.getVehicle();
		
		Plot plot;
		if ((plot = isInside(vehicle.getLocation())) != null) {
			if (!plot.addEntity(vehicle))
				vehicle.remove();
		}
	}

	/**
     * Handles hanging entity spawning
     *
     * @param e an event representing a hanging entity that has spawned
     * @see HangingPlaceEvent
     * @since 4.0.4
     */
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

	/**
     * Handles placement of entities
     *
     * @param e an event representing a player that interacts
     * @see PlayerInteractEvent
     * @since 4.0.6
     */
    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Arena arena = ArenaManager.getInstance().getArena(player);
        ItemStack item = e.getItem();

        if (item == null)
            return;

        Material type = item.getType();

        if (arena == null || (type != Material.MONSTER_EGG && type != Material.ARMOR_STAND) ||
                e.getAction() != Action.RIGHT_CLICK_BLOCK)
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

        if (!arena.getPlot(player).getBoundary().isInside(improvedLocation))
            e.setCancelled(true);
    }

    /**
     * Returns the plot by the given location based on the boundary
     *
     * @param location the location inside the boundary
     * @return the plot which boundary contains the given location
     * @see Plot
     * @since 2.1.0
     */
	@Nullable
    private static Plot isInside(Location location) {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
                Region boundary = plot.getBoundary();

                if (boundary == null)
					continue;
				
				if (boundary.isInside(location))
					return plot;
			}
		}
		
		return null;
	}
}