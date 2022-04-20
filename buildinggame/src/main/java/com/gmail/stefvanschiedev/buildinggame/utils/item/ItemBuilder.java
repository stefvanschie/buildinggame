package com.gmail.stefvanschiedev.buildinggame.utils.item;

import java.util.*;

import com.gmail.stefvanschiedev.buildinggame.utils.item.datatype.BooleanDataType;
import com.gmail.stefvanschiedev.buildinggame.utils.item.datatype.UUIDDataType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Easily allows you to create items with click events
 *
 * @since 4.0.6
 */
public class ItemBuilder {

    /**
     * The click event assigned to this item
     */
    private ClickEvent event;

    /**
     * Whether you can move the item around
     */
    private boolean movable;

    /**
     * The player this item belongs to
     */
    @NotNull
    private final Player player;

    /**
     * The item we're making
     */
    private final ItemStack item;

    /**
     * Stores the context for this item.
     */
    private final ContextBag contextBag;

    /**
     * Whether the listener was already registered or not
     */
    private static boolean hasRegisteredListener;

    /**
     * Constructs a new ItemBuilder
     *
     * @param player   the player for whom the item is meant
     * @param material the item's material
     */
    public ItemBuilder(@NotNull Player player, Material material) {
        this(player, material, 1);
    }

    /**
     * Constructs a new ItemBuilder
     *
     * @param player   the player for whom the item is meant
     * @param material the item's material
     * @param amount   the amount of items there should be
     */
    private ItemBuilder(@NotNull Player player, Material material, int amount) {
        this.item = new ItemStack(material, amount);
        this.player = player;
        this.contextBag = new ContextBag(this.item);
    }

    /**
     * Builds the item stack
     *
     * @return the itemstack
     * @since 5.6.1
     */
    public ItemStack build() {
        if (!hasRegisteredListener) {
            Bukkit.getPluginManager().registerEvents(new Listener(), Main.getInstance());

            hasRegisteredListener = true;
        }

        ItemMeta itemMeta = item.getItemMeta();

        NamespacedKey movableKey = new NamespacedKey(Main.getInstance(), "movable");
        itemMeta.getPersistentDataContainer().set(movableKey, new BooleanDataType(), this.movable);

        NamespacedKey playerKey = new NamespacedKey(Main.getInstance(), "player");
        itemMeta.getPersistentDataContainer().set(playerKey, new UUIDDataType(), this.player.getUniqueId());

        NamespacedKey clickKey = new NamespacedKey(Main.getInstance(), "click");
        itemMeta.getPersistentDataContainer().set(clickKey, PersistentDataType.INTEGER, this.event.ordinal());

        item.setItemMeta(itemMeta);

        return item;
    }

    /**
     * Adds context to this item that can be retrieved in a click event.
     *
     * @param key the key to identify the context with
     * @param type the type of context
     * @param context the context
     * @return this instance
     * @param <Z> the type of the context
     * @since 11.0.1
     */
    public <Z> ItemBuilder addContext(@NotNull String key, @NotNull PersistentDataType<?, Z> type, @NotNull Z context) {
        this.contextBag.addContext(key, type, context);

        return this;
    }

    /**
     * Sets whether this item should be able to be moved
     *
     * @param movable the new movable state
     * @return this instance
     * @since 4.0.6
     */
    public ItemBuilder movable(boolean movable) {
        this.movable = movable;
        return this;
    }

    /**
     * Sets the click event for this item
     *
     * @param event the new click event
     * @return this instance
     * @since 4.0.6
     */
    public ItemBuilder setClickEvent(ClickEvent event) {
        this.event = event;
        return this;
    }

    /**
     * Sets the display name of this item
     *
     * @param name the new display name
     * @return this instance
     * @since 4.0.6
     */
    public ItemBuilder setDisplayName(String name) {
        var meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);
        return this;
    }

    /**
     * Sets the lore of this item
     *
     * @param lores sets the new lore
     * @return this item
     * @since 4.0.6
     */
    public ItemBuilder setLore(List<String> lores) {
        var meta = item.getItemMeta();
        meta.setLore(lores);
        item.setItemMeta(meta);
        return this;
    }

    /**
     * This class listens to events related to {@link ItemBuilder}s.
     *
     * @since 7.0.0
     */
    public static class Listener implements org.bukkit.event.Listener {

        /**
         * Inventory types for which the specified item's action should continue as opposed to ignoring it.
         */
        @NotNull
        private static final EnumSet<InventoryType> ALLOWED_INVENTORY_TYPES = EnumSet.of(
            InventoryType.CRAFTING,
            InventoryType.CREATIVE
        );

        /**
         * Handles the interaction between player and their item
         *
         * @param e the event that occurs
         * @since 7.0.0
         */
        @Contract("null -> fail")
        @EventHandler
        private void onPlayerInteract(PlayerInteractEvent e) {
            Player player = e.getPlayer();

            if (e.getItem() == null
                || e.getHand() != EquipmentSlot.HAND
                || !ALLOWED_INVENTORY_TYPES.contains(player.getOpenInventory().getType())) {
                return;
            }

            ItemMeta itemMeta = e.getItem().getItemMeta();

            NamespacedKey playerKey = new NamespacedKey(Main.getInstance(), "player");
            var playerUUID = itemMeta.getPersistentDataContainer().get(playerKey, new UUIDDataType());

            if (playerUUID == null || !player.getUniqueId().equals(playerUUID)) {
                return;
            }

            NamespacedKey clickKey = new NamespacedKey(Main.getInstance(), "click");
            int click = itemMeta.getPersistentDataContainer().get(clickKey, PersistentDataType.INTEGER);
            ClickEvent[] events = ClickEvent.values();

            if (click >= events.length) {
                return;
            }

            events[click].invoke(e, new ContextBag(e.getItem()));
        }

        /**
         * Handles the movement of items
         *
         * @param e the event that occurs
         * @since 7.0.0
         */
        @Contract("null -> fail")
        @EventHandler(ignoreCancelled = true)
        private void onInventoryClick(InventoryClickEvent e) {
            if (e.getCurrentItem() == null) {
                return;
            }

            var itemMeta = e.getCurrentItem().getItemMeta();

            if (itemMeta == null) {
                return;
            }

            NamespacedKey playerKey = new NamespacedKey(Main.getInstance(), "player");
            var playerUUID = itemMeta.getPersistentDataContainer().get(playerKey, new UUIDDataType());

            if (playerUUID == null || !e.getWhoClicked().getUniqueId().equals(playerUUID)) {
                return;
            }

            NamespacedKey movableKey = new NamespacedKey(Main.getInstance(), "movable");

            if (!itemMeta.getPersistentDataContainer().has(movableKey, new BooleanDataType())) {
                return;
            }

            boolean movable = itemMeta.getPersistentDataContainer().get(movableKey, new BooleanDataType());

            if (!movable) {
                e.setCancelled(true);
            }
        }
    }
}