package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.LobbyManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class SetLobby extends PlayerCommand {

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
		
		arenas.set(arena.getName() + ".lobby.server", player.getServer().getServerName());
		arenas.set(arena.getName() + ".lobby.world", player.getLocation().getWorld().getName());
		arenas.set(arena.getName() + ".lobby.x", player.getLocation().getBlockX());
		arenas.set(arena.getName() + ".lobby.y", player.getLocation().getBlockY());
		arenas.set(arena.getName() + ".lobby.z", player.getLocation().getBlockZ());
		SettingsManager.getInstance().save();
		
		LobbyManager.getInstance().setup();
		
		MessageManager.getInstance().send(player, messages.getStringList("setLobby.succes"));
		
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