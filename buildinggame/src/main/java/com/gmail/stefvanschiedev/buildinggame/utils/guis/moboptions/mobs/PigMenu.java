package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs;

import com.github.stefvanschie.inventoryframework.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Pig;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the options of a pig
 *
 * @since 5.3.0
 */
public class PigMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public PigMenu(Plot plot, Pig pig) {
        super(plot, pig);

        //saddle
        ItemStack saddle = new ItemStack(Material.SADDLE);
        ItemMeta saddleMeta = saddle.getItemMeta();
        saddleMeta.setDisplayName(ChatColor.GREEN + "Change whether this pig has a saddle");
        saddle.setItemMeta(saddleMeta);

        pane.insertItem(new GuiItem(saddle, event -> {
            pig.setSaddle(!pig.hasSaddle());

            event.setCancelled(true);
        }), 0);
    }
}
