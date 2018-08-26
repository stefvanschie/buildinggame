package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.pufferfish;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.PufferFish;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A selection menu for the inflation state of a pufferfish
 *
 * @since 6.0.0
 */
class PufferfishInflationStateMenu extends Gui {

    /**
     * Constructs a new pufferfish inflation state menu
     */
    PufferfishInflationStateMenu(PufferFish pufferfish) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Set pufferfish inflation state");

        OutlinePane pane = new OutlinePane(new GuiLocation(3, 0), 3, 1);

        //deflated
        ItemStack goldNugget = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta goldNuggetMeta = goldNugget.getItemMeta();
        goldNuggetMeta.setDisplayName(ChatColor.GREEN + "Deflated");
        goldNugget.setItemMeta(goldNuggetMeta);

        pane.addItem(new GuiItem(goldNugget, event -> {
            pufferfish.setPuffState(0);

            event.setCancelled(true);
        }));

        //half inflated
        ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldIngotMeta = goldIngot.getItemMeta();
        goldIngotMeta.setDisplayName(ChatColor.GREEN + "Half inflated");
        goldIngot.setItemMeta(goldIngotMeta);

        pane.addItem(new GuiItem(goldIngot, event -> {
            pufferfish.setPuffState(1);

            event.setCancelled(true);
        }));

        //fully inflated
        ItemStack goldBlock = new ItemStack(Material.GOLD_BLOCK);
        ItemMeta goldBlockMeta = goldBlock.getItemMeta();
        goldBlockMeta.setDisplayName(ChatColor.GREEN + "Fully inflated");
        goldBlock.setItemMeta(goldBlockMeta);

        pane.addItem(new GuiItem(goldBlock, event -> {
            pufferfish.setPuffState(2);

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
