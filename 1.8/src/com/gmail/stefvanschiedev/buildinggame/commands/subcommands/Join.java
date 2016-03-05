package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class Join extends PlayerCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length == 0) {
			List<Arena> arenas = getArenas();
			
			if (arenas.size() == 0) {
				MessageManager.getInstance().send(player, messages.getStringList("join.no-arena"));
				return CommandResult.ERROR;
			}
			
			arenas.get(new Random().nextInt(arenas.size())).join(player);
			
			return CommandResult.SUCCES;
		} else {
			Arena arena = ArenaManager.getInstance().getArena(args[0]);
			
			if (arena == null) {
				MessageManager.getInstance().send(player, messages.getStringList("join.invalid"));
				return CommandResult.ERROR;
			}
		
			arena.join(player);
		
			return CommandResult.SUCCES;
		}
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
	
	private List<Arena> getArenas() {
		List<Arena> arenas = new ArrayList<Arena>();
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arena.isFull() && (arena.getState() == GameState.WAITING || arena.getState() == GameState.STARTING))
				arenas.add(arena);
		}
		return arenas;
	}
}