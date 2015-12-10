package me.stefvanschie.buildinggame.commands.subcommands.settings.commands.first;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.ConsoleCommand;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

public class Remove extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the command");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		String command = "";
		for (String arg : args) {
			command += arg + " ";
		}
		command = command.trim();
		
		config.set("commands.first", config.getStringList("commands.first").remove(command));
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Command " + command + " removed");
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "remove";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "REmove a comamnd from the first commands";
	}

	@Override
	public String getPermission() {
		return "bg.setting.commands.first.remove";
	}
}