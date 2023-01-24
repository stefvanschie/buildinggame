package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.tropicalfish;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.RemoveMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.TropicalFish;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

/**
 * Represents the menu used for a tropical fish
 *
 * @since 6.0.0
 */
public class TropicalFishMenu extends RemoveMenu {

    /**
     * {@inheritDoc}
     */
    public TropicalFishMenu(Plot plot, TropicalFish tropicalFish) {
        super(plot, tropicalFish);

        //body color
        var bodyColor = new ItemStack(Material.RED_WOOL);
        var bodyColorMeta = bodyColor.getItemMeta();
        bodyColorMeta.setDisplayName(ChatColor.GREEN + "Set the body color");
        bodyColor.setItemMeta(bodyColorMeta);

        pane.insertItem(new GuiItem(bodyColor, event -> {
            new TropicalFishBodyColorMenu(tropicalFish).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 0);

        //pattern
        var pattern = new ItemStack(Material.WHITE_BANNER);
        var patternMeta = (BannerMeta) pattern.getItemMeta();
        patternMeta.addPattern(new Pattern(DyeColor.RED, PatternType.SQUARE_TOP_LEFT));
        patternMeta.setDisplayName(ChatColor.GREEN + "Set the pattern");
        pattern.setItemMeta(patternMeta);

        pane.insertItem(new GuiItem(pattern, event -> {
            new TropicalFishPatternMenu(tropicalFish).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 1);

        //pattern color
        var patternColor = new ItemStack(Material.LIGHT_GRAY_DYE);
        var patternColorMeta = patternColor.getItemMeta();
        patternColorMeta.setDisplayName(ChatColor.GREEN + "Set the pattern color");
        patternColor.setItemMeta(patternColorMeta);

        pane.insertItem(new GuiItem(patternColor, event -> {
            new TropicalFishPatternColorMenu(tropicalFish).show(event.getWhoClicked());

            event.setCancelled(true);
        }), 2);
    }
}
