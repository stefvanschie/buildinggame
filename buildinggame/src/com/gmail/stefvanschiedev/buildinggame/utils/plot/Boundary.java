package com.gmail.stefvanschiedev.buildinggame.utils.plot;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A class for marking the boundary for plots
 *
 * @since 2.1.0
 */
public class Boundary {

    /**
     * The world this boundary is located in
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
     * Constructs a new Boundary
     *
     * @param world the world this boundary is located in
     * @param highX the high point x coordinate
     * @param highY the high point y coordinate
     * @param highZ the high point z coordinate
     * @param lowX the low point x coordinate
     * @param lowY the low point y coordinate
     * @param lowZ the low point z coordinate
     */
	public Boundary(World world, int highX, int highY, int highZ, int lowX, int lowY, int lowZ) {
		this.world = world;
		this.highX = highX;
		this.highY = highY;
		this.highZ = highZ;
		this.lowX = lowX;
		this.lowY = lowY;
		this.lowZ = lowZ;
	}

	/**
     * Returns a list of all blocks inside the boundary
     *
     * @return all blocks inside the boundary
     * @since 2.1.0
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
     * Returns the center location of this boundary
     *
     * @return the center
     */
    @NotNull
    @Contract(pure = true)
	public Location getCenter() {
	    return new Location(world, lowX + ((highX - lowX) / 2.0), lowY + ((highY - lowY) / 2.0),
                lowZ  + ((highZ - lowZ) / 2.0));
    }

    /**
     * Returns a location that is safe for a player. This includes both blocks being inside the boundary and being fully
     * transparent. When no space inside a plot is safe this will return null.
     *
     * @return a safe location inside the boundary or null if there's no safe spot
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
     * Returns whether the location is inside the boundary or not
     *
     * @param location the location to test for
     * @return true if the location is inside, false otherwise
     * @since 2.1.0
     */
	@Contract(pure = true)
	public boolean isInside(Location location) {
        return location.getWorld().equals(world) && !(location.getBlockX() < lowX || location.getBlockX() > highX) &&
                !(location.getBlockY() < lowY || location.getBlockY() > highY) &&
                !(location.getBlockZ() < lowZ || location.getBlockZ() > highZ);
    }
}