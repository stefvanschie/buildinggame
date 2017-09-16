package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.Vote;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a command to vote on a plot
 *
 * @since 2.1.0
 */
public class VoteCommand extends PlayerCommand {

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
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify the amount of points");
			return CommandResult.ERROR;
		}

		int points;

		try {
			points = Integer.parseInt(args[0]);
		} catch (NumberFormatException nfe) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid number");
			return CommandResult.ERROR;
		}
		
		if (points < 1 || points > 10) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Points can only be between 1 and 10");
			return CommandResult.ERROR;
		}

		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're not in an arena");
			return CommandResult.ERROR;
		}

		if (arena.getPlot(player).getGamePlayer(player).getGamePlayerType() == GamePlayerType.SPECTATOR) {
		    MessageManager.getInstance().send(player, ChatColor.RED + "Spectators can't vote");
		    return CommandResult.ERROR;
        }

        if (arena.getState() != GameState.VOTING) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You can't vote at this moment");
			return CommandResult.ERROR;
		}

		Plot plot = arena.getVotingPlot();
		plot.addVote(new Vote(points, player));

		MessageManager.getInstance().send(player, messages.getString("vote.message")
				.replace("%playerplot%", plot.getPlayerFormat())
				.replace("%points%", points + ""));
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
		return "vote";
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
		return "Vote on someone's plot";
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
		return "bg.vote";
	}
}