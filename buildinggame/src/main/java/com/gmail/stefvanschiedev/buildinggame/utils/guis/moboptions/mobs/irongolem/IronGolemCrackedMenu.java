package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.irongolem;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.IronGolem;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.jetbrains.annotations.NotNull;

/**
 * Sets the cracked state of an iron golem
 *
 * @since 8.0.0
 */
class IronGolemCrackedMenu extends Gui {

    /**
     * Creates a new menu
     *
     * @since 8.0.0
     */
    IronGolemCrackedMenu(@NotNull IronGolem ironGolem) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Change the cracked state of an iron golem");

        var pane = new OutlinePane(0, 0, 9, 1);

        //80, 160
        var noCracks = new ItemStack(Material.IRON_CHESTPLATE);
        var noCracksMeta = noCracks.getItemMeta();
        noCracksMeta.setDisplayName(ChatColor.GREEN + "No cracks");
        noCracks.setItemMeta(noCracksMeta);

        pane.addItem(new GuiItem(noCracks, event -> {
            //TODO: remove cracks from iron golem

            event.setCancelled(true);
        }));

        var chipped = new ItemStack(Material.IRON_CHESTPLATE);
        var chippedMeta = chipped.getItemMeta();
        ((Damageable) chippedMeta).setDamage((IronGolemMenu.MAX_DAMAGE - 1) / 3 * 2);
        chippedMeta.setDisplayName(ChatColor.GREEN + "Chipped");
        chipped.setItemMeta(chippedMeta);

        pane.addItem(new GuiItem(chipped, event -> {
            //TODO: set crack state to chipped

            event.setCancelled(true);
        }));

        var damaged = new ItemStack(Material.IRON_CHESTPLATE);
        var damagedMeta = damaged.getItemMeta();
        ((Damageable) damagedMeta).setDamage((IronGolemMenu.MAX_DAMAGE - 1) / 3);
        damagedMeta.setDisplayName(ChatColor.GREEN + "Damaged");
        damaged.setItemMeta(damagedMeta);

        pane.addItem(new GuiItem(damaged, event -> {
            //TODO: set crack state to damaged

            event.setCancelled(true);
        }));

        var severelyDamaged = new ItemStack(Material.IRON_CHESTPLATE);
        var severelyDamagedMeta = severelyDamaged.getItemMeta();
        ((Damageable) severelyDamagedMeta).setDamage(IronGolemMenu.MAX_DAMAGE - 1);
        severelyDamagedMeta.setDisplayName(ChatColor.GREEN + "Severely damaged");
        severelyDamaged.setItemMeta(severelyDamagedMeta);

        pane.addItem(new GuiItem(severelyDamaged, event -> {
            //TODO: set crack state to severely damaged

            event.setCancelled(true);
        }));

        addPane(pane);
    }
}
