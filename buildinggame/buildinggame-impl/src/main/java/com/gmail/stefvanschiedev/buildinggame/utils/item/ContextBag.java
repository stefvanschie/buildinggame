package com.gmail.stefvanschiedev.buildinggame.utils.item;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A bag which stores context for an item.
 *
 * @since 11.0.1
 */
class ContextBag {

    /**
     * The item for which this bag stores and retrieves the context.
     */
    @NotNull
    private final ItemStack item;

    /**
     * Creates a context bag for the specified {@link ItemStack}. The created context bag will immediately contain
     * context that was already attached to the provided item, if this item has context. Added context will be reflected
     * in this item.
     *
     * @since 11.0.1
     */
    ContextBag(@NotNull ItemStack item) {
        this.item = item;
    }

    /**
     * Adds context to this context bag and the underlying item. If context already existed for the specified key, this
     * invocation will overwrite the previous context.
     *
     * @param key the key for which to add context
     * @param type the type for which to add context
     * @param context the context
     * @param <Z> the type of context
     * @since 11.0.1
     */
    <Z> void addContext(@NotNull String key, @NotNull PersistentDataType<?, Z> type, @NotNull Z context) {
        ItemMeta itemMeta = this.item.getItemMeta();

        itemMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), key), type, context);

        this.item.setItemMeta(itemMeta);
    }

    /**
     * Gets context from this context bag. If there is no context for this given item, null will be returned.
     *
     * @param key the key for which to get the context
     * @param type the type of context to retrieve
     * @return the context or null if the context does not exist
     * @param <Z> the type of context
     * @since 11.0.1
     */
    @Nullable
    <Z> Z getContext(@NotNull String key, @NotNull PersistentDataType<?, Z> type) {
        var namespacedKey = new NamespacedKey(Main.getInstance(), key);

        return this.item.getItemMeta().getPersistentDataContainer().get(namespacedKey, type);
    }
}
