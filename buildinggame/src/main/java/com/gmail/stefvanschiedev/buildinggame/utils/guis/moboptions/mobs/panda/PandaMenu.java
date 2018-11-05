package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.panda;

import com.github.stefvanschie.inventoryframework.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
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
    //TODO: Change Entity to Panda
    public PandaMenu(Plot plot, Entity panda) {
        super(plot, panda);

        //personality
        ItemStack personality = new ItemStack(Material.PLAYER_HEAD);
        ItemMeta personalityMeta = personality.getItemMeta();
        personalityMeta.setDisplayName(ChatColor.GREEN + "Change the personality");
        personality.setItemMeta(personalityMeta);

        pane.insertItem(new GuiItem(personality, event -> {
            new PandaPersonalityMenu(panda).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);

        //color
        ItemStack color = new ItemStack(Material.BROWN_WOOL);
        ItemMeta colorMeta = color.getItemMeta();
        colorMeta.setDisplayName(ChatColor.GREEN + "Change the color");
        color.setItemMeta(colorMeta);

        pane.insertItem(new GuiItem(color, event -> {
            new PandaColorSelectionMenu(panda).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 1);
    }
}
