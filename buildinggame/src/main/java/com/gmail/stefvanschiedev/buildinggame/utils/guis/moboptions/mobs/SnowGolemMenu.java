package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Snowman;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing the options of a snow golem
 *
 * @since 5.3.0
 */
public class SnowGolemMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public SnowGolemMenu(Plot plot, Snowman snowman) {
        super(plot, snowman);

        var pumpkin = new ItemStack(Material.PUMPKIN);
        var pumpkinMeta = pumpkin.getItemMeta();
        pumpkinMeta.setDisplayName(ChatColor.GREEN + "Change whether this snow golem has a pumpkin");
        pumpkin.setItemMeta(pumpkinMeta);

        pane.insertItem(new GuiItem(pumpkin, event -> {
            snowman.setDerp(!snowman.isDerp());

            event.setCancelled(true);
        }), 0);
    }
}
