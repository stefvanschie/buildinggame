package me.stefvanschie.buildinggame.commands.commandutils;

import org.bukkit.command.CommandSender;

public abstract class ConsoleCommand extends SubCommand {

	public abstract CommandResult onCommand(CommandSender sender, String[] args);
	
}
