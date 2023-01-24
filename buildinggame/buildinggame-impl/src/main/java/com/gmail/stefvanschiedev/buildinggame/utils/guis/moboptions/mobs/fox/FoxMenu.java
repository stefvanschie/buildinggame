package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.fox;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.BabyMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Fox;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for altering foxes
 *
 * @since 7.0.0
 */
public class FoxMenu extends BabyMenu {

    /**
     * {@inheritDoc}
     */
    public FoxMenu(@NotNull Plot plot, @NotNull Fox fox) {
        super(plot, fox);

        ItemStack type = new ItemStack(Material.ORANGE_CONCRETE_POWDER);
        ItemMeta typeMeta = type.getItemMeta();
        typeMeta.setDisplayName(ChatColor.GREEN + "Change the fox's type");
        type.setItemMeta(typeMeta);

        pane.insertItem(new GuiItem(type, event -> {
            new FoxTypeSelectionMenu(fox).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);

        ItemStack sleeping = new ItemStack(Material.LIGHT_BLUE_BED);
        ItemMeta sleepingMeta = sleeping.getItemMeta();
        sleepingMeta.setDisplayName(ChatColor.GREEN + "Set the fox to be sleeping or be awake");
        sleeping.setItemMeta(sleepingMeta);

        pane.insertItem(new GuiItem(sleeping, event -> {
            fox.setSleeping(!fox.isSleeping());

            event.setCancelled(true);
        }), 1);

        ItemStack sitting = new ItemStack(Material.OAK_STAIRS);
        ItemMeta sittingMeta = sitting.getItemMeta();
        sittingMeta.setDisplayName(ChatColor.GREEN + "Make the fox sit or stand up");
        sitting.setItemMeta(sittingMeta);

        pane.insertItem(new GuiItem(sitting, event -> {
            fox.setSitting(!fox.isSitting());

            event.setCancelled(true);
        }), 2);

        ItemStack crouching = new ItemStack(Material.SOUL_SAND);
        ItemMeta crouchingMeta = crouching.getItemMeta();
        crouchingMeta.setDisplayName(ChatColor.GREEN + "Make the fox crouch or stand");
        crouching.setItemMeta(crouchingMeta);

        pane.insertItem(new GuiItem(crouching, event -> {
            fox.setCrouching(!fox.isCrouching());

            event.setCancelled(true);
        }), 3);
    }
}
