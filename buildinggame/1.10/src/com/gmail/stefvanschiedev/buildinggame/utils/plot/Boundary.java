package com.gmail.stefvanschiedev.buildinggame.utils.plot;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;

public class Boundary {

	World world;
	int highX;
	int highY;
	int highZ;
	int lowX;
	int lowY;
	int lowZ;
	
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
		List<Block> blocks = new ArrayList<Block>();
		
		for (int x = lowX; x <= highX; x++) {
			for (int y = lowY; y <= highY; y++) {
				for (int z = lowZ; z <= highZ; z++) {
					blocks.add(world.getBlockAt(x, y, z));
				}
			}
		}
		return blocks;
	}
	
	public List<Chunk> getAllChunks() {
		List<Chunk> chunks = new ArrayList<Chunk>();
		
		for (Block block : getAllBlocks()) {
			if (!chunks.contains(block.getChunk())) {
				chunks.add(block.getChunk());
			}
		}
		
		return chunks;
	}
	
	public int getHighX() {
		return highX;
	}
	
	public int getHighY() {
		return highY;
	}
	
	public int getHighZ() {
		return highZ;
	}
	
	public int getLowX() {
		return lowX;
	}
	
	public int getLowY() {
		return lowY;
	}
	
	public int getLowZ() {
		return lowZ;
	}
	
	public World getWorld() {
		return world;
	}
	
	public boolean isInside(Location location) {
		if (location.getWorld() != getWorld()) {
			return false;
		}
		if (location.getBlockX() < getLowX() || location.getBlockX() > getHighX()) {
			return false;
		}
		if (location.getBlockY() < getLowY() || location.getBlockY() > getHighY()) {
			return false;
		}
		if (location.getBlockZ() < getLowZ() || location.getBlockZ() > getHighZ()) {
			return false;
		}
		
		return true;
	}
	
	public void setHighX(int highX) {
		this.highX = highX;
	}
	
	public void setHighY(int highY) {
		this.highY = highY;
	}
	
	public void setHighZ(int highZ) {
		this.highZ = highZ;
	}
	
	public void setLowX(int lowX) {
		this.lowX = lowX;
	}
	
	public void setLowY(int lowY) {
		this.lowY = lowY;
	}
	
	public void setLowZ(int lowZ) {
		this.lowZ = lowZ;
	}
	
	public void setWorld(World world) {
		this.world = world;
	}
}