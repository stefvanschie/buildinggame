package me.stefvanschie;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Vote {
	
	@SuppressWarnings("deprecation")
	public static void vote(Player player, int points) {
		if (player.hasPermission("bg.vote")) {
			if (BuildingGame.main.players.containsKey(player)) {
				if (points >= 1 && points <= 10) {
					if (BuildingGame.main.playernumbers.get(BuildingGame.main.place) != player) {
						Player pl = BuildingGame.main.playernumbers.get(BuildingGame.main.place);
						if (BuildingGame.main.playervotes.containsKey(player)) {
							int previousPoints = BuildingGame.main.playervotes.get(player);
							BuildingGame.main.votes.put(pl, points + BuildingGame.main.votes.get(pl) - previousPoints);
							BuildingGame.main.playervotes.put(player, points);
						} else {
							BuildingGame.main.votes.put(pl, points + BuildingGame.main.votes.get(pl));
							BuildingGame.main.playervotes.put(player, points);
						}
						//scoreboard
						BuildingGame.main.score = BuildingGame.main.objective.getScore(BuildingGame.main.playernumbers.get(BuildingGame.main.place));
						BuildingGame.main.score.setScore(BuildingGame.main.votes.get(BuildingGame.main.playernumbers.get(BuildingGame.main.place)));
						//message
						player.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("vote.message")
								.replace("%playerplot%", BuildingGame.main.playernumbers.get(BuildingGame.main.place).getName() + "")
								.replace("%points%", points + "")
								.replaceAll("&", "§"));
					} else if (BuildingGame.main.playernumbers.get(BuildingGame.main.place) == player) {
						player.sendMessage(ChatColor.RED + "You can't vote on your own plot");
					} else {
						player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.Vote.vote.playernumbers.get");
					}
				} else if (!(points >= 1 && points <= 10)) {
					player.sendMessage(ChatColor.RED + "Choose a number between 1 and 10");
				} else {
					player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.vote.number");
				}
			} else if (!BuildingGame.main.players.containsKey(player)) {
				player.sendMessage(ChatColor.RED + "You're not in a game");
			} else {
				player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.vote.cotains");
			}
		} else if (!player.hasPermission("bg.vote")) {
			player.sendMessage(BuildingGame.main.messages.getString("global.prefix").replaceAll("&", "§") + BuildingGame.main.messages.getString("global.permissionNode").replaceAll("&", "§"));
		} else {
			player.sendMessage(ChatColor.RED + "An unexpected error occured. Error: bg.vote.permission");
		}
	}
}
