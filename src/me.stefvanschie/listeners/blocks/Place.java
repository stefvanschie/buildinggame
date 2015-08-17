package me.stefvanschie.listeners.blocks;

import java.util.Map.Entry;

import me.stefvanschie.BuildingGame;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Place implements Listener {
	
	@EventHandler
	public void onBlockPlace (BlockPlaceEvent e) {
		String arena = BuildingGame.main.players.get(e.getPlayer());
		int place = 0;
		Player player = e.getPlayer();
		
		for (Entry<Integer, Player> entry : BuildingGame.main.playernumbers.entrySet()) {
			if (entry.getValue() == player) {
				place = entry.getKey();
			}
		}
		
		Block block = e.getBlock();
		Location location = block.getLocation();
		World world = location.getWorld();
		int x = location.getBlockX();
		int y = location.getBlockY();
		int z = location.getBlockZ();
		
		try {
			if (world == Bukkit.getWorld(BuildingGame.main.arenas.getString(arena + "." + place + "." + ".low.world"))) {
				
			} else {
				player.sendMessage(ChatColor.RED + "You can't build here!");
				e.setCancelled(true);
			}
			if (x >= BuildingGame.main.arenas.getInt(arena + "." + place + ".low.x") && x <= BuildingGame.main.arenas.getInt(arena + "." + place + ".high.x")) {
			
			} else {
				player.sendMessage(ChatColor.RED + "You can't build here!");
				e.setCancelled(true);
			}
			if (y >= BuildingGame.main.arenas.getInt(arena + "." + place + ".low.y") && y <= BuildingGame.main.arenas.getInt(arena + "." + place + ".high.y")) {
				
			} else {
				player.sendMessage(ChatColor.RED + "You can't build here!");
				e.setCancelled(true);
			}
			if (z >= BuildingGame.main.arenas.getInt(arena + "." + place + ".low.z") && z <= BuildingGame.main.arenas.getInt(arena + "." + place + ".high.z")) {
				
			} else {
				player.sendMessage(ChatColor.RED + "You can't build here!");
				e.setCancelled(true);
			}
		} catch (Exception exception) {
			//if the place isn't initialized, otherwise players would get an error when they place a block
		}
	}

}
