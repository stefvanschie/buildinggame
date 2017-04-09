package com.gmail.stefvanschiedev.buildinggame.events.player;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
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

public class Move implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
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
		
		if (config.getBoolean("allow-fly-out-bounds")) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		Plot plot = arena.getPlot(player);

		if (plot.getGamePlayer(player).getGamePlayerType() == GamePlayerType.SPECTATOR) {
			GamePlayer gamePlayer = plot.getGamePlayer(player);
			
			if (!plot.getBoundary().isInside(to)) {
				player.teleport(gamePlayer.getSpectates().getPlayer());
				MessageManager.getInstance().send(player, MessageManager.translate(messages.getStringList("in-game.move-out-bounds")));
			}
			
			return;
		}
		
		if (arena.getState() == GameState.VOTING) {
			if (arena.getVotingPlot() == null) {
				return;
			}
			if (!arena.getVotingPlot().getBoundary().isInside(from)) {
				player.teleport(arena.getVotingPlot().getBoundary().getAllBlocks().get(new Random().nextInt(arena.getVotingPlot().getBoundary().getAllBlocks().size())).getLocation());
				return;
			}
			
			if (!arena.getVotingPlot().getBoundary().isInside(to)) {
				player.teleport(from);
				MessageManager.getInstance().send(player, messages.getStringList("in-game.move-out-bounds"));
				return;
			}
		}
		
		if (arena.getState() == GameState.RESETING) {		
			if (arena.getFirstPlot() == null) {
				return;
			}
			if (!arena.getFirstPlot().getBoundary().isInside(from)) {
				player.teleport(arena.getFirstPlot().getBoundary().getAllBlocks().get(new Random().nextInt(arena.getFirstPlot().getBoundary().getAllBlocks().size())).getLocation());
				return;
			}
			
			if (!arena.getFirstPlot().getBoundary().isInside(to)) {
				player.teleport(from);
				MessageManager.getInstance().send(player, messages.getStringList("in-game.move-out-bounds"));
				return;
			}
		}
		
		if (arena.getState() != GameState.BUILDING) {
			return;
		}
		
		if (!plot.getBoundary().isInside(from)) {
			player.teleport(plot.getBoundary().getAllBlocks().get(new Random().nextInt(plot.getBoundary().getAllBlocks().size())).getLocation());
			return;
		}
		
		if (!plot.getBoundary().isInside(to)) {
			player.teleport(from);
			MessageManager.getInstance().send(player, messages.getStringList("in-game.move-out-bounds"));
		}
	}
	
	private Location getClosestPositionOutsideActivePlot(Location start) {
		Location closest = null;
		
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
									break;
								}
							}
							
							if (closest != null)
								break;
						}
						
						if (closest != null)
							break;
					}
					
					if (closest != null)
						break;
				}
				
				if (closest != null)
					break;
			}
		}
		
		return closest;
	}
}