package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing the options of a creeper
 *
 * @since 5.3.0
 */
public class CreeperMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public CreeperMenu(Plot plot, Creeper creeper) {
        super(plot, creeper);

        //powered
        var powered = new ItemStack(Material.REDSTONE);
        var poweredMeta = powered.getItemMeta();
        poweredMeta.setDisplayName(ChatColor.GREEN + "Change whether this creeper is charged");
        powered.setItemMeta(poweredMeta);

        pane.insertItem(new GuiItem(powered, event -> {
            creeper.setPowered(!creeper.isPowered());

            event.setCancelled(true);
        }), 0);
    }
}
