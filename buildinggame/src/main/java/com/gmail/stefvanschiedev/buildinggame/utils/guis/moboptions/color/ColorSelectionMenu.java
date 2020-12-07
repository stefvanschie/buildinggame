package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.color;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.utils.MappedMaterialUtil;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Colorable;

/**
 * A menu for selecting the color of a creature
 *
 * @since 5.3.0
 */
public class ColorSelectionMenu extends ChestGui {

    /**
     * Constructs a new Gui
     *
     * @param entity the entity to change the color of
     */
    public ColorSelectionMenu(Creature entity) {
        super(2, ChatColor.GREEN + "Select a color");

        var pane = new OutlinePane(0, 0, 9, 2);

        MappedMaterialUtil.WOOL_DYE_COLOR_ITEMS.forEach(entry ->
            pane.addItem(new GuiItem(new ItemStack(entry.getKey()), event -> {
                DyeColor dyeColor = entry.getValue();

                if (entity instanceof Colorable) {
                    ((Colorable) entity).setColor(dyeColor);
                } else if (entity instanceof Wolf) {
                    Wolf wolf = (Wolf) entity;

                    wolf.setTamed(true);
                    wolf.setCollarColor(dyeColor);
                } else if (entity instanceof Cat) {
                    Cat cat = (Cat) entity;

                    cat.setTamed(true);
                    cat.setCollarColor(dyeColor);
                }

                event.setCancelled(true);
            }))
        );

        addPane(pane);
    }
}