package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions;

import com.github.stefvanschie.inventoryframework.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.ChestedHorse;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing whether a chested horse has a chest
 *
 * @since 5.3.0
 */
public class ChestMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public ChestMenu(Plot plot, ChestedHorse chestedHorse) {
        super(plot, chestedHorse);

        //chest
        ItemStack chest = new ItemStack(Material.CHEST);
        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.setDisplayName(ChatColor.GREEN + "Set/Remove chest");
        chest.setItemMeta(chestMeta);

        pane.insertItem(new GuiItem(chest, event -> {
            chestedHorse.setCarryingChest(!chestedHorse.isCarryingChest());

            event.setCancelled(true);
        }), 0);
    }
}
