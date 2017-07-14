package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a command to spectate an arena
 *
 * @since 2.1.0
 */
public class Spectate extends PlayerCommand {

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
		if (args.length < 1) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify a player");
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		Player toSpectate = Bukkit.getPlayer(args[0]);
		
		if (toSpectate == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + args[0] + " is not a valid player");
			return CommandResult.ERROR;
		}
		
		if (ArenaManager.getInstance().getArena(toSpectate) == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Arena " + args[0] + " not found");
			return CommandResult.ERROR;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(toSpectate);
		
		if (arena.getState() != GameState.BUILDING) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You can't spectate right now");
			return CommandResult.ERROR;
		}
		
		GamePlayer toSpectateGameplayer = getPlayer(arena, toSpectate.getName());

		if (toSpectateGameplayer == null) {
		    MessageManager.getInstance().send(player, ChatColor.RED + "Couldn't find the player to spectate");
		    return CommandResult.ERROR;
        }

		if (toSpectateGameplayer.getGamePlayerType() == GamePlayerType.SPECTATOR) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You can't spectate a spectator");
			return CommandResult.ERROR;
		}
		
		//check if the player is playing the game
		if (ArenaManager.getInstance().getArena(player) != null && ArenaManager.getInstance().getArena(player).getPlot(player).getGamePlayer(player).getGamePlayerType() == GamePlayerType.PLAYER) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You can't spectate while you're in game");
			return CommandResult.ERROR;
		}
		
		//check if we are already spectating
		if (isSpectating(player) != null)
            //noinspection ConstantConditions
            isSpectating(player).removeSpectator(isSpectating(player).getGamePlayer(player));
		
		arena.getPlot(toSpectateGameplayer.getPlayer()).addSpectator(player, toSpectateGameplayer);
		
		MessageManager.getInstance().send(player, ChatColor.GREEN + "Now spectating " + toSpectateGameplayer.getPlayer().getName() + '!');
		
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
		return "spectate";
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
		return "Spectate a player";
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
		return "bg.spectate";
	}

	/**
     * Returns a gameplayer by his name and the arena the player is in
     *
     * @param arena the arena to look in
     * @param playerName the name of the player to look for
     * @return the gameplayer by the given name
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
    private static GamePlayer getPlayer(Arena arena, String playerName) {
		for (Plot plot : arena.getPlots()) {
			for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
				if (gamePlayer.getPlayer().getName().equals(playerName))
					return gamePlayer;
			}
		}
		
		return null;
	}

	/**
     * Returns the plot the given player is spectating
     *
     * @param player the player to look by
     * @return the plot this player is spectatring or null if the player isn't spectating
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
    private static Plot isSpectating(Player player) {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				for (GamePlayer gamePlayer : plot.getSpectators()) {
					if (gamePlayer.getPlayer().equals(player))
						return plot;
				}
			}
		}
		
		return null;
	}
}