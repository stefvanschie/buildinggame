package me.stefvanschie.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.arenas.ArenaModeManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.arena.ArenaMode;

public class SetGameMode extends SubCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the arena and gamemode");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "'" + args[0] + "' isn't a valid arena");
			return CommandResult.ERROR;
		}
		
		ArenaMode mode;
		try {
			mode = ArenaMode.valueOf(args[1].toUpperCase());
		} catch (IllegalArgumentException e) {
			MessageManager.getInstance().send(player, ChatColor.RED + "'" + args[1] + "' isn't a valid gamemode");
			return CommandResult.ERROR;
		}
		
		arenas.set(arena.getName() + ".mode", mode.toString());
		SettingsManager.getInstance().save();
		
		ArenaModeManager.getInstance().setup();
		
		MessageManager.getInstance().send(player, ChatColor.GREEN + "Succesgully changed gamemode of arena " + arena.getName() + " to " + mode.toString());;
		
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
