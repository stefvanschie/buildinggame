package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.bossbar;

import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class Color extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify a color");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		BarColor barColor;
		try {
			barColor = BarColor.valueOf(args[0]);
		} catch (IllegalArgumentException e) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a valid color");
			return CommandResult.ERROR;
		}
		
		config.set("bossbar.color", barColor.toString().toLowerCase());
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Color changed to " + barColor.toString().toLowerCase());
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "color";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Edit the color setting";
	}

	@Override
	public String getPermission() {
		return "bg.setting.bossbar.color";
	}
}