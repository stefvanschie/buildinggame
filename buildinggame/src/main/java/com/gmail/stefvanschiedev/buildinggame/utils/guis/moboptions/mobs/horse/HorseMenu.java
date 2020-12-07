package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.horse;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing the options of a horse
 *
 * @since 5.3.0
 */
public class HorseMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public HorseMenu(Plot plot, Horse horse) {
        super(plot, horse);

        //color
        var color = new ItemStack(Material.ORANGE_CONCRETE_POWDER, 1);
        var colorMeta = color.getItemMeta();
        colorMeta.setDisplayName(ChatColor.GREEN + "Change the color");
        color.setItemMeta(colorMeta);

        pane.insertItem(new GuiItem(color, event -> {
            new HorseColorSelectionMenu(horse).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);

        //style
        var style = new ItemStack(Material.SNOWBALL);
        var styleMeta = style.getItemMeta();
        styleMeta.setDisplayName(ChatColor.GREEN + "Change the style");
        style.setItemMeta(styleMeta);

        pane.insertItem(new GuiItem(style, event -> {
            new HorseStyleSelectionMenu(horse).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 1);
    }
}
