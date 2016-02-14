package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaModeManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.ArenaMode;

public class SetGameMode extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arena and gamemode");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[0] + "' isn't a valid arena");
			return CommandResult.ERROR;
		}
		
		ArenaMode mode;
		try {
			mode = ArenaMode.valueOf(args[1].toUpperCase());
		} catch (IllegalArgumentException e) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[1] + "' isn't a valid gamemode");
			return CommandResult.ERROR;
		}
		
		arenas.set(arena.getName() + ".mode", mode.toString());
		SettingsManager.getInstance().save();
		
		ArenaModeManager.getInstance().setup();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Succesfully changed gamemode of arena " + arena.getName() + " to " + mode.toString().toLowerCase());
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "setgamemode";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Set the game mode of an arena";
	}

	@Override
	public String getPermission() {
		return "bg.setgamemode";
	}
	
}