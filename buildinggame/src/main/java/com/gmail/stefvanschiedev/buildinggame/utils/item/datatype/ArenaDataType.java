package com.gmail.stefvanschiedev.buildinggame.utils.item.datatype;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

/**
 * A persistent data type for storing {@link Arena}s.
 *
 * @since 11.0.1
 */
public final class ArenaDataType implements PersistentDataType<String, Arena> {

    /**
     * The sole instance of this class.
     */
    private static final ArenaDataType INSTANCE = new ArenaDataType();

    /**
     * A private constructor to prevent instantiation.
     *
     * @since 11.0.1
     */
    private ArenaDataType() {}

    /**
     * Gets the instance of this class.
     *
     * @return the instance
     * @since 11.0.1
     */
    public static ArenaDataType getInstance() {
        return INSTANCE;
    }

    @NotNull
    @Override
    public Class<String> getPrimitiveType() {
        return String.class;
    }

    @NotNull
    @Override
    public Class<Arena> getComplexType() {
        return Arena.class;
    }

    @NotNull
    @Override
    public String toPrimitive(@NotNull Arena arena, @NotNull PersistentDataAdapterContext context) {
        return arena.getName();
    }

    @NotNull
    @Override
    public Arena fromPrimitive(@NotNull String string, @NotNull PersistentDataAdapterContext context) {
        return ArenaManager.getInstance().getArena(string);
    }
}
