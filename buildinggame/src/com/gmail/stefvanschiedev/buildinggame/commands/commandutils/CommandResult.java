package com.gmail.stefvanschiedev.buildinggame.commands.commandutils;

/**
 * An enum with values representing the outcome of a command.
 *
 * @since 2.1.0
 */
public enum CommandResult {

    /**
     * Not enough or incorrect arguments were specified and thus the command failed
     *
     * @since 2.1.0
     */
	ARGUMENTEXCEPTION,

    /**
     * There was an error while executing the command
     *
     * @since 2.1.0
     */
	ERROR,

    /**
     * The command was successful
     *
     * @since 2.1.0
     */
	SUCCES
	
}