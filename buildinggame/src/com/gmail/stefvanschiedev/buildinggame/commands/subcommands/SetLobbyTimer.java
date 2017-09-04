package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.LobbyTimerManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a command to set the lobby timer of an arena
 *
 * @since 2.3.0
 */
public class SetLobbyTimer extends ConsoleCommand {

    /**
     * The method which is called once the correct command is entered
     *
     * @param sender the sender who entered the command
     * @param args the arguments provided
     * @return the commandresult this execution yielded
     * @see CommandResult
     * @since 2.3.0
     */
	@NotNull
    @Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		
		if (args.length < 2) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arena and the amount of seconds");
			return CommandResult.ARGUMENT_EXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[0] + "' isn't a valid arena");
			return CommandResult.ERROR;
		}
		
		int seconds;
		
		try {
			seconds = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[1] + "' isn't a number");
			return CommandResult.ERROR;
		}
		
		arenas.set(arena.getName() + ".lobby-timer", seconds);
		SettingsManager.getInstance().save();
		LobbyTimerManager.getInstance().setup();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Lobby timer setting for arena '" + arena.getName() + "' changed to '" + seconds + '\'');
		return CommandResult.SUCCESS;
	}

    /**
     * Returns the name of this subcommand
     *
     * @return the name of this subcommand
     * @since 2.3.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getName() {
		return "setlobbytimer";
	}

    /**
     * Returns the aliases for this sbucommand
     *
     * @return an array of aliases for this subcommand
     * @since 2.3.0
     */
	@Nullable
    @Contract(pure = true)
	@Override
	public String[] getAliases() {
		return null;
	}

    /**
     * Returns an informational message about this subcommand
     *
     * @return an informational message
     * @since 2.3.0
     */
    @Nls
	@NotNull
    @Contract(pure = true)
    @Override
	public String getInfo() {
		return "Change the lobby timer";
	}

    /**
     * Returns the permission node required for this subcommand
     *
     * @return the permission node for this subcommand
     * @since 2.3.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getPermission() {
		return "bg.setlobbytimer";
	}
}