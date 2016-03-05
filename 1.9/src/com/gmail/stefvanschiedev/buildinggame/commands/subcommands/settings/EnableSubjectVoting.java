package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class EnableSubjectVoting extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify true or false");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		boolean setting = Boolean.parseBoolean(args[0]);
		
		config.set("enable-subject-voting", setting);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Enable subject voting setting changed to " + setting);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "enable-subject-voting";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Enable or disable subject voting";
	}

	@Override
	public String getPermission() {
		return "bg.setting.enablesubjectvoting";
	}
}