package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

public class EntitySpawnByHuman implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null || e.getItem() == null || e.getItem().getType() != Material.MONSTER_EGG || e.getAction() != Action.RIGHT_CLICK_BLOCK)
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
}