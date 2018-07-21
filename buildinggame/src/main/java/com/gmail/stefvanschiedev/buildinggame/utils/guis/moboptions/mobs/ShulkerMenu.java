package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs;

import com.github.stefvanschie.inventoryframework.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.color.ColorSelectionMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Shulker;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the options of a shulker
 *
 * @since 5.3.0
 */
public class ShulkerMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public ShulkerMenu(Plot plot, Shulker shulker) {
        super(plot, shulker);

        //color
        ItemStack color = new ItemStack(Material.CONCRETE_POWDER, 1, (short) 1);
        ItemMeta colorMeta = color.getItemMeta();
        colorMeta.setDisplayName(ChatColor.GREEN + "Change the color of the entity");
        color.setItemMeta(colorMeta);

        pane.insertItem(new GuiItem(color, event -> {
            new ColorSelectionMenu(shulker).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
