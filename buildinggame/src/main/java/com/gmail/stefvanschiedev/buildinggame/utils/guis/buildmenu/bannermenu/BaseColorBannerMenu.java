package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * A gui for selecting the base color of your banner
 *
 * @since 5.2.0
 */
public class BaseColorBannerMenu {

    /**
     * The gui
     */
    private final Gui gui;

    /**
     * {@inheritDoc}
     */
    public BaseColorBannerMenu() {
        this.gui = Gui.load(this, Main.getInstance().getResource(
            "gui/buildmenu/banner/basecolorbannermenu.xml"
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
     * Called whenever a user clicks on the floor item
     *
     * @param event the event called when clicking
     * @param damage the damage value assigned in the XML file
     * @since 5.6.0
     */
    public void bannerClick(InventoryClickEvent event, short damage) {
        new ColorBannerMenu(new ItemStack(Material.BANNER, 1, damage)).show(event.getWhoClicked());

        event.setCancelled(true);
    }
}