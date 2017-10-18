package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for removing the entity
 *
 * @since 5.3.0
 */
public class RemoveMenu extends Gui {

    /**
     * Constructs a new Gui
     *
     * @param plot the plot this entity belongs to
     * @param entity the entity to edit
     */
    public RemoveMenu(Plot plot, Entity entity) {
        super(null, 9, ChatColor.GREEN + "Modify entity", 1);

        ItemStack remove = new ItemStack(Material.BARRIER);
        ItemMeta removeMeta = remove.getItemMeta();
        removeMeta.setDisplayName(ChatColor.RED + "Remove entity");
        remove.setItemMeta(removeMeta);

        addItem(remove, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                plot.getEntities().remove(entity);
                entity.remove();

                ((InventoryInteractEvent) event).getWhoClicked().closeInventory();

                return true;
            }
        });
    }
}