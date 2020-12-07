package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.villagerlike;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
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
class ProfessionSelectionMenu extends ChestGui {

    /**
     * {@inheritDoc}
     */
    ProfessionSelectionMenu(Creature villagerLike) {
        super(2, ChatColor.GREEN + "Select profession");

        var pane = new OutlinePane(0, 0, 9, 2);

        //armorer
        var armorer = new ItemStack(Material.IRON_CHESTPLATE);
        var armorerMeta = armorer.getItemMeta();
        armorerMeta.setDisplayName(ChatColor.GREEN + "Armorer");
        armorer.setItemMeta(armorerMeta);

        pane.addItem(new GuiItem(armorer, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.ARMORER);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.ARMORER);
            }

            event.setCancelled(true);
        }));

        //butcher
        var butcher = new ItemStack(Material.BEEF);
        var butcherMeta = butcher.getItemMeta();
        butcherMeta.setDisplayName(ChatColor.GREEN + "Butcher");
        butcher.setItemMeta(butcherMeta);

        pane.addItem(new GuiItem(butcher, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.BUTCHER);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.BUTCHER);
            }

            event.setCancelled(true);
        }));

        //cartographer
        var cartographer = new ItemStack(Material.MAP);
        var cartographerMeta = cartographer.getItemMeta();
        cartographerMeta.setDisplayName(ChatColor.GREEN + "Cartographer");
        cartographer.setItemMeta(cartographerMeta);

        pane.addItem(new GuiItem(cartographer, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.CARTOGRAPHER);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.CARTOGRAPHER);
            }

            event.setCancelled(true);
        }));

        //cleric
        var cleric = new ItemStack(Material.BREWING_STAND);
        var clericMeta = cleric.getItemMeta();
        clericMeta.setDisplayName(ChatColor.GREEN + "Cleric");
        cleric.setItemMeta(clericMeta);

        pane.addItem(new GuiItem(cleric, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.CLERIC);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.CLERIC);
            }

            event.setCancelled(true);
        }));

        //farmer
        var farmer = new ItemStack(Material.WHEAT);
        var farmerMeta = farmer.getItemMeta();
        farmerMeta.setDisplayName(ChatColor.GREEN + "Farmer");
        farmer.setItemMeta(farmerMeta);

        pane.addItem(new GuiItem(farmer, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.FARMER);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.FARMER);
            }

            event.setCancelled(true);
        }));

        //fisherman
        var fisherman = new ItemStack(Material.COD);
        var fishermanMeta = fisherman.getItemMeta();
        fishermanMeta.setDisplayName(ChatColor.GREEN + "Fisherman");
        fisherman.setItemMeta(fishermanMeta);

        pane.addItem(new GuiItem(fisherman, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.FISHERMAN);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.FISHERMAN);
            }

            event.setCancelled(true);
        }));

        //fletcher
        var fletcher = new ItemStack(Material.ARROW);
        var fletcherMeta = fletcher.getItemMeta();
        fletcherMeta.setDisplayName(ChatColor.GREEN + "Fletcher");
        fletcher.setItemMeta(fletcherMeta);

        pane.addItem(new GuiItem(fletcher, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.FLETCHER);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.FLETCHER);
            }

            event.setCancelled(true);
        }));

        //leatherworker
        var leatherworker = new ItemStack(Material.LEATHER);
        var leatherworkerMeta = leatherworker.getItemMeta();
        leatherworkerMeta.setDisplayName(ChatColor.GREEN + "Leatherworker");
        leatherworker.setItemMeta(leatherworkerMeta);

        pane.addItem(new GuiItem(leatherworker, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.LEATHERWORKER);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.LEATHERWORKER);
            }

            event.setCancelled(true);
        }));

        //librarian
        var librarian = new ItemStack(Material.BOOK);
        var librarianMeta = librarian.getItemMeta();
        librarianMeta.setDisplayName(ChatColor.GREEN + "Librarian");
        librarian.setItemMeta(librarianMeta);

        pane.addItem(new GuiItem(librarian, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.LIBRARIAN);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.LIBRARIAN);
            }

            event.setCancelled(true);
        }));

        //mason
        var mason = new ItemStack(Material.BRICK);
        var masonMeta = mason.getItemMeta();
        masonMeta.setDisplayName(ChatColor.GREEN + "Mason");
        mason.setItemMeta(masonMeta);

        pane.addItem(new GuiItem(mason, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.MASON);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.MASON);
            }

            event.setCancelled(true);
        }));

        //nitwit
        var nitwit = new ItemStack(Material.DIAMOND_HOE);
        var nitwitMeta = nitwit.getItemMeta();
        nitwitMeta.setDisplayName(ChatColor.GREEN + "Nitwit");
        nitwit.setItemMeta(nitwitMeta);

        pane.addItem(new GuiItem(nitwit, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.NITWIT);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.NITWIT);
            }

            event.setCancelled(true);
        }));

        //shepherd
        var shepherd = new ItemStack(Material.SHEARS);
        var shepherdMeta = shepherd.getItemMeta();
        shepherdMeta.setDisplayName(ChatColor.GREEN + "Shepherd");
        shepherd.setItemMeta(shepherdMeta);

        pane.addItem(new GuiItem(shepherd, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.SHEPHERD);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.SHEPHERD);
            }

            event.setCancelled(true);
        }));

        //toolsmith
        var toolsmith = new ItemStack(Material.IRON_PICKAXE);
        var toolsmithMeta = toolsmith.getItemMeta();
        toolsmithMeta.setDisplayName(ChatColor.GREEN + "Toolsmith");
        toolsmith.setItemMeta(toolsmithMeta);

        pane.addItem(new GuiItem(toolsmith, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.TOOLSMITH);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.TOOLSMITH);
            }

            event.setCancelled(true);
        }));

        //weaponsmith
        var weaponsmith = new ItemStack(Material.IRON_SWORD);
        var weaponsmithMeta = weaponsmith.getItemMeta();
        weaponsmithMeta.setDisplayName(ChatColor.GREEN + "Weaponsmith");
        weaponsmith.setItemMeta(weaponsmithMeta);

        pane.addItem(new GuiItem(weaponsmith, event -> {
            if (villagerLike instanceof Villager) {
                ((Villager) villagerLike).setProfession(Villager.Profession.WEAPONSMITH);
            } else if (villagerLike instanceof ZombieVillager) {
                ((ZombieVillager) villagerLike).setVillagerProfession(Villager.Profession.WEAPONSMITH);
            }

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
