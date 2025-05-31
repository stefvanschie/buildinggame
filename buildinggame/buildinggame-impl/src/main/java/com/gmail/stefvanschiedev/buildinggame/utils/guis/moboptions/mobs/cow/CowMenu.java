package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.cow;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Cow;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * A menu for changing the options of a cow.
 *
 * @since 12.10.0
 */
public class CowMenu extends BabyMenu {

    /**
     * Creates a new menu for changing the options of the specified cow.
     *
     * @param plot the plot this cow belongs to
     * @param cow the cow to edit
     * @since 12.10.0
     */
    public CowMenu(@NotNull Plot plot, @NotNull Cow cow) {
        super(plot, cow);

        //variant
        ItemStack variant = new ItemStack(Material.WHITE_DYE);
        ItemMeta variantMeta = variant.getItemMeta();
        Objects.requireNonNull(variantMeta).setDisplayName(ChatColor.GREEN + "Change the cow's variant");
        variant.setItemMeta(variantMeta);

        super.pane.insertItem(new GuiItem(variant, event -> {
            new CowVariantMenu(cow).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
