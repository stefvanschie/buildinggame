package me.stefvanschie.buildinggame.commands.subcommands.settings.gui;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.ConsoleCommand;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

public class RainId extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify an id");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		config.set("gui.rain-id", args[0]);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Rain id changed to " + args[0]);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "rain-id";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the rain id";
	}

	@Override
	public String getPermission() {
		return "bg.setting.gui.rainid";
	}
}