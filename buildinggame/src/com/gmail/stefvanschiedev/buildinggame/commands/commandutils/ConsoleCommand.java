package com.gmail.stefvanschiedev.buildinggame.commands.commandutils;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

/**
 * A base class for commands which can be executed by all possible commandsenders
 *
 * @since 2.1.0
 */
public abstract class ConsoleCommand extends SubCommand {

    /**
     * This method will be called when the command is executed
     *
     * @param sender the sender who executed the command
     * @param args the arguments specified
     * @return the result this command execution yielded
     * @see CommandResult
     * @since 2.1.0
     */
    @NotNull
	public abstract CommandResult onCommand(CommandSender sender, String[] args);
	
}