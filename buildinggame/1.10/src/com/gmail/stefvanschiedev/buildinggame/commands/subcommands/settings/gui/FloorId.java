package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.gui;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class FloorId extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify an id");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		config.set("gui.floor-id", args[0]);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Floor id set to " + args[0]);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "floor-id";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the floor id";
	}

	@Override
	public String getPermission() {
		return "bg.setting.gui.floorid";
	}
}