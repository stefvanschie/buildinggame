package com.gmail.stefvanschiedev.buildinggame.events.bungeecord;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import fr.rhaz.socket4mc.Bukkit.BukkitSocketJSONEvent;

public class ReceiveMessage implements Listener {

	@EventHandler
	public void onBukkitSocketJSON(BukkitSocketJSONEvent e) {
		if (!e.getChannel().equals("BuildingGame"))
			return;
		
		String rawData = e.getData();
		if (rawData.startsWith("teleport:")) {
			String[] newData = rawData.replace("teleport:", "").trim().split(", ");
			
			Player player = Bukkit.getPlayer(newData[0]);
			if (player == null)
				return;
			World world = Bukkit.getWorld(newData[1]);
			if (world == null)
				return;
			
			player.teleport(new Location(world, Integer.parseInt(newData[2]), Integer.parseInt(newData[3]), Integer.parseInt(newData[4])));
		}
	}
}
