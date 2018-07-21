package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.rabbit;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Rabbit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A selection menu for the type of rabbit
 */
class RabbitTypeMenu extends Gui {

    /**
     * Constructs a new rabbit type menu
     */
    RabbitTypeMenu(Rabbit rabbit) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Set rabbit type");

        OutlinePane pane = new OutlinePane(new GuiLocation(1, 0), 8, 1);

        //black type
        ItemStack black = new ItemStack(Material.WOOL, 1, (short) 15);
        ItemMeta blackMeta = black.getItemMeta();
        blackMeta.setDisplayName(ChatColor.GREEN + "Black");
        black.setItemMeta(blackMeta);

        pane.addItem(new GuiItem(black, event -> {
            rabbit.setRabbitType(Rabbit.Type.BLACK);

            event.setCancelled(true);
        }));

        //black and white type
        ItemStack blackAndWhite = new ItemStack(Material.RECORD_9);
        ItemMeta blackAndWhiteMeta = blackAndWhite.getItemMeta();
        blackAndWhiteMeta.setDisplayName(ChatColor.GREEN + "Black and white");
        blackAndWhite.setItemMeta(blackAndWhiteMeta);

        pane.addItem(new GuiItem(blackAndWhite, event -> {
            rabbit.setRabbitType(Rabbit.Type.BLACK_AND_WHITE);

            event.setCancelled(true);
        }));

        //brown type
        ItemStack brown = new ItemStack(Material.WOOL, 1, (short) 12);
        ItemMeta brownMeta = brown.getItemMeta();
        brownMeta.setDisplayName(ChatColor.GREEN + "Brown");
        brown.setItemMeta(brownMeta);

        pane.addItem(new GuiItem(brown, event -> {
            rabbit.setRabbitType(Rabbit.Type.BROWN);

            event.setCancelled(true);
        }));

        //gold type
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldMeta = gold.getItemMeta();
        goldMeta.setDisplayName(ChatColor.GREEN + "Gold");
        gold.setItemMeta(goldMeta);

        pane.addItem(new GuiItem(gold, event -> {
            rabbit.setRabbitType(Rabbit.Type.GOLD);

            event.setCancelled(true);
        }));

        //salt and pepper type
        ItemStack saltAndPepper = new ItemStack(Material.COOKIE);
        ItemMeta saltAndPepperMeta = saltAndPepper.getItemMeta();
        saltAndPepperMeta.setDisplayName(ChatColor.GREEN + "Salt and pepper");
        saltAndPepper.setItemMeta(saltAndPepperMeta);

        pane.addItem(new GuiItem(saltAndPepper, event -> {
            rabbit.setRabbitType(Rabbit.Type.SALT_AND_PEPPER);

            event.setCancelled(true);
        }));

        //the killer bunny type
        ItemStack theKillerBunny = new ItemStack(Material.IRON_SWORD);
        ItemMeta theKillerBunnyMeta = theKillerBunny.getItemMeta();
        theKillerBunnyMeta.setDisplayName(ChatColor.GREEN + "The killer bunny");
        theKillerBunny.setItemMeta(theKillerBunnyMeta);

        pane.addItem(new GuiItem(theKillerBunny, event -> {
            rabbit.setRabbitType(Rabbit.Type.THE_KILLER_BUNNY);

            event.setCancelled(true);
        }));

        //white type
        ItemStack white = new ItemStack(Material.BONE);
        ItemMeta whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.GREEN + "White");
        white.setItemMeta(whiteMeta);

        pane.addItem(new GuiItem(white, event -> {
            rabbit.setRabbitType(Rabbit.Type.WHITE);

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}