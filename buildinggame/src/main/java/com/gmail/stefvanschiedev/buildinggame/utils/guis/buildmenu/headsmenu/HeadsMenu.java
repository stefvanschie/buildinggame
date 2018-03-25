package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * A heads menu
 *
 * @since 5.6.0
 */
public class HeadsMenu {

    /**
     * The gui
     */
    Gui gui;

    /**
     * Empty constructor in case paginated heads menu wants to initialize the gui
     *
     * @since 5.6.0
     */
    HeadsMenu() {}

    /**
     * Creates a new heads menu
     *
     * @param location the path to the gui file
     * @since 5.6.0
     */
    public HeadsMenu(String location) {
        this.gui = Gui.load(this, Main.getInstance().getResource(location));
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
     * Called whenever a user clicks on a head item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    @SuppressWarnings("deprecation")
    public void headClick(InventoryClickEvent event) {
        event.setCursor(event.getCurrentItem());
        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the close item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void closeClick(InventoryClickEvent event) {
        event.getWhoClicked().closeInventory();
        event.setCancelled(true);
    }
}
