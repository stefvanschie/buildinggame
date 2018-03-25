package com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.util.Pane;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * A pane for panes that should be spread out over multiple pages
 *
 * @since 5.6.0
 */
public class PaginatedPane extends Pane {

    /**
     * A set of panes for the different pages
     */
    private final Pane[] panes;

    /**
     * The current page
     */
    private int page;

    /**
     * {@inheritDoc}
     */
    public PaginatedPane(@NotNull GuiLocation start, int length, int height, int pages) {
        super(start, length, height);

        this.panes = new Pane[pages];
    }

    /**
     * Returns the current page
     *
     * @return the current page
     * @since 5.6.0
     */
    public int getPage() {
        return page;
    }

    /**
     * Returns the amount of pages
     *
     * @return the amount of pages
     * @since 5.6.0
     */
    public int getPages() {
        return panes.length;
    }
    /**
     * Assigns a pane to a selected page
     *
     * @param page the page to assign the pane to
     * @param pane the new pane
     * @since 5.6.0
     */
    public void setPane(int page, Pane pane) {
        this.panes[page] = pane;
    }

    /**
     * Sets the current displayed page
     *
     * @param page the page
     * @since 5.6.0
     */
    public void setPage(int page) {
        assert page >= 0 && page < panes.length : "page outside range";

        this.page = page;
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
    @Override
    public void display(Inventory inventory) {
        this.panes[page].display(inventory);
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
    @Override
    public boolean click(@NotNull InventoryClickEvent event) {
        return this.panes[page].click(event);
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
    @Override
    public GuiItem getItem(@NotNull String tag) {
        for (Pane pane : panes) {
            GuiItem item = pane.getItem(tag);

            if (item != null)
                return item;
        }

        return null;
    }

    /**
     * Loads a paginated pane from a given element
     *
     * @param instance the instance class
     * @param element the element
     * @return the paginated pane
     * @since 5.6.0
     */
    @Nullable
    @Contract("_, null -> fail")
    public static PaginatedPane load(Object instance, @NotNull Element element) {
        try {
            NodeList childNodes = element.getChildNodes();
            int pages = 0;

            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i).getNodeType() != Node.ELEMENT_NODE)
                    continue;

                pages++;
            }

            PaginatedPane paginatedPane = new PaginatedPane(new GuiLocation(Integer.parseInt(
                element.getAttribute("x")
            ), Integer.parseInt(element.getAttribute("y"))), Integer.parseInt(
                element.getAttribute("length")
            ), Integer.parseInt(element.getAttribute("height")), pages);

            if (element.hasAttribute("tag"))
                paginatedPane.setTag(element.getAttribute("tag"));

            if (element.hasAttribute("visible"))
                paginatedPane.setVisible(Boolean.parseBoolean(element.getAttribute("visible")));

            if (element.hasAttribute("onPopulate")) {
                for (Method method : instance.getClass().getMethods()) {
                    if (!method.getName().equals(element.getAttribute("onPopulate")))
                        continue;

                    if (method.getParameterCount() == 1 &&
                        PaginatedPane.class.isAssignableFrom(method.getParameterTypes()[0])) {
                        method.setAccessible(true);
                        method.invoke(instance, paginatedPane);
                    }
                }

                return paginatedPane;
            }

            int pageCount = 0;

            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);

                if (item.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                NodeList innerNodes = item.getChildNodes();

                for (int j = 0; j < innerNodes.getLength(); j++) {
                    Node pane = innerNodes.item(j);

                    if (pane.getNodeType() != Node.ELEMENT_NODE)
                        continue;

                    paginatedPane.setPane(pageCount, Gui.loadPane(instance, pane));
                    break;
                }

                pageCount++;
            }

            return paginatedPane;
        } catch (NumberFormatException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
