package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.llama;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.ChestMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Llama;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for changing the options of a llama
 *
 * @since 5.3.0
 */
public class LlamaMenu extends ChestMenu {

    /**
     * {@inheritDoc}
     */
    public LlamaMenu(Plot plot, Llama llama) {
        super(plot, llama);

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

                new LlamaColorSelectionMenu(llama).open((Player) ((InventoryInteractEvent) event).getWhoClicked());

                return true;
            }
        }, 0);
    }
}