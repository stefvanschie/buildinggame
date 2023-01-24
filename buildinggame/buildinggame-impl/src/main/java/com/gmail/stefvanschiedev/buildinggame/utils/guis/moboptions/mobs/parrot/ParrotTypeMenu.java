package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.parrot;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Parrot;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing the type of a parrot
 *
 * @since 5.3.0
 */
class ParrotTypeMenu extends ChestGui {

    /**
     * {@inheritDoc}
     */
    ParrotTypeMenu(Parrot parrot) {
        super(1, ChatColor.GREEN + "Select the parrot type");

        var pane = new OutlinePane(2, 0, 7, 1);

        //blue
        var blue = new ItemStack(Material.BLUE_WOOL);
        var blueMeta = blue.getItemMeta();
        blueMeta.setDisplayName(ChatColor.GREEN + "Blue");
        blue.setItemMeta(blueMeta);

        pane.addItem(new GuiItem(blue, event -> {
            parrot.setVariant(Parrot.Variant.BLUE);

            event.setCancelled(true);
        }));

        //cyan
        var cyan = new ItemStack(Material.CYAN_WOOL);
        var cyanMeta = cyan.getItemMeta();
        cyanMeta.setDisplayName(ChatColor.GREEN + "Cyan");
        cyan.setItemMeta(cyanMeta);

        pane.addItem(new GuiItem(cyan, event -> {
            parrot.setVariant(Parrot.Variant.CYAN);

            event.setCancelled(true);
        }));

        //gray
        var gray = new ItemStack(Material.GRAY_WOOL);
        var grayMeta = gray.getItemMeta();
        grayMeta.setDisplayName(ChatColor.GREEN + "Gray");
        gray.setItemMeta(grayMeta);

        pane.addItem(new GuiItem(gray, event -> {
            parrot.setVariant(Parrot.Variant.GRAY);

            event.setCancelled(true);
        }));

        //green
        var green = new ItemStack(Material.GREEN_WOOL);
        var greenMeta = green.getItemMeta();
        greenMeta.setDisplayName(ChatColor.GREEN + "Green");
        green.setItemMeta(greenMeta);

        pane.addItem(new GuiItem(green, event -> {
            parrot.setVariant(Parrot.Variant.GREEN);

            event.setCancelled(true);
        }));

        //red
        var red = new ItemStack(Material.RED_WOOL);
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
