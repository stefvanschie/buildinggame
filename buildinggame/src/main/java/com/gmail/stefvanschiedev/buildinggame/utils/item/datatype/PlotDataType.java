package com.gmail.stefvanschiedev.buildinggame.utils.item.datatype;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

/**
 * A persistent data type for storing {@link Plot}s.
 *
 * @since 11.0.1
 */
public final class PlotDataType implements PersistentDataType<PersistentDataContainer, Plot> {

    /**
     * The key to store the plot id under.
     */
    private static final NamespacedKey ID_KEY = new NamespacedKey(Main.getInstance(), "id");

    /**
     * The key to store the arena under.
     */
    private static final NamespacedKey ARENA_KEY = new NamespacedKey(Main.getInstance(), "arena");

    /**
     * The sole instance of this class.
     */
    private static final PlotDataType INSTANCE = new PlotDataType();

    /**
     * A private constructor to prevent instantiation.
     */
    private PlotDataType() {}

    /**
     * Gets the instance of this class.
     *
     * @return the instance
     * @since 11.0.1
     */
    public static PlotDataType getInstance() {
        return INSTANCE;
    }

    @NotNull
    @Override
    public Class<PersistentDataContainer> getPrimitiveType() {
        return PersistentDataContainer.class;
    }

    @NotNull
    @Override
    public Class<Plot> getComplexType() {
        return Plot.class;
    }

    @NotNull
    @Override
    public PersistentDataContainer toPrimitive(@NotNull Plot plot, @NotNull PersistentDataAdapterContext context) {
        PersistentDataContainer container = context.newPersistentDataContainer();

        container.set(ID_KEY, PersistentDataType.INTEGER, plot.getId());
        container.set(ARENA_KEY, ArenaDataType.getInstance(), plot.getArena());

        return container;
    }

    @NotNull
    @Override
    public Plot fromPrimitive(@NotNull PersistentDataContainer container, @NotNull PersistentDataAdapterContext context) {
        int id = container.get(ID_KEY, PersistentDataType.INTEGER);
        Arena arena = container.get(ARENA_KEY, ArenaDataType.getInstance());

        return arena.getPlot(id);
    }
}
