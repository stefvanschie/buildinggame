package me.stefvanschie.buildinggame.commands.subcommands;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CreateArena extends SubCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the arenaname");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		if (arenas.contains(args[0])) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That arena does already exists");
			return CommandResult.ERROR;
		}
		
		arenas.createSection(args[0]);
		arenas.set(args[0] + ".mode", "SOLO");
		SettingsManager.getInstance().save();
		
		ArenaManager.getInstance().setup();
		
		MessageManager.getInstance().send(player, messages.getString("createArena.succes")
				.replace("%arena%", args[0])
				.replaceAll("&", "§"));
		
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
