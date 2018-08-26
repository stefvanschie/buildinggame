package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.profession;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Villager;
import org.bukkit.entity.ZombieVillager;
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
        super(Main.getInstance(), 1, ChatColor.GREEN + "Select profession");

        StaticPane pane = new StaticPane(new GuiLocation(1, 0), 7, 1);

        //blacksmith
        ItemStack blacksmith = new ItemStack(Material.ANVIL);
        ItemMeta blacksmithMeta = blacksmith.getItemMeta();
        blacksmithMeta.setDisplayName(ChatColor.GREEN + "Blacksmith");
        blacksmith.setItemMeta(blacksmithMeta);

        pane.addItem(new GuiItem(blacksmith, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.BLACKSMITH);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.BLACKSMITH);

            event.setCancelled(true);
        }), new GuiLocation(0, 0));

        //butcher
        ItemStack butcher = new ItemStack(Material.BEEF);
        ItemMeta butcherMeta = butcher.getItemMeta();
        butcherMeta.setDisplayName(ChatColor.GREEN + "Butcher");
        butcher.setItemMeta(butcherMeta);

        pane.addItem(new GuiItem(butcher, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.BUTCHER);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.BUTCHER);

            event.setCancelled(true);
        }), new GuiLocation(1, 0));

        //farmer
        ItemStack farmer = new ItemStack(Material.WHEAT);
        ItemMeta farmerMeta = farmer.getItemMeta();
        farmerMeta.setDisplayName(ChatColor.GREEN + "Farmer");
        farmer.setItemMeta(farmerMeta);

        pane.addItem(new GuiItem(farmer, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.FARMER);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.FARMER);

            event.setCancelled(true);
        }), new GuiLocation(2, 0));

        //librarian
        ItemStack librarian = new ItemStack(Material.BOOK);
        ItemMeta librarianMeta = librarian.getItemMeta();
        librarianMeta.setDisplayName(ChatColor.GREEN + "Librarian");
        librarian.setItemMeta(librarianMeta);

        pane.addItem(new GuiItem(librarian, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.LIBRARIAN);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.LIBRARIAN);

            event.setCancelled(true);
        }), new GuiLocation(4, 0));

        //nitwit
        ItemStack nitwit = new ItemStack(Material.DIAMOND_HOE);
        ItemMeta nitwitMeta = nitwit.getItemMeta();
        nitwitMeta.setDisplayName(ChatColor.GREEN + "Nitwit");
        nitwit.setItemMeta(nitwitMeta);

        pane.addItem(new GuiItem(nitwit, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.NITWIT);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.NITWIT);

            event.setCancelled(true);
        }), new GuiLocation(5, 0));

        //priest
        ItemStack priest = new ItemStack(Material.ENDER_EYE);
        ItemMeta priestMeta = priest.getItemMeta();
        priestMeta.setDisplayName(ChatColor.GREEN + "Priest");
        priest.setItemMeta(priestMeta);

        pane.addItem(new GuiItem(priest, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.PRIEST);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.PRIEST);

            event.setCancelled(true);
        }), new GuiLocation(6, 0));

        addPane(pane);
    }
}
