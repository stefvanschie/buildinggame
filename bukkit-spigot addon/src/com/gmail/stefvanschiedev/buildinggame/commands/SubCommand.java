package com.gmail.stefvanschiedev.buildinggame.commands;

import org.bukkit.entity.Player;

/**
 * Base class for all sub commands
 *
 * @since 2.1.0
 */
public abstract class SubCommand {

    /**
     * Called whenever this sub command is executed
     *
     * @param player the player who executed the sub command
     * @param args the arguments added to the command
     * @since 2.1.0
     */
	public abstract void onCommand(Player player, @SuppressWarnings("unused") String[] args);

    /**
     * Returns the name of this sub commands
     *
     * @return the name
     * @since 2.1.0
     */
	@SuppressWarnings("SameReturnValue")
    public abstract String getName();
}
