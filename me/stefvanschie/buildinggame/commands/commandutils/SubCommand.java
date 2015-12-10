package me.stefvanschie.buildinggame.commands.commandutils;

import org.bukkit.command.CommandSender;

public abstract class SubCommand {

	public abstract CommandResult onCommand(CommandSender sender, String[] args);
	
	public abstract String getName();
	
	public abstract String[] getAliases();
	
	public abstract String getInfo();
	
	public abstract String getPermission();
}
