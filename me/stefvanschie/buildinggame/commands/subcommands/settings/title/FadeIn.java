package me.stefvanschie.buildinggame.commands.subcommands.settings.title;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

public class FadeIn extends SubCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the fade in time");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		try {
			Integer.parseInt(args[0]);
		} catch (NumberFormatException e) {
			MessageManager.getInstance().send(player, ChatColor.RED + "'" + args[0] + "' is not a valid number");
			return CommandResult.ERROR;
		}
		
		config.set("title.fade_in", Integer.parseInt(args[0]));
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(player, ChatColor.GREEN + "Fade in time updated!");
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "fadein";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Set the fade in time (in ticks)";
	}

	@Override
	public String getPermission() {
		return "bg.setting.title.fadein";
	}
}
