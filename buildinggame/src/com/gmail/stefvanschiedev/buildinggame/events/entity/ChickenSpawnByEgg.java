package com.gmail.stefvanschiedev.buildinggame.events.entity;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;

/**
 * Handles chickens spawning by eggs
 *
 * @since 3.1.2
 */
public class ChickenSpawnByEgg implements Listener {

    /**
     * Handles players breaking join signs
     *
     * @param e an event indicating that an egg is thrown
     * @see PlayerEggThrowEvent
     * @since 3.1.2
     */
	@EventHandler
	public void onPlayerEggThrowEvent(PlayerEggThrowEvent e) {
		if (ArenaManager.getInstance().getArena(e.getPlayer()) == null)
			return;
		
		if (e.isHatching())
			e.setHatching(false);
	}
}