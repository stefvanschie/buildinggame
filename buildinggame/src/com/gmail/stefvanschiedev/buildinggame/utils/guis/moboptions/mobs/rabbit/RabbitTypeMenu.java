package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.rabbit;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Rabbit;
import org.bukkit.event.inventory.InventoryEvent;
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
        super(null, 9, ChatColor.GREEN + "Set rabbit type", 1);

        setStartingPoint(1);

        //black type
        ItemStack black = new ItemStack(Material.WOOL, 1, (short) 15);
        ItemMeta blackMeta = black.getItemMeta();
        blackMeta.setDisplayName(ChatColor.GREEN + "Black");
        black.setItemMeta(blackMeta);

        addItem(black, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                rabbit.setRabbitType(Rabbit.Type.BLACK);

                return true;
            }
        });

        //black and white type
        ItemStack blackAndWhite = new ItemStack(Material.RECORD_9);
        ItemMeta blackAndWhiteMeta = blackAndWhite.getItemMeta();
        blackAndWhiteMeta.setDisplayName(ChatColor.GREEN + "Black and white");
        blackAndWhite.setItemMeta(blackAndWhiteMeta);

        addItem(blackAndWhite, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                rabbit.setRabbitType(Rabbit.Type.BLACK_AND_WHITE);

                return true;
            }
        });

        //brown type
        ItemStack brown = new ItemStack(Material.WOOL, 1, (short) 12);
        ItemMeta brownMeta = brown.getItemMeta();
        brownMeta.setDisplayName(ChatColor.GREEN + "Brown");
        brown.setItemMeta(brownMeta);

        addItem(brown, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                rabbit.setRabbitType(Rabbit.Type.BROWN);

                return true;
            }
        });

        //gold type
        ItemStack gold = new ItemStack(Material.GOLD_INGOT);
        ItemMeta goldMeta = gold.getItemMeta();
        goldMeta.setDisplayName(ChatColor.GREEN + "Gold");
        gold.setItemMeta(goldMeta);

        addItem(gold, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                rabbit.setRabbitType(Rabbit.Type.GOLD);

                return true;
            }
        });

        //salt and pepper type
        ItemStack saltAndPepper = new ItemStack(Material.COOKIE);
        ItemMeta saltAndPepperMeta = saltAndPepper.getItemMeta();
        saltAndPepperMeta.setDisplayName(ChatColor.GREEN + "Salt and pepper");
        saltAndPepper.setItemMeta(saltAndPepperMeta);

        addItem(saltAndPepper, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                rabbit.setRabbitType(Rabbit.Type.SALT_AND_PEPPER);

                return true;
            }
        });

        //the killer bunny type
        ItemStack theKillerBunny = new ItemStack(Material.IRON_SWORD);
        ItemMeta theKillerBunnyMeta = theKillerBunny.getItemMeta();
        theKillerBunnyMeta.setDisplayName(ChatColor.GREEN + "The killer bunny");
        theKillerBunny.setItemMeta(theKillerBunnyMeta);

        addItem(theKillerBunny, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                rabbit.setRabbitType(Rabbit.Type.THE_KILLER_BUNNY);

                return true;
            }
        });

        //white type
        ItemStack white = new ItemStack(Material.BONE);
        ItemMeta whiteMeta = white.getItemMeta();
        whiteMeta.setDisplayName(ChatColor.GREEN + "White");
        white.setItemMeta(whiteMeta);

        addItem(white, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                rabbit.setRabbitType(Rabbit.Type.WHITE);

                return true;
            }
        });
    }
}