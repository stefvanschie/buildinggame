package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class CreateArena extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arenaname");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		if (arenas.contains(args[0])) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That arena does already exists");
			return CommandResult.ERROR;
		}
		
		arenas.createSection(args[0]);
		arenas.set(args[0] + ".mode", "SOLO");
		SettingsManager.getInstance().save();
		
		ArenaManager.getInstance().setup();
		
		for (String message : messages.getStringList("createArena.succes")) {
			MessageManager.getInstance().send(sender, message
					.replace("%arena%", args[0]));
		}
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "createarena";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Create an arena";
	}

	@Override
	public String getPermission() {
		return "bg.createarena";
	}

}
