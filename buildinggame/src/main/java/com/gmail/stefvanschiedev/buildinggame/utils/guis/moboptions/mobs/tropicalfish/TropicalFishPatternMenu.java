package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.tropicalfish;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.TropicalFishBucketMeta;

import java.util.Locale;

/**
 * A menu for selecting the pattern of a tropical fish
 *
 * @since 6.0.0
 */
final class TropicalFishPatternMenu extends ChestGui {

    /**
     * Constructs a new tropical fish pattern menu
     *
     * @param tropicalFish the tropical fish to change the pattern of
     */
    TropicalFishPatternMenu(TropicalFish tropicalFish) {
        super(2, ChatColor.GREEN + "Select a pattern");

        var pane = new OutlinePane(0, 0, 9, 2);

        for (var pattern : TropicalFish.Pattern.values()) {
            String name = pattern.toString().replace("_", " ").toLowerCase(Locale.getDefault());

            if (!name.isEmpty()) {
                name = Character.toUpperCase(name.charAt(0)) + name.substring(1);
            }

            var bucket = new ItemStack(Material.TROPICAL_FISH_BUCKET);
            var bucketMeta = (TropicalFishBucketMeta) bucket.getItemMeta();
            bucketMeta.setBodyColor(DyeColor.BLUE);
            bucketMeta.setPatternColor(DyeColor.LIME);
            bucketMeta.setPattern(pattern);
            bucketMeta.setDisplayName(ChatColor.GREEN + name);
            bucket.setItemMeta(bucketMeta);

            pane.addItem(new GuiItem(bucket, event -> {
                tropicalFish.setPattern(pattern);

                event.setCancelled(true);
            }));
        }

        addPane(pane);
    }
}
