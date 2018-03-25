package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.parrot;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Parrot;
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
        super(1, ChatColor.GREEN + "Select the parrot type");

        OutlinePane pane = new OutlinePane(new GuiLocation(2, 0), 7, 1);

        //blue
        ItemStack blue = new Wool(DyeColor.BLUE).toItemStack(1);
        ItemMeta blueMeta = blue.getItemMeta();
        blueMeta.setDisplayName(ChatColor.GREEN + "Blue");
        blue.setItemMeta(blueMeta);

        pane.addItem(new GuiItem(blue, event -> {
            parrot.setVariant(Parrot.Variant.BLUE);

            event.setCancelled(true);
        }));

        //cyan
        ItemStack cyan = new Wool(DyeColor.CYAN).toItemStack(1);
        ItemMeta cyanMeta = cyan.getItemMeta();
        cyanMeta.setDisplayName(ChatColor.GREEN + "Cyan");
        cyan.setItemMeta(cyanMeta);

        pane.addItem(new GuiItem(cyan, event -> {
            parrot.setVariant(Parrot.Variant.CYAN);

            event.setCancelled(true);
        }));

        //gray
        ItemStack gray = new Wool(DyeColor.GRAY).toItemStack(1);
        ItemMeta grayMeta = gray.getItemMeta();
        grayMeta.setDisplayName(ChatColor.GREEN + "Gray");
        gray.setItemMeta(grayMeta);

        pane.addItem(new GuiItem(gray, event -> {
            parrot.setVariant(Parrot.Variant.GRAY);

            event.setCancelled(true);
        }));

        //green
        ItemStack green = new Wool(DyeColor.GREEN).toItemStack(1);
        ItemMeta greenMeta = green.getItemMeta();
        greenMeta.setDisplayName(ChatColor.GREEN + "Green");
        green.setItemMeta(greenMeta);

        pane.addItem(new GuiItem(green, event -> {
            parrot.setVariant(Parrot.Variant.GREEN);

            event.setCancelled(true);
        }));

        //red
        ItemStack red = new Wool(DyeColor.RED).toItemStack(1);
        ItemMeta redMeta = red.getItemMeta();
        redMeta.setDisplayName(ChatColor.GREEN + "Red");
        red.setItemMeta(redMeta);

        pane.addItem(new GuiItem(red, event -> {
            parrot.setVariant(Parrot.Variant.RED);

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
