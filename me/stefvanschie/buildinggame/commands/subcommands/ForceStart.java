package me.stefvanschie.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.GameState;

public class ForceStart extends SubCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		if (ArenaManager.getInstance().getArena(player) != null) {
			Arena arena = ArenaManager.getInstance().getArena(player);
			arena.getWaitTimer().setSeconds(0);
			return CommandResult.SUCCES;
		}
		
		if (args.length < 1) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the arena");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		if (ArenaManager.getInstance().getArena(args[0]) == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Arena " + args[0] + " doesn't exist. Try to create one first");
			return CommandResult.ERROR;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena.getPlayers() < 1) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Arena could not start. There are no players!");
			return CommandResult.ERROR;
		}
		
		if (arena.getState() != GameState.WAITING && arena.getState() != GameState.STARTING && arena.getState() != GameState.FULL) {
			MessageManager.getInstance().send(player, ChatColor.RED + "The arena is already in game");
			return CommandResult.ERROR;
		}
		
		arena.getWaitTimer().setSeconds(0);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "forcestart";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Force an arena to start";
	}

	@Override
	public String getPermission() {
		return "bg.forcestart";
	}
}
