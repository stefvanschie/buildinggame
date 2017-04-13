package com.gmail.stefvanschiedev.buildinggame.managers.id;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.utils.ItemBuilder;

public final class IDDecompiler {
	
	private IDDecompiler() {}
	
	private static final IDDecompiler INSTANCE = new IDDecompiler();
	
	public static IDDecompiler getInstance() {
		return INSTANCE;
	}
	
	@SuppressWarnings("MethodMayBeStatic")
    public ItemBuilder decompile(Player player, CharSequence block) {
		Matcher matcher = Pattern.compile("([_a-zA-Z]+)([:][0-9]+)?").matcher(block);
		if (matcher.matches()) {
			return new ItemBuilder(player, Material.matchMaterial(matcher.group(1)), 1, 
					matcher.group(2) != null ? Short.parseShort(matcher.group(2).substring(1)) : 0);
		} else {
			Main.getInstance().getLogger().warning("Failed to load id '" + block + '\'');
			Main.getInstance().getLogger().warning("If you're sure all your ids are right, please contact the plugin developer");
			Main.getInstance().getLogger().warning("There will likely be a stracktrace due to this");
		}
		return null;
	}
	
	@SuppressWarnings("MethodMayBeStatic")
    public ItemStack decompile(CharSequence block) {
		Matcher matcher = Pattern.compile("([_a-zA-Z]+)([:][0-9]+)?").matcher(block);
		if (matcher.matches()) {
			return new ItemStack(Material.matchMaterial(matcher.group(1)), 1, 
					matcher.group(2) != null ? Short.parseShort(matcher.group(2).substring(1)) : 0);
		} else {
			Main.getInstance().getLogger().warning("Failed to load id '" + block + '\'');
			Main.getInstance().getLogger().warning("If you're sure all your ids are right, please contact the plugin developer");
			Main.getInstance().getLogger().warning("There will likely be a stracktrace due to this");
		}
		return null;
	}
	
	public boolean matches(CharSequence block, ItemStack item) {
		ItemStack itemStack = decompile(block);
		
		return itemStack.getType() == item.getType() && itemStack.getDurability() == item.getDurability();
	}
	
	@SuppressWarnings({"deprecation", "MethodMayBeStatic"})
	public boolean matches(CharSequence item, Block block) {
        Matcher matcher = Pattern.compile("([_a-zA-Z]+)([:][0-9]+)?").matcher(item);
        return matcher.matches() && Material.matchMaterial(matcher.group(1)) == block.getType() && (matcher.group(2) == null || Short.parseShort(matcher.group(2).substring(1)) == block.getData());
    }
}