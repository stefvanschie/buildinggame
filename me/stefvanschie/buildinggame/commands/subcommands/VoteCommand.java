package me.stefvanschie.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.GameState;
import me.stefvanschie.buildinggame.utils.Plot;
import me.stefvanschie.buildinggame.utils.Vote;

public class VoteCommand extends SubCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the amount of points");
			return CommandResult.ERROR;
		}
		
		try {
			Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid number");
			return CommandResult.ERROR;
		}
		
		int points = Integer.parseInt(args[0]);
		
		if (points < 1 || points > 10) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Points can only be between 1 and 10");
			return CommandResult.ERROR;
		}
		
		Vote vote = new Vote(points, player);
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're not in an arena");
			return CommandResult.ERROR;
		}
		
		if (arena.getState() != GameState.VOTING) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You can't vote at this moment");
			return CommandResult.ERROR;
		}
		
		Plot plot = arena.getVotingPlot();
		
		plot.addVote(vote);
		MessageManager.getInstance().send(player, messages.getString("vote.message")
				.replace("%playerplot%", plot.getPlayerData().getPlayer().getName())
				.replace("%points%", points + "")
				.replaceAll("&", "§"));
		return null;
	}

	@Override
	public String getName() {
		return "vote";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Vote on someone's plot";
	}

	@Override
	public String getPermission() {
		return "bg.vote";
	}

}
