package me.stefvanschie.buildinggame.commands.subcommands.settings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.ConsoleCommand;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.commands.subcommands.settings.voting.EightPointsId;
import me.stefvanschie.buildinggame.commands.subcommands.settings.voting.FivePointsId;
import me.stefvanschie.buildinggame.commands.subcommands.settings.voting.FourPointsId;
import me.stefvanschie.buildinggame.commands.subcommands.settings.voting.SevenPointsId;
import me.stefvanschie.buildinggame.commands.subcommands.settings.voting.SixPointsId;
import me.stefvanschie.buildinggame.commands.subcommands.settings.voting.ThreePointsId;
import me.stefvanschie.buildinggame.commands.subcommands.settings.voting.TwoPointsId;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

public class Voting extends ConsoleCommand {

	private List<SubCommand> subCommands = new ArrayList<SubCommand>();
	
	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		//add settings to list
		subCommands.add(new TwoPointsId());
		subCommands.add(new ThreePointsId());
		subCommands.add(new FourPointsId());
		subCommands.add(new FivePointsId());
		subCommands.add(new SixPointsId());
		subCommands.add(new SevenPointsId());
		subCommands.add(new EightPointsId());
		//test for the right setting
		
		if (args.length == 0) {
			for (SubCommand sc : subCommands) {
				if (sender.hasPermission(sc.getPermission())) {
					MessageManager.getInstance().sendWithoutPrefix(sender, ChatColor.GREEN + "/bg setting money " + sc.getName() + " - " + sc.getInfo());
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
		return "voting";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the voting setting";
	}

	@Override
	public String getPermission() {
		return "bg.setting.voting";
	}
}