package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.wolf;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.color.ColorMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.nms.Version;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for changing the options of a wolf.
 *
 * @since 12.5.0
 */
public class WolfMenu extends ColorMenu {

    /**
     * Creates a wolf menu to change the properties of a wolf.
     *
     * @param plot the plot where the entity is located
     * @param entity the entity to modify
     * @since 12.5.0
     */
    public WolfMenu(@NotNull Plot plot, @NotNull Wolf entity) {
        super(plot, entity);

        if (!Version.getVersion().isAtLeast(Version.V1_20_5)) {
            return;
        }

        var variant = new ItemStack(Material.WHITE_WOOL);
        var variantMeta = variant.getItemMeta();
        variantMeta.setDisplayName(ChatColor.GREEN + "Change the wolf's variant");
        variant.setItemMeta(variantMeta);

        pane.insertItem(new GuiItem(variant, event -> {
            new WolfVariantMenu(entity).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
