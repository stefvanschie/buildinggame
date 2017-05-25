package com.gmail.stefvanschiedev.buildinggame.managers.commands;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("UtilityClassCanBeEnum")
public final class CommandExecuter {

    private CommandExecuter() {}

    @Nullable
    public static String execute(String command) {
		if (command.startsWith("%console%")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replaceFirst("%console%", "").trim());
			return null;
		} else
			return command;
	}
}