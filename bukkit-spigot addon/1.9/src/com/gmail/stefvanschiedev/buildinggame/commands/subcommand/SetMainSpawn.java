package com.gmail.stefvanschiedev.buildinggame.commands.subcommand;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.SubCommand;

import fr.rhaz.socketapi.SocketAPI;

public class SetMainSpawn extends SubCommand {

	@Override
	public void onCommand(Player player, String[] args) {
		SocketAPI.bukkit().getSocketClient().writeJSON("BuildingGame", "write: arenas.yml, main-spawn.server, " + player.getServer().getServerName());
		SocketAPI.bukkit().getSocketClient().writeJSON("BuildingGame", "write: arenas.yml, main-spawn.world, " + player.getWorld().getName());
		SocketAPI.bukkit().getSocketClient().writeJSON("BuildingGame", "write: arenas.yml, main-spawn.x, (int) " + player.getLocation().getBlockX());
		SocketAPI.bukkit().getSocketClient().writeJSON("BuildingGame", "write: arenas.yml, main-spawn.y, (int) " + player.getLocation().getBlockY());
		SocketAPI.bukkit().getSocketClient().writeJSON("BuildingGame", "write: arenas.yml, main-spawn.z, (int) " + player.getLocation().getBlockZ());
		
		SocketAPI.bukkit().getSocketClient().writeJSON("BuildingGame", "save");
		
		player.sendMessage(ChatColor.GREEN + "Main spawn set!");
	}
	
	@Override
	public String getName() {
		return "setmainspawn";
	}
}