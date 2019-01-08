package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.ocelot;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Ocelot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Wool;

/**
 * A menu for changing the type of an ocelot
 *
 * @since 5.3.0
 */
class OcelotTypeMenu extends Gui {

    /**
     * {@inheritDoc}
     */
    OcelotTypeMenu(Ocelot ocelot) {
        super(Main.getInstance(), 1, ChatColor.GREEN + "Select the ocelot type");

        var pane = new StaticPane(2, 0, 5, 1);

        //wild ocelot
        var wildOcelot = new ItemStack(Material.COD);
        var wildOcelotMeta = wildOcelot.getItemMeta();
        wildOcelotMeta.setDisplayName(ChatColor.GREEN + "Wild ocelot");
        wildOcelot.setItemMeta(wildOcelotMeta);

        pane.addItem(new GuiItem(wildOcelot, event -> {
            ocelot.setCatType(Ocelot.Type.WILD_OCELOT);

            event.setCancelled(true);
        }), 0, 0);

        //black cat
        var blackCat = new Wool(DyeColor.BLACK).toItemStack(1);
        var blackCatMeta = blackCat.getItemMeta();
        blackCatMeta.setDisplayName(ChatColor.GREEN + "Black cat");
        blackCat.setItemMeta(blackCatMeta);

        pane.addItem(new GuiItem(blackCat, event -> {
            ocelot.setCatType(Ocelot.Type.BLACK_CAT);

            event.setCancelled(true);
        }), 1, 0);

        //red cat
        var redCat = new Wool(DyeColor.RED).toItemStack(1);
        var redCatMeta = redCat.getItemMeta();
        redCatMeta.setDisplayName(ChatColor.GREEN + "Red cat");
        redCat.setItemMeta(redCatMeta);

        pane.addItem(new GuiItem(redCat, event -> {
            ocelot.setCatType(Ocelot.Type.RED_CAT);

            event.setCancelled(true);
        }), 3, 0);

        //siamese cat
        var siameseCat = new Wool(DyeColor.LIGHT_GRAY).toItemStack(1);
        var siameseCatMeta = siameseCat.getItemMeta();
        siameseCatMeta.setDisplayName(ChatColor.GREEN + "Siamese cat");
        siameseCat.setItemMeta(siameseCatMeta);

        pane.addItem(new GuiItem(siameseCat, event -> {
            ocelot.setCatType(Ocelot.Type.SIAMESE_CAT);

            event.setCancelled(true);
        }), 4, 0);

        addPane(pane);
    }
}
