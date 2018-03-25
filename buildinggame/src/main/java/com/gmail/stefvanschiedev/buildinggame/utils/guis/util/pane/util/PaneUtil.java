package com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.util;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiLocation;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * Utility class for panes
 *
 * @since 5.6.0
 */
public final class PaneUtil {

    /**
     * Private constructor since this class is a utility class and should never be instantiated
     *
     * @since 5.6.0
     */
    private PaneUtil() {}

    /**
     * Display the items in a linear fashion (that is to say from left to right, top to bottom).
     *
     * @param inventory the inventory to put the items in
     * @param items the items to put into the inventory
     * @param start the starting location of the pane
     * @param length the length of the pane
     * @param height the height of the pane
     * @since 5.6.0
     */
    public static void linearDisplay(@NotNull Inventory inventory, @NotNull GuiItem[] items, @NotNull GuiLocation start,
                                     int length, int height) {
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < height; y++) {
                if (items[y * length + x] == null || !items[y * length + x].isVisible())
                    continue;

                ItemStack item = items[y * length + x].getItem();

                if (item.getType() == Material.AIR)
                    continue;

                inventory.setItem((start.getY() + y) * 9 + (start.getX() + x), item);
            }
        }
    }

    /**
     * Detects a click on one of the items in the item array when the items are displayed according to
     * {@link #linearDisplay(Inventory, GuiItem[], GuiLocation, int, int)}
     *
     * @param event the click event
     * @param items the items
     * @param start the starting position of the pane
     * @param length the length of the pane
     * @return whether the click on the item was correct
     * @since 5.6.0
     */
    public static boolean linearClick(@NotNull InventoryClickEvent event, @NotNull GuiItem[] items,
                                      @NotNull GuiLocation start, int length) {
        int slot = event.getSlot();

        //correct coordinates
        int x = (slot % 9) - start.getX();
        int y = (slot / 9) - start.getY();

        if (y * length + x < 0 || y * length + x >= items.length || items[y * length + x] == null)
            return false;

        if (items[y * length + x].getItem().equals(event.getCurrentItem())) {
            Consumer<InventoryClickEvent> action = items[y * length + x].getAction();

            if (action != null)
                action.accept(event);

            return true;
        }

        return false;
    }
}