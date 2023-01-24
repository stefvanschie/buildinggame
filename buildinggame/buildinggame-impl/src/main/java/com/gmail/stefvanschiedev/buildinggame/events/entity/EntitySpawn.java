package com.gmail.stefvanschiedev.buildinggame.events.entity;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.inventory.ItemStack;

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
		var entity = e.getEntity();
		var plot = Plot.getPlot(entity.getLocation());

		if (plot != null && !plot.addEntity(entity))
		    entity.remove();
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
		var vehicle = e.getVehicle();
		var plot = Plot.getPlot(vehicle.getLocation());

		if (plot != null && !plot.addEntity(vehicle))
		    vehicle.remove();
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
		
		var entity = e.getEntity();
		var plot = Plot.getPlot(entity.getLocation());

		if (plot != null) {
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
        var player = e.getPlayer();
        var arena = ArenaManager.getInstance().getArena(player);
        ItemStack item = e.getItem();

        if (item == null)
            return;

        Material type = item.getType();

        //there are no tags existent for grouping spawn eggs, so we will use this name check instead
        if (arena == null || (!type.name().contains("_SPAWN_EGG") && type != Material.ARMOR_STAND) ||
                e.getAction() != Action.RIGHT_CLICK_BLOCK)
            return;

        if (!arena.getPlot(player).getBoundary().isInside(e.getClickedBlock().getRelative(e.getBlockFace())
                .getLocation()))
            e.setCancelled(true);
    }
}