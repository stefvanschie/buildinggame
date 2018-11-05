package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.panda;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

/**
 * A menu for changing the color of a panda
 *
 * @since 7.0.0
 */
class PandaColorSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    //TODO: Change Entity to Panda
    PandaColorSelectionMenu(Entity panda) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Change the panda's color");

        var pane = new StaticPane(new GuiLocation(2, 0), 5, 1);

        //black
        ItemStack black = new Wool(DyeColor.BLACK).toItemStack(1);
        ItemMeta blackMeta = black.getItemMeta();
        blackMeta.setDisplayName(ChatColor.GREEN + "Black");
        black.setItemMeta(blackMeta);

        pane.addItem(new GuiItem(black, event -> {
            //TODO: Change the panda's color to black

            event.setCancelled(true);
        }), new GuiLocation(0, 0));

        //brown
        ItemStack brown = new Wool(DyeColor.BROWN).toItemStack(1);
        ItemMeta brownMeta = brown.getItemMeta();
        brownMeta.setDisplayName(ChatColor.GREEN + "Brown");
        brown.setItemMeta(brownMeta);

        pane.addItem(new GuiItem(brown, event -> {
            //TODO: Change the panda's color to brown

            event.setCancelled(true);
        }), new GuiLocation(4, 0));

        addPane(pane);
    }
}
