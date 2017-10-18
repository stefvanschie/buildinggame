package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.ocelot;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the options of an ocelot
 *
 * @since 5.3.0
 */
public class OcelotMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public OcelotMenu(Plot plot, Ocelot ocelot) {
        super(plot, ocelot);

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

                new OcelotTypeMenu(ocelot).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        }, 0);
    }
}
