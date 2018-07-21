package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.profession;

import com.github.stefvanschie.inventoryframework.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the profession of a creature
 *
 * @since 5.3.0
 */
public class ProfessionMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public ProfessionMenu(Plot plot, Creature creature) {
        super(plot, creature);

        //profession
        ItemStack profession = new ItemStack(Material.EMERALD);
        ItemMeta professionMeta = profession.getItemMeta();
        professionMeta.setDisplayName(ChatColor.GREEN + "Change the profession");
        profession.setItemMeta(professionMeta);

        pane.insertItem(new GuiItem(profession, event -> {
            new ProfessionSelectionMenu(creature).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
