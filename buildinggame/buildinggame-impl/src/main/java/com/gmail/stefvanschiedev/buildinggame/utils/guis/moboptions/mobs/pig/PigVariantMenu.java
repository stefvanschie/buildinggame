package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.pig;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Pig;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * A menu for changing a pig's variant.
 *
 * @since 12.10.0
 */
public class PigVariantMenu extends ChestGui {

    /**
     * Creates a menu for changing the variant of the specified pig.
     *
     * @param pig the pig to change the variant of
     * @since 12.10.0
     */
    PigVariantMenu(@NotNull Pig pig) {
        super(1, ChatColor.GREEN + "Change the pig's variant");

        setOnGlobalClick(event -> event.setCancelled(true));

        var pane = new OutlinePane(0, 0, 9, 1);
        pane.align(OutlinePane.Alignment.CENTER);
        pane.setGap(1);

        //temperate
        ItemStack temperate = new ItemStack(Material.BROWN_DYE);
        ItemMeta temperateMeta = temperate.getItemMeta();
        Objects.requireNonNull(temperateMeta).setDisplayName(ChatColor.GREEN + "Temperate");
        temperate.setItemMeta(temperateMeta);

        pane.addItem(new GuiItem(temperate, event -> pig.setVariant(Pig.Variant.TEMPERATE)));

        //cold
        ItemStack cold = new ItemStack(Material.WHITE_DYE);
        ItemMeta coldMeta = cold.getItemMeta();
        Objects.requireNonNull(coldMeta).setDisplayName(ChatColor.GREEN + "Cold");
        cold.setItemMeta(coldMeta);

        pane.addItem(new GuiItem(cold, event -> pig.setVariant(Pig.Variant.COLD)));

        //warm
        ItemStack warm = new ItemStack(Material.BLACK_DYE);
        ItemMeta warmMeta = warm.getItemMeta();
        Objects.requireNonNull(warmMeta).setDisplayName(ChatColor.GREEN + "Warm");
        warm.setItemMeta(warmMeta);

        pane.addItem(new GuiItem(warm, event -> pig.setVariant(Pig.Variant.WARM)));

        addPane(pane);
    }
}
