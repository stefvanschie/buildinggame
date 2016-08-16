package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class ForceStart extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			
			if (ArenaManager.getInstance().getArena(player) != null && args.length < 1) {
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
		} else {
			if (args.length < 1) {
				MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify an arena");
				return CommandResult.ARGUMENTEXCEPTION;
			}
			
			
			Arena arena = ArenaManager.getInstance().getArena(args[0]);
			
			if (arena == null) {
				MessageManager.getInstance().send(sender, ChatColor.RED + "Arena " + args[0] + " doesn't exist. Try to create one first");
				return CommandResult.ERROR;
			}
			
			if (arena.getPlayers() < 1) {
				MessageManager.getInstance().send(sender, ChatColor.RED + "Arena could not start. There are no players!");
				return CommandResult.ERROR;
			}
		
			if (arena.getState() != GameState.WAITING && arena.getState() != GameState.STARTING && arena.getState() != GameState.FULL) {
				MessageManager.getInstance().send(sender, ChatColor.RED + "The arena is already in game");
				return CommandResult.ERROR;
			}
			
			arena.getWaitTimer().setSeconds(0);
			
			return CommandResult.SUCCES;
		}
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