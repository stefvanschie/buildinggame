package me.stefvanschie;


import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import me.stefvanschie.BuildingGame;

public class Join
{
	public static void joinGame (Player player, String arena)
	{
		if (player.hasPermission("join"))
		{
			if (!BuildingGame.main.players.containsKey(player))
			{
				if (BuildingGame.main.arenas.contains(arena))
				{
					if (!BuildingGame.main.playersInArena.containsKey(arena))
					{
						BuildingGame.main.playersInArena.put(arena, 0);
					}
					if (BuildingGame.main.playersInArena.get(arena) < BuildingGame.main.arenas.getInt(arena + ".maxplayers"))
					{
						World lobbyworld = BuildingGame.main.getServer().getWorld(BuildingGame.main.arenas.getString(arena + ".lobby.world"));
						Location lobbylocation = new Location(lobbyworld, BuildingGame.main.arenas.getInt(arena + ".lobby.x"), BuildingGame.main.arenas.getInt(arena + ".lobby.y"), BuildingGame.main.arenas.getInt(arena + ".lobby.z"));
						player.teleport(lobbylocation);
						player.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("join.message")
								.replaceAll("&", "§"));
						for (Player pl : BuildingGame.main.players.keySet())
						{
							if (BuildingGame.main.players.get(pl).equals(arena))
							{
								pl.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("join.otherPlayers")
										.replace("%player%", player.getName())
										.replaceAll("&", "§"));
							}
						}
						BuildingGame.main.playersInArena.put(arena, BuildingGame.main.playersInArena.get(arena) + 1);
						BuildingGame.main.players.put(player, arena);
						BuildingGame.main.votes.put(player, 0);
						
						//update all signs
						SignUpdate.update();
						
						if (BuildingGame.main.playersInArena.get(arena) == BuildingGame.main.arenas.getInt(arena + ".minplayers"))
						{
							GameStartCountdown.gamestartcountdown(arena);
						}
						if (BuildingGame.main.playersInArena.get(arena) == BuildingGame.main.arenas.getInt(arena + ".maxplayers"))
						{
							GameStartCountdown.seconds = 0;
						}
					}
					else if (BuildingGame.main.playersInArena.get(arena) >= BuildingGame.main.config.getInt(arena + ".maxplayers"))
					{
						player.sendMessage(ChatColor.RED + "This arena is currently full");
					}
					else
					{
						player.sendMessage(ChatColor.RED + "An unexpected error occured: Error: bg.join.playersingame");
					}
				}
				else if (!BuildingGame.main.arenas.contains(arena))
				{
					player.sendMessage(ChatColor.RED + "This arena does not exists!");
				}
				else
				{
					player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.join.arenas.contains");
				}
			}
			else if (BuildingGame.main.players.containsKey(player))
			{
				player.sendMessage(ChatColor.RED + "You're already in a game!");
			}
			else
			{
				player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.join.joinGame.BuildingGame.main.players.containskey");
			}
		}
		else if (!player.hasPermission("join"))
		{
			player.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("global.permissionNode")
					.replaceAll("&", "§"));
		}
		else
		{
			player.sendMessage(ChatColor.RED + "An unexpected error occured: Error: bg.join.permission");
		}
	}
}
