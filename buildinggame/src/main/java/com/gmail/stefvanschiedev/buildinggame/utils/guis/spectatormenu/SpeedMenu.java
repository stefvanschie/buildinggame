package com.gmail.stefvanschiedev.buildinggame.utils.guis.spectatormenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * A menu to change the fly speed for spectators
 *
 * @since 3.0.0
 */
class SpeedMenu {

    /**
     * The gui
     */
    private final Gui gui;

    /**
     * Constructs a new SpeedMenu
     */
    SpeedMenu() {
        this.gui = Gui.load(this, Main.getInstance().getResource("gui/spectatormenu/speedmenu.xml"));
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
    public void speedClick(InventoryClickEvent event, float flySpeed) {
        ((Player) event.getWhoClicked()).setFlySpeed(flySpeed);

        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the back item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void backClick(InventoryClickEvent event) {
        new SpectatorMenu().show(event.getWhoClicked());

        event.setCancelled(true);
    }
}