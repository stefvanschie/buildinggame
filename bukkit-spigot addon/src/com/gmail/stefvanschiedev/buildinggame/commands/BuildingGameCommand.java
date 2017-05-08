package com.gmail.stefvanschiedev.buildinggame.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.subcommand.SetMainSpawn;

public class BuildingGameCommand implements CommandExecutor {
	
	private final Collection<SubCommand> subCommands = new ArrayList<>();
	
	public BuildingGameCommand() {
		subCommands.add(new SetMainSpawn());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute commands");
			return true;
		}
		
		Player player = (Player) sender;
		
		if (args.length == 0) {
			for (SubCommand subCommand : subCommands)
				player.sendMessage(ChatColor.AQUA + "/bg " + subCommand.getName());
			return true;
		}
		
		if (cmd.getName().equals("bg") || cmd.getName().equals("buildinggame")) {
			for (SubCommand subCommand : subCommands) {
				if (subCommand.getName().equals(args[0])) {
					//found correct subcommand
					String[] newArgs = new String[args.length - 1];
                    System.arraycopy(args, 1, newArgs, 0, args.length - 1);
					
					subCommand.onCommand(player, newArgs);
					return true;
				}
			}
		}
		
		player.sendMessage(ChatColor.RED + "Couldn't find subcommand " + args[0]);
		return true;
	}
}