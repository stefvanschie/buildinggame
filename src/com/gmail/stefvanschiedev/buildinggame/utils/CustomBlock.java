package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.Material;

public class CustomBlock {

	private byte data;
	private Material material;
	
	public CustomBlock(Material material) {
		this.material = material;
	}
	
	public CustomBlock(Material material, byte data) {
		this.material = material;
		this.data = data;
	}
	
	public byte getData() {
		return data;
	}
	
	public Material getMaterial() {
		return material;
	}
	
	public CustomBlock setData(byte data) {
		this.data = data;
		return this;
	}
	
	public CustomBlock setMaterial(Material material) {
		this.material = material;
		return this;
	}
}
