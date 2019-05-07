package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.llama;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Llama;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

/**
 * A menu for changing the color of a llama
 *
 * @since 5.3.0
 */
class LlamaColorSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    LlamaColorSelectionMenu(Llama llama) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Change the llama color");

        var pane = new StaticPane(2, 0, 5, 1);

        //brown
        var brown = new Wool(DyeColor.BROWN).toItemStack(1);
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
        var gray = new Wool(DyeColor.GRAY).toItemStack(1);
        var grayMeta = gray.getItemMeta();
        grayMeta.setDisplayName(ChatColor.GREEN + "Gray");
        gray.setItemMeta(grayMeta);

        pane.addItem(new GuiItem(gray, event -> {
            llama.setColor(Llama.Color.GRAY);

            event.setCancelled(true);
        }), 3, 0);

        //white
        var white = new Wool(DyeColor.WHITE).toItemStack(1);
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
