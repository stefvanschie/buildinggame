package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.panda;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Panda;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the options of a panda
 *
 * @since 7.0.0
 */
public class PandaMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public PandaMenu(Plot plot, Panda panda) {
        super(plot, panda);

        //personality
        ItemStack personality = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta personalityMeta = personality.getItemMeta();
        personalityMeta.setDisplayName(ChatColor.GREEN + "Change the genes");
        personality.setItemMeta(personalityMeta);

        pane.insertItem(new GuiItem(personality, event -> {
            new PandaGeneMenu(panda).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
