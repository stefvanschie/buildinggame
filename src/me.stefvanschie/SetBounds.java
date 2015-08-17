package me.stefvanschie;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SetBounds {

	static HashMap<Player, String> arenas = new HashMap<Player, String>();
	static HashMap<Player, Integer> places = new HashMap<Player, Integer>();
	
	public static void set(int place, String arena, Player player) {
		if (arenas.containsKey(player) || places.containsKey(player)) {
			player.sendMessage(ChatColor.RED + "You are already editing a plot");
			return;
		}
		player.sendMessage(ChatColor.GOLD + "Please click on one corner with your stick");
		
		ItemStack item = new ItemStack(Material.STICK, 1);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Wand");
		item.setItemMeta(meta);
		
		player.getInventory().addItem(item);
		arenas.put(player, arena);
		places.put(player, place);
	}
	
	public static HashMap<Player, String> getArenas() {
		return arenas;
	}

	public static String getArena(Player player) {
		return arenas.get(player);
	}
	
	public static void setArenas(HashMap<Player, String> newArenas) {
		arenas = newArenas;
	}
	
	public static HashMap<Player, Integer> getPlaces() {
		return places;
	}
	
	public static int getPlace(Player player) {
		return places.get(player);
	}
	
	public static void setPlaces(HashMap<Player, Integer> newPlaces) {
		places = newPlaces;
	}
}
