package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.mooshroom;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.MushroomCow;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for setting a {@link org.bukkit.entity.MushroomCow}'s type
 *
 * @since 7.0.0
 */
public class MooshroomTypeSelectionMenu extends Gui {

    /**
     * Creates a new mushroom type selection menu
     *
     * @param mushroomCow the mushroom cow to set the type for
     * @since 7.0.0
     */
    public MooshroomTypeSelectionMenu(@NotNull MushroomCow mushroomCow) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Change the mooshroom's type");

        var pane = new StaticPane(0, 0, 9, 1);

        ItemStack red = new ItemStack(Material.ROSE_RED);
        ItemMeta redMeta = red.getItemMeta();
        redMeta.setDisplayName(ChatColor.GREEN + "Red");
        red.setItemMeta(redMeta);

        pane.addItem(new GuiItem(red, event -> {
            //TODO: Set the mooshroom's type to red

            event.setCancelled(true);
        }), 2, 0);

        ItemStack brown = new ItemStack(Material.COCOA_BEANS);
        ItemMeta brownMeta = brown.getItemMeta();
        brownMeta.setDisplayName(ChatColor.GREEN + "Brown");
        brown.setItemMeta(brownMeta);

        pane.addItem(new GuiItem(brown, event -> {
            //TODO: Set the mooshroom's type to brown

            event.setCancelled(true);
        }), 6, 0);

        addPane(pane);
    }
}
