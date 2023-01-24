package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.mooshroom;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.MushroomCow;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for altering the properties of {@link org.bukkit.entity.MushroomCow}s.
 *
 * @since 0.5.0
 */
public class MooshroomMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public MooshroomMenu(@NotNull Plot plot, @NotNull MushroomCow mushroomCow) {
        super(plot, mushroomCow);

        ItemStack type = new ItemStack(Material.ORANGE_CONCRETE_POWDER);
        ItemMeta typeMeta = type.getItemMeta();
        typeMeta.setDisplayName(ChatColor.GREEN + "Change the mooshroom's type");
        type.setItemMeta(typeMeta);

        pane.insertItem(new GuiItem(type, event -> {
            new MooshroomTypeSelectionMenu(mushroomCow).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
