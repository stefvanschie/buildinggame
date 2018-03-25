package com.gmail.stefvanschiedev.buildinggame.utils.guis.spectatormenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Represents a gui to change the fly speed for spectators
 *
 * @since 3.0.0
 */
public class SpectatorMenu {

    /**
     * The gui
     */
    private final Gui gui;

    /**
     * Constructs a new SpeedMenu
     */
    public SpectatorMenu() {
        this.gui = Gui.load(this, Main.getInstance().getResource(
            "gui/spectatormenu/spectatormenu.xml"
        ));
    }

    /**
     * {@link Gui#show(HumanEntity)}
     *
     * @since 5.6.0
     */
    public void show(HumanEntity humanEntity) {
        gui.show(humanEntity);
    }

    /**
     * Called whenever a user clicks on a speed item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void flySpeedClick(InventoryClickEvent event) {
        new SpeedMenu().show(event.getWhoClicked());

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the back item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void closeClick(InventoryClickEvent event) {
        event.getWhoClicked().closeInventory();
        event.setCancelled(true);
    }
}