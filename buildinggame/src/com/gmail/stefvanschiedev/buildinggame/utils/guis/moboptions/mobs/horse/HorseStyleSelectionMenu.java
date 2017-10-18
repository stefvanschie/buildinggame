package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.horse;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.event.inventory.InventoryEvent;
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
        super(null, 9, ChatColor.GREEN + "Change the horse style", 1);

        setStartingPoint(2);

        //black dots
        ItemStack blackDots = new ItemStack(Material.MELON_SEEDS);
        ItemMeta blackDotsMeta = blackDots.getItemMeta();
        blackDotsMeta.setDisplayName(ChatColor.GREEN + "Black dots");
        blackDots.setItemMeta(blackDotsMeta);

        addItem(blackDots, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setStyle(Horse.Style.BLACK_DOTS);

                return true;
            }
        });

        //none
        ItemStack none = new ItemStack(Material.BARRIER);
        ItemMeta noneMeta = none.getItemMeta();
        noneMeta.setDisplayName(ChatColor.GREEN + "None");
        none.setItemMeta(noneMeta);

        addItem(none, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setStyle(Horse.Style.NONE);

                return true;
            }
        });

        //white
        ItemStack white = new Wool(DyeColor.WHITE).toItemStack(1);
        ItemMeta whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.GREEN + "White");
        white.setItemMeta(whiteMeta);

        addItem(white, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setStyle(Horse.Style.WHITE);

                return true;
            }
        });

        //white dots
        ItemStack whiteDots = new ItemStack(Material.PUMPKIN_SEEDS);
        ItemMeta whiteDotsMeta = whiteDots.getItemMeta();
        whiteDotsMeta.setDisplayName(ChatColor.GREEN + "White dots");
        whiteDots.setItemMeta(whiteDotsMeta);

        addItem(whiteDots, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setStyle(Horse.Style.WHITE_DOTS);

                return true;
            }
        });

        //whitefield
        ItemStack whitefield = new ItemStack(Material.BOOK);
        ItemMeta whitefieldMeta = whitefield.getItemMeta();
        whitefieldMeta.setDisplayName(ChatColor.GREEN + "Whitefield");
        whitefield.setItemMeta(whitefieldMeta);

        addItem(whitefield, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setStyle(Horse.Style.WHITEFIELD);

                return true;
            }
        });
    }
}
