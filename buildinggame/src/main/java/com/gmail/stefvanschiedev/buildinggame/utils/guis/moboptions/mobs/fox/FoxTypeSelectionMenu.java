package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.fox;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for setting the type of a fox
 *
 * @since 7.0.0
 */
public class FoxTypeSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    //TODO: Change Entity to Fox
    public FoxTypeSelectionMenu(@NotNull Entity Fox) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Change the fox's type");

        var pane = new StaticPane(0, 0, 9, 1);

        ItemStack red = new ItemStack(Material.ROSE_RED);
        ItemMeta redMeta = red.getItemMeta();
        redMeta.setDisplayName(ChatColor.GREEN + "Red");
        red.setItemMeta(redMeta);

        pane.addItem(new GuiItem(red, event -> {
            //TODO: Change the fox's type to red

            event.setCancelled(true);
        }), 2, 0);

        ItemStack snow = new ItemStack(Material.SNOWBALL);
        ItemMeta snowMeta = snow.getItemMeta();
        snowMeta.setDisplayName(ChatColor.GREEN + "Snow");
        snow.setItemMeta(redMeta);

        pane.addItem(new GuiItem(snow, event -> {
            //TODO: Change the fox's type to snow

            event.setCancelled(true);
        }), 6, 0);

        addPane(pane);
    }
}
