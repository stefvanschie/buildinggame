package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.tropicalfish;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.utils.MappedMaterialUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for selecting the pattern color of a tropical fish
 *
 * @since 6.0.0
 */
class TropicalFishPatternColorMenu extends ChestGui {

    /**
     * Constructs a new tropical fish pattern color menu
     *
     * @param tropicalFish the tropical fish to change the pattern color of
     */
    TropicalFishPatternColorMenu(TropicalFish tropicalFish) {
        super(2, ChatColor.GREEN + "Select a color");

        var pane = new OutlinePane(0, 0, 9, 2);

        MappedMaterialUtil.WOOL_DYE_COLOR_ITEMS.forEach(entry ->
            pane.addItem(new GuiItem(new ItemStack(entry.getKey()), event -> {
                tropicalFish.setPatternColor(entry.getValue());

                event.setCancelled(true);
            }))
        );

        addPane(pane);
    }
}
