package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

/**
 * Handles dropping items while in-game
 *
 * @since 2.1.0
 */
public class Drop implements Listener {

    /**
     * Handles dropping itmes while in-game
     *
     * @param e an event representing a player dropping an item
     * @see PlayerDropItemEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		Player player = e.getPlayer();

		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
	
		if (!config.getBoolean("enable-item-drop"))
			e.setCancelled(true);
	}
}
