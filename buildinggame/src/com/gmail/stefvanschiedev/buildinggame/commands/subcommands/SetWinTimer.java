package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.WinTimerManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class SetWinTimer extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		
		if (args.length < 2) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arena and the amount of seconds");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[0] + "' isn't a valid arena");
			return CommandResult.ERROR;
		}
		
		int seconds;
		
		try {
			seconds = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[1] + "' isn't a number");
			return CommandResult.ERROR;
		}
		
		arenas.set(arena.getName() + ".win-timer", seconds);
		SettingsManager.getInstance().save();
		WinTimerManager.getInstance().setup();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Win timer setting for arena '" + arena.getName() + "' changed to '" + seconds + '\'');
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "setwintimer";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the win timer";
	}

	@Override
	public String getPermission() {
		return "bg.setwintimer";
	}
}