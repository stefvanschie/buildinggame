package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.bossbar;

import org.bukkit.ChatColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class Style extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify a style");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		BarStyle barStyle;
		try {
			barStyle = BarStyle.valueOf(args[0]);
		} catch (IllegalArgumentException e) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a valid setting");
			return CommandResult.ERROR;
		}
		
		config.set("bossbar.style", barStyle.toString().toLowerCase());
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Style set to " + barStyle.toString().toLowerCase());
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "style";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the style setting";
	}

	@Override
	public String getPermission() {
		return "bg.setting.bossbar.style";
	}
}