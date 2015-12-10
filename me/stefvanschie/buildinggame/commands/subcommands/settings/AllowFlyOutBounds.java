package me.stefvanschie.buildinggame.commands.subcommands.settings;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.ConsoleCommand;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

public class AllowFlyOutBounds extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify true or false");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		config.set("allow-fly-out-bounds", Boolean.parseBoolean(args[0]));
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Allow fly out bounds changed to " + Boolean.parseBoolean(args[0]));
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "allow-fly-out-bounds";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Allow people to fly out of bounds";
	}

	@Override
	public String getPermission() {
		return "bg.setting.allowflyoutbounds";
	}
}