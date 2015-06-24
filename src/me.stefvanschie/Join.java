package me.stefvanschie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import me.stefvanschie.BuildingGame;

public class Join
{
	//public static Join join;
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
						player.sendMessage(ChatColor.GOLD + "You have joined the game");
						for (Player pl : BuildingGame.main.players.keySet())
						{
							if (BuildingGame.main.players.get(pl).equals(arena))
							{
								pl.sendMessage(ChatColor.GOLD + "" + player.getName() + " joined the game!");
							}
						}
						BuildingGame.main.playersInArena.put(arena, BuildingGame.main.playersInArena.get(arena) + 1);
						BuildingGame.main.players.put(player, arena);
						BuildingGame.main.votes.put(player, 0);
						if (BuildingGame.main.playersInArena.get(arena) == BuildingGame.main.arenas.getInt(arena + ".maxplayers"))
						{
							String subject = "";
							if (BuildingGame.main.config.contains("subjects"))
							{
								List<String> subjects = new ArrayList<String>(); 
								subjects = BuildingGame.main.config.getStringList("subjects");
								Random rndm = new Random();
									int subjectint = rndm.nextInt(subjects.size());
									subject = subjects.get(subjectint);
							}
							int places = 1;
							for (Player pl : BuildingGame.main.players.keySet())
							{
								if (BuildingGame.main.players.get(pl).equals(arena))
								{
									String worldstr = BuildingGame.main.arenas.getString(arena + "." + places + ".world");
									World world = BuildingGame.main.getServer().getWorld(worldstr);
									int x = BuildingGame.main.arenas.getInt(arena + "." + places + ".x");
									int y = BuildingGame.main.arenas.getInt(arena + "." + places + ".y");
									int z = BuildingGame.main.arenas.getInt(arena + "." + places + ".z");
									Location location = new Location(world, x, y, z);
									pl.teleport(location);
									pl.sendMessage(ChatColor.GOLD + "The game has started!");
									if (BuildingGame.main.config.contains("subjects"))
									{
										pl.sendMessage(ChatColor.GOLD + "The subject is " + subject);
									}
									BuildingGame.main.playernumbers.put(places, player);
									places++;
								}
							}
							BuildingGame.main.timer(arena);
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
				else if (!BuildingGame.main.config.contains(arena))
				{
				player.sendMessage(ChatColor.RED + "This arena does not exists!");
				}
				else
				{
				player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.join.config.contains");
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
			player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
		}
		else
		{
			player.sendMessage(ChatColor.RED + "An unexpected error occured: Error: bg.join.permission");
		}
	}
}
