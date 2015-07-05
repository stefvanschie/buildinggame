package me.stefvanschie;

import org.bukkit.entity.Player;

public class Setlobby
{
	public static void setlobby (Player player, String arena)
	{
		BuildingGame.main.arenas.set(arena + ".lobby.world", player.getLocation().getWorld().getName());
		BuildingGame.main.arenas.set(arena + ".lobby.x", player.getLocation().getBlockX());
		BuildingGame.main.arenas.set(arena + ".lobby.y", player.getLocation().getBlockY());
		BuildingGame.main.arenas.set(arena + ".lobby.z", player.getLocation().getBlockZ());
		player.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("setLobby.succes")
				.replaceAll("&", "§"));
	}
}
