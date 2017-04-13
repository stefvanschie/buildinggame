package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.teamselection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.SubCommand;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.teamselection.team.Id;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class Team extends ConsoleCommand {

	private final Collection<SubCommand> subCommands = new ArrayList<>();
	
	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		//add settings to list
		subCommands.add(new Id());
		//test for right setting
		
		if (args.length == 0) {
			for (SubCommand sc : subCommands) {
				if (sender.hasPermission(sc.getPermission()))
					MessageManager.getInstance().sendWithoutPrefix(sender, ChatColor.GREEN + "/bg setting money " + sc.getName() + " - " + sc.getInfo());
			}
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		for (SubCommand subCommand : subCommands) {
			if (subCommand.getName().equalsIgnoreCase(args[0])) {
				if (sender.hasPermission(subCommand.getPermission())) {
					//remove first argument
				
					List<String> arguments = new ArrayList<>(Arrays.asList(args));
                    arguments.remove(0);
					args = arguments.toArray(new String[arguments.size()]);

					return subCommand.onCommand(sender, args);
				}
			}
		}
		
		MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a setting");
		return CommandResult.ERROR;
	}

	@Override
	public String getName() {
		return "team";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the team setting";
	}

	@Override
	public String getPermission() {
		return "bg.setting.teamselection.team";
	}
}