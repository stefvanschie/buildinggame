package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.frog;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Frog;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for altering foxes
 *
 * @since 12.0.0
 */
public class FrogMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public FrogMenu(@NotNull Plot plot, @NotNull Frog frog) {
        super(plot, frog);

        ItemStack type = new ItemStack(Material.WHITE_WOOL);
        ItemMeta typeMeta = type.getItemMeta();
        typeMeta.setDisplayName(ChatColor.GREEN + "Change the frog's color");
        type.setItemMeta(typeMeta);

        super.pane.insertItem(new GuiItem(type, event -> {
            new FrogTypeSelectionMenu(frog).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
