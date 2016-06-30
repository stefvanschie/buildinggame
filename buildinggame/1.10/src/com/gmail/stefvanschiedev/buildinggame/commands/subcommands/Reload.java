package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class Reload extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (arena.getPlayers() > 0)
				arena.stop();
		}
		
		Main.getInstance().loadPlugin();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Reloaded the plugin!");
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "reload";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Reload the server";
	}

	@Override
	public String getPermission() {
		return "bg.reload";
	}
}