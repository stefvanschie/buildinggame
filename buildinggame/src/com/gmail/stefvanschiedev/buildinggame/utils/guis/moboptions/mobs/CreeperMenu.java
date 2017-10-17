package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the options of a creeper
 *
 * @since 5.3.0
 */
public class CreeperMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public CreeperMenu(Plot plot, Creeper creeper) {
        super(plot, creeper);

        //powered
        ItemStack powered = new ItemStack(Material.REDSTONE);
        ItemMeta poweredMeta = powered.getItemMeta();
        poweredMeta.setDisplayName(ChatColor.GREEN + "Change whether this creeper is charged");
        powered.setItemMeta(poweredMeta);

        insertItem(powered, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                creeper.setPowered(!creeper.isPowered());

                return true;
            }
        }, 0);
    }
}
