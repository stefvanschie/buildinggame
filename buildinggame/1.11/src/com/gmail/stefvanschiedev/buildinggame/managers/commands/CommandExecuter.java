package com.gmail.stefvanschiedev.buildinggame.managers.commands;

import org.bukkit.Bukkit;

public class CommandExecuter {

	public static String execute(String command) {
		if (command.startsWith("%console%")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replaceFirst("%console%", "").trim());
			return null;
		} else
			return command;
	}
	
}