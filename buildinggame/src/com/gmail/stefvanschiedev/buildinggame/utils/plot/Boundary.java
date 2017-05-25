package com.gmail.stefvanschiedev.buildinggame.utils.plot;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.jetbrains.annotations.Contract;

public class Boundary {

	private final World world;
	private final int highX;
	private final int highY;
	private final int highZ;
	private final int lowX;
	private final int lowY;
	private final int lowZ;
	
	public Boundary(World world, int highX, int highY, int highZ, int lowX, int lowY, int lowZ) {
		this.world = world;
		this.highX = highX;
		this.highY = highY;
		this.highZ = highZ;
		this.lowX = lowX;
		this.lowY = lowY;
		this.lowZ = lowZ;
	}
	
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
	
	@Contract(pure = true)
    private int getHighX() {
		return highX;
	}
	
	@Contract(pure = true)
    private int getHighY() {
		return highY;
	}
	
	@Contract(pure = true)
    private int getHighZ() {
		return highZ;
	}
	
	@Contract(pure = true)
    private int getLowX() {
		return lowX;
	}
	
	@Contract(pure = true)
    private int getLowY() {
		return lowY;
	}
	
	@Contract(pure = true)
    private int getLowZ() {
		return lowZ;
	}
	
	@Contract(pure = true)
    private World getWorld() {
		return world;
	}
	
	public boolean isInside(Location location) {
        return location.getWorld().equals(getWorld()) && !(location.getBlockX() < getLowX() || location.getBlockX() > getHighX()) && !(location.getBlockY() < getLowY() || location.getBlockY() > getHighY()) && !(location.getBlockZ() < getLowZ() || location.getBlockZ() > getHighZ());
    }
}