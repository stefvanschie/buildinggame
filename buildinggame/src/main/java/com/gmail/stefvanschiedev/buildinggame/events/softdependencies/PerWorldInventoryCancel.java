package com.gmail.stefvanschiedev.buildinggame.events.softdependencies;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import me.ebonjaeger.perworldinventory.event.InventoryLoadEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Cancel per world inventory editing the inventories when we're in-game
 *
 * @since 5.2.0
 */
public class PerWorldInventoryCancel implements Listener {

    /**
     * Listens for the inventory being edited and cancels it when needed
     *
     * @param e the event of the inventory being about to change
     */
    @EventHandler(ignoreCancelled = true)
    public void onInventoryLoad(InventoryLoadEvent e) {
        e.setCancelled(ArenaManager.getInstance().getArena(e.getPlayer()) != null);
    }
}