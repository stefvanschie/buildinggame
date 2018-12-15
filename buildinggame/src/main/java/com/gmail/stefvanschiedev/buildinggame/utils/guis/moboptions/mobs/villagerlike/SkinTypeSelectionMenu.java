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
 * A menu for selecting the skin type of villager-like creatures.
 *
 * @since 7.0.0
 */
public class SkinTypeSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    public SkinTypeSelectionMenu(@NotNull Creature creature) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Select skin type");

        var pane = new OutlinePane(new GuiLocation(1, 0), 7, 1);

        //plains
        ItemStack plains = new ItemStack(Material.GRASS);
        ItemMeta plainsMeta = plains.getItemMeta();
        plainsMeta.setDisplayName(ChatColor.GREEN + "Plains");
        plains.setItemMeta(plainsMeta);

        pane.addItem(new GuiItem(plains, event -> {
            //TODO: Change the villager-like's skin type to plains

            event.setCancelled(true);
        }));

        //desert
        ItemStack desert = new ItemStack(Material.SAND);
        ItemMeta desertMeta = desert.getItemMeta();
        desertMeta.setDisplayName(ChatColor.GREEN + "Desert");
        desert.setItemMeta(desertMeta);

        pane.addItem(new GuiItem(desert, event -> {
            //TODO: Change the villager-like's skin type to desert

            event.setCancelled(true);
        }));

        //savanna
        ItemStack savanna = new ItemStack(Material.ACACIA_LOG);
        ItemMeta savannaMeta = savanna.getItemMeta();
        savannaMeta.setDisplayName(ChatColor.GREEN + "Savanna");
        savanna.setItemMeta(savannaMeta);

        pane.addItem(new GuiItem(savanna, event -> {
            //TODO: Change the villager-like's skin type to savanna

            event.setCancelled(true);
        }));

        //taiga
        ItemStack taiga = new ItemStack(Material.SPRUCE_LOG);
        ItemMeta taigaMeta = taiga.getItemMeta();
        taigaMeta.setDisplayName(ChatColor.GREEN + "Taiga");
        taiga.setItemMeta(taigaMeta);

        pane.addItem(new GuiItem(taiga, event -> {
            //TODO: Change the villager-like's skin type to taiga

            event.setCancelled(true);
        }));

        //snowy tundra
        ItemStack snowyTundra = new ItemStack(Material.ICE);
        ItemMeta snowyTundraMeta = snowyTundra.getItemMeta();
        snowyTundraMeta.setDisplayName(ChatColor.GREEN + "Snowy Tundra");
        snowyTundra.setItemMeta(snowyTundraMeta);

        pane.addItem(new GuiItem(snowyTundra, event -> {
            //TODO: Change the villager-like's skin type to snowy tundra

            event.setCancelled(true);
        }));

        //jungle
        ItemStack jungle = new ItemStack(Material.VINE);
        ItemMeta jungleMeta = jungle.getItemMeta();
        jungleMeta.setDisplayName(ChatColor.GREEN + "Jungle");
        jungle.setItemMeta(jungleMeta);

        pane.addItem(new GuiItem(jungle, event -> {
            //TODO: Change the villager-like's skin type to jungle

            event.setCancelled(true);
        }));

        //swamp
        ItemStack swamp = new ItemStack(Material.LILY_PAD);
        ItemMeta swampMeta = swamp.getItemMeta();
        swampMeta.setDisplayName(ChatColor.GREEN + "Swamp");
        swamp.setItemMeta(swampMeta);

        pane.addItem(new GuiItem(swamp, event -> {
            //TODO: Change the villager-like's skin type to swamp

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
