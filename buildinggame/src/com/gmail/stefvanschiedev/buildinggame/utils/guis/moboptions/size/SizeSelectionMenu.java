package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.size;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Slime;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for selecting the size of a slime
 *
 * @since 5.3.0
 */
class SizeSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    SizeSelectionMenu(Slime slime) {
        super(null, 9, ChatColor.GREEN + "Change size", 1);

        setStartingPoint(3);

        //small
        ItemStack goldNugget = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta goldNuggetMeta = goldNugget.getItemMeta();
        goldNuggetMeta.setDisplayName(ChatColor.GREEN + "Small");
        goldNugget.setItemMeta(goldNuggetMeta);

        addItem(goldNugget, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                slime.setSize(1);

                return true;
            }
        });

        //medium
        ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldIngotMeta = goldIngot.getItemMeta();
        goldIngotMeta.setDisplayName(ChatColor.GREEN + "Medium");
        goldIngot.setItemMeta(goldIngotMeta);

        addItem(goldIngot, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                slime.setSize(2);

                return true;
            }
        });

        //large
        ItemStack goldBlock = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta goldBlockMeta = goldBlock.getItemMeta();
        goldBlockMeta.setDisplayName(ChatColor.GREEN + "Large");
        goldBlock.setItemMeta(goldBlockMeta);

        addItem(goldBlock, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                slime.setSize(4);

                return true;
            }
        });
    }
}
