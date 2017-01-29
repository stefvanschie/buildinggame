package com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.blocks.blocked;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class Add extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 0) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify a block");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		List<String> list = config.getStringList("blocks.blocked");
		list.add(args[0]);
		config.set("blocks.blocked", list);
		SettingsManager.getInstance().save();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Added block to the list");
		
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
		return "Add a new blocke block";
	}

	@Override
	public String getPermission() {
		return "bg.setting.blocks.blocked.add";
	}
}