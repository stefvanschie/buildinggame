package com.gmail.stefvanschiedev.buildinggame.commands.commandutils;

import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A base class for all commands which fall under the main buildinggame command.
 *
 * @since 2.1.0
 */
public abstract class SubCommand {

    /**
     * This method will be called once the comamnd is executed.
     *
     * @param sender the sender who executed this command
     * @param args the arguments specified
     * @return the commandresult this execution yielded
     * @see CommandResult
     * @since 2.1.0
     */
    @NotNull
	public abstract CommandResult onCommand(CommandSender sender, String[] args);

    /**
     * Gets the name of this subcommand
     *
     * @return the name of this subcommand
     */
	@NotNull
    @Contract(pure = true)
	public abstract String getName();

	/**
     * Gets all aliases of this command. This may return null if there are no aliases.
     *
     * @return an array of aliases or null if no aliases exist
     */
	@Nullable
    @Contract(pure = true)
	@SuppressWarnings({"unused", "SameReturnValue"})
    public abstract String[] getAliases();

	/**
     * Returns a small informational message about this command.
     *
     * @return the info message
     */
	@Nls
	@NotNull
    @Contract(pure = true)
	public abstract String getInfo();

	/**
     * Returns the permission needed in order to execute this command as a string
     *
     * @return the required permission node
     */
	@NotNull
    @Contract(pure = true)
	public abstract String getPermission();
}
