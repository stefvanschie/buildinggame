package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.color;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Animals;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing the color of an entity
 *
 * @since 5.3.0
 */
public class ColorMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public ColorMenu(Plot plot, Animals entity) {
        super(plot, entity);

        var color = new ItemStack(Material.ORANGE_CONCRETE_POWDER);
        var colorMeta = color.getItemMeta();
        colorMeta.setDisplayName(ChatColor.GREEN + "Change the color of the entity");
        color.setItemMeta(colorMeta);

        pane.insertItem(new GuiItem(color, event -> {
            new ColorSelectionMenu(entity).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
