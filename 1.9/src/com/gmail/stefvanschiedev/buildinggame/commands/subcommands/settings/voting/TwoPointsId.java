package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.voting;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class TwoPointsId extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the id");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		config.set("voting.two-points-id", args[0]);
		SettingsManager.getInstance().save();

		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Two points id changed to " + args[0]);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "two-points-id";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the two points id";
	}

	@Override
	public String getPermission() {
		return "bg.setting.voting.twopointsid";
	}
}