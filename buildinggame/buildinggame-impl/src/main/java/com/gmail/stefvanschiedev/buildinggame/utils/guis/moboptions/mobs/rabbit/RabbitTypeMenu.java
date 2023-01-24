package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.rabbit;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Rabbit;
import org.bukkit.inventory.ItemStack;

/**
 * A selection menu for the type of rabbit
 */
class RabbitTypeMenu extends ChestGui {

    /**
     * Constructs a new rabbit type menu
     */
    RabbitTypeMenu(Rabbit rabbit) {
        super(1, ChatColor.GREEN + "Set rabbit type");

        var pane = new OutlinePane(1, 0, 8, 1);

        //black type
        var black = new ItemStack(Material.BLACK_WOOL, 1);
        var blackMeta = black.getItemMeta();
        blackMeta.setDisplayName(ChatColor.GREEN + "Black");
        black.setItemMeta(blackMeta);

        pane.addItem(new GuiItem(black, event -> {
            rabbit.setRabbitType(Rabbit.Type.BLACK);

            event.setCancelled(true);
        }));

        //black and white type
        var blackAndWhite = new ItemStack(Material.MUSIC_DISC_STRAD);
        var blackAndWhiteMeta = blackAndWhite.getItemMeta();
        blackAndWhiteMeta.setDisplayName(ChatColor.GREEN + "Black and white");
        blackAndWhite.setItemMeta(blackAndWhiteMeta);

        pane.addItem(new GuiItem(blackAndWhite, event -> {
            rabbit.setRabbitType(Rabbit.Type.BLACK_AND_WHITE);

            event.setCancelled(true);
        }));

        //brown type
        var brown = new ItemStack(Material.BROWN_WOOL, 1);
        var brownMeta = brown.getItemMeta();
        brownMeta.setDisplayName(ChatColor.GREEN + "Brown");
        brown.setItemMeta(brownMeta);

        pane.addItem(new GuiItem(brown, event -> {
            rabbit.setRabbitType(Rabbit.Type.BROWN);

            event.setCancelled(true);
        }));

        //gold type
        var gold = new ItemStack(Material.GOLD_INGOT);
        var goldMeta = gold.getItemMeta();
        goldMeta.setDisplayName(ChatColor.GREEN + "Gold");
        gold.setItemMeta(goldMeta);

        pane.addItem(new GuiItem(gold, event -> {
            rabbit.setRabbitType(Rabbit.Type.GOLD);

            event.setCancelled(true);
        }));

        //salt and pepper type
        var saltAndPepper = new ItemStack(Material.COOKIE);
        var saltAndPepperMeta = saltAndPepper.getItemMeta();
        saltAndPepperMeta.setDisplayName(ChatColor.GREEN + "Salt and pepper");
        saltAndPepper.setItemMeta(saltAndPepperMeta);

        pane.addItem(new GuiItem(saltAndPepper, event -> {
            rabbit.setRabbitType(Rabbit.Type.SALT_AND_PEPPER);

            event.setCancelled(true);
        }));

        //the killer bunny type
        var theKillerBunny = new ItemStack(Material.IRON_SWORD);
        var theKillerBunnyMeta = theKillerBunny.getItemMeta();
        theKillerBunnyMeta.setDisplayName(ChatColor.GREEN + "The killer bunny");
        theKillerBunny.setItemMeta(theKillerBunnyMeta);

        pane.addItem(new GuiItem(theKillerBunny, event -> {
            rabbit.setRabbitType(Rabbit.Type.THE_KILLER_BUNNY);

            event.setCancelled(true);
        }));

        //white type
        var white = new ItemStack(Material.BONE);
        var whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.GREEN + "White");
        white.setItemMeta(whiteMeta);

        pane.addItem(new GuiItem(white, event -> {
            rabbit.setRabbitType(Rabbit.Type.WHITE);

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}