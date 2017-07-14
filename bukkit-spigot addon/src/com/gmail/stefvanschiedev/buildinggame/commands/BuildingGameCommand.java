package com.gmail.stefvanschiedev.buildinggame.commands;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.subcommand.SetMainSpawn;

/**
 * The main Building Game command
 *
 * @since 2.1.0
 */
public class BuildingGameCommand implements CommandExecutor {

    /**
     * A collection of all sub commands
     */
	private final Collection<SubCommand> subCommands = new ArrayList<>();

    /**
     * Constructs a new BuildingGameCommand which initializes all sub commands
     */
	public BuildingGameCommand() {
		subCommands.add(new SetMainSpawn());
	}

    /**
     * Called whenever a player executes the Building Game command
     *
     * @param sender the sender who executed the command
     * @param cmd the command that was executed
     * @param label the name of the command executed
     * @param args the arguments from the command
     * @return whether the command was successful
     * @since 2.1.0
     */
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