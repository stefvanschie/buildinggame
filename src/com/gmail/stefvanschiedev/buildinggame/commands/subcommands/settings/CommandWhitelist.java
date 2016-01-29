package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.SubCommand;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.commandwhitelist.Add;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.commandwhitelist.Remove;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class CommandWhitelist extends ConsoleCommand {

	private List<SubCommand> subCommands = new ArrayList<SubCommand>();
	
	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		//add settings to list
		subCommands.add(new Add());
		subCommands.add(new Remove());
		//test for the right setting
				
		if (args.length == 0) {
			for (SubCommand sc : subCommands) {
				if (sender.hasPermission(sc.getPermission())) {
					MessageManager.getInstance().sendWithoutPrefix(sender, ChatColor.GREEN + "/bg setting command-whitelist " + sc.getName() + " - " + sc.getInfo());
				}
			}
			return CommandResult.ARGUMENTEXCEPTION;
		}
				
		for (SubCommand subCommand : subCommands) {
			if (subCommand.getName().equalsIgnoreCase(args[0])) {
				if (sender.hasPermission(subCommand.getPermission())) {
					//remove first argument
						
					List<String> arguments = new ArrayList<String>();
					arguments.addAll(Arrays.asList(args));
					arguments.remove(0);
					args = arguments.toArray(new String[arguments.size()]);
						
					CommandResult result = subCommand.onCommand(sender, args);
					return result;
				}
			}
		}
				
		MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a setting");
		return CommandResult.ERROR;
	}

	@Override
	public String getName() {
		return "command-whitelist";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the command whitelist";
	}

	@Override
	public String getPermission() {
		return "bg.setting.commandwhitelist";
	}
}