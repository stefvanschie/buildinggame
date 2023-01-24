package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.parrot;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Parrot;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing the options of a parrot
 *
 * @since 5.3.0
 */
public class ParrotMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public ParrotMenu(Plot plot, Parrot parrot) {
        super(plot, parrot);

        //type
        var type = new ItemStack(Material.BONE);
        var typeMeta = type.getItemMeta();
        typeMeta.setDisplayName(ChatColor.GREEN + "Change type");
        type.setItemMeta(typeMeta);

        pane.insertItem(new GuiItem(type, event -> {
            new ParrotTypeMenu(parrot).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
