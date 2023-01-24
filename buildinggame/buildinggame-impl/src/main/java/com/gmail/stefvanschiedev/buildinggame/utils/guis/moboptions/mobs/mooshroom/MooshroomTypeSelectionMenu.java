package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.mooshroom;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
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
class MooshroomTypeSelectionMenu extends ChestGui {

    /**
     * Creates a new mushroom type selection menu
     *
     * @param mushroomCow the mushroom cow to set the type for
     * @since 7.0.0
     */
    MooshroomTypeSelectionMenu(@NotNull MushroomCow mushroomCow) {
        super(1, ChatColor.GREEN + "Change the mooshroom's type");

        var pane = new StaticPane(0, 0, 9, 1);

        ItemStack red = new ItemStack(Material.RED_DYE);
        ItemMeta redMeta = red.getItemMeta();
        redMeta.setDisplayName(ChatColor.GREEN + "Red");
        red.setItemMeta(redMeta);

        pane.addItem(new GuiItem(red, event -> {
            mushroomCow.setVariant(MushroomCow.Variant.RED);

            event.setCancelled(true);
        }), 2, 0);

        ItemStack brown = new ItemStack(Material.BROWN_DYE);
        ItemMeta brownMeta = brown.getItemMeta();
        brownMeta.setDisplayName(ChatColor.GREEN + "Brown");
        brown.setItemMeta(brownMeta);

        pane.addItem(new GuiItem(brown, event -> {
            mushroomCow.setVariant(MushroomCow.Variant.BROWN);

            event.setCancelled(true);
        }), 6, 0);

        addPane(pane);
    }
}
