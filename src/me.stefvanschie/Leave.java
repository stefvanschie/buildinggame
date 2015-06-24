package me.stefvanschie;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Leave
{
	public static void leaveGame(Player player)
	{
		if (player.hasPermission("leave"))
		{
			String worldstr = BuildingGame.main.arenas.getString("main-spawn.world");
			World world = BuildingGame.main.getServer().getWorld(worldstr);
			Location location = new Location(world, BuildingGame.main.arenas.getInt("main-spawn.x"), BuildingGame.main.arenas.getInt("main-spawn.y"), BuildingGame.main.arenas.getInt("main-spawn.z"));
			if (BuildingGame.main.players.containsKey(player))
			{
				BuildingGame.main.playersInArena.put(BuildingGame.main.players.get(player), BuildingGame.main.playersInArena.get(BuildingGame.main.players.get(player)) - 1);
				BuildingGame.main.players.remove(player);
				BuildingGame.main.playernumbers.remove(player);
				BuildingGame.main.votes.remove(player);
				player.teleport(location);
				player.sendMessage(ChatColor.GOLD + "You have left the game!");
				for (Player pl : BuildingGame.main.players.keySet())
				{
					if (BuildingGame.main.players.get(pl).equals(BuildingGame.main.players.get(player)))
					{
						pl.sendMessage(ChatColor.GOLD + "" + player.getName() + " has left the arena!");
					}
				}
			}
			else
			{
				player.sendMessage(ChatColor.GOLD + "You're not in a game!");
			}
		}
		else if (!player.hasPermission("leave"))
		{
			player.sendMessage(ChatColor.RED + "You don't have the required permission for that!");
		}
		else
		{
			player.sendMessage(ChatColor.RED + "An unexpected error occured: Error: bg.leave.permission");
		}
	}
}
