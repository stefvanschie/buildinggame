package me.stefvanschie.buildinggame.commands.subcommands;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.PlayerCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.arenas.MaxPlayersManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.managers.plots.LocationManager;
import me.stefvanschie.buildinggame.managers.plots.PlotManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

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
		
		arenas.set(arena.getName() + "." + place + ".world", player.getLocation().getWorld().getName());
		arenas.set(arena.getName() + "." + place + ".x", player.getLocation().getBlockX());
		arenas.set(arena.getName() + "." + place + ".y", player.getLocation().getBlockY());
		arenas.set(arena.getName() + "." + place + ".z", player.getLocation().getBlockZ());
		arenas.set(arena.getName() + ".maxplayers", place);
		SettingsManager.getInstance().save();
		
		PlotManager.getInstance().setup();
		LocationManager.getInstance().setup();
		MaxPlayersManager.getInstance().setup();
		
		MessageManager.getInstance().send(player, messages.getString("setSpawn.succes")
				.replace("%place%", place + "")
				.replaceAll("&", "§"));
		
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