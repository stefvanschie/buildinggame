package com.gmail.stefvanschiedev.buildinggame.utils.guis.moboptions.mobs.wolf;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Wolf;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * A menu for changing a wolf's variant.
 *
 * @since 12.5.0
 */
class WolfVariantMenu extends ChestGui {

    /**
     * Creates a menu to change the provided wolf's variant.
     *
     * @param wolf the wolf to change
     * @since 12.5.0
     */
    WolfVariantMenu(@NotNull Wolf wolf) {
        super(1, ChatColor.GREEN + "Wolf variant");

        OutlinePane pane = new OutlinePane(0, 0, 9, 1);

        pane.setOnClick(event -> event.setCancelled(true));

        pane.addItem(new GuiItem(itemStackWithName(Material.SNOWBALL, ChatColor.GREEN + "Snowy"), event ->
            wolf.setVariant(Wolf.Variant.SNOWY)));
        pane.addItem(new GuiItem(itemStackWithName(Material.DARK_OAK_SAPLING, ChatColor.GREEN + "Striped"), event ->
            wolf.setVariant(Wolf.Variant.STRIPED)));
        pane.addItem(new GuiItem(itemStackWithName(Material.TERRACOTTA, ChatColor.GREEN + "Spotted"), event ->
            wolf.setVariant(Wolf.Variant.SPOTTED)));
        pane.addItem(new GuiItem(itemStackWithName(Material.COPPER_INGOT, ChatColor.GREEN + "Rusty"), event ->
            wolf.setVariant(Wolf.Variant.RUSTY)));
        pane.addItem(new GuiItem(itemStackWithName(Material.PITCHER_POD, ChatColor.GREEN + "Chestnut"), event ->
            wolf.setVariant(Wolf.Variant.CHESTNUT)));
        pane.addItem(new GuiItem(itemStackWithName(Material.BLACK_DYE, ChatColor.GREEN + "Black"), event ->
            wolf.setVariant(Wolf.Variant.BLACK)));
        pane.addItem(new GuiItem(itemStackWithName(Material.FIREWORK_STAR, ChatColor.GREEN + "Ashen"), event ->
            wolf.setVariant(Wolf.Variant.ASHEN)));
        pane.addItem(new GuiItem(itemStackWithName(Material.OAK_SAPLING, ChatColor.GREEN + "Woods"), event ->
            wolf.setVariant(Wolf.Variant.WOODS)));
        pane.addItem(new GuiItem(itemStackWithName(Material.WHITE_DYE, ChatColor.GREEN + "Pale"), event ->
            wolf.setVariant(Wolf.Variant.PALE)));

        addPane(pane);
    }

    /**
     * Generates an item stack for the given material and name. The name will be applied as the display name.
     *
     * @param material the material of the item stack
     * @param name the display name of the item stack
     * @return the created item stack
     * @since 12.5.0
     */
    @NotNull
    @Contract(pure = true)
    private ItemStack itemStackWithName(@NotNull Material material, @NotNull String name) {
        var itemStack = new ItemStack(material);
        var itemMeta = itemStack.getItemMeta();

        if (itemMeta != null) {
            itemMeta.setDisplayName(name);
            itemStack.setItemMeta(itemMeta);
        }

        return itemStack;
    }
}
