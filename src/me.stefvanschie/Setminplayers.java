package me.stefvanschie;

import org.bukkit.entity.Player;

public class Setminplayers
{
	public static void setminplayers(Player player, String arena, int minplayers)
	{
		BuildingGame.main.arenas.set(arena + ".minplayers", minplayers);
		player.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("setminplayers.succes")
				.replaceAll("&", "§"));
	}
}
