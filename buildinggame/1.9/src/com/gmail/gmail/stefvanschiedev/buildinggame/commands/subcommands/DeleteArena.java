package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.LobbyManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MaxPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MinPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.BoundaryManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.FloorManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.LocationManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.PlotManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class DeleteArena extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arena name");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		if (ArenaManager.getInstance().getArena(args[0]) == null) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a valid arena. Try creating one first.");
			return CommandResult.ERROR;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		arenas.set(arena.getName(), null);
		SettingsManager.getInstance().save();
		
		ArenaManager.getInstance().setup();
		LobbyManager.getInstance().setup();
		MaxPlayersManager.getInstance().setup();
		MinPlayersManager.getInstance().setup();
		
		PlotManager.getInstance().setup();
		LocationManager.getInstance().setup();
		BoundaryManager.getInstance().setup();
		FloorManager.getInstance().setup();
		
		for (String message : messages.getStringList("deleteArena.succes"))
			MessageManager.getInstance().send(sender, message
					.replace("%arena%", arena.getName()));
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "deletearena";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Deletes an arena";
	}

	@Override
	public String getPermission() {
		return "bg.deletearena";
	}
}