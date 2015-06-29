package me.stefvanschie;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Setminplayers
{
	public static void setminplayers(Player player, String arena, int minplayers)
	{
		BuildingGame.main.arenas.set(arena + ".minplayers", minplayers);
		player.sendMessage(ChatColor.GREEN + "Minimal amount of players set!");
	}
}
