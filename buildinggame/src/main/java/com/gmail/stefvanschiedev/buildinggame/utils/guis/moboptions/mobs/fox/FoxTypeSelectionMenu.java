package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.fox;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Fox;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for setting the type of a fox
 *
 * @since 7.0.0
 */
class FoxTypeSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    FoxTypeSelectionMenu(@NotNull Fox fox) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Change the fox's type");

        var pane = new StaticPane(0, 0, 9, 1);

        ItemStack red = new ItemStack(Material.RED_DYE);
        ItemMeta redMeta = red.getItemMeta();
        redMeta.setDisplayName(ChatColor.GREEN + "Red");
        red.setItemMeta(redMeta);

        pane.addItem(new GuiItem(red, event -> {
            fox.setFoxType(Fox.Type.RED);

            event.setCancelled(true);
        }), 2, 0);

        ItemStack snow = new ItemStack(Material.SNOWBALL);
        ItemMeta snowMeta = snow.getItemMeta();
        snowMeta.setDisplayName(ChatColor.GREEN + "Snow");
        snow.setItemMeta(snowMeta);

        pane.addItem(new GuiItem(snow, event -> {
            fox.setFoxType(Fox.Type.SNOW);

            event.setCancelled(true);
        }), 6, 0);

        addPane(pane);
    }
}
