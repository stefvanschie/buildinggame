package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a command to set the main spawn
 *
 * @since 2.1.0
 */
public class SetMainSpawn extends PlayerCommand {

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
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		List<String> worlds = config.getStringList("scoreboards.main.worlds.enable");
		
		if (arenas.contains("main-spawn.world"))
			worlds.remove(arenas.getString("main-spawn.world"));
		
		worlds.add(player.getLocation().getWorld().getName());
		config.set("scoreboards.main.worlds.enable", worlds);
		
		arenas.set("main-spawn.server", player.getServer().getServerName());
		arenas.set("main-spawn.world", player.getLocation().getWorld().getName());
		arenas.set("main-spawn.x", player.getLocation().getBlockX());
		arenas.set("main-spawn.y", player.getLocation().getBlockY());
		arenas.set("main-spawn.z", player.getLocation().getBlockZ());
		arenas.set("main-spawn.pitch", player.getLocation().getPitch());
		arenas.set("main-spawn.yaw", player.getLocation().getYaw());
		SettingsManager.getInstance().save();
		
		MainSpawnManager.getInstance().setMainSpawn(player.getLocation());
		MessageManager.getInstance().send(player, messages.getStringList("setMainSpawn.succes"));
		
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
		return "setmainspawn";
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
		return "Set the main spawn";
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
		return "bg.setmainspawn";
	}
}