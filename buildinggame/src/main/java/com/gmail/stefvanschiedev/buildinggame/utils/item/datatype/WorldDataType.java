package com.gmail.stefvanschiedev.buildinggame.utils.item.datatype;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

/**
 * A persistent data type for storing {@link World}s.
 *
 * @since 11.0.1
 */
public final class WorldDataType implements PersistentDataType<String, World> {

    /**
     * The sole instance of this class.
     */
    private static final WorldDataType INSTANCE = new WorldDataType();

    /**
     * A private constructor to prevent instantiation.
     */
    private WorldDataType() {}

    /**
     * Gets the instance of this class.
     *
     * @return the instance
     * @since 11.0.1
     */
    public static WorldDataType getInstance() {
        return INSTANCE;
    }

    @NotNull
    @Override
    public Class<String> getPrimitiveType() {
        return String.class;
    }

    @NotNull
    @Override
    public Class<World> getComplexType() {
        return World.class;
    }

    @NotNull
    @Override
    public String toPrimitive(@NotNull World world, @NotNull PersistentDataAdapterContext context) {
        return world.getName();
    }

    @NotNull
    @Override
    public World fromPrimitive(@NotNull String string, @NotNull PersistentDataAdapterContext context) {
        return Bukkit.getWorld(string);
    }
}
