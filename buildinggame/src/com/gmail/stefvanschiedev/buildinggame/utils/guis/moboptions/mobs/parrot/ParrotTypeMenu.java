package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.parrot;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Parrot;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

/**
 * A menu for changing the type of a parrot
 *
 * @since 5.3.0
 */
class ParrotTypeMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    ParrotTypeMenu(Parrot parrot) {
        super(null, 9, ChatColor.GREEN + "Select the parrot type", 1);

        setStartingPoint(2);

        //blue
        ItemStack blue = new Wool(DyeColor.BLUE).toItemStack(1);
        ItemMeta blueMeta = blue.getItemMeta();
        blueMeta.setDisplayName(ChatColor.GREEN + "Blue");
        blue.setItemMeta(blueMeta);

        addItem(blue, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                parrot.setVariant(Parrot.Variant.BLUE);

                return true;
            }
        });

        //cyan
        ItemStack cyan = new Wool(DyeColor.CYAN).toItemStack(1);
        ItemMeta cyanMeta = cyan.getItemMeta();
        cyanMeta.setDisplayName(ChatColor.GREEN + "Cyan");
        cyan.setItemMeta(cyanMeta);

        addItem(cyan, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                parrot.setVariant(Parrot.Variant.CYAN);

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

                parrot.setVariant(Parrot.Variant.GRAY);

                return true;
            }
        });

        //green
        ItemStack green = new Wool(DyeColor.GREEN).toItemStack(1);
        ItemMeta greenMeta = green.getItemMeta();
        greenMeta.setDisplayName(ChatColor.GREEN + "Green");
        green.setItemMeta(greenMeta);

        addItem(green, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                parrot.setVariant(Parrot.Variant.GREEN);

                return true;
            }
        });

        //red
        ItemStack red = new Wool(DyeColor.RED).toItemStack(1);
        ItemMeta redMeta = red.getItemMeta();
        redMeta.setDisplayName(ChatColor.GREEN + "Red");
        red.setItemMeta(redMeta);

        addItem(red, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                parrot.setVariant(Parrot.Variant.RED);

                return true;
            }
        });
    }
}
