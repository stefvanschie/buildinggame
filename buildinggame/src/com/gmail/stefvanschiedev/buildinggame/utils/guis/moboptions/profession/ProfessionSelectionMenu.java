package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.profession;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Villager;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A menu for selecting the profession of a creature
 *
 * @since 5.3.0
 */
class ProfessionSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    ProfessionSelectionMenu(Creature creature) {
        super(null, 9, ChatColor.GREEN + "Select profession", 1);

        setStartingPoint(1);

        //blacksmith
        ItemStack blacksmith = new ItemStack(Material.ANVIL);
        ItemMeta blacksmithMeta = blacksmith.getItemMeta();
        blacksmithMeta.setDisplayName(ChatColor.GREEN + "Blacksmith");
        blacksmith.setItemMeta(blacksmithMeta);

        addItem(blacksmith, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                if (creature instanceof Villager)
                    ((Villager) creature).setProfession(Villager.Profession.BLACKSMITH);
                else if (creature instanceof ZombieVillager)
                    //noinspection OverlyStrongTypeCast
                    ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.BLACKSMITH);

                return true;
            }
        });

        //butcher
        ItemStack butcher = new ItemStack(Material.RAW_BEEF);
        ItemMeta butcherMeta = butcher.getItemMeta();
        butcherMeta.setDisplayName(ChatColor.GREEN + "Butcher");
        butcher.setItemMeta(butcherMeta);

        addItem(butcher, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                if (creature instanceof Villager)
                    ((Villager) creature).setProfession(Villager.Profession.BUTCHER);
                else if (creature instanceof ZombieVillager)
                    //noinspection OverlyStrongTypeCast
                    ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.BUTCHER);

                return true;
            }
        });

        //farmer
        ItemStack farmer = new ItemStack(Material.WHEAT);
        ItemMeta farmerMeta = farmer.getItemMeta();
        farmerMeta.setDisplayName(ChatColor.GREEN + "Farmer");
        farmer.setItemMeta(farmerMeta);

        addItem(farmer, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                if (creature instanceof Villager)
                    ((Villager) creature).setProfession(Villager.Profession.FARMER);
                else if (creature instanceof ZombieVillager)
                    //noinspection OverlyStrongTypeCast
                    ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.FARMER);

                return true;
            }
        });

        setStartingPoint(5);

        //librarian
        ItemStack librarian = new ItemStack(Material.BOOK);
        ItemMeta librarianMeta = librarian.getItemMeta();
        librarianMeta.setDisplayName(ChatColor.GREEN + "Librarian");
        librarian.setItemMeta(librarianMeta);

        addItem(librarian, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                if (creature instanceof Villager)
                    ((Villager) creature).setProfession(Villager.Profession.LIBRARIAN);
                else if (creature instanceof ZombieVillager)
                    //noinspection OverlyStrongTypeCast
                    ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.LIBRARIAN);

                return true;
            }
        });

        //nitwit
        ItemStack nitwit = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta nitwitMeta = nitwit.getItemMeta();
        nitwitMeta.setDisplayName(ChatColor.GREEN + "Nitwit");
        nitwit.setItemMeta(nitwitMeta);

        addItem(nitwit, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                if (creature instanceof Villager)
                    ((Villager) creature).setProfession(Villager.Profession.NITWIT);
                else if (creature instanceof ZombieVillager)
                    //noinspection OverlyStrongTypeCast
                    ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.NITWIT);

                return true;
            }
        });

        //priest
        ItemStack priest = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta priestMeta = priest.getItemMeta();
        priestMeta.setDisplayName(ChatColor.GREEN + "Priest");
        priest.setItemMeta(priestMeta);

        addItem(priest, new GuiAction() {

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean actionPerformed(GuiActionType type, InventoryEvent event) {
                if (type != GuiActionType.CLICK)
                    return false;

                if (creature instanceof Villager)
                    ((Villager) creature).setProfession(Villager.Profession.PRIEST);
                else if (creature instanceof ZombieVillager)
                    //noinspection OverlyStrongTypeCast
                    ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.PRIEST);

                return true;
            }
        });
    }
}
