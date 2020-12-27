package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.axolotl;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for changing an axolotl's variant.
 *
 * @since 10.0.0
 */
class AxolotlVariantMenu extends ChestGui {

    /**
     * Create a menu to change the specified axolotl's variant.
     *
     * @param axolotl the axolotl to change
     * @since 10.0.0
     */
    //TODO: change parameter type to axolotl
    AxolotlVariantMenu(@NotNull Entity axolotl) {
        super(1, ChatColor.GREEN + "Axolotl variant");

        var pane = new OutlinePane(2, 0, 5, 1);

        //leucistic
        var leucistic = new ItemStack(Material.PINK_WOOL);
        ItemMeta leucisticMeta = leucistic.getItemMeta();
        leucisticMeta.setDisplayName(ChatColor.GREEN + "Leucistic");
        leucistic.setItemMeta(leucisticMeta);

        pane.addItem(new GuiItem(leucistic, event -> {
            //TODO: change axolotl variant to leucistic

            event.setCancelled(true);
        }));

        //wild
        var wild = new ItemStack(Material.BROWN_WOOL);
        ItemMeta wildMeta = wild.getItemMeta();
        wildMeta.setDisplayName(ChatColor.GREEN + "Wild");
        wild.setItemMeta(wildMeta);

        pane.addItem(new GuiItem(wild, event -> {
            //TODO: change axolotl variant to wild

            event.setCancelled(true);
        }));

        //gold
        var gold = new ItemStack(Material.YELLOW_WOOL);
        ItemMeta goldMeta = gold.getItemMeta();
        goldMeta.setDisplayName(ChatColor.GREEN + "Gold");
        gold.setItemMeta(goldMeta);

        pane.addItem(new GuiItem(gold, event -> {
            //TODO: change axolotl variant to gold

            event.setCancelled(true);
        }));

        //cyan
        var cyan = new ItemStack(Material.CYAN_WOOL);
        ItemMeta cyanMeta = cyan.getItemMeta();
        cyanMeta.setDisplayName(ChatColor.GREEN + "Cyan");
        cyan.setItemMeta(cyanMeta);

        pane.addItem(new GuiItem(cyan, event -> {
            //TODO: change axolotl variant to cyan

            event.setCancelled(true);
        }));

        //blue
        var blue = new ItemStack(Material.BLUE_WOOL);
        ItemMeta blueMeta = blue.getItemMeta();
        blueMeta.setDisplayName(ChatColor.GREEN + "Blue");
        blue.setItemMeta(blueMeta);

        pane.addItem(new GuiItem(blue, event -> {
            //TODO: change axolotl variant to blue

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
