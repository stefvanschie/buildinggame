package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.parrot;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.entity.Parrot;
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
        super(Main.getInstance(), 1, ChatColor.GREEN + "Select the parrot type");

        var pane = new OutlinePane(2, 0, 7, 1);

        //blue
        var blue = new Wool(DyeColor.BLUE).toItemStack(1);
        var blueMeta = blue.getItemMeta();
        blueMeta.setDisplayName(ChatColor.GREEN + "Blue");
        blue.setItemMeta(blueMeta);

        pane.addItem(new GuiItem(blue, event -> {
            parrot.setVariant(Parrot.Variant.BLUE);

            event.setCancelled(true);
        }));

        //cyan
        var cyan = new Wool(DyeColor.CYAN).toItemStack(1);
        var cyanMeta = cyan.getItemMeta();
        cyanMeta.setDisplayName(ChatColor.GREEN + "Cyan");
        cyan.setItemMeta(cyanMeta);

        pane.addItem(new GuiItem(cyan, event -> {
            parrot.setVariant(Parrot.Variant.CYAN);

            event.setCancelled(true);
        }));

        //gray
        var gray = new Wool(DyeColor.GRAY).toItemStack(1);
        var grayMeta = gray.getItemMeta();
        grayMeta.setDisplayName(ChatColor.GREEN + "Gray");
        gray.setItemMeta(grayMeta);

        pane.addItem(new GuiItem(gray, event -> {
            parrot.setVariant(Parrot.Variant.GRAY);

            event.setCancelled(true);
        }));

        //green
        var green = new Wool(DyeColor.GREEN).toItemStack(1);
        var greenMeta = green.getItemMeta();
        greenMeta.setDisplayName(ChatColor.GREEN + "Green");
        green.setItemMeta(greenMeta);

        pane.addItem(new GuiItem(green, event -> {
            parrot.setVariant(Parrot.Variant.GREEN);

            event.setCancelled(true);
        }));

        //red
        var red = new Wool(DyeColor.RED).toItemStack(1);
        var redMeta = red.getItemMeta();
        redMeta.setDisplayName(ChatColor.GREEN + "Red");
        red.setItemMeta(redMeta);

        pane.addItem(new GuiItem(red, event -> {
            parrot.setVariant(Parrot.Variant.RED);

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
