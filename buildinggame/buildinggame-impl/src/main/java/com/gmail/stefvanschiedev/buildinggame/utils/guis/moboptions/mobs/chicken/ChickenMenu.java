package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.chicken;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Chicken;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

/**
 * A menu for changing the options of a chicken.
 *
 * @since 12.10.0
 */
public class ChickenMenu extends BabyMenu {

    /**
     * Creates a new menu for changing the options of the specified chicken.
     *
     * @param plot the plot this chicken belongs to
     * @param chicken the chicken to edit
     * @since 12.10.0
     */
    public ChickenMenu(@NotNull Plot plot, @NotNull Chicken chicken) {
        super(plot, chicken);

        //variant
        ItemStack variant = new ItemStack(Material.WHITE_DYE);
        ItemMeta variantMeta = variant.getItemMeta();
        Objects.requireNonNull(variantMeta).setDisplayName(ChatColor.GREEN + "Change the chicken's variant");
        variant.setItemMeta(variantMeta);

        super.pane.insertItem(new GuiItem(variant, event -> {
            new ChickenVariantMenu(chicken).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
