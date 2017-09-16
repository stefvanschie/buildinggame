package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a command to force an arena to start
 *
 * @since 2.1.0
 */
public class ForceStart extends ConsoleCommand {

    /**
     * The method which is called once the correct command is entered
     *
     * @param sender the sender who entered the command
     * @param args the arguments provided
     * @return the commandresult this execution yielded
     * @see CommandResult
     * @since 2.1.0
     */
	@NotNull
    @Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
            Arena playerArena = ArenaManager.getInstance().getArena(player);

            if (playerArena != null && args.length < 1) {
				playerArena.getWaitTimer().setSeconds(0);
				return CommandResult.SUCCESS;
			}
		
			if (args.length < 1) {
				MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the arena");
				return CommandResult.ARGUMENT_EXCEPTION;
			}
			
			if (ArenaManager.getInstance().getArena(args[0]) == null) {
				MessageManager.getInstance().send(player,
                        ChatColor.RED + "Arena " + args[0] + " doesn't exist. Try to create one first");
				return CommandResult.ERROR;
			}
		
			Arena arena = ArenaManager.getInstance().getArena(args[0]);
			
			if (arena.getPlayers() < 1) {
				MessageManager.getInstance().send(player,
                        ChatColor.RED + "Arena could not start. There are no players!");
				return CommandResult.ERROR;
			}
		
			if (arena.getState() != GameState.WAITING && arena.getState() != GameState.STARTING &&
                    arena.getState() != GameState.FULL) {
				MessageManager.getInstance().send(player, ChatColor.RED + "The arena is already in game");
				return CommandResult.ERROR;
			}
		
			arena.getWaitTimer().setSeconds(0);
		
			return CommandResult.SUCCESS;
		} else {
			if (args.length < 1) {
				MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify an arena");
				return CommandResult.ARGUMENT_EXCEPTION;
			}
			
			Arena arena = ArenaManager.getInstance().getArena(args[0]);
			
			if (arena == null) {
				MessageManager.getInstance().send(sender,
                        ChatColor.RED + "Arena " + args[0] + " doesn't exist. Try to create one first");
				return CommandResult.ERROR;
			}
			
			if (arena.getPlayers() < 1) {
				MessageManager.getInstance().send(sender,
                        ChatColor.RED + "Arena could not start. There are no players!");
				return CommandResult.ERROR;
			}
		
			if (arena.getState() != GameState.WAITING && arena.getState() != GameState.STARTING &&
                    arena.getState() != GameState.FULL) {
				MessageManager.getInstance().send(sender, ChatColor.RED + "The arena is already in game");
				return CommandResult.ERROR;
			}
			
			arena.getWaitTimer().setSeconds(0);
			
			return CommandResult.SUCCESS;
		}
	}

    /**
     * Returns the name of this subcommand
     *
     * @return the name of this subcommand
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getName() {
		return "forcestart";
	}

    /**
     * Returns an informational message about this subcommand
     *
     * @return an informational message
     * @since 2.1.0
     */
    @Nls
	@NotNull
    @Contract(pure = true)
    @Override
	public String getInfo() {
		return "Force an arena to start";
	}

    /**
     * Returns the permission node required for this subcommand
     *
     * @return the permission node for this subcommand
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getPermission() {
		return "bg.forcestart";
	}
}