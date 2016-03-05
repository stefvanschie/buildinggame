package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;

public class Reload extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		Main.getInstance().loadPlugin();
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "reload";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Reload the server";
	}

	@Override
	public String getPermission() {
		return "bg.reload";
	}
}