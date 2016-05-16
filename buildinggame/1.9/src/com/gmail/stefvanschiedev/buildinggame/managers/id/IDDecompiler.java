package com.gmail.stefvanschiedev.buildinggame.managers.id;

import org.bukkit.Material;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.CustomBlock;

public class IDDecompiler {
	
	private IDDecompiler() {}
	
	private static IDDecompiler instance = new IDDecompiler();
	
	public static IDDecompiler getInstance() {
		return instance;
	}
	
	public CustomBlock decompile(String block) {
		String[] strings = block.split(":");
		try {
			if (strings.length == 1) {
				return new CustomBlock(Material.getMaterial(strings[0].toUpperCase()), (byte) 0);
			} else if (strings.length == 2) {
				return new CustomBlock(Material.getMaterial(strings[0].toUpperCase()), Byte.parseByte(strings[1]));
			}
		} catch (NullPointerException npe) {
			Main.getInstance().getLogger().warning("Failed to load id '" + block + "'");
			Main.getInstance().getLogger().warning("Stacktrace down below:");
			npe.printStackTrace();
			Main.getInstance().getLogger().warning("If you're sure all your ids are right, please contact the plugin developer and show him the stacktrace");
		}
		return null;
	}
}
