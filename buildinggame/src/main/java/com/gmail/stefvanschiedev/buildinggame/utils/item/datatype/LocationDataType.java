package com.gmail.stefvanschiedev.buildinggame.utils.item.datatype;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

/**
 * A persistent data type for storing {@link Location}s.
 *
 * @since 11.0.1
 */
public final class LocationDataType implements PersistentDataType<PersistentDataContainer, Location> {

    /**
     * The key to store the world under.
     */
    private static final NamespacedKey WORLD_KEY = new NamespacedKey(Main.getInstance(), "world");

    /**
     * The key to store the x coordinate under.
     */
    private static final NamespacedKey X_KEY = new NamespacedKey(Main.getInstance(), "x");

    /**
     * The key to store the y coordinate under.
     */
    private static final NamespacedKey Y_KEY = new NamespacedKey(Main.getInstance(), "y");

    /**
     * The key to store the z coordinate under.
     */
    private static final NamespacedKey Z_KEY = new NamespacedKey(Main.getInstance(), "z");

    /**
     * The key to store the yaw under.
     */
    private static final NamespacedKey YAW_KEY = new NamespacedKey(Main.getInstance(), "yaw");

    /**
     * The key to store the pitch under.
     */
    private static final NamespacedKey PITCH_KEY = new NamespacedKey(Main.getInstance(), "pitch");

    /**
     * The sole instance of this class.
     */
    private static final LocationDataType INSTANCE = new LocationDataType();

    /**
     * A private constructor to prevent instantiation.
     *
     * @since 11.0.1
     */
    private LocationDataType() {}

    /**
     * Gets the instance of this class.
     *
     * @return the instance
     * @since 11.0.1
     */
    public static LocationDataType getInstance() {
        return INSTANCE;
    }

    @NotNull
    @Override
    public Class<PersistentDataContainer> getPrimitiveType() {
        return PersistentDataContainer.class;
    }

    @NotNull
    @Override
    public Class<Location> getComplexType() {
        return Location.class;
    }

    @NotNull
    @Override
    public PersistentDataContainer toPrimitive(@NotNull Location location, @NotNull PersistentDataAdapterContext context) {
        PersistentDataContainer container = context.newPersistentDataContainer();

        container.set(WORLD_KEY, WorldDataType.getInstance(), location.getWorld());
        container.set(X_KEY, PersistentDataType.DOUBLE, location.getX());
        container.set(Y_KEY, PersistentDataType.DOUBLE, location.getY());
        container.set(Z_KEY, PersistentDataType.DOUBLE, location.getZ());
        container.set(YAW_KEY, PersistentDataType.FLOAT, location.getYaw());
        container.set(PITCH_KEY, PersistentDataType.FLOAT, location.getPitch());

        return container;
    }

    @NotNull
    @Override
    public Location fromPrimitive(@NotNull PersistentDataContainer container, @NotNull PersistentDataAdapterContext context) {
        World world = container.get(WORLD_KEY, WorldDataType.getInstance());
        double x = container.get(X_KEY, PersistentDataType.DOUBLE);
        double y = container.get(Y_KEY, PersistentDataType.DOUBLE);
        double z = container.get(Z_KEY, PersistentDataType.DOUBLE);
        float yaw = container.get(YAW_KEY, PersistentDataType.FLOAT);
        float pitch = container.get(PITCH_KEY, PersistentDataType.FLOAT);

        return new Location(world, x, y, z, yaw, pitch);
    }
}
