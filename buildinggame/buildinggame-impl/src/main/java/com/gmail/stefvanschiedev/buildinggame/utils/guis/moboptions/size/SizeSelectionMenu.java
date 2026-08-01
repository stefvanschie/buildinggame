package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.size;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.util.Slot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Phantom;
import org.bukkit.entity.Slime;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A menu for selecting the size of a slime
 *
 * @since 5.3.0
 */
class SizeSelectionMenu extends ChestGui {

    /**
     * The size for a small mob.
     */
    private static final int SMALL_SIZE = 1;

    /**
     * The size for a medium mob.
     */
    private static final int MEDIUM_SIZE = 2;

    /**
     * The size for a large mob.
     */
    private static final int LARGE_SIZE = 4;

    /**
     * The key of the sulfur cube.
     */
    @NotNull
    private static final NamespacedKey SULFUR_CUBE_KEY = NamespacedKey.minecraft("sulfur_cube");

    /**
     * {@inheritDoc}
     */
    SizeSelectionMenu(Mob mob) {
        super(1, ChatColor.GREEN + "Change size");

        var pane = new OutlinePane(6, 1);

        //small
        var goldNugget = new ItemStack(Material.GOLD_NUGGET);
        var goldNuggetMeta = goldNugget.getItemMeta();
        goldNuggetMeta.setDisplayName(ChatColor.GREEN + "Small");
        goldNugget.setItemMeta(goldNuggetMeta);

        pane.addItem(new GuiItem(goldNugget, event -> {
            if (mob instanceof Slime) {
                ((Slime) mob).setSize(SMALL_SIZE);
            } else if (mob instanceof MagmaCube) {
                ((MagmaCube) mob).setSize(SMALL_SIZE);
            } else if (mob instanceof Phantom) {
                ((Phantom) mob).setSize(SMALL_SIZE);
            } else if (mob.getType().getKeyOrThrow().equals(SULFUR_CUBE_KEY)) {
                setSizeSulfurCube(mob, SMALL_SIZE);
            }

            event.setCancelled(true);
        }));

        //medium
        var goldIngot = new ItemStack(Material.GOLD_INGOT);
        var goldIngotMeta = goldIngot.getItemMeta();
        goldIngotMeta.setDisplayName(ChatColor.GREEN + "Medium");
        goldIngot.setItemMeta(goldIngotMeta);

        pane.addItem(new GuiItem(goldIngot, event -> {
            if (mob instanceof Slime) {
                ((Slime) mob).setSize(MEDIUM_SIZE);
            } else if (mob instanceof MagmaCube) {
                ((MagmaCube) mob).setSize(MEDIUM_SIZE);
            } else if (mob instanceof Phantom) {
                ((Phantom) mob).setSize(MEDIUM_SIZE);
            } else if (mob.getType().getKeyOrThrow().equals(SULFUR_CUBE_KEY)) {
                setSizeSulfurCube(mob, MEDIUM_SIZE);
            }

            event.setCancelled(true);
        }));

        //large
        var goldBlock = new ItemStack(Material.GOLD_BLOCK);
        var goldBlockMeta = goldBlock.getItemMeta();
        goldBlockMeta.setDisplayName(ChatColor.GREEN + "Large");
        goldBlock.setItemMeta(goldBlockMeta);

        pane.addItem(new GuiItem(goldBlock, event -> {
            if (mob instanceof Slime) {
                ((Slime) mob).setSize(LARGE_SIZE);
            } else if (mob instanceof MagmaCube) {
                ((MagmaCube) mob).setSize(LARGE_SIZE);
            } else if (mob instanceof Phantom) {
                ((Phantom) mob).setSize(LARGE_SIZE);
            } else if (mob.getType().getKeyOrThrow().equals(SULFUR_CUBE_KEY)) {
                setSizeSulfurCube(mob, LARGE_SIZE);
            }

            event.setCancelled(true);
        }));

        addPane(Slot.fromXY(3, 0), pane);
    }

    // This should be removed when support for versions prior to 26.2 is dropped.

    /**
     * The SulfurCube#setSize method.
     */
    private static Method setSize;

    /**
     * Sets the size for a sulfur cube.
     *
     * @param mob the mob to set the size for
     * @param size the size
     * @since 14.2.0
     */
    private void setSizeSulfurCube(@NotNull Mob mob, int size) {
        if (setSize == null) {
            try {
                setSize = mob.getClass().getMethod("setSize", int.class);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            setSize.invoke(mob, size);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
