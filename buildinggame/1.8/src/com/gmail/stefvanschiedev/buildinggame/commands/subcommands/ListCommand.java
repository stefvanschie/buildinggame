package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class ListCommand extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			sender.sendMessage(ChatColor.DARK_AQUA + " - " + arena.getName() + ChatColor.DARK_GREEN + " - " + arena.getState().toString().toLowerCase());
		}
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "list";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "List all arenas";
	}

	@Override
	public String getPermission() {
		return "bg.list";
	}
}