package com.gmail.stefvanschiedev.buildinggame.events.player.gui.subjectmenu;

import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

/**
 * Handles closing the subject menu
 *
 * @since 2.1.0
 */
public class CloseSubjectMenu implements Listener {

    /**
     * Handles closing the subject menu
     *
     * @param e an event that represents an inventory closing
     * @see InventoryCloseEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onInventoryClose(InventoryCloseEvent e) {
		Player player = (Player) e.getPlayer();
		Arena arena = ArenaManager.getInstance().getArena(player);

		if (arena == null || !e.getInventory().getName().equals(MessageManager.translate(SettingsManager.getInstance()
                .getMessages().getString("subject-gui.title"))))
			return;
		
		arena.getSubjectMenu().removePlayer(player);
	}
}