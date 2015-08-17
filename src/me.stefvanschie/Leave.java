package me.stefvanschie;

import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Leave
{
	public static void leaveGame(Player player)
	{
		if (player.hasPermission("bg.leave"))
		{
			String worldstr = BuildingGame.main.arenas.getString("main-spawn.world");
			World world = BuildingGame.main.getServer().getWorld(worldstr);
			Location location = new Location(world, BuildingGame.main.arenas.getInt("main-spawn.x"), BuildingGame.main.arenas.getInt("main-spawn.y"), BuildingGame.main.arenas.getInt("main-spawn.z"));
			if (BuildingGame.main.players.containsKey(player))
			{
				BuildingGame.main.playersInArena.put(BuildingGame.main.players.get(player), BuildingGame.main.playersInArena.get(BuildingGame.main.players.get(player)) - 1);
				if (BuildingGame.main.playersInArena.get(BuildingGame.main.players.get(player)) == 0) {
					GameStartCountdown.seconds = 0;
				}
				BuildingGame.main.players.remove(player);
				BuildingGame.main.playernumbers.remove(player);
				BuildingGame.main.votes.remove(player);
				player.teleport(location);
				player.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("leave.message")
						.replaceAll("&", "§"));
				for (Player pl : BuildingGame.main.players.keySet())
				{
					if (BuildingGame.main.players.get(pl).equals(BuildingGame.main.players.get(player)))
					{
						pl.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("leave.otherPlayers")
								.replace("%player%", pl.getName())
								.replaceAll("&", "§"));
					}
				}
				//update all signs
				SignUpdate.update();
				if (Bukkit.getPluginManager().isPluginEnabled("BarAPI")) {
					if (BarAPI.hasBar(player)) {
						BarAPI.removeBar(player);
					}
				}
			}
			else
			{
				player.sendMessage(ChatColor.GOLD + "You're not in a game!");
			}
		}
		else if (!player.hasPermission("bg.leave"))
		{
			player.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("global.permissionNode")
					.replaceAll("&", "§"));
		}
		else
		{
			player.sendMessage(ChatColor.RED + "An unexpected error occured: Error: bg.leave.permission");
		}
	}
}
