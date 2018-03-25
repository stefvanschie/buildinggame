package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.OutlinePane;
import org.bukkit.DyeColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * A gui for selecting the color for the next pattern
 *
 * @since 5.2.0
 */
class ColorBannerMenu {

    /**
     * The banner from the previous GUI(s)
     */
    private final ItemStack banner;

    /**
     * The gui
     */
    private final Gui gui;

    /**
     * {@inheritDoc}
     */
    ColorBannerMenu(ItemStack banner) {
        this.banner = banner;
        this.gui = Gui.load(this, Main.getInstance().getResource(
            "gui/buildmenu/banner/colorbannermenu.xml"
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
     * Called whenever the outline pane specified in the XML file needs to be populated
     *
     * @param pane the outline pane
     * @since 5.6.0
     */
    public void populate(OutlinePane pane) {
        pane.addItem(new GuiItem(new ItemStack(banner), event -> {
            HumanEntity humanEntity = event.getWhoClicked();

            humanEntity.getInventory().addItem(banner);
            humanEntity.closeInventory();

            event.setCancelled(true);
        }));
    }

    /**
     * Called whenever a user clicks on the floor item
     *
     * @param event the event called when clicking
     * @param dyeColor the dye color value assigned in the XML file
     * @since 5.6.0
     */
    public void dyeClick(InventoryClickEvent event, DyeColor dyeColor) {
        new PatternBannerMenu(banner, dyeColor).show(event.getWhoClicked());

        event.setCancelled(true);
    }
}
