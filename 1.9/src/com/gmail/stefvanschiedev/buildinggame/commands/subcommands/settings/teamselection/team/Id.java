package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.teamselection.team;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class Id extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 2) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Usage: /bg setting team-selection team id <number> <id>");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		config.set("team-selection.team." + args[0] + ".id", args[1]);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Id set to " + args[1]);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "id";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the id of a team";
	}

	@Override
	public String getPermission() {
		return "bg.setting.teamselection.team.id";
	}
}