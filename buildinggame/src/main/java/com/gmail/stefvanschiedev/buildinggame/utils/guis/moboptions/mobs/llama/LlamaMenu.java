package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.llama;

import com.github.stefvanschie.inventoryframework.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.ChestMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Llama;
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
        ItemStack color = new ItemStack(Material.ORANGE_CONCRETE_POWDER);
        ItemMeta colorMeta = color.getItemMeta();
        colorMeta.setDisplayName(ChatColor.GREEN + "Change the color");
        color.setItemMeta(colorMeta);

        pane.insertItem(new GuiItem(color, event -> {
            new LlamaColorSelectionMenu(llama).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);
    }
}