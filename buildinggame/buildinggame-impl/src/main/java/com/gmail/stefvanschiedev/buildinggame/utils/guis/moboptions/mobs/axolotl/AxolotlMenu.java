package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.axolotl;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Axolotl;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for changing the options of an axolotl.
 *
 * @since 10.0.0
 */
public class AxolotlMenu extends BabyMenu {

    public AxolotlMenu(@NotNull Plot plot, @NotNull Axolotl axolotl) {
        super(plot, axolotl);

        //variant
        ItemStack variant = new ItemStack(Material.AXOLOTL_BUCKET);
        ItemMeta variantMeta = variant.getItemMeta();
        variantMeta.setDisplayName(ChatColor.GREEN + "Change the axolotl's variant");
        variant.setItemMeta(variantMeta);

        pane.insertItem(new GuiItem(variant, event -> {
            new AxolotlVariantMenu(axolotl).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
