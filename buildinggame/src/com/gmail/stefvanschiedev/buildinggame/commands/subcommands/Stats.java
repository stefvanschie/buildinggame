package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

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
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();
        StatManager statManager = StatManager.getInstance();

        Stat playsStat = statManager.getStat(player, StatType.PLAYS);
        Stat firstStat = statManager.getStat(player, StatType.FIRST);
        Stat secondStat = statManager.getStat(player, StatType.SECOND);
        Stat thirdStat = statManager.getStat(player, StatType.THIRD);
        Stat placedStat = statManager.getStat(player, StatType.PLACED);
        Stat brokenStat = statManager.getStat(player, StatType.BROKEN);
        Stat walkedStat = statManager.getStat(player, StatType.WALKED);

        for (String line : MessageManager.translate(messages.getStringList("commands.stats.success"))) {
            MessageManager.getInstance().send(player, line
                    .replace("%stat_plays%", playsStat == null ? "0" : String.valueOf(playsStat.getValue()))
                    .replace("%stat_first%", firstStat == null ? "0" : String.valueOf(firstStat.getValue()))
                    .replace("%stat_second%", secondStat == null ? "0" : String.valueOf(secondStat.getValue()))
                    .replace("%stat_third%", thirdStat == null ? "0" : String.valueOf(thirdStat.getValue()))
                    .replace("%stat_placed%", placedStat == null ? "0" : String.valueOf(placedStat.getValue()))
                    .replace("%stat_broken%", brokenStat == null ? "0" : String.valueOf(brokenStat.getValue()))
                    .replace("%stat_walked%", walkedStat == null ? "0" : String.valueOf(walkedStat.getValue())));
        }

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