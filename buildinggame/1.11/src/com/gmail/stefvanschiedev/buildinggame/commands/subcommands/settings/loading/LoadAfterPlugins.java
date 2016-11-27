package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.loading;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class LoadAfterPlugins extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify either true or false");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		boolean value = Boolean.parseBoolean(args[0]);
		
		config.set("loading.load-after-plugins", value);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Load after plugins set to " + value);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "load-after-plugins";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Edit the load-after-plugins setting";
	}

	@Override
	public String getPermission() {
		return "bg.setting.loading.load-after-plugins";
	}
}