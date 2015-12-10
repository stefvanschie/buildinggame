package me.stefvanschie.buildinggame.commands.subcommands.settings.blockedentities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.ConsoleCommand;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

public class Add extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify an entity");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		config.set("blocked-entities", config.getStringList("blocked-entities").add(args[0]));
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Entity " + args[0] + " added");
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "add";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Add an entity to the blocked entities";
	}

	@Override
	public String getPermission() {
		return "bg.setting.blockedentities.add";
	}
}