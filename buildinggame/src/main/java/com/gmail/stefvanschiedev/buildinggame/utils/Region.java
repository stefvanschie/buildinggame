package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.utils.worldedit.WorldBackedClipboard;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.extent.clipboard.io.BuiltInClipboardFormat;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldedit.regions.CuboidRegion;
import com.sk89q.worldedit.util.io.Closer;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     * Saves this region to a schematic file. This will do nothing if WorldEdit is not enabled. This should be called
     * async.
     *
     * @param file the file to save the schematic to
     * @since 6.5.0
     */
    public void saveSchematic(@NotNull File file) throws IOException {
        if (!Bukkit.getPluginManager().isPluginEnabled("WorldEdit")) {
            return;
        }

        try (var closer = Closer.create()) {
            var fileOutputStream = closer.register(new FileOutputStream(file));
            var bufferedOutputStream = closer.register(new BufferedOutputStream(fileOutputStream));
            var builtInClipboardFormat = BuiltInClipboardFormat.SPONGE_SCHEMATIC;
            var clipboardWriter = builtInClipboardFormat.getWriter(bufferedOutputStream);

            var lowVector = BlockVector3.at(getLowX(), getLowY(), getLowZ());
            var highVector = BlockVector3.at(getHighX(), getHighY(), getHighZ());
            var bukkitWorld = new BukkitWorld(getWorld());

            var cuboidRegion = new CuboidRegion(bukkitWorld, lowVector, highVector);
            var blockArrayClipboard = new WorldBackedClipboard(cuboidRegion);

            closer.register(clipboardWriter).write(blockArrayClipboard);
        }
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

        for (var x = lowX; x <= highX; x++) {
            for (var y = lowY; y <= highY; y++) {
                for (var z = lowZ; z <= highZ; z++)
                    blocks.add(world.getBlockAt(x, y, z));
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
        return getAllBlocks().stream().map(Block::getChunk).collect(Collectors.toSet());
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

        for (var xOffset = 0; xOffset < highX - lowX; xOffset++) {
            for (var yOffset = 0; yOffset < highY - lowY - 1; yOffset++) {
                for (var zOffset = 0; zOffset < highZ - lowZ; zOffset++) {
                    Location newLoc = loc.clone().subtract(xOffset, yOffset, zOffset);
                    var newBlock = newLoc.getBlock();

                    if (!newBlock.getType().isSolid() && !newBlock.getRelative(BlockFace.UP).getType().isSolid())
                        return newLoc;
                }
            }
        }

        return null;
    }

    /**
     * Returns the world this region is in
     *
     * @return the world
     * @since 5.5.0
     */
    @NotNull
    @Contract(pure = true)
    public World getWorld() {
        return world;
    }

    /**
     * Returns the lowest x coordinate
     *
     * @return the lowest x coordinate
     * @since 5.5.0
     */
    @Contract(pure = true)
    private int getLowX() {
        return lowX;
    }

    /**
     * Returns the lowest y coordinate
     *
     * @return the lowest y coordinate
     * @since 5.5.0
     */
    @Contract(pure = true)
    private int getLowY() {
        return lowY;
    }

    /**
     * Returns the lowest z coordinate
     *
     * @return the lowest z coordinate
     * @since 5.5.0
     */
    @Contract(pure = true)
    private int getLowZ() {
        return lowZ;
    }

    /**
     * Returns the highest x coordinate
     *
     * @return the highest x coordinate
     * @since 5.5.0
     */
    @Contract(pure = true)
    private int getHighX() {
        return highX;
    }

    /**
     * Returns the highest y coordinate
     *
     * @return the highest y coordinate
     * @since 5.5.0
     */
    @Contract(pure = true)
    private int getHighY() {
        return highY;
    }

    /**
     * Returns the highest z coordinate
     *
     * @return the highest z coordinate
     * @since 5.5.0
     */
    @Contract(pure = true)
    private int getHighZ() {
        return highZ;
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