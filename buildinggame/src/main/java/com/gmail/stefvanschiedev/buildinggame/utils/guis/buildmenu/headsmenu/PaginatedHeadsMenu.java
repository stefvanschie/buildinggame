package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.PaginatedPane;
import org.bukkit.event.Cancellable;

/**
 * A heads menu with multiple pages
 *
 * @since 5.6.0
 */
public class PaginatedHeadsMenu extends HeadsMenu {

    /**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
    public PaginatedHeadsMenu(String location) {
        this.gui = Gui.load(this, Main.getInstance().getResource(location));
    }

    /**
     * Called whenever a user clicks on the previous page item
     *
     * @param cancellable a cancellable event
     * @since 5.6.0
     */
    public void previousPageClick(Cancellable cancellable) {
        PaginatedPane paginatedPane = (PaginatedPane) gui.getPane("paginatedpane");

        paginatedPane.setPage(paginatedPane.getPage() - 1);

        if (paginatedPane.getPage() == 0)
            gui.getPane("previous").setVisible(false);

        gui.getPane("next").setVisible(true);

        gui.update();

        cancellable.setCancelled(true);
    }

    /**
     * Called whenever a user clicks on the next page item
     *
     * @since 5.6.0
     */
    public void nextPageClick(Cancellable cancellable) {
        PaginatedPane paginatedPane = (PaginatedPane) gui.getPane("paginatedpane");

        paginatedPane.setPage(paginatedPane.getPage() + 1);

        if (paginatedPane.getPage() == paginatedPane.getPages() - 1)
            gui.getPane("next").setVisible(false);

        gui.getPane("previous").setVisible(true);

        gui.update();

        cancellable.setCancelled(true);
    }
}
