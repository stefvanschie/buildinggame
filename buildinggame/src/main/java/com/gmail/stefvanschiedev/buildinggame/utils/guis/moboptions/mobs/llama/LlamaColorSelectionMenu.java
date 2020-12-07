package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.llama;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Llama;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing the color of a llama
 *
 * @since 5.3.0
 */
class LlamaColorSelectionMenu extends ChestGui {

    /**
     * {@inheritDoc}
     */
    LlamaColorSelectionMenu(Llama llama) {
        super(1, ChatColor.GREEN + "Change the llama color");

        var pane = new StaticPane(2, 0, 5, 1);

        //brown
        var brown = new ItemStack(Material.BROWN_WOOL);
        var brownMeta = brown.getItemMeta();
        brownMeta.setDisplayName(ChatColor.GREEN + "Brown");
        brown.setItemMeta(brownMeta);

        pane.addItem(new GuiItem(brown, event -> {
            llama.setColor(Llama.Color.BROWN);

            event.setCancelled(true);
        }), 0, 0);

        //creamy
        var creamy = new ItemStack(Material.SANDSTONE);
        var creamyMeta = creamy.getItemMeta();
        creamyMeta.setDisplayName(ChatColor.GREEN + "Creamy");
        creamy.setItemMeta(creamyMeta);

        pane.addItem(new GuiItem(creamy, event -> {
            llama.setColor(Llama.Color.CREAMY);

            event.setCancelled(true);
        }), 1, 0);

        //gray
        var gray = new ItemStack(Material.GRAY_WOOL);
        var grayMeta = gray.getItemMeta();
        grayMeta.setDisplayName(ChatColor.GREEN + "Gray");
        gray.setItemMeta(grayMeta);

        pane.addItem(new GuiItem(gray, event -> {
            llama.setColor(Llama.Color.GRAY);

            event.setCancelled(true);
        }), 3, 0);

        //white
        var white = new ItemStack(Material.WHITE_WOOL);
        var whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.GREEN + "White");
        white.setItemMeta(whiteMeta);

        pane.addItem(new GuiItem(white, event -> {
            llama.setColor(Llama.Color.WHITE);

            event.setCancelled(true);
        }), 4, 0);

        addPane(pane);
    }
}
