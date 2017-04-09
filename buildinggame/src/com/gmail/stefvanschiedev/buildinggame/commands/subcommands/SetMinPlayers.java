package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MinPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class SetMinPlayers extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length <= 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arena and the amount of players");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That is not a valid arena");
			return CommandResult.ERROR;
		}

		int players;

		try {
			players = Integer.parseInt(args[1]);
		} catch (NumberFormatException npe) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a number");
			return CommandResult.ERROR;
		}
		
		arenas.set(arena.getName() + ".minplayers", players);
		SettingsManager.getInstance().save();
		
		MinPlayersManager.getInstance().setup();
		
		MessageManager.getInstance().send(sender, messages.getStringList("setMinPlayers.succes"));
		
		return null;
	}

	@Override
	public String getName() {
		return "setminplayers";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Set the minimum amount of players";
	}

	@Override
	public String getPermission() {
		return "bg.setminplayers";
	}

}