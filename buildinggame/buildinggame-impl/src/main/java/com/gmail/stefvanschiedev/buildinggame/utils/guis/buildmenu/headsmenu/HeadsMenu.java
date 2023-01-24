package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * A heads menu
 *
 * @since 5.6.0
 */
public class HeadsMenu {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * The gui
     */
    ChestGui gui;

    /**
     * Empty constructor in case paginated heads menu wants to initialize the gui
     *
     * @since 5.6.0
     */
    HeadsMenu() {}

    /**
     * Creates a new heads menu
     *
     * @param location the path to the gui file
     * @since 5.6.0
     */
    public HeadsMenu(String location) {
        this.gui = ChestGui.load(this, Main.getInstance().getResource(location));

        var title = gui.getTitle();

        if (!title.isEmpty() && title.charAt(0) == '*')
            gui.setTitle(MessageManager.translate(MESSAGES.getString(ChatColor.stripColor(title.substring(1)))));

        gui.getItems().forEach(item -> {
            var itemMeta = item.getItem().getItemMeta();

            if (itemMeta == null)
                return;

            var displayName = itemMeta.getDisplayName();

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
     * Called whenever a user clicks on a head item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    @SuppressWarnings("deprecation")
    public void headClick(InventoryClickEvent event) {
        event.setCursor(event.getCurrentItem());
        event.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the close item
     *
     * @param event the event called when clicking
     * @since 5.6.0
     */
    public void closeClick(InventoryClickEvent event) {
        event.getWhoClicked().closeInventory();
        event.setCancelled(true);
    }
}
