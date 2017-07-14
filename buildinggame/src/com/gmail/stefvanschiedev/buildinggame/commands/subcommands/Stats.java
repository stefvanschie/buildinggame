package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a command to show your statistics
 *
 * @since 2.2.0
 */
public class Stats extends PlayerCommand {

    /**
     * The method which is called once the correct command is entered
     *
     * @param player the player who entered the command
     * @param args the arguments provided
     * @return the commandresult this execution yielded
     * @see CommandResult
     * @since 2.2.0
     */
	@NotNull
    @Override
	public CommandResult onCommand(Player player, String[] args) {
		player.sendMessage(ChatColor.GREEN + "Games played: " + (StatManager.getInstance().getStat(player, StatType.PLAYS) == null ? 0 : StatManager.getInstance().getStat(player, StatType.PLAYS).getValue()));
		player.sendMessage(ChatColor.GREEN + "First places: " + (StatManager.getInstance().getStat(player, StatType.FIRST) == null ? 0 : StatManager.getInstance().getStat(player, StatType.FIRST).getValue()));
		player.sendMessage(ChatColor.GREEN + "Second places: " + (StatManager.getInstance().getStat(player, StatType.SECOND) == null ? 0 : StatManager.getInstance().getStat(player, StatType.SECOND).getValue()));
		player.sendMessage(ChatColor.GREEN + "Third places: " + (StatManager.getInstance().getStat(player, StatType.THIRD) == null ? 0 : StatManager.getInstance().getStat(player, StatType.THIRD).getValue()));
		player.sendMessage(ChatColor.GREEN + "Blocks placed: " + (StatManager.getInstance().getStat(player, StatType.PLACED) == null ? 0 : StatManager.getInstance().getStat(player, StatType.PLACED).getValue()));
		player.sendMessage(ChatColor.GREEN + "Blocks broken: " + (StatManager.getInstance().getStat(player, StatType.BROKEN) == null ? 0 : StatManager.getInstance().getStat(player, StatType.BROKEN).getValue()));
		player.sendMessage(ChatColor.GREEN + "Distance walked: " + (StatManager.getInstance().getStat(player, StatType.WALKED) == null ? 0 : StatManager.getInstance().getStat(player, StatType.WALKED).getValue()));
		return CommandResult.SUCCES;
	}

    /**
     * Returns the name of this subcommand
     *
     * @return the name of this subcommand
     * @since 2.2.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getName() {
		return "stats";
	}

    /**
     * Returns the aliases for this sbucommand
     *
     * @return an array of aliases for this subcommand
     * @since 2.2.0
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
     * @since 2.2.0
     */
	@Nls
	@NotNull
    @Contract(pure = true)
    @Override
	public String getInfo() {
		return "Shows your stats";
	}

    /**
     * Returns the permission node required for this subcommand
     *
     * @return the permission node for this subcommand
     * @since 2.2.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getPermission() {
		return "bg.stats";
	}
}