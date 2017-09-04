package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
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
        StatManager instance = StatManager.getInstance();

        Stat playStat = instance.getStat(player, StatType.PLAYS);
        Stat firstStat = instance.getStat(player, StatType.FIRST);
        Stat secondStat = instance.getStat(player, StatType.SECOND);
        Stat thirdStat = instance.getStat(player, StatType.THIRD);
        Stat placedStat = instance.getStat(player, StatType.PLACED);
        Stat brokenStat = instance.getStat(player, StatType.BROKEN);
        Stat walkedStat = instance.getStat(player, StatType.WALKED);

        player.sendMessage(ChatColor.GREEN + "Games played: " + (playStat == null ? 0 : playStat.getValue()));
		player.sendMessage(ChatColor.GREEN + "First places: " + (firstStat == null ? 0 : firstStat.getValue()));
		player.sendMessage(ChatColor.GREEN + "Second places: " + (secondStat == null ? 0 : secondStat.getValue()));
		player.sendMessage(ChatColor.GREEN + "Third places: " + (thirdStat == null ? 0 : thirdStat.getValue()));
		player.sendMessage(ChatColor.GREEN + "Blocks placed: " + (placedStat == null ? 0 : placedStat.getValue()));
		player.sendMessage(ChatColor.GREEN + "Blocks broken: " + (brokenStat == null ? 0 : brokenStat.getValue()));
		player.sendMessage(ChatColor.GREEN + "Distance walked: " + (walkedStat == null ? 0 : walkedStat.getValue()));

		return CommandResult.SUCCESS;
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