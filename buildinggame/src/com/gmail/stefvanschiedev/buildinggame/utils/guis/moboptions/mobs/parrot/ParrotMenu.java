package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.parrot;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the options of a parrot
 *
 * @since 5.3.0
 */
public class ParrotMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public ParrotMenu(Plot plot, Parrot parrot) {
        super(plot, parrot);

        //type
        ItemStack type = new ItemStack(Material.BONE);
        ItemMeta typeMeta = type.getItemMeta();
        typeMeta.setDisplayName(ChatColor.GREEN + "Change type");
        type.setItemMeta(typeMeta);

        insertItem(type, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                new ParrotTypeMenu(parrot).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        }, 0);
    }
}
