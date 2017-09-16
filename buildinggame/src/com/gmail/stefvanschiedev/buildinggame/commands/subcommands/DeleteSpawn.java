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
import com.gmail.stefvanschiedev.buildinggame.managers.plots.BoundaryManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.FloorManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.LocationManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.PlotManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a command to delete a spawn
 *
 * @since 2.1.0
 */
public class DeleteSpawn extends ConsoleCommand {

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
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length < 2) {
			MessageManager.getInstance().send(sender,
                    ChatColor.RED + "Please specify the arena and the spawn");
			return CommandResult.ARGUMENT_EXCEPTION;
		}
		
		if (ArenaManager.getInstance().getArena(args[0]) == null) {
			MessageManager.getInstance().send(sender,
                    ChatColor.RED + "That's not a valid arena. Try to create one first.");
			return CommandResult.ERROR;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		int id;

		try {
			id = Integer.parseInt(args[1]);
		} catch (NumberFormatException nfe) {
			MessageManager.getInstance().send(sender,
                    ChatColor.RED + "That's not a valid plot. Try to create one first.");
			return CommandResult.ERROR;
		}
		
		if (arena.getPlot(id) == null) {
			MessageManager.getInstance().send(sender,
                    ChatColor.RED + "That's not a valid plot. Try to create one first.");
			return CommandResult.ERROR;
		}
		
		Plot plot = arena.getPlot(id);
		
		int maxPlayers = arenas.getInt(arena.getName() + ".maxplayers");
		
		for (int i = plot.getID(); i < maxPlayers; i++)
			arenas.set(arena.getName() + '.' + i, arenas.getConfigurationSection(arena.getName() + '.' + i + 1));
		
		arenas.set(arena.getName() + '.' + maxPlayers, null);
		arenas.set(arena.getName() + ".maxplayers", maxPlayers - 1);
		
		SettingsManager.getInstance().save();
		
		MaxPlayersManager.getInstance().setup();
		
		PlotManager.getInstance().setup();
		LocationManager.getInstance().setup();
		BoundaryManager.getInstance().setup();
		FloorManager.getInstance().setup();
		
		for (String message : messages.getStringList("deleteSpawn.succes"))
			MessageManager.getInstance().send(sender, message
					.replace("%place%", plot.getID() + ""));
		
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
		return "deletespawn";
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
		return "Deletes a spawn";
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
		return "bg.deletespawn";
	}
}