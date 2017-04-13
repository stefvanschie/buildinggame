package com.gmail.stefvanschiedev.buildinggame.managers.commands;

import org.bukkit.Bukkit;

@SuppressWarnings("UtilityClassCanBeEnum")
public final class CommandExecuter {

    private CommandExecuter() {}

    public static String execute(String command) {
		if (command.startsWith("%console%")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replaceFirst("%console%", "").trim());
			return null;
		} else
			return command;
	}
}