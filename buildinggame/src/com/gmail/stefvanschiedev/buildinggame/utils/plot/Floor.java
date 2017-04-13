package com.gmail.stefvanschiedev.buildinggame.utils.plot;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.World;
import org.bukkit.block.Block;

public class Floor {

	private final World world;
	private final int highX;
	private final int highY;
	private final int highZ;
	private final int lowX;
	private final int lowY;
	private final int lowZ;
	
	public Floor(World world, int highX, int highY, int highZ, int lowX, int lowY, int lowZ) {
		this.world = world;
		this.highX = highX;
		this.highY = highY;
		this.highZ = highZ;
		this.lowX = lowX;
		this.lowY = lowY;
		this.lowZ = lowZ;
	}
	
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