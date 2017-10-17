package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.size;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the size of an entity
 *
 * @since 5.3.0
 */
public class SizeMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public SizeMenu(Plot plot, Slime slime) {
        super(plot, slime);

        //size
        ItemStack size = new ItemStack(Material.RED_MUSHROOM);
        ItemMeta sizeMeta = size.getItemMeta();
        sizeMeta.setDisplayName(ChatColor.GREEN + "Change size");
        size.setItemMeta(sizeMeta);

        insertItem(size, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                new SizeSelectionMenu(slime).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        }, 0);
    }
}
