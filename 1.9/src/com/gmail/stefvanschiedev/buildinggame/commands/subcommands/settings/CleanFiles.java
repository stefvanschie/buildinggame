package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class CleanFiles extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify true or false");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		config.set("clean-files", Boolean.parseBoolean(args[0]));
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Clean files changed to " + Boolean.parseBoolean(args[0]));
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "clean-files";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Enable or diable clean files";
	}

	@Override
	public String getPermission() {
		return "bg.setting.cleanfiles";
	}
}