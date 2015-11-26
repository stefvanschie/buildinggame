package me.stefvanschie.buildinggame.commands.subcommands.settings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.commands.subcommands.settings.title.FadeIn;
import me.stefvanschie.buildinggame.commands.subcommands.settings.title.FadeOut;
import me.stefvanschie.buildinggame.commands.subcommands.settings.title.Stay;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Title extends SubCommand {

private List<SubCommand> subCommands = new ArrayList<SubCommand>();
	
	@Override
	public CommandResult onCommand(Player player, String[] args) {
		
		subCommands.add(new FadeIn());
		subCommands.add(new Stay());
		subCommands.add(new FadeOut());
		
		if (args.length == 0) {
			for (SubCommand sc : subCommands) {
				MessageManager.getInstance().sendWithoutPrefix(player, ChatColor.GREEN + "/bg setting title " + sc.getName() + " - " + sc.getInfo());
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
		return "title";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the title setting";
	}

	@Override
	public String getPermission() {
		return "bg.setting.title";
	}
}
