package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.rabbit;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Rabbit;
import org.bukkit.inventory.ItemStack;

/**
 * Represents the menu used for a rabbit
 */
public class RabbitMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public RabbitMenu(Plot plot, Rabbit rabbit) {
        super(plot, rabbit);

        //type
        var type = new ItemStack(Material.BONE);
        var typeMeta = type.getItemMeta();
        typeMeta.setDisplayName(ChatColor.GREEN + "Change type");
        type.setItemMeta(typeMeta);

        pane.insertItem(new GuiItem(type, event -> {
            new RabbitTypeMenu(rabbit).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}