package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.tropicalfish;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.MappedMaterialUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for selecting the body color of a tropical fish
 *
 * @since 6.0.0
 */
class TropicalFishBodyColorMenu extends Gui {

    /**
     * Constructs a new tropical fish body color menu
     *
     * @param tropicalFish the tropical fish to change the color of
     */
    TropicalFishBodyColorMenu(TropicalFish tropicalFish) {
        super(Main.getInstance(), 2, ChatColor.GREEN + "Select a color");

        var pane = new OutlinePane(0, 0, 9, 2);

        MappedMaterialUtil.WOOL_DYE_COLOR_ITEMS.forEach(entry ->
            pane.addItem(new GuiItem(new ItemStack(entry.getKey()), event -> {
                tropicalFish.setBodyColor(entry.getValue());

                event.setCancelled(true);
            }))
        );

        addPane(pane);
    }
}
