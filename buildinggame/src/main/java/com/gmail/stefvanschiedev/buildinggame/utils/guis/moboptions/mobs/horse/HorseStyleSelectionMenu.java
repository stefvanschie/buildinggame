package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.horse;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing the style of a horse
 *
 * @since 5.3.0
 */
class HorseStyleSelectionMenu extends ChestGui {

    /**
     * {@inheritDoc}
     */
    HorseStyleSelectionMenu(Horse horse) {
        super(1, ChatColor.GREEN + "Change the horse style");

        var pane = new OutlinePane(2, 0, 7, 1);

        //black dots
        var blackDots = new ItemStack(Material.MELON_SEEDS);
        var blackDotsMeta = blackDots.getItemMeta();
        blackDotsMeta.setDisplayName(ChatColor.GREEN + "Black dots");
        blackDots.setItemMeta(blackDotsMeta);

        pane.addItem(new GuiItem(blackDots, event -> {
            horse.setStyle(Horse.Style.BLACK_DOTS);

            event.setCancelled(true);
        }));

        //none
        var none = new ItemStack(Material.BARRIER);
        var noneMeta = none.getItemMeta();
        noneMeta.setDisplayName(ChatColor.GREEN + "None");
        none.setItemMeta(noneMeta);

        pane.addItem(new GuiItem(none, event -> {
            horse.setStyle(Horse.Style.NONE);

            event.setCancelled(true);
        }));

        //white
        var white = new ItemStack(Material.WHITE_WOOL);
        var whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.GREEN + "White");
        white.setItemMeta(whiteMeta);

        pane.addItem(new GuiItem(white, event -> {
            horse.setStyle(Horse.Style.WHITE);

            event.setCancelled(true);
        }));

        //white dots
        var whiteDots = new ItemStack(Material.PUMPKIN_SEEDS);
        var whiteDotsMeta = whiteDots.getItemMeta();
        whiteDotsMeta.setDisplayName(ChatColor.GREEN + "White dots");
        whiteDots.setItemMeta(whiteDotsMeta);

        pane.addItem(new GuiItem(whiteDots, event -> {
            horse.setStyle(Horse.Style.WHITE_DOTS);

            event.setCancelled(true);
        }));

        //whitefield
        var whitefield = new ItemStack(Material.BOOK);
        var whitefieldMeta = whitefield.getItemMeta();
        whitefieldMeta.setDisplayName(ChatColor.GREEN + "Whitefield");
        whitefield.setItemMeta(whitefieldMeta);

        pane.addItem(new GuiItem(whitefield, event -> {
            horse.setStyle(Horse.Style.WHITEFIELD);

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
