package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu;

import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * A gui for selecting the color for the next pattern
 *
 * @since 5.2.0
 */
class ColorBannerMenu {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * The banner from the previous GUI(s)
     */
    private final ItemStack banner;

    /**
     * The gui
     */
    private final Gui gui;

    /**
     * {@inheritDoc}
     */
    ColorBannerMenu(ItemStack banner) {
        this.banner = banner;
        this.gui = Gui.load(Main.getInstance(), this, Main.getInstance().getResource(
            "gui/buildmenu/banner/colorbannermenu.xml"
        ));

        String title = gui.getTitle();

        if (!title.isEmpty() && title.charAt(0) == '*')
            gui.setTitle(MessageManager.translate(MESSAGES.getString(ChatColor.stripColor(title.substring(1)))));

        gui.getItems().forEach(item -> {
            ItemMeta itemMeta = item.getItem().getItemMeta();

            if (itemMeta == null)
                return;

            String displayName = itemMeta.getDisplayName();

            if (displayName != null && !displayName.isEmpty() && displayName.charAt(0) == '*')
                itemMeta.setDisplayName(MessageManager.translate(MESSAGES.getString(displayName.substring(1))));

            List<String> lore = itemMeta.getLore();

            if (lore != null) {
                String line = lore.get(0);

                if (!line.isEmpty() && line.charAt(0) == '*')
                    itemMeta.setLore(MessageManager.translate(MESSAGES.getStringList(line.substring(1))));
            }

            item.getItem().setItemMeta(itemMeta);
        });
    }

    /**
     * {@link Gui#show(HumanEntity)}
     *
     * @since 5.6.0
     */
    public void show(HumanEntity humanEntity) {
        gui.show(humanEntity);
    }

    /**
     * Called whenever the outline pane specified in the XML file needs to be populated
     *
     * @param pane the outline pane
     * @since 5.6.0
     */
    public void populate(OutlinePane pane) {
        pane.addItem(new GuiItem(new ItemStack(banner), event -> {
            HumanEntity humanEntity = event.getWhoClicked();

            humanEntity.getInventory().addItem(banner);
            humanEntity.closeInventory();

            event.setCancelled(true);
        }));
    }

    /**
     * Called whenever a user clicks on the floor item
     *
     * @param event the event called when clicking
     * @param dyeColor the dye color value assigned in the XML file
     * @since 5.6.0
     */
    public void dyeClick(InventoryClickEvent event, DyeColor dyeColor) {
        new PatternBannerMenu(banner, dyeColor).show(event.getWhoClicked());

        event.setCancelled(true);
    }
}
