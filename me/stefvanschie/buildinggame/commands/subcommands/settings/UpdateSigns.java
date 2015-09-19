package me.stefvanschie.buildinggame.commands.subcommands.settings;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

public class UpdateSigns extends SubCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the setting");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		if (!args[0].equalsIgnoreCase("true") && !args[0].equalsIgnoreCase("false")) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid setting");
			return CommandResult.ERROR;
		}
		boolean setting;
		setting = Boolean.parseBoolean(args[0]);
		
		
		config.set("update-signs", setting);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(player, ChatColor.GREEN + "Update-signs setting set to " + setting);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "update-signs";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Edit the update signs setting";
	}

	@Override
	public String getPermission() {
		return "bg.setting.update-signs";
	}

}
