package com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.util.Pane;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.util.PaneUtil;
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
import java.util.stream.Stream;

/**
 * A pane for static items and stuff. All items will have to be specified a slot, or will be added in the next position.
 *
 * @since 5.6.0
 */
public class StaticPane extends Pane {

    /**
     * A set of items inside this pane
     */
    private final GuiItem[] items;

    /**
     * Constructs a new default pane
     *
     * @param start the upper left corner of the pane
     * @param length the length of the pane
     * @param height the height of the pane
     */
    public StaticPane(@NotNull GuiLocation start, int length, int height) {
        super(start, length, height);

        this.items = new GuiItem[length * height];
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
    @Override
    public void display(@NotNull Inventory inventory) {
        PaneUtil.linearDisplay(inventory, items, start, length, height);
    }

    /**
     * Adds a gui item at the specific spot in the pane
     *
     * @param item the item to set
     * @param location the location of the item
     * @since 5.6.0
     */
    public void addItem(@NotNull GuiItem item, @NotNull GuiLocation location) {
        items[location.getY() * length + location.getX()] = item;
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
    @Override
    public boolean click(@NotNull InventoryClickEvent event) {
        return PaneUtil.linearClick(event, items, start, length);
    }

    /**
     * {@inheritDoc}
     *
     * @since 5.6.0
     */
    @Nullable
    @Override
    public GuiItem getItem(@NotNull String tag) {
        return Stream.of(items).filter(item -> item != null && tag.equals(item.getTag())).findAny().orElse(null);
    }

    /**
     * Loads an outline pane from a given element
     *
     * @param instance the instance class
     * @param element the element
     * @return the outline pane
     * @since 5.6.0
     */
    @Nullable
    @Contract("_, null -> fail")
    public static StaticPane load(Object instance, @NotNull Element element) {
        try {
            StaticPane staticPane = new StaticPane(new GuiLocation(
                Integer.parseInt(element.getAttribute("x")),
                Integer.parseInt(element.getAttribute("y"))),
                Integer.parseInt(element.getAttribute("length")),
                Integer.parseInt(element.getAttribute("height"))
            );

            if (element.hasAttribute("tag"))
                staticPane.setTag(element.getAttribute("tag"));

            if (element.hasAttribute("visible"))
                staticPane.setVisible(Boolean.parseBoolean(element.getAttribute("visible")));

            if (element.hasAttribute("onPopulate")) {
                for (Method method : instance.getClass().getMethods()) {
                    if (!method.getName().equals(element.getAttribute("onPopulate")))
                        continue;

                    if (method.getParameterCount() == 1 &&
                        StaticPane.class.isAssignableFrom(method.getParameterTypes()[0])) {
                        method.setAccessible(true);
                        method.invoke(instance, staticPane);
                    }
                }

                return staticPane;
            }

            NodeList childNodes = element.getChildNodes();

            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);

                if (item.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                Element child = (Element) item;

                staticPane.addItem(Pane.loadItem(instance, child),
                    new GuiLocation(Integer.parseInt(child.getAttribute("x")),
                        Integer.parseInt(child.getAttribute("y"))));
            }

            return staticPane;
        } catch (NumberFormatException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}