package me.stefvanschie.listeners.blocks;

import java.util.HashMap;

import me.stefvanschie.BuildingGame;
import me.stefvanschie.FileCheck;
import me.stefvanschie.SetBounds;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class Bounds implements Listener {
	
	HashMap<Player, Location> locationByPlayer = new HashMap<Player, Location>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		if (SetBounds.getArenas().containsKey(player)) {
			
			String arena = SetBounds.getArena(player);
			int place = SetBounds.getPlace(player);

			player.sendMessage(ChatColor.GREEN + "You're editing");
			if (player.getItemInHand().getType() == Material.STICK) {
				player.sendMessage(ChatColor.GREEN + "You have a stick");
				if (player.getItemInHand().hasItemMeta()) {
					player.sendMessage(ChatColor.GREEN + "It has itemmeta");
					if (player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.LIGHT_PURPLE + "Wand")) {
						player.sendMessage(ChatColor.GREEN + "It has the correct name");
						if (locationByPlayer.containsKey(player)) {
							//second time
							player.sendMessage(ChatColor.GREEN + "You're doing this for the second time");
							
							Location previousLocation = locationByPlayer.get(player);
							Location location = e.getClickedBlock().getLocation();
							//world
							if (previousLocation.getWorld() == location.getWorld()) {
								BuildingGame.main.arenas.set(arena + "." + place + ".high.world", location.getWorld().getName());
								BuildingGame.main.arenas.set(arena + "." + place + ".low.world", previousLocation.getWorld().getName());
							} else {
								player.sendMessage(ChatColor.RED + "The world has to be the same");
							}
							//x
							if (previousLocation.getBlockX() < location.getBlockX()) {
								BuildingGame.main.arenas.set(arena + "." + place + ".high.x", location.getBlockX());
								BuildingGame.main.arenas.set(arena + "." + place + ".low.x", previousLocation.getBlockX());
							} else {
								BuildingGame.main.arenas.set(arena + "." + place + ".low.x", location.getBlockX());
								BuildingGame.main.arenas.set(arena + "." + place + ".high.x", previousLocation.getBlockX());
							}
							//y
							if (previousLocation.getBlockY() < location.getBlockY()) {
								BuildingGame.main.arenas.set(arena + "." + place + ".high.y", location.getBlockY());
								BuildingGame.main.arenas.set(arena + "." + place + ".low.y", previousLocation.getBlockY());
							} else {
								BuildingGame.main.arenas.set(arena + "." + place + ".low.y", location.getBlockY());
								BuildingGame.main.arenas.set(arena + "." + place + ".high.y", previousLocation.getBlockY());
							}
							//z
							if (previousLocation.getBlockZ() < location.getBlockZ()) {
								BuildingGame.main.arenas.set(arena + "." + place + ".high.z", location.getBlockZ());
								BuildingGame.main.arenas.set(arena + "." + place + ".low.z", previousLocation.getBlockZ());
							} else {
								BuildingGame.main.arenas.set(arena + "." + place + ".low.z", location.getBlockZ());
								BuildingGame.main.arenas.set(arena + "." + place + ".high.z", previousLocation.getBlockZ());
							}
							FileCheck.check("setBounds.succes", "&aBoundaries for plot %place% in arena %arena% set!", BuildingGame.main.messages, BuildingGame.main);
							player.sendMessage(BuildingGame.main.messages.getString("setBounds.succes")
									.replaceAll("%place%", place + "")
									.replaceAll("%arena%", arena + "")
									.replaceAll("&", "§"));
							
							SetBounds.getArenas().remove(player);
							SetBounds.getPlaces().remove(player);
							locationByPlayer.remove(player);
							BuildingGame.main.saveYamls();
							e.setCancelled(true);
						} else {
							//first time
							player.sendMessage(ChatColor.GREEN + "You're doing this for the first time");
							locationByPlayer.put(player, e.getClickedBlock().getLocation());
							player.sendMessage(ChatColor.GOLD + "Click the other corner of the plot");
							e.setCancelled(true);
						}	
					}
				}
			}
		}
	}
}
