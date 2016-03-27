package com.gmail.stefvanschiedev.buildinggame.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.subcommand.SetMainSpawn;

public class BuildingGameCommand implements CommandExecutor {
	
	private List<SubCommand> subCommands = new ArrayList<SubCommand>();
	
	public BuildingGameCommand() {
		subCommands.add(new SetMainSpawn());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can execute commands");
			return true;
		}
		
		if (cmd.getName().equals("bg") || cmd.getName().equals("buildinggame")) {
			for (SubCommand subCommand : subCommands) {
				if (subCommand.getName().equals(args[0])) {
					//found correct subcommand
					String[] newArgs = new String[args.length - 1];
					for (int i = 1; i < args.length; i++)
						newArgs[i] = args[i];
					
					subCommand.onCommand((Player) sender, newArgs);
					return true;
				}
			}
		}
		
		sender.sendMessage(ChatColor.RED + "Couldn't find subcommand " + args[0]);
		return true;
	}
}