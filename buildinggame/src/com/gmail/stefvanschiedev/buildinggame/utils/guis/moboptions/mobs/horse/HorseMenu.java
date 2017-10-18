package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.horse;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

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
        ItemStack color = new ItemStack(Material.CONCRETE_POWDER, 1, (short) 1);
        ItemMeta colorMeta = color.getItemMeta();
        colorMeta.setDisplayName(ChatColor.GREEN + "Change the color");
        color.setItemMeta(colorMeta);

        insertItem(color, new GuiAction() {
            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                new HorseColorSelectionMenu(horse).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        }, 0);

        //style
        ItemStack style = new ItemStack(Material.SNOW_BALL);
        ItemMeta styleMeta = style.getItemMeta();
        styleMeta.setDisplayName(ChatColor.GREEN + "Change the style");
        style.setItemMeta(styleMeta);

        insertItem(style, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                new HorseStyleSelectionMenu(horse).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        }, 1);
    }
}
