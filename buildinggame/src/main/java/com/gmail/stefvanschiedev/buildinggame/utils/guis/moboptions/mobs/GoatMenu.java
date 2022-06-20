package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Goat;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for altering goats.
 *
 * @since 12.0.0
 */
public final class GoatMenu extends BabyMenu {

    /**
     * Creates a new goat menu to display several options to adjust for goats.
     *
     * @param plot the plot this goat resides in
     * @param goat the goat to change
     * @since 12.0.0
     */
    public GoatMenu(Plot plot, Goat goat) {
        super(plot, goat);

        super.setRows(2);

        super.pane.setY(1);
        super.pane.setX(7);
        super.pane.setLength(2);

        var pane = new OutlinePane(0, 0, 9, 1);
        pane.align(OutlinePane.Alignment.CENTER);
        pane.setGap(3);

        var leftHorn = new ItemStack(Material.GOAT_HORN);
        ItemMeta leftHornMeta = leftHorn.getItemMeta();
        leftHornMeta.setDisplayName(ChatColor.GREEN + "Change the visibility of the left horn");
        leftHorn.setItemMeta(leftHornMeta);

        pane.addItem(new GuiItem(leftHorn, event -> {
            goat.setLeftHorn(!goat.hasLeftHorn());

            event.setCancelled(true);
        }));

        var rightHorn = new ItemStack(Material.GOAT_HORN);
        ItemMeta rightHornMeta = rightHorn.getItemMeta();
        rightHornMeta.setDisplayName(ChatColor.GREEN + "Change the visibility of the right horn");
        rightHorn.setItemMeta(rightHornMeta);

        pane.addItem(new GuiItem(rightHorn, event -> {
            goat.setRightHorn(!goat.hasRightHorn());

            event.setCancelled(true);
        }));

        super.addPane(pane);
        super.addPane(super.pane); //workaround for an issue in IF 0.10.6 see #227 on its issue tracker
    }
}
