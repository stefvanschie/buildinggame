package com.gmail.stefvanschiedev.buildinggame.managers.commands;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * A utility class that executes commands from the config.yml
 *
 * @since 2.1.0
 */
@SuppressWarnings("UtilityClassCanBeEnum")
public final class CommandExecuter {

    /**
     * Constructs a new CommandExecutor. This shouldn't be called to keep this class a utility class.
     */
    private CommandExecuter() {}

    /**
     * Executes a string from the config.yml. When the command is prefixed with %console% it will be executed by the
     * console, otherwise it'll return itself.
     *
     * @param command the command to execute
     * @return the command or null in case the string is prefixed with %console%
     * @since 2.1.0
     */
    @Nullable
    @Contract("null -> fail")
    public static String execute(String command) {
		if (command.startsWith("%console%")) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replaceFirst("%console%", "").trim());
			return null;
		} else
			return command;
	}
}