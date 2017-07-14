package com.gmail.stefvanschiedev.buildinggame.utils.plot;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * A class for marking the floor for a plot
 *
 * @since 2.1.0
 */
public class Floor {

    /**
     * The world the floor is located in
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
     * Constructs a new Floor
     *
     * @param world the world this floor is located in
     * @param highX the high point x coordinate
     * @param highY the high point y coordinate
     * @param highZ the high point z coordinate
     * @param lowX the low point x coordinate
     * @param lowY the low point y coordinate
     * @param lowZ the low point z coordinate
     */
	public Floor(World world, int highX, int highY, int highZ, int lowX, int lowY, int lowZ) {
		this.world = world;
		this.highX = highX;
		this.highY = highY;
		this.highZ = highZ;
		this.lowX = lowX;
		this.lowY = lowY;
		this.lowZ = lowZ;
	}

	/**
     * Returns an iterable of all blocks inside the floor
     *
     * @return all blocks inside the floor
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
	public Iterable<Block> getAllBlocks() {
		Collection<Block> blocks = new ArrayList<>();
		
		for (int x = lowX; x <= highX; x++) {
			for (int y = lowY; y <= highY; y++) {
				for (int z = lowZ; z <= highZ; z++) {
					blocks.add(world.getBlockAt(x, y, z));
				}
			}
		}
		return blocks;
	}
}