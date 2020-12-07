package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.horse;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Horse;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for changing the color of a horse
 *
 * @since 5.3.0
 */
class HorseColorSelectionMenu extends ChestGui {

    /**
     * {@inheritDoc}
     */
    HorseColorSelectionMenu(Horse horse) {
        super(1, ChatColor.GREEN + "Change the horse color");

        var pane = new OutlinePane(1, 0, 8, 1);

        //black
        var black = new ItemStack(Material.BLACK_WOOL);
        var blackMeta = black.getItemMeta();
        blackMeta.setDisplayName(ChatColor.GREEN + "Black");
        black.setItemMeta(blackMeta);

        pane.addItem(new GuiItem(black, event -> {
            horse.setColor(Horse.Color.BLACK);

            event.setCancelled(true);
        }));

        //brown
        var brown = new ItemStack(Material.BROWN_WOOL);
        var brownMeta = brown.getItemMeta();
        brownMeta.setDisplayName(ChatColor.GREEN + "Brown");
        brown.setItemMeta(brownMeta);

        pane.addItem(new GuiItem(brown, event -> {
            horse.setColor(Horse.Color.BROWN);

            event.setCancelled(true);
        }));

        //chestnut
        var chestnut = new ItemStack(Material.RED_NETHER_BRICKS);
        var chestnutMeta = chestnut.getItemMeta();
        chestnutMeta.setDisplayName(ChatColor.GREEN + "Chestnut");
        chestnut.setItemMeta(chestnutMeta);

        pane.addItem(new GuiItem(chestnut, event -> {
            horse.setColor(Horse.Color.CHESTNUT);

            event.setCancelled(true);
        }));

        //creamy
        var creamy = new ItemStack(Material.SANDSTONE);
        var creamyMeta = creamy.getItemMeta();
        creamyMeta.setDisplayName(ChatColor.GREEN + "Creamy");
        creamy.setItemMeta(creamyMeta);

        pane.addItem(new GuiItem(creamy, event -> {
            horse.setColor(Horse.Color.CREAMY);

            event.setCancelled(true);
        }));

        //dark brown
        var darkBrown = new ItemStack(Material.NETHER_BRICK);
        var darkBrownMeta = darkBrown.getItemMeta();
        darkBrownMeta.setDisplayName(ChatColor.GREEN + "Dark brown");
        darkBrown.setItemMeta(darkBrownMeta);

        pane.addItem(new GuiItem(darkBrown, event -> {
            horse.setColor(Horse.Color.DARK_BROWN);

            event.setCancelled(true);
        }));

        //gray
        var gray = new ItemStack(Material.GRAY_WOOL);
        var grayMeta = gray.getItemMeta();
        grayMeta.setDisplayName(ChatColor.GREEN + "Gray");
        gray.setItemMeta(grayMeta);

        pane.addItem(new GuiItem(gray, event -> {
            horse.setColor(Horse.Color.GRAY);

            event.setCancelled(true);
        }));

        //white
        var white = new ItemStack(Material.WHITE_WOOL);
        var whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.GREEN + "White");
        white.setItemMeta(whiteMeta);

        pane.addItem(new GuiItem(white, event -> {
            horse.setColor(Horse.Color.WHITE);

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
