package com.gmail.stefvanschiedev.buildinggame.utils.itemtagtypes;

import org.bukkit.inventory.meta.tags.ItemTagAdapterContext;
import org.bukkit.inventory.meta.tags.ItemTagType;
import org.jetbrains.annotations.NotNull;

/**
 * An item tag type for storing booleans
 *
 * @since 7.0.0
 */
public class BooleanItemTagType implements ItemTagType<Boolean, Boolean> {

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public Class<Boolean> getPrimitiveType() {
        return boolean.class;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public Class<Boolean> getComplexType() {
        return boolean.class;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public Boolean toPrimitive(@NotNull Boolean aBoolean, @NotNull ItemTagAdapterContext itemTagAdapterContext) {
        return aBoolean;
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Override
    public Boolean fromPrimitive(@NotNull Boolean aBoolean, @NotNull ItemTagAdapterContext itemTagAdapterContext) {
        return aBoolean;
    }
}
