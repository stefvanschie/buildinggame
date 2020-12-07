package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.size;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Mob;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing the size of an entity
 *
 * @since 5.3.0
 */
public class SizeMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public SizeMenu(Plot plot, Mob mob) {
        super(plot, mob);

        //size
        var size = new ItemStack(Material.RED_MUSHROOM);
        var sizeMeta = size.getItemMeta();
        sizeMeta.setDisplayName(ChatColor.GREEN + "Change size");
        size.setItemMeta(sizeMeta);

        pane.insertItem(new GuiItem(size, event -> {
            new SizeSelectionMenu(mob).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
