package com.gmail.stefvanschiedev.buildinggame.utils.potential;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

/**
 * A location that may or may not exist at this moment. The location may not exist if the world in which it resides is
 * unloaded or deleted. If the world exists and is loaded, then this location also exists.
 *
 * @since 9.1.2
 */
public class PotentialLocation {

    /**
     * Supplies the world of this block position. While the supplier is always existent, the actual returned world may
     * not be.
     */
    @NotNull
    private final Supplier<World> worldSupplier;

    /**
     * The coordinates of the locationn
     */
    private final double x, y, z;

    /**
     * The rotation of the locationn
     */
    private final float yaw, pitch;

    /**
     * Creates a new potential location.
     *
     * @param worldSupplier the supplier for the world
     * @param x the x coordinate
     * @param y the y coordinate
     * @param z the z coordinate
     * @param yaw the yaw rotation
     * @param pitch the pitch rotation
     * @since 9.1.2
     */
    public PotentialLocation(@NotNull Supplier<World> worldSupplier, double x, double y, double z, float yaw,
                             float pitch) {
        this.worldSupplier = worldSupplier;
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    /**
     * Creates a new potential location based on the provided location.
     *
     * @param location the location to base this potential location of
     * @since 9.1.2
     */
    public PotentialLocation(@NotNull Location location) {
        this(() -> Bukkit.getWorld(location.getWorld().getName()), location.getX(), location.getY(), location.getZ(),
            location.getYaw(), location.getPitch());
    }

    /**
     * Teleports the given entity to the specified location if it exists. If the location does not exist, the entity
     * will be send a failure message and no teleportation will occur.
     *
     * @param entity the entity to teleport
     * @since 9.1.2
     */
    public void teleport(@NotNull Entity entity) {
        World world = worldSupplier.get();

        if (world == null) {
            entity.sendMessage(ChatColor.RED +
                "Unable to teleport you because the world can't be found. Is it perhaps unloaded?");
            return;
        }

        entity.teleport(new Location(world, x, y, z, yaw, pitch), PlayerTeleportEvent.TeleportCause.PLUGIN);
    }

    /**
     * Gets the world this location represents or null if the world is not found.
     *
     * @return the world
     * @since 9.1.2
     */
    @Nullable
    @Contract(pure = true)
    public World getWorld() {
        return worldSupplier.get();
    }

    /**
     * Gets the x coordinate of this location.
     *
     * @return the x coordinate
     * @since 9.1.2
     */
    @Contract(pure = true)
    public double getX() {
        return x;
    }

    /**
     * Gets the x coordinate of this location.
     *
     * @return the x coordinate
     * @since 9.1.2
     */
    @Contract(pure = true)
    public double getY() {
        return y;
    }

    /**
     * Gets the x coordinate of this location.
     *
     * @return the x coordinate
     * @since 9.1.2
     */
    @Contract(pure = true)
    public double getZ() {
        return z;
    }
}
