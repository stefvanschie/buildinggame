package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.horse;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

/**
 * A menu for changing the style of a horse
 *
 * @since 5.3.0
 */
class HorseStyleSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    HorseStyleSelectionMenu(Horse horse) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Change the horse style");

        OutlinePane pane = new OutlinePane(new GuiLocation(2, 0), 7, 1);

        //black dots
        ItemStack blackDots = new ItemStack(Material.MELON_SEEDS);
        ItemMeta blackDotsMeta = blackDots.getItemMeta();
        blackDotsMeta.setDisplayName(ChatColor.GREEN + "Black dots");
        blackDots.setItemMeta(blackDotsMeta);

        pane.addItem(new GuiItem(blackDots, event -> {
            horse.setStyle(Horse.Style.BLACK_DOTS);

            event.setCancelled(true);
        }));

        //none
        ItemStack none = new ItemStack(Material.BARRIER);
        ItemMeta noneMeta = none.getItemMeta();
        noneMeta.setDisplayName(ChatColor.GREEN + "None");
        none.setItemMeta(noneMeta);

        pane.addItem(new GuiItem(none, event -> {
            horse.setStyle(Horse.Style.NONE);

            event.setCancelled(true);
        }));

        //white
        ItemStack white = new Wool(DyeColor.WHITE).toItemStack(1);
        ItemMeta whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.GREEN + "White");
        white.setItemMeta(whiteMeta);

        pane.addItem(new GuiItem(white, event -> {
            horse.setStyle(Horse.Style.WHITE);

            event.setCancelled(true);
        }));

        //white dots
        ItemStack whiteDots = new ItemStack(Material.PUMPKIN_SEEDS);
        ItemMeta whiteDotsMeta = whiteDots.getItemMeta();
        whiteDotsMeta.setDisplayName(ChatColor.GREEN + "White dots");
        whiteDots.setItemMeta(whiteDotsMeta);

        pane.addItem(new GuiItem(whiteDots, event -> {
            horse.setStyle(Horse.Style.WHITE_DOTS);

            event.setCancelled(true);
        }));

        //whitefield
        ItemStack whitefield = new ItemStack(Material.BOOK);
        ItemMeta whitefieldMeta = whitefield.getItemMeta();
        whitefieldMeta.setDisplayName(ChatColor.GREEN + "Whitefield");
        whitefield.setItemMeta(whitefieldMeta);

        pane.addItem(new GuiItem(whitefield, event -> {
            horse.setStyle(Horse.Style.WHITEFIELD);

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
