package me.stefvanschie.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.ConsoleCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.arenas.MaxPlayersManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.managers.plots.BoundaryManager;
import me.stefvanschie.buildinggame.managers.plots.FloorManager;
import me.stefvanschie.buildinggame.managers.plots.LocationManager;
import me.stefvanschie.buildinggame.managers.plots.PlotManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.plot.Plot;

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
		
		MessageManager.getInstance().send(sender, messages.getString("deleteSpawn.succes")
				.replace("%place%", plot.getID() + ""));
		
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