package com.gmail.stefvanschiedev.buildinggame.events.player;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.gmail.stefvanschiedev.buildinggame.utils.Region;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Handles player movement in-game
 *
 * @since 2.1.0
 */
public class Move implements Listener {

    /**
     * Handles player movement in-game
     *
     * @param e an event representing a player moving
     * @see PlayerMoveEvent
     * @since 2.1.0
     */
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		Location to = e.getTo();
		Location from = e.getFrom();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			//check if player wants to go inside (except spectators of course)
			for (Arena arena : ArenaManager.getInstance().getArenas()) {
				if (arena.getState() == GameState.WAITING || arena.getState() == GameState.STARTING)
					continue;
				
				for (Plot plot : arena.getPlots()) {
					if (plot.getBoundary().isInside(to) && !plot.getBoundary().isInside(from)) {
						//teleport this intruder back
						player.teleport(from);
						MessageManager.getInstance().send(player, ChatColor.RED + "You can't access this plot when this arena is in-game");
					} else if (plot.getBoundary().isInside(to)) {
						//use algorithm to find nearest block to push them out of the arena
						player.teleport(getClosestPositionOutsideActivePlot(player.getLocation()));
						MessageManager.getInstance().send(player, ChatColor.RED + "You can't access this plot when this arena is in-game");
					}
				}
			}
			
			return;
		}
		
		if (SettingsManager.getInstance().getConfig().getBoolean("allow-fly-out-bounds"))
			return;
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		Plot plot = arena.getPlot(player);
        Region boundary = plot.getBoundary();

        if (plot.getGamePlayer(player).getGamePlayerType() == GamePlayerType.SPECTATOR) {
			GamePlayer gamePlayer = plot.getGamePlayer(player);
			
			if (!boundary.isInside(to)) {
				player.teleport(gamePlayer.getSpectates().getPlayer());
				MessageManager.getInstance().send(player, MessageManager.translate(messages.getStringList("in-game.move-out-bounds")));
			}
			
			return;
		}
		
		if (arena.getState() == GameState.VOTING) {
            Plot votingPlot = arena.getVotingPlot();

            if (votingPlot == null)
				return;

            Region votingBoundary = votingPlot.getBoundary();

            if (!votingBoundary.isInside(from)) {
                List<Block> allBlocks = votingBoundary.getAllBlocks();

                player.teleport(allBlocks.get(ThreadLocalRandom.current().nextInt(allBlocks.size())).getLocation());
				return;
			}
			
			if (!votingBoundary.isInside(to)) {
				player.teleport(from);
				MessageManager.getInstance().send(player, messages.getStringList("in-game.move-out-bounds"));
				return;
			}
		}
		
		if (arena.getState() == GameState.RESETING) {
            Plot firstPlot = arena.getFirstPlot();

            if (firstPlot == null)
				return;

            Region firstBoundary = firstPlot.getBoundary();

            if (!firstBoundary.isInside(from)) {
                List<Block> allBlocks = firstBoundary.getAllBlocks();

                player.teleport(allBlocks.get(ThreadLocalRandom.current().nextInt(allBlocks.size())).getLocation());
				return;
			}
			
			if (!firstBoundary.isInside(to)) {
				player.teleport(from);
				MessageManager.getInstance().send(player, messages.getStringList("in-game.move-out-bounds"));
				return;
			}
		}
		
		if (arena.getState() != GameState.BUILDING)
			return;

        if (!boundary.isInside(from)) {
            List<Block> allBlocks = boundary.getAllBlocks();

            player.teleport(allBlocks.get(ThreadLocalRandom.current().nextInt(allBlocks.size())).getLocation());
			return;
		}
		
		if (!boundary.isInside(to)) {
			player.teleport(from);
			MessageManager.getInstance().send(player, messages.getStringList("in-game.move-out-bounds"));
		}
	}

    /**
     * Returns the closest position outside any active plots from the current position
     *
     * @param start the starting point inside an active plot
     * @return the location outside any active plots
     * @see Location
     * @since 4.0.1
     */
    @NotNull
    @Contract(pure = true)
	private static Location getClosestPositionOutsideActivePlot(Location start) {
		Location closest = null;

		outerLoop:
            //radius is for a cube not a sphere as the name suggests
            for (int radius = 1; closest == null; radius++) {
                //loop through cube starting at a positive corner going to a negative one
                for (int x = radius; x >= -radius; x--) {
                    for (int y = radius; y >= -radius; y--) {
                        for (int z = radius; z >= -radius; z--) {
                            Location loc = start.clone().add(x, y, z);

                            //loop through all plots
                            for (Arena arena : ArenaManager.getInstance().getArenas()) {
                                if (arena.getState() == GameState.WAITING || arena.getState() == GameState.STARTING)
                                    continue;

                                for (Plot plot : arena.getPlots()) {
                                    if (!plot.getBoundary().isInside(loc)) {
                                        closest = loc;
                                        break outerLoop;
                                    }
                                }
                            }
                        }
                    }
                }
            }
		
		return closest;
	}
}