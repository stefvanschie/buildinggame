package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MaxPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.LocationManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.PlotManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class SetSpawn extends PlayerCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the arenaname");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid arena");
			return CommandResult.ERROR;
		}
		
		int place = arena.getMaxPlayers() + 1;
		
		arenas.set(arena.getName() + "." + place + ".server", player.getServer().getServerName());
		arenas.set(arena.getName() + "." + place + ".world", player.getLocation().getWorld().getName());
		arenas.set(arena.getName() + "." + place + ".x", player.getLocation().getBlockX());
		arenas.set(arena.getName() + "." + place + ".y", player.getLocation().getBlockY());
		arenas.set(arena.getName() + "." + place + ".z", player.getLocation().getBlockZ());
		arenas.set(arena.getName() + ".maxplayers", place);
		SettingsManager.getInstance().save();
		
		PlotManager.getInstance().setup();
		LocationManager.getInstance().setup();
		MaxPlayersManager.getInstance().setup();
		
		for (String message : messages.getStringList("setSpawn.succes")) {
			MessageManager.getInstance().send(player, message
					.replace("%place%", place + ""));
		}
		
		return CommandResult.ERROR;
	}

	@Override
	public String getName() {
		return "setspawn";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Set a new spawn";
	}

	@Override
	public String getPermission() {
		return "bg.setspawn";
	}

}