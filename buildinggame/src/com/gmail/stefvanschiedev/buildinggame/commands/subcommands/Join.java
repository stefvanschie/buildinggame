package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.ArenaSelection;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a command to join an arena
 *
 * @since 2.1.0
 */
public class Join extends PlayerCommand {

    /**
     * The method which is called once the correct command is entered
     *
     * @param player the player who entered the command
     * @param args the arguments provided
     * @return the commandresult this execution yielded
     * @see CommandResult
     * @since 2.1.0
     */
	@NotNull
    @Override
	public CommandResult onCommand(Player player, String[] args) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length == 0) {
			List<Arena> arenas = getArenas();
			
			if (arenas.isEmpty()) {
				MessageManager.getInstance().send(player, messages.getStringList("join.no-arena"));
				return CommandResult.ERROR;
			}
			
			new ArenaSelection().open(player);
		} else {
			Arena arena = ArenaManager.getInstance().getArena(args[0]);
			
			if (arena == null) {
				MessageManager.getInstance().send(player, messages.getStringList("join.invalid"));
				return CommandResult.ERROR;
			}
		
			arena.join(player);
		}
		
		return CommandResult.SUCCES;
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
		return "join";
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
    @Nls
	@NotNull
    @Contract(pure = true)
    @Override
	public String getInfo() {
		return "Join an arena";
	}

    /**
     * Returns the permission node required for this subcommand
     *
     * @return the permission node for this subcommand
     * @since 4.0.4
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getPermission() {
		return "bg.join";
	}

	/**
     * Returns a list of arenas in which players can join without being kicked
     *
     * @return a list of open arenas
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	private static List<Arena> getArenas() {
		List<Arena> arenas = new ArrayList<>();
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (!arena.isFull() && (arena.getState() == GameState.WAITING || arena.getState() == GameState.STARTING))
				arenas.add(arena);
		}
		return arenas;
	}
}