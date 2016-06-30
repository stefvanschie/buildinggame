package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class WinTimer extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the time");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		try {
			Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a valid number");
			return CommandResult.ERROR;
		}
		
		int time = Integer.parseInt(args[0]);
		
		config.set("wintimer", time);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Wintimer setting set to " + time);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "wintimer";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Edit the wintimer setting";
	}

	@Override
	public String getPermission() {
		return "bg.setting.wintimer";
	}

}
