package com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane;

import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.util.Pane;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.util.PaneUtil;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * A pane for items that should be outlined
 *
 * @since 5.6.0
 */
public class OutlinePane extends Pane {

    /**
     * A set of items inside this pane
     */
    private final GuiItem[] items;

    /**
     * Constructs a new default pane
     *
     * @param start  the upper left corner of the pane
     * @param length the length of the pane
     * @param height the height of the pane
     */
    public OutlinePane(@NotNull GuiLocation start, int length, int height) {
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
     * @since 5.6.0
     */
    public void addItem(@NotNull GuiItem item) {
        int openIndex = -1;

        int length = items.length;
        for (int i = 0; i < length; i++) {
            if (items[i] == null) {
                openIndex = i;
                break;
            }
        }

        if (openIndex == -1)
            return;

        items[openIndex] = item;
    }

    public void insertItem(@NotNull GuiItem item, int position) {
        if (items[position] != null)
            System.arraycopy(items, position, items, position + 1, (int) Stream.of(items).skip(position)
                .filter(Objects::nonNull).count());

        items[position] = item;
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
    public static OutlinePane load(Object instance, @NotNull Element element) {
        try {
            OutlinePane outlinePane = new OutlinePane(new GuiLocation(
                Integer.parseInt(element.getAttribute("x")),
                Integer.parseInt(element.getAttribute("y"))),
                Integer.parseInt(element.getAttribute("length")),
                Integer.parseInt(element.getAttribute("height"))
            );

            if (element.hasAttribute("tag"))
                outlinePane.setTag(element.getAttribute("tag"));

            if (element.hasAttribute("visible"))
                outlinePane.setVisible(Boolean.parseBoolean(element.getAttribute("visible")));

            if (element.hasAttribute("onPopulate")) {
                for (Method method : instance.getClass().getMethods()) {
                    if (!method.getName().equals(element.getAttribute("onPopulate")))
                        continue;

                    if (method.getParameterCount() == 1 &&
                        OutlinePane.class.isAssignableFrom(method.getParameterTypes()[0])) {
                        method.setAccessible(true);
                        method.invoke(instance, outlinePane);
                    }
                }

                return outlinePane;
            }

            NodeList childNodes = element.getChildNodes();

            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);

                if (item.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                if (item.getNodeName().equals("empty"))
                    outlinePane.addItem(new GuiItem(new ItemStack(Material.AIR)));
                else
                    outlinePane.addItem(Pane.loadItem(instance, (Element) item));
            }

            return outlinePane;
        } catch (NumberFormatException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}