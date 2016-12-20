package com.gmail.stefvanschiedev.buildinggame.managers.id;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.Main;

public class IDDecompiler {
	
	private IDDecompiler() {}
	
	private static IDDecompiler instance = new IDDecompiler();
	
	public static IDDecompiler getInstance() {
		return instance;
	}
	
	public ItemStack decompile(String block) {
		Matcher matcher = Pattern.compile("([_a-zA-Z]+)([:][0-9]+)?").matcher(block);
		if (matcher.matches()) {
			return new ItemStack(Material.matchMaterial(matcher.group(1)), 1,  
					matcher.group(2) != null ? Short.parseShort(matcher.group(2).substring(1)) : 0);
		} else {
			Main.getInstance().getLogger().warning("Failed to load id '" + block + "'");
			Main.getInstance().getLogger().warning("If you're sure all your ids are right, please contact the plugin developer");
			Main.getInstance().getLogger().warning("There will likely be a stracktrace due to this");
		}
		return null;
	}
	
	public boolean matches(String block, ItemStack item) {
		ItemStack itemStack = decompile(block);
		
		return itemStack.getType() == item.getType() && itemStack.getDurability() == item.getDurability();
	}
	
	@SuppressWarnings("deprecation")
	public boolean matches(String item, Block block) {
		Matcher matcher = Pattern.compile("([_a-zA-Z]+)([:][0-9]+)?").matcher(item);
		if (matcher.matches()) {
			if (Material.matchMaterial(matcher.group(1)) == block.getType()) {
				if (matcher.group(2) != null) {
					if (Short.parseShort(matcher.group(2).substring(1)) == block.getData())
						return true;
					else
						return false;
				} else
					return true;
			} else
				return false;
		} else
			return false;
	}
}
