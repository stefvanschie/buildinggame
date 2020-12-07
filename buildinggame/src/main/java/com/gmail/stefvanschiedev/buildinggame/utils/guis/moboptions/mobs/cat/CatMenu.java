package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.cat;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.color.ColorMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Cat;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the options of a cat
 *
 * @since 7.0.0
 */
public class CatMenu extends ColorMenu {

    /**
     * {@inheritDoc}
     */
    public CatMenu(Plot plot, Cat cat) {
        super(plot, cat);

        //appearance
        ItemStack appearance = new ItemStack(Material.PINK_BANNER);
        ItemMeta appearanceMeta = appearance.getItemMeta();
        appearanceMeta.setDisplayName(ChatColor.GREEN + "Change the cat's appearance");
        appearance.setItemMeta(appearanceMeta);

        pane.insertItem(new GuiItem(appearance, event -> {
            new CatAppearanceMenu(cat).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}
