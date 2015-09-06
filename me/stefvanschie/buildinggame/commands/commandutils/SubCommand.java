package me.stefvanschie.buildinggame.commands.commandutils;

import org.bukkit.entity.Player;

public abstract class SubCommand {

	public abstract CommandResult onCommand(Player player, String[] args);
	
	public abstract String getName();
	
	public abstract String[] getAliases();
	
	public abstract String getInfo();
	
	public abstract String getPermission();
}
