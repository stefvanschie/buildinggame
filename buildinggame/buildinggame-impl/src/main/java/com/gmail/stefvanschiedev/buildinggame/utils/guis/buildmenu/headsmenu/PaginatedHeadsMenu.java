package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.PaginatedPane;
import org.bukkit.event.Cancellable;

/**
 * A heads menu with multiple pages
 *
 * @since 5.6.0
 */
public class PaginatedHeadsMenu extends HeadsMenu {

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
        super(location);
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
