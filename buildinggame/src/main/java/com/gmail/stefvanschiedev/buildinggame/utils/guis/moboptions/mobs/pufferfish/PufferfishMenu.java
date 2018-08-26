package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.pufferfish;

import com.github.stefvanschie.inventoryframework.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.PufferFish;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Represents the menu used for a pufferfish
 *
 * @since 6.0.0
 */
public class PufferfishMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public PufferfishMenu(Plot plot, PufferFish pufferfish) {
        super(plot, pufferfish);

        //inflation state
        ItemStack inflation = new ItemStack(Material.BONE);
        ItemMeta inflationMeta = inflation.getItemMeta();
        inflationMeta.setDisplayName(ChatColor.GREEN + "Set inflation state");
        inflation.setItemMeta(inflationMeta);

        pane.insertItem(new GuiItem(inflation, event -> {
            new PufferfishInflationStateMenu(pufferfish).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
