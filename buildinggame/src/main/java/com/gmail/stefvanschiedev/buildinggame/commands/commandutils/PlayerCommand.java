package com.gmail.stefvanschiedev.buildinggame.commands.commandutils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.jetbrains.annotations.NotNull;

/**
 * A base class for commands which can only be executed as a player
 *
 * @since 2.1.0
 */
public abstract class PlayerCommand extends SubCommand {

    /**
     * This method will be called once the command is executed
     *
     * @param sender the sender which executed the command
     * @param args the arguments specified
     * @return the commandresult this execution yielded
     * @see CommandResult
     * @since 2.1.0
     */
    @NotNull
	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Only players can perform this command");
			return CommandResult.ERROR;
		}
		
		return onCommand((Player) sender, args);
	}

	/**
     * This method will be called once the commandsender is checked and casted to a player
     *
     * @param player the player who executed the command
     * @param args the arguments specified
     * @return the commandresult this execution yielded
     * @see CommandResult
     * @since 2.1.0
     */
	@NotNull
	protected abstract CommandResult onCommand(Player player, String[] args);
}