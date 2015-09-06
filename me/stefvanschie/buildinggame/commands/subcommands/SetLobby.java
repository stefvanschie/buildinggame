package me.stefvanschie.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.arenas.LobbyManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.Arena;

public class SetLobby extends SubCommand {

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
		
		arenas.set(arena.getName() + ".lobby.world", player.getLocation().getWorld().getName());
		arenas.set(arena.getName() + ".lobby.x", player.getLocation().getBlockX());
		arenas.set(arena.getName() + ".lobby.y", player.getLocation().getBlockY());
		arenas.set(arena.getName() + ".lobby.z", player.getLocation().getBlockZ());
		SettingsManager.getInstance().save();
		
		LobbyManager.getInstance().setup();
		
		MessageManager.getInstance().send(player, messages.getString("setLobby.succes")
				.replaceAll("&", "§"));
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "setlobby";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Set the lobby";
	}

	@Override
	public String getPermission() {
		return "bg.setlobby";
	}

}
