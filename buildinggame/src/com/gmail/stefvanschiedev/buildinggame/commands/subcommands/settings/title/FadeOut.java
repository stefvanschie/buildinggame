package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.title;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class FadeOut extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the fade out time");
			return CommandResult.ARGUMENTEXCEPTION;
		}

		int fadeOut;

		try {
			fadeOut = Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[0] + "' is not a valid number");
			return CommandResult.ERROR;
		}
		
		config.set("title.fade_out", fadeOut);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Fade out time updated!");
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "fadeout";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Set the fade out time (in ticks)";
	}

	@Override
	public String getPermission() {
		return "bg.setting.title.fadeout";
	}
}