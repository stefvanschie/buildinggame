package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaModeManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.ArenaMode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;

/**
 * Represents a command to set the gamemode of an arena
 *
 * @since 2.1.0
 */
public class SetGameMode extends ConsoleCommand {

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
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		
		if (args.length < 2) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arena and gamemode");
			return CommandResult.ARGUMENT_EXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[0] + "' isn't a valid arena");
			return CommandResult.ERROR;
		}
		
		ArenaMode mode;
		try {
			mode = ArenaMode.valueOf(args[1].toUpperCase(Locale.getDefault()));
		} catch (IllegalArgumentException e) {
			MessageManager.getInstance().send(sender,
                    ChatColor.RED + "'" + args[1] + "' isn't a valid game mode");
			return CommandResult.ERROR;
		}
		
		arenas.set(arena.getName() + ".mode", mode.toString());
		SettingsManager.getInstance().save();
		
		ArenaModeManager.getInstance().setup();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN +
                "Successfully changed game mode of arena " + arena.getName() + " to " +
                mode.toString().toLowerCase(Locale.getDefault()));
		
		return CommandResult.SUCCESS;
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
		return "setgamemode";
	}

    /**
     * Returns the aliases for this sbucommand
     *
     * @return an array of aliases for this subcommand
     * @since 2.1.0
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
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getInfo() {
		return "Set the game mode of an arena";
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
		return "bg.setgamemode";
	}
}