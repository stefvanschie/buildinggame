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
 * A menu for changing the color of a horse
 *
 * @since 5.3.0
 */
class HorseColorSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    HorseColorSelectionMenu(Horse horse) {
        super(null, 9, ChatColor.GREEN + "Change the horse color", 1);

        setStartingPoint(1);

        //black
        ItemStack black = new Wool(DyeColor.BLACK).toItemStack(1);
        ItemMeta blackMeta = black.getItemMeta();
        blackMeta.setDisplayName(ChatColor.GREEN + "Black");
        black.setItemMeta(blackMeta);

        addItem(black, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setColor(Horse.Color.BLACK);

                return true;
            }
        });

        //brown
        ItemStack brown = new Wool(DyeColor.BROWN).toItemStack(1);
        ItemMeta brownMeta = brown.getItemMeta();
        brownMeta.setDisplayName(ChatColor.GREEN + "Brown");
        brown.setItemMeta(brownMeta);

        addItem(brown, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setColor(Horse.Color.BROWN);

                return true;
            }
        });

        //chestnut
        ItemStack chestnut = new ItemStack(Material.RED_NETHER_BRICK);
        ItemMeta chestnutMeta = chestnut.getItemMeta();
        chestnutMeta.setDisplayName(ChatColor.GREEN + "Chestnut");
        chestnut.setItemMeta(chestnutMeta);

        addItem(chestnut, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setColor(Horse.Color.CHESTNUT);

                return true;
            }
        });

        //creamy
        ItemStack creamy = new ItemStack(Material.SANDSTONE);
        ItemMeta creamyMeta = creamy.getItemMeta();
        creamyMeta.setDisplayName(ChatColor.GREEN + "Creamy");
        creamy.setItemMeta(creamyMeta);

        addItem(creamy, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setColor(Horse.Color.CREAMY);

                return true;
            }
        });

        //dark brown
        ItemStack darkBrown = new ItemStack(Material.NETHER_BRICK);
        ItemMeta darkBrownMeta = darkBrown.getItemMeta();
        darkBrownMeta.setDisplayName(ChatColor.GREEN + "Dark brown");
        darkBrown.setItemMeta(darkBrownMeta);

        addItem(darkBrown, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setColor(Horse.Color.DARK_BROWN);

                return true;
            }
        });

        //gray
        ItemStack gray = new Wool(DyeColor.GRAY).toItemStack(1);
        ItemMeta grayMeta = gray.getItemMeta();
        grayMeta.setDisplayName(ChatColor.GREEN + "Gray");
        gray.setItemMeta(grayMeta);

        addItem(gray, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                horse.setColor(Horse.Color.GRAY);

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

                horse.setColor(Horse.Color.WHITE);

                return true;
            }
        });
    }
}
