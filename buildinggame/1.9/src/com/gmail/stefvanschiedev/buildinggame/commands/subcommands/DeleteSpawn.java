package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MaxPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.BoundaryManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.FloorManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.LocationManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.PlotManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class DeleteSpawn extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length < 2) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arena and the spawn");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		if (ArenaManager.getInstance().getArena(args[0]) == null) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a valid arena. Try to create one first.");
			return CommandResult.ERROR;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		try {
			Integer.parseInt(args[1]);
		} catch (NumberFormatException nfe) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a valid plot. Try to create one first.");
			return CommandResult.ERROR;
		}
		
		int id = Integer.parseInt(args[1]);
		
		if (arena.getPlot(id) == null) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a valid plot. Try to create one first.");
			return CommandResult.ERROR;
		}
		
		Plot plot = arena.getPlot(id);
		
		int maxplayers = arenas.getInt(arena.getName() + ".maxplayers");
		
		for (int i = plot.getID(); i < maxplayers; i++) {
			arenas.set(arena.getName() + "." + i, arenas.getConfigurationSection(arena.getName() + "." + i++));
		}
		
		arenas.set(arena.getName() + "." + maxplayers, null);
		arenas.set(arena.getName() + ".maxplayers", maxplayers - 1);
		
		SettingsManager.getInstance().save();
		
		MaxPlayersManager.getInstance().setup();
		
		PlotManager.getInstance().setup();
		LocationManager.getInstance().setup();
		BoundaryManager.getInstance().setup();
		FloorManager.getInstance().setup();
		
		for (String message : messages.getStringList("deleteSpawn.succes")) {
			MessageManager.getInstance().send(sender, message
					.replace("%place%", plot.getID() + ""));
		}
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "deletespawn";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Deletes a spawn";
	}

	@Override
	public String getPermission() {
		return "bg.deletespawn";
	}
}