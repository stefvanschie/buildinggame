package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.mobs;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class Allow extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify either true or false");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		boolean value = Boolean.parseBoolean(args[0]);
		
		config.set("mobs.allow", value);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Allow changed to " + value);
		
		return null;
	}

	@Override
	public String getName() {
		return "allow";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the allow setting";
	}

	@Override
	public String getPermission() {
		return "bg.setting.mobs.allow";
	}
}