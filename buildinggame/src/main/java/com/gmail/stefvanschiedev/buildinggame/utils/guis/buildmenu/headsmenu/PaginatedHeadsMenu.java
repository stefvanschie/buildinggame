package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Cancellable;

/**
 * A heads menu with multiple pages
 *
 * @since 5.6.0
 */
public class PaginatedHeadsMenu extends HeadsMenu {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * The paginated pane
     */
    public PaginatedPane paginatedPane;

    /**
     * The panes for going to the previous and next pages
     */
    public OutlinePane previous, next;

    /**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
    public PaginatedHeadsMenu(String location) {
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
     * Called whenever a user clicks on the previous page item
     *
     * @param cancellable a cancellable event
     * @since 5.6.0
     */
    public void previousPageClick(Cancellable cancellable) {
        paginatedPane.setPage(paginatedPane.getPage() - 1);

        if (paginatedPane.getPage() == 0)
            previous.setVisible(false);

        next.setVisible(true);

        gui.update();

        cancellable.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the next page item
     *
     * @since 5.6.0
     */
    public void nextPageClick(Cancellable cancellable) {
        paginatedPane.setPage(paginatedPane.getPage() + 1);

        if (paginatedPane.getPage() == paginatedPane.getPages() - 1)
            next.setVisible(false);

        previous.setVisible(true);

        gui.update();

        cancellable.setCancelled(true);
    }
}
