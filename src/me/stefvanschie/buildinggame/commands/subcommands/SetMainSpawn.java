package me.stefvanschie.buildinggame.commands.subcommands;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.PlayerCommand;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.mainspawn.MainSpawnManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetMainSpawn extends PlayerCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		arenas.set("main-spawn.world", player.getLocation().getWorld().getName());
		arenas.set("main-spawn.x", player.getLocation().getBlockX());
		arenas.set("main-spawn.y", player.getLocation().getBlockY());
		arenas.set("main-spawn.z", player.getLocation().getBlockZ());
		SettingsManager.getInstance().save();
		
		MainSpawnManager.getInstance().setMainSpawn(player.getLocation());
		MessageManager.getInstance().send(player, messages.getString("setMainSpawn.succes")
				.replaceAll("&", "§"));
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "setmainspawn";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Set the main spawn";
	}

	@Override
	public String getPermission() {
		return "bg.setmainspawn";
	}

}
