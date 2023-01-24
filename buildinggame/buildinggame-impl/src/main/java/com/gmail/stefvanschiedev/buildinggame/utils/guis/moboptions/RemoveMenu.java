package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for removing the entity
 *
 * @since 5.3.0
 */
public class RemoveMenu extends ChestGui {

    /**
     * The general outline pane
     */
    protected final OutlinePane pane;

    /**
     * Constructs a new Gui
     *
     * @param plot the plot this entity belongs to
     * @param entity the entity to edit
     */
    public RemoveMenu(Plot plot, Entity entity) {
        super(1, ChatColor.GREEN + "Modify entity");

        pane = new OutlinePane(0, 0, 9, 1);

        var remove = new ItemStack(Material.BARRIER);
        var removeMeta = remove.getItemMeta();
        removeMeta.setDisplayName(ChatColor.RED + "Remove entity");
        remove.setItemMeta(removeMeta);

        pane.addItem(new GuiItem(remove, event -> {
            plot.getEntities().remove(entity);
            entity.remove();

            event.getWhoClicked().closeInventory();

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}