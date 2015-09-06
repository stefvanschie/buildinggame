package me.stefvanschie.buildinggame.commands.subcommands.settings.money;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

public class Second extends SubCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the money");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		try {
			Double.parseDouble(args[0]);
		} catch (NumberFormatException nfe) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid number");
			return CommandResult.ERROR;
		}
		
		double money = Double.parseDouble(args[0]);
		
		config.set("money.second", money);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(player, ChatColor.GREEN + "Money setting set to " + money);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "second";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Set the money";
	}

	@Override
	public String getPermission() {
		return "bg.setting.money.second";
	}

}
