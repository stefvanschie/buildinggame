package me.stefvanschie.buildinggame.commands.subcommands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.commands.subcommands.settings.Money;
import me.stefvanschie.buildinggame.commands.subcommands.settings.Subjects;
import me.stefvanschie.buildinggame.commands.subcommands.settings.Timer;
import me.stefvanschie.buildinggame.commands.subcommands.settings.VoteTimer;
import me.stefvanschie.buildinggame.commands.subcommands.settings.WaitTimer;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

public class Setting extends SubCommand {
	
	private List<SubCommand> subCommands = new ArrayList<SubCommand>();
	
	@Override
	public CommandResult onCommand(Player player, String[] args) {

		//add settings to list
		subCommands.add(new Money());
		subCommands.add(new Subjects());
		subCommands.add(new Timer());
		subCommands.add(new VoteTimer());
		subCommands.add(new WaitTimer());
		//test for right setting
		
		if (args.length == 0) {
			for (SubCommand sc : subCommands) {
				MessageManager.getInstance().sendWithoutPrefix(player, ChatColor.GREEN + "/bg setting " + sc.getName() + " - " + sc.getInfo());
			}
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		for (SubCommand subCommand : subCommands) {
			if (subCommand.getName().equalsIgnoreCase(args[0])) {
				if (player.hasPermission(subCommand.getPermission())) {
					//remove first argument
					
					List<String> arguments = new ArrayList<String>();
					arguments.addAll(Arrays.asList(args));
					arguments.remove(0);
					args = arguments.toArray(new String[arguments.size()]);
					
					CommandResult result = subCommand.onCommand(player, args);
					return result;
				}
			}
		}
		
		MessageManager.getInstance().send(player, ChatColor.RED + "That's not a setting");
		return CommandResult.ERROR;
	}

	@Override
	public String getName() {
		return "setting";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the settings";
	}

	@Override
	public String getPermission() {
		return "bg.setting";
	}

}
