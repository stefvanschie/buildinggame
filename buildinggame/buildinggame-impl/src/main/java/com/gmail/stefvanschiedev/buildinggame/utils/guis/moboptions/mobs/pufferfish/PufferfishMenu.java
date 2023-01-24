package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.pufferfish;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.PufferFish;
import org.bukkit.inventory.ItemStack;

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
        var inflation = new ItemStack(Material.BONE);
        var inflationMeta = inflation.getItemMeta();
        inflationMeta.setDisplayName(ChatColor.GREEN + "Set inflation state");
        inflation.setItemMeta(inflationMeta);

        pane.insertItem(new GuiItem(inflation, event -> {
            new PufferfishInflationStateMenu(pufferfish).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
