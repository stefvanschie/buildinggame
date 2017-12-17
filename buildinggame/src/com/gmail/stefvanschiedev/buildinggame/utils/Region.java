package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * A class which marks points for a three dimensional cuboid
 *
 * @since 5.0.5
 */
public class Region {

    /**
     * The world this region is located in
     */
    private final World world;

    /**
     * The high point x coordinate
     */
    private final int highX;

    /**
     * The high point y coordinate
     */
    private final int highY;

    /**
     * The high point z coordinate
     */
    private final int highZ;

    /**
     * The low point x coordinate
     */
    private final int lowX;

    /**
     * The low point y coordinate
     */
    private final int lowY;

    /**
     * The low point z coordinate
     */
    private final int lowZ;

    /**
     * Constructs a new region
     *
     * @param world the world this region is located in
     * @param highX the high point x coordinate
     * @param highY the high point y coordinate
     * @param highZ the high point z coordinate
     * @param lowX the low point x coordinate
     * @param lowY the low point y coordinate
     * @param lowZ the low point z coordinate
     */
    public Region(World world, int highX, int highY, int highZ, int lowX, int lowY, int lowZ) {
        this.world = world;
        this.highX = highX;
        this.highY = highY;
        this.highZ = highZ;
        this.lowX = lowX;
        this.lowY = lowY;
        this.lowZ = lowZ;
    }

    /**
     * Returns a list of all blocks inside the region
     *
     * @return all blocks inside the region
     * @since 5.0.5
     */
    @NotNull
    @Contract(pure = true)
    public List<Block> getAllBlocks() {
        List<Block> blocks = new ArrayList<>();

        for (int x = lowX; x <= highX; x++) {
            for (int y = lowY; y <= highY; y++) {
                for (int z = lowZ; z <= highZ; z++) {
                    blocks.add(world.getBlockAt(x, y, z));
                }
            }
        }
        return blocks;
    }

    /**
     * Returns the center location of this region
     *
     * @return the center
     * @since 5.0.5
     */
    @NotNull
    @Contract(pure = true)
    public Location getCenter() {
        return new Location(world, lowX + (highX - lowX / 2.0), lowY + (highY - lowY / 2.0),
                lowZ  + (highZ - lowZ / 2.0));
    }

    /**
     * Returns every single chunk that is (partially) inside this region
     *
     * @return the chunks inside this region
     * @since 5.2.0
     */
    @NotNull
    @Contract(pure = true)
    public Iterable<Chunk> getChunks() {
        Collection<Chunk> chunks = new HashSet<>();

        getAllBlocks().forEach(block -> chunks.add(block.getChunk()));

        return chunks;
    }

    /**
     * Returns a location that is safe for a player. This includes both blocks being inside the region and being fully
     * transparent. When no space inside a plot is safe this will return null.
     *
     * @return a safe location inside the region or null if there's no safe spot
     * @since 5.0.5
     */
    @Nullable
    @Contract(pure = true)
    public Location getSafeLocation() {
        Location loc = new Location(world, highX, highY - 1, highZ);

        for (int xOffset = 0; xOffset < highX - lowX; xOffset++) {
            for (int yOffset = 0; yOffset < highY - lowY - 1; yOffset++) {
                for (int zOffset = 0; zOffset < highZ - lowZ; zOffset++) {
                    Location newLoc = loc.clone().subtract(xOffset, yOffset, zOffset);
                    Block newBlock = newLoc.getBlock();

                    if (newBlock.getType().isTransparent() &&
                            newBlock.getRelative(BlockFace.UP).getType().isTransparent())
                        return newLoc;
                }
            }
        }

        return null;
    }

    /**
     * Returns whether the location is inside the region or not
     *
     * @param location the location to test for
     * @return true if the location is inside, false otherwise
     * @since 5.0.5
     */
    @Contract(pure = true)
    public boolean isInside(Location location) {
        return location.getWorld().equals(world) && !(location.getBlockX() < lowX || location.getBlockX() > highX) &&
                !(location.getBlockY() < lowY || location.getBlockY() > highY) &&
                !(location.getBlockZ() < lowZ || location.getBlockZ() > highZ);
    }
}