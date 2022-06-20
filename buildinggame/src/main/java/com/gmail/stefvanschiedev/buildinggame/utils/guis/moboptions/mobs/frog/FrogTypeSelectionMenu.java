package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.frog;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Frog;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for setting the variant of a fox
 *
 * @since 12.0.0
 */
final class FrogTypeSelectionMenu extends ChestGui {

    /**
     * {@inheritDoc}
     */
    FrogTypeSelectionMenu(@NotNull Frog frog) {
        super(1, ChatColor.GREEN + "Change the fox's type");

        var pane = new OutlinePane(0, 0, 9, 1);
        pane.align(OutlinePane.Alignment.CENTER);
        pane.setGap(1);
        pane.setOnClick(event -> event.setCancelled(true));

        ItemStack temperate = new ItemStack(Material.ORANGE_DYE);
        ItemMeta temperateMeta = temperate.getItemMeta();
        temperateMeta.setDisplayName(ChatColor.GREEN + "Temperate");
        temperate.setItemMeta(temperateMeta);

        pane.addItem(new GuiItem(temperate, event -> frog.setVariant(Frog.Variant.TEMPERATE)));

        ItemStack warm = new ItemStack(Material.WHITE_DYE);
        ItemMeta warmMeta = warm.getItemMeta();
        warmMeta.setDisplayName(ChatColor.GREEN + "Warm");
        warm.setItemMeta(warmMeta);

        pane.addItem(new GuiItem(warm, event -> frog.setVariant(Frog.Variant.WARM)));

        ItemStack cold = new ItemStack(Material.GREEN_DYE);
        ItemMeta coldMeta = cold.getItemMeta();
        coldMeta.setDisplayName(ChatColor.GREEN + "Cold");
        cold.setItemMeta(coldMeta);

        pane.addItem(new GuiItem(cold, event -> frog.setVariant(Frog.Variant.COLD)));

        addPane(pane);
    }
}
