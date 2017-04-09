package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class ForceTheme extends PlayerCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		if (args.length < 1) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify a theme");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You aren't in an arena");
			return CommandResult.ERROR;
		}
		
		String theme = StringUtils.join(args, " ");
		
		if (theme.trim().isEmpty()) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Theme can't be blank");
			return CommandResult.ERROR;
		}
		
		arena.getSubjectMenu().forceTheme(theme);
		MessageManager.getInstance().send(player, ChatColor.GREEN + "Forced '" + theme + "' to be the theme");
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "forcetheme";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Forces a theme to be chosen";
	}

	@Override
	public String getPermission() {
		return "bg.forcetheme";
	}
}