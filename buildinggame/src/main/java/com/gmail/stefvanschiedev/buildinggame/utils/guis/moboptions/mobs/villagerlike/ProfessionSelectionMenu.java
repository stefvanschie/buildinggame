package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.villagerlike;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.GuiLocation;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Creature;
import org.bukkit.entity.Villager;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.inventory.ItemStack;

/**
 * A menu for selecting the profession of a villager-like
 *
 * @since 5.3.0
 */
class ProfessionSelectionMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    ProfessionSelectionMenu(Creature creature) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Select profession");

        var pane = new OutlinePane(new GuiLocation(1, 0), 7, 1);

        //blacksmith
        var blacksmith = new ItemStack(Material.ANVIL);
        var blacksmithMeta = blacksmith.getItemMeta();
        blacksmithMeta.setDisplayName(ChatColor.GREEN + "Blacksmith");
        blacksmith.setItemMeta(blacksmithMeta);

        pane.addItem(new GuiItem(blacksmith, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.BLACKSMITH);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.BLACKSMITH);

            event.setCancelled(true);
        }));

        //butcher
        var butcher = new ItemStack(Material.BEEF);
        var butcherMeta = butcher.getItemMeta();
        butcherMeta.setDisplayName(ChatColor.GREEN + "Butcher");
        butcher.setItemMeta(butcherMeta);

        pane.addItem(new GuiItem(butcher, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.BUTCHER);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.BUTCHER);

            event.setCancelled(true);
        }));

        //farmer
        var farmer = new ItemStack(Material.WHEAT);
        var farmerMeta = farmer.getItemMeta();
        farmerMeta.setDisplayName(ChatColor.GREEN + "Farmer");
        farmer.setItemMeta(farmerMeta);

        pane.addItem(new GuiItem(farmer, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.FARMER);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.FARMER);

            event.setCancelled(true);
        }));

        //librarian
        var librarian = new ItemStack(Material.BOOK);
        var librarianMeta = librarian.getItemMeta();
        librarianMeta.setDisplayName(ChatColor.GREEN + "Librarian");
        librarian.setItemMeta(librarianMeta);

        pane.addItem(new GuiItem(librarian, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.LIBRARIAN);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.LIBRARIAN);

            event.setCancelled(true);
        }));

        //nitwit
        var nitwit = new ItemStack(Material.DIAMOND_HOE);
        var nitwitMeta = nitwit.getItemMeta();
        nitwitMeta.setDisplayName(ChatColor.GREEN + "Nitwit");
        nitwit.setItemMeta(nitwitMeta);

        pane.addItem(new GuiItem(nitwit, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.NITWIT);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.NITWIT);

            event.setCancelled(true);
        }));

        //priest
        var priest = new ItemStack(Material.ENDER_EYE);
        var priestMeta = priest.getItemMeta();
        priestMeta.setDisplayName(ChatColor.GREEN + "Priest");
        priest.setItemMeta(priestMeta);

        pane.addItem(new GuiItem(priest, event -> {
            if (creature instanceof Villager)
                ((Villager) creature).setProfession(Villager.Profession.PRIEST);
            else if (creature instanceof ZombieVillager)
                //noinspection OverlyStrongTypeCast
                ((ZombieVillager) creature).setVillagerProfession(Villager.Profession.PRIEST);

            event.setCancelled(true);
        }));

        //mason
        var mason = new ItemStack(Material.BRICK);
        var masonMeta = mason.getItemMeta();
        masonMeta.setDisplayName(ChatColor.GREEN + "Mason");
        mason.setItemMeta(masonMeta);

        pane.addItem(new GuiItem(mason, event -> {
            if (creature instanceof Villager) {
                //TODO: Set the villager's profession to mason
            } else if (creature instanceof ZombieVillager) {
                //TODO: Set the villager's profession to mason
            }

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
