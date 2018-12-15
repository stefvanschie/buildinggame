package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.villagerlike;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for selecting the level of a villager-like.
 *
 * @since 7.0.0
 */
public class LevelSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    public LevelSelectionMenu(@NotNull Creature creature) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Change the level");

        var pane = new OutlinePane(new GuiLocation(2, 0), 5, 1);

        //level 1
        ItemStack level1 = new ItemStack(Material.STONE);
        ItemMeta level1Meta = level1.getItemMeta();
        level1Meta.setDisplayName(ChatColor.GREEN + "Level 1");
        level1.setItemMeta(level1Meta);

        pane.addItem(new GuiItem(level1, event -> {
            //TODO: Change the villager-like's level to 1

            event.setCancelled(true);
        }));

        //level 2
        ItemStack level2 = new ItemStack(Material.IRON_INGOT);
        ItemMeta level2Meta = level2.getItemMeta();
        level2Meta.setDisplayName(ChatColor.GREEN + "Level 2");
        level2.setItemMeta(level2Meta);

        pane.addItem(new GuiItem(level2, event -> {
            //TODO: Change the villager-like's level to 2

            event.setCancelled(true);
        }));

        //level 3
        ItemStack level3 = new ItemStack(Material.GOLD_INGOT);
        ItemMeta level3Meta = level3.getItemMeta();
        level3Meta.setDisplayName(ChatColor.GREEN + "Level 3");
        level3.setItemMeta(level3Meta);

        pane.addItem(new GuiItem(level3, event -> {
            //TODO: Change the villager-like's level to 3

            event.setCancelled(true);
        }));

        //level 4
        ItemStack level4 = new ItemStack(Material.EMERALD);
        ItemMeta level4Meta = level4.getItemMeta();
        level4Meta.setDisplayName(ChatColor.GREEN + "Level 4");
        level4.setItemMeta(level4Meta);

        pane.addItem(new GuiItem(level4, event -> {
            //TODO: Change the villager-like's level to 4

            event.setCancelled(true);
        }));

        //level 5
        ItemStack level5 = new ItemStack(Material.DIAMOND);
        ItemMeta level5Meta = level5.getItemMeta();
        level5Meta.setDisplayName(ChatColor.GREEN + "Level 5");
        level5.setItemMeta(level5Meta);

        pane.addItem(new GuiItem(level5, event -> {
            //TODO: Change the villager-like's level to 5

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
