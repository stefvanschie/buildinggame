package me.stefvanschie.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.arenas.LobbyManager;
import me.stefvanschie.buildinggame.managers.arenas.MaxPlayersManager;
import me.stefvanschie.buildinggame.managers.arenas.MinPlayersManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.managers.plots.BoundaryManager;
import me.stefvanschie.buildinggame.managers.plots.FloorManager;
import me.stefvanschie.buildinggame.managers.plots.LocationManager;
import me.stefvanschie.buildinggame.managers.plots.PlotManager;
import me.stefvanschie.buildinggame.utils.Arena;

public class DeleteArena extends SubCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the arena name");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		if (ArenaManager.getInstance().getArena(args[0]) == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid arena. Try creating one first.");
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
		
		MessageManager.getInstance().send(player, messages.getString("deleteArena.succes")
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
