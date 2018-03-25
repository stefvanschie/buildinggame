package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.size;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Slime;
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
        super(1, ChatColor.GREEN + "Change size");

        OutlinePane pane = new OutlinePane(new GuiLocation(3, 0), 6, 1);

        //small
        ItemStack goldNugget = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta goldNuggetMeta = goldNugget.getItemMeta();
        goldNuggetMeta.setDisplayName(ChatColor.GREEN + "Small");
        goldNugget.setItemMeta(goldNuggetMeta);

        pane.addItem(new GuiItem(goldNugget, event -> {
            slime.setSize(1);

            event.setCancelled(true);
        }));

        //medium
        ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldIngotMeta = goldIngot.getItemMeta();
        goldIngotMeta.setDisplayName(ChatColor.GREEN + "Medium");
        goldIngot.setItemMeta(goldIngotMeta);

        pane.addItem(new GuiItem(goldIngot, event -> {
            slime.setSize(2);

            event.setCancelled(true);
        }));

        //large
        ItemStack goldBlock = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta goldBlockMeta = goldBlock.getItemMeta();
        goldBlockMeta.setDisplayName(ChatColor.GREEN + "Large");
        goldBlock.setItemMeta(goldBlockMeta);

        pane.addItem(new GuiItem(goldBlock, event -> {
            slime.setSize(4);

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
