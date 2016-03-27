package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class ScoreboardUpdateDelay extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the delay");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		try {
			Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify a whole number");
			return CommandResult.ERROR;
		}
		
		int setting = Integer.parseInt(args[0]);
		
		config.set("scoreboard-update-delay", setting);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Scoreboard update delay changed to " + setting);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "scoreboard-update-delay";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the scoreboard update delay";
	}

	@Override
	public String getPermission() {
		return "bg.setting.scoreboardupdatedelay";
	}
}