package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.MaxPlayersManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.LocationManager;
import com.gmail.stefvanschiedev.buildinggame.managers.plots.PlotManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a command to set the minimum amount of players in an arena
 *
 * @since 2.1.0
 */
public class SetSpawn extends PlayerCommand {

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
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the arenaname");
			return CommandResult.ARGUMENT_EXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(args[0]);
		
		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid arena");
			return CommandResult.ERROR;
		}
		
		int place = arena.getMaxPlayers() + 1;
        String name = arena.getName();

        arenas.set(name + '.' + place + ".server", player.getServer().getServerName());
		arenas.set(name + '.' + place + ".world", player.getLocation().getWorld().getName());
		arenas.set(name + '.' + place + ".x", player.getLocation().getBlockX());
		arenas.set(name + '.' + place + ".y", player.getLocation().getBlockY());
		arenas.set(name + '.' + place + ".z", player.getLocation().getBlockZ());
		arenas.set(name + '.' + place + ".pitch", player.getLocation().getPitch());
		arenas.set(name + '.' + place + ".yaw", player.getLocation().getYaw());
		arenas.set(name + ".maxplayers", place);
		SettingsManager.getInstance().save();
		
		PlotManager.getInstance().setup();
		LocationManager.getInstance().setup();
		MaxPlayersManager.getInstance().setup();
		
		for (String message : messages.getStringList("setSpawn.succes"))
			MessageManager.getInstance().send(player, message
					.replace("%place%", place + ""));
		
		return CommandResult.ERROR;
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
		return "setspawn";
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
		return "Set a new spawn";
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
		return "bg.setspawn";
	}
}