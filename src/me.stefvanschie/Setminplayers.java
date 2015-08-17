package me.stefvanschie;

import org.bukkit.entity.Player;

public class Setminplayers
{
	public static void setminplayers(Player player, String arena, int minplayers)
	{
		BuildingGame.main.arenas.set(arena + ".minplayers", minplayers);
		BuildingGame.main.saveYamls();
		player.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("setMinPlayers.succes")
				.replaceAll("&", "§"));
	}
}
