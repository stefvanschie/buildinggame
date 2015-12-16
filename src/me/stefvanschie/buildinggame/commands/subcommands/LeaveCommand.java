package me.stefvanschie.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.PlayerCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;

public class LeaveCommand extends PlayerCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're not in an arena");
			return CommandResult.ERROR;
		}
		
		arena.leave(player);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "leave";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Leave the arena you're in";
	}

	@Override
	public String getPermission() {
		return "bg.leave";
	}

}
