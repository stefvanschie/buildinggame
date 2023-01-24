package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

/**
 * Handles players losing food in the lobby
 *
 * @since 2.1.0
 */
public class LoseFood implements Listener {

    /**
     * Handles players losing food in the lobby
     *
     * @param e an event representing a player losing food
     * @see FoodLevelChangeEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onFoodLevelChange(FoodLevelChangeEvent e) {
        HumanEntity entity = e.getEntity();

        if (!(entity instanceof Player) || ArenaManager.getInstance().getArena((Player) entity) == null)
			return;
		
		e.setCancelled(true);
	}
}