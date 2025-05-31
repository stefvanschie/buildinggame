package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.cow;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Cow;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * A menu for changing a cow's variant.
 *
 * @since 12.10.0
 */
public class CowVariantMenu extends ChestGui {

    /**
     * Creates a menu for changing the variant of the specified cow.
     *
     * @param cow the cow to change the variant of
     * @since 12.10.0
     */
    CowVariantMenu(@NotNull Cow cow) {
        super(1, ChatColor.GREEN + "Change the cow's variant");

        setOnGlobalClick(event -> event.setCancelled(true));

        var pane = new OutlinePane(0, 0, 9, 1);
        pane.align(OutlinePane.Alignment.CENTER);
        pane.setGap(1);

        //temperate
        ItemStack temperate = new ItemStack(Material.BLACK_DYE);
        ItemMeta temperateMeta = temperate.getItemMeta();
        Objects.requireNonNull(temperateMeta).setDisplayName(ChatColor.GREEN + "Temperate");
        temperate.setItemMeta(temperateMeta);

        pane.addItem(new GuiItem(temperate, event -> setVariant(cow, Cow.Variant.TEMPERATE)));

        //cold
        ItemStack cold = new ItemStack(Material.BROWN_DYE);
        ItemMeta coldMeta = cold.getItemMeta();
        Objects.requireNonNull(coldMeta).setDisplayName(ChatColor.GREEN + "Cold");
        cold.setItemMeta(coldMeta);

        pane.addItem(new GuiItem(cold, event -> setVariant(cow, Cow.Variant.COLD)));

        //warm
        ItemStack warm = new ItemStack(Material.RED_DYE);
        ItemMeta warmMeta = warm.getItemMeta();
        Objects.requireNonNull(warmMeta).setDisplayName(ChatColor.GREEN + "Warm");
        warm.setItemMeta(warmMeta);

        pane.addItem(new GuiItem(warm, event -> setVariant(cow, Cow.Variant.WARM)));

        addPane(pane);
    }

    private static Method setVariant;

    /*
    Commodore remaps Cow to AbstractCow if plugin-version is before 1.21.5. This causes the normal Cow#setVariant to be
    remapped to AbstractCow#setVariant, which doesn't exist. This method allows you to set the variant without Commodore
    intervening. This should be removed when no version before 1.21.5 is supported anymore.
     */
    private void setVariant(@NotNull Cow cow, @NotNull Cow.Variant variant) {
        if (setVariant == null) {
            try {
                Class<?> cowClass = Class.forName("org.bukkit.entity.Cow");
                Class<?> variantClass = Class.forName("org.bukkit.entity.Cow$Variant");

                setVariant = cowClass.getMethod("setVariant", variantClass);
            } catch (NoSuchMethodException | ClassNotFoundException exception) {
                throw new RuntimeException(exception);
            }
        }

        try {
            setVariant.invoke(cow, variant);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
