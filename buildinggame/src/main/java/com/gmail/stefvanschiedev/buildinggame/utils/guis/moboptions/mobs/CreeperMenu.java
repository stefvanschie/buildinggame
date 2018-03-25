package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        ItemStack powered = new ItemStack(Material.REDSTONE);
        ItemMeta poweredMeta = powered.getItemMeta();
        poweredMeta.setDisplayName(ChatColor.GREEN + "Change whether this creeper is charged");
        powered.setItemMeta(poweredMeta);

        pane.insertItem(new GuiItem(powered, event -> {
            creeper.setPowered(!creeper.isPowered());

            event.setCancelled(true);
        }), 0);
    }
}
