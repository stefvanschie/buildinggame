package com.gmail.stefvanschiedev.buildinggame.utils.region;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * A factory for creating regions.
 *
 * @since 7.0.0
 */
public final class RegionFactory {

    /**
     * Creates a region from the given parameters. If WorldEdit is enabled, this will be a {@link WorldEditRegion},
     * otherwise a {@link Region}.
     *
     * @param world the world this region resides ion
     * @param highX the high x coordinate
     * @param highY the high y coordinate
     * @param highZ the high z coordinate
     * @param lowX the low x coordinate
     * @param lowY the low y coordinate
     * @param lowZ the low z coordinate
     * @return the created region
     * @since 7.0.0
     */
    public static Region createRegion(@NotNull Supplier<World> world, int highX, int highY, int highZ, int lowX,
                                      int lowY, int lowZ) {
        //noinspection IfMayBeConditional
        if (Bukkit.getPluginManager().isPluginEnabled("WorldEdit")) {
            return new WorldEditRegion(world, highX, highY, highZ, lowX, lowY, lowZ);
        } else {
            return new Region(world, highX, highY, highZ, lowX, lowY, lowZ);
        }
    }

    private RegionFactory() {}
}
