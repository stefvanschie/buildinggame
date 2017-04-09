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

public class Spectate extends PlayerCommand {

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
		
		MessageManager.getInstance().send(player, ChatColor.GREEN + "Now spectating " + toSpectateGameplayer.getPlayer().getName() + "!");
		
		return CommandResult.SUCCES;
	}

	@Override
	public String getName() {
		return "spectate";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Spectate a player";
	}

	@Override
	public String getPermission() {
		return "bg.spectate";
	}
	
	private GamePlayer getPlayer(Arena arena, String playerName) {
		for (Plot plot : arena.getPlots()) {
			for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
				if (gamePlayer.getPlayer().getName().equals(playerName))
					return gamePlayer;
			}
		}
		
		return null;
	}
	
	private Plot isSpectating(Player player) {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				for (GamePlayer gamePlayer : plot.getSpectators()) {
					if (gamePlayer.getPlayer() == player)
						return plot;
				}
			}
		}
		
		return null;
	}
}