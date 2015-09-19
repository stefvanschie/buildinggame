package me.stefvanschie.buildinggame.events.player;

import java.util.Random;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.GameState;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Move implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		Location to = e.getTo();
		Location from = e.getFrom();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		Plot plot = ArenaManager.getInstance().getArena(player).getPlot(player);
		
		if (arena.getState() != GameState.BUILDING && arena.getState() != GameState.VOTING) {
			return;
		}
		
		if (!plot.getBoundary().isInside(from)) {
			player.teleport(plot.getBoundary().getAllBlocks().get(new Random().nextInt(plot.getBoundary().getAllBlocks().size())).getLocation());
			return;
		}
		
		if (!plot.getBoundary().isInside(to)) {
			player.teleport(from);
			MessageManager.getInstance().send(player, ChatColor.RED + "You can't move outside your plot");
			return;
		}
		return;
	}
}
