package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.bannermenu;

import com.github.stefvanschie.inventoryframework.Gui;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * A gui for selecting the base color of your banner
 *
 * @since 5.2.0
 */
public class BaseColorBannerMenu {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * The gui
     */
    private final Gui gui;

    /**
     * {@inheritDoc}
     */
    public BaseColorBannerMenu() {
        this.gui = Gui.load(Main.getInstance(), this, Main.getInstance().getResource(
            "gui/buildmenu/banner/basecolorbannermenu.xml"
        ));

        String title = gui.getTitle();

        if (!title.isEmpty() && title.charAt(0) == '*')
            gui.setTitle(MessageManager.translate(MESSAGES.getString(title.substring(1))));

        gui.getItems().forEach(item -> {
            ItemMeta itemMeta = item.getItem().getItemMeta();

            if (itemMeta == null)
                return;

            String displayName = itemMeta.getDisplayName();

            if (!displayName.isEmpty() && displayName.charAt(0) == '*')
                itemMeta.setDisplayName(MessageManager.translate(MESSAGES.getString(displayName.substring(1))));

            String lore = itemMeta.getLore().get(0);

            if (!lore.isEmpty() && lore.charAt(0) == '*')
                itemMeta.setLore(MessageManager.translate(MESSAGES.getStringList(lore.substring(1))));

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
     * Called whenever a user clicks on the floor item
     *
     * @param event the event called when clicking
     * @param damage the damage value assigned in the XML file
     * @since 5.6.0
     */
    public void bannerClick(InventoryClickEvent event, short damage) {
        new ColorBannerMenu(new ItemStack(Material.BANNER, 1, damage)).show(event.getWhoClicked());

        event.setCancelled(true);
    }
}