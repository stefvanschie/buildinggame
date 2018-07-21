package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.color;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Wolf;
import org.bukkit.material.Colorable;
import org.bukkit.material.Wool;

/**
 * A menu for selecting the color of a creature
 *
 * @since 5.3.0
 */
public class ColorSelectionMenu extends Gui {

    /**
     * Constructs a new Gui
     *
     * @param entity the entity to change the color of
     */
    public ColorSelectionMenu(Creature entity) {
        super(Main.getInstance(), 2, ChatColor.GREEN + "Select a color");

        OutlinePane pane = new OutlinePane(new GuiLocation(0, 0), 9, 2);

        for (DyeColor dyeColor : DyeColor.values())
            pane.addItem(new GuiItem(new Wool(dyeColor).toItemStack(1), event -> {
                if (entity instanceof Colorable)
                    ((Colorable) entity).setColor(dyeColor);
                else if (entity instanceof Wolf) {
                    Wolf wolf = (Wolf) entity;

                    wolf.setTamed(true);
                    wolf.setCollarColor(dyeColor);
                }

                event.setCancelled(true);
            }));

        addPane(pane);
    }
}