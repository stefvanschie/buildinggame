package com.gmail.stefvanschiedev.buildinggame.utils.guis.util.pane.util;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.Time;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiItem;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.util.GuiLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.ParticleType;
import com.google.common.primitives.Primitives;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Cancellable;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * The base class for all panes.
 *
 * @since 5.6.0
 */
public abstract class Pane {

    /**
     * The starting position of this pane
     */
    protected GuiLocation start;

    /**
     * Length is horizontal, height is vertical
     */
    protected int length, height;

    /**
     * The visibility state of the pane
     */
    private boolean visible;

    /**
     * The tag assigned to this pane, null if no tag has been assigned
     */
    private String tag;

    /**
     * A map containing the mappings for attributes for items
     */
    private static final Map<String, Function<String, Object>> ATTRIBUTE_MAPPINGS = new HashMap<>();

    /**
     * Constructs a new default pane
     *
     * @param start the upper left corner of the pane
     * @param length the length of the pane
     * @param height the height of the pane
     */
    protected Pane(@NotNull GuiLocation start, int length, int height) {
        assert start.getX() + length <= 9 : "length longer than maximum size";
        assert start.getY() + height <= 6 : "height longer than maximum size";

        this.start = start;

        this.length = length;
        this.height = height;

        this.visible = true;
    }

    /**
     * Returns the length of this pane
     *
     * @return the length
     * @since 5.6.0
     */
    public int getLength() {
        return length;
    }

    /**
     * Returns the height of this pane
     *
     * @return the height
     * @since 5.6.0
     */
    public int getHeight() {
        return height;
    }

    /**
     * Has to set all the items in the right spot inside the inventory
     *
     * @param inventory the inventory that the items should be displayed in
     * @since 5.6.0
     */
    public abstract void display(Inventory inventory);

    /**
     * Returns the pane's visibility state
     *
     * @return the pane's visibility
     * @since 5.6.0
     */
    @Contract(pure = true)
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sets whether this pane is visible or not
     *
     * @param visible the pane's visibility
     * @since 5.6.0
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Called whenever there is being clicked on this pane
     *
     * @param event the event that occurred while clicking on this item
     * @return whether the item was found or not
     * @since 5.6.0
     */
    public abstract boolean click(@NotNull InventoryClickEvent event);

    /**
     * Returns a gui item by tag
     *
     * @param tag the tag to look for
     * @return the gui item
     * @since 5.6.0
     */
    @Nullable
    public abstract GuiItem getItem(@NotNull String tag);

    /**
     * Returns the tag that belongs to this item, or null if no tag has been assigned
     *
     * @return the tag or null
     * @since 5.6.0
     */
    @Nullable
    @Contract(pure = true)
    public String getTag() {
        return tag;
    }

    /**
     * Sets the tag of this item to the new tag or removes it when the parameter is null
     *
     * @param tag the new tag
     * @since 5.6.0
     */
    public void setTag(@Nullable String tag) {
        this.tag = tag;
    }

    /**
     * Loads an item from an instance and an element
     *
     * @param instance the instance
     * @param element the element
     * @return the gui item
     * @since 5.6.0
     */
    public static GuiItem loadItem(Object instance, Element element) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        String nodeName = element.getNodeName();
        String id = element.getAttribute("id");
        ItemStack itemStack = null;

        if (nodeName.equals("item"))
            itemStack = !id.isEmpty() && id.charAt(0) == '*' ? IDDecompiler.getInstance().decompile(config.getString(id
                .substring(1))) : new ItemStack(Material.matchMaterial(id.toUpperCase(Locale.getDefault())), 1,
                element.hasAttribute("damage") ? Short.parseShort(element.getAttribute("damage")) : 0);
        else if (nodeName.equals("skull"))
            itemStack = getSkull("http://textures.minecraft.net/texture/" + id);

        if (element.hasAttribute("displayName")) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            String displayName = element.getAttribute("displayName");

            if (!displayName.isEmpty() && displayName.charAt(0) == '*')
                itemMeta.setDisplayName(MessageManager.translate(messages.getString(displayName.substring(1))));
            else
                itemMeta.setDisplayName(displayName.substring(1));

            itemStack.setItemMeta(itemMeta);
        }

        if (element.hasAttribute("lores")) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            String lores = element.getAttribute("lores");

            if (!lores.isEmpty() && lores.charAt(0) == '*')
                itemMeta.setLore(MessageManager.translate(messages.getStringList(lores.substring(1))));

            itemStack.setItemMeta(itemMeta);
        }

        String tag = null;

        if (element.hasAttribute("tag"))
            tag = element.getAttribute("tag");

        Object attribute = null;

        if (element.hasChildNodes()) {
            NodeList childNodes = element.getChildNodes();

            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);

                if (item.getNodeType() != Node.ELEMENT_NODE)
                    continue;

                Element firstChild = (Element) item;

                attribute =
                    ATTRIBUTE_MAPPINGS.get(firstChild.getAttribute("type")).apply(firstChild.getTextContent());
                break;
            }
        }

        Consumer<InventoryClickEvent> action = null;

        if (element.hasAttribute("onClick")) {
            for (Method method : instance.getClass().getMethods()) {
                if (!method.getName().equals(element.getAttribute("onClick")))
                    continue;

                int parameterCount = method.getParameterCount();
                Class<?>[] parameterTypes = method.getParameterTypes();
                Object finalAttribute = attribute;

                if (parameterCount == 0)
                    action = event -> {
                        try {
                            //because reflection with lambdas is stupid
                            method.setAccessible(true);
                            method.invoke(instance);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    };
                else if (InventoryClickEvent.class.isAssignableFrom(parameterTypes[0]) ||
                    Cancellable.class.isAssignableFrom(parameterTypes[0])) {
                    if (parameterCount == 1)
                        action = event -> {
                            try {
                                //because reflection with lambdas is stupid
                                method.setAccessible(true);
                                method.invoke(instance, event);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        };
                    else if (parameterCount == 2 && ((parameterTypes[1].isPrimitive() &&
                        Primitives.unwrap(attribute.getClass()).isAssignableFrom(parameterTypes[1])) ||
                        attribute.getClass().isAssignableFrom(parameterTypes[1])))
                        action = event -> {
                            try {
                                //because reflection with lambdas is stupid
                                method.setAccessible(true);
                                method.invoke(instance, event, finalAttribute);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        };
                }

                break;
            }
        }

        GuiItem item = action == null ? new GuiItem(itemStack) : new GuiItem(itemStack, action);
        item.setTag(tag);

        return item;
    }

    /**
     * Returns a head item with the URL assigned to it
     *
     * @param skinURL the URL to use for this head
     * @return the head with the URL assigned
     * @since 2.1.0
     */
    @Contract(value = "null -> fail", pure = true)
    @SuppressWarnings("ConstantConditions")
    private static ItemStack getSkull(@NotNull String skinURL) {
        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);

        if(skinURL.isEmpty()) {
            return head;
        }

        ItemMeta headMeta = head.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", skinURL).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;

        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        profileField.setAccessible(true);

        try {
            profileField.set(headMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        head.setItemMeta(headMeta);
        return head;
    }

    static {
        ATTRIBUTE_MAPPINGS.put("biome", Biome::valueOf);
        ATTRIBUTE_MAPPINGS.put("dye-color", DyeColor::valueOf);
        ATTRIBUTE_MAPPINGS.put("float", Float::parseFloat);
        ATTRIBUTE_MAPPINGS.put("particle-type", ParticleType::valueOf);
        ATTRIBUTE_MAPPINGS.put("short", Short::parseShort);
        ATTRIBUTE_MAPPINGS.put("time", Time::valueOf);
    }
}