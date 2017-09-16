package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MaxPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.ArenaMode;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a command to set the maximum amount of players in an arena
 *
 * @since 2.1.0
 */
public class SetMaxPlayers extends ConsoleCommand {

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
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (args.length < 1) {
			MessageManager.getInstance().send(sender,
                    ChatColor.RED + "Please specify the arena and the max players");
			return CommandResult.ARGUMENT_EXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[0] + "' isn't a valid arena");
			return CommandResult.ERROR;
		}
		
		if (arena.getMode() == ArenaMode.SOLO) {
			MessageManager.getInstance().send(sender,
                    ChatColor.RED + "You can only modify the maxplayers from arenas, which are in team mode");
			return CommandResult.ERROR;
		}

		int maxPlayers;

		try {
			maxPlayers = Integer.parseInt(args[1]);
		} catch (NumberFormatException e) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "'" + args[1] + "' isn't a whole number");
			return CommandResult.ERROR;
		}
		
		if (maxPlayers % arena.getPlots().size() != 0) {
			MessageManager.getInstance().send(sender, ChatColor.RED +
                    "Your max players has to be a number dividible by " + arena.getPlots().size());
			return CommandResult.ERROR;
		}
		
		arenas.set(arena.getName() + ".maxplayers", maxPlayers);
		
		//add parts to config
		for (int i = 0; i < maxPlayers; i++) {
			if (config.contains("team-selection.team." + i))
				continue;
			
			config.set("team-selection.team." + i + ".id", "paper");
		}
		
		SettingsManager.getInstance().save();
		
		MaxPlayersManager.getInstance().setup();
		
		MessageManager.getInstance().send(sender, ChatColor.GREEN + "Max players changed!");
		
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
		return "setmaxplayers";
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
		return "Set the max players in an arena";
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
		return "bg.setmaxplayers";
	}
}