package me.stefvanschie.buildinggame.commands.subcommands;


import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.PlayerCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;

public class Join extends PlayerCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(player, messages.getString("join.no-arena"));
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(player, messages.getString("join.invalid"));
			return CommandResult.ERROR;
		}
		
		arena.join(player);
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "join";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Join an arena";
	}

	@Override
	public String getPermission() {
		return "bg.join";
	}
}