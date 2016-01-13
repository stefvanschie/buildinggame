package com.gmail.stefvanschiedev.buildinggame.events.player;

import java.util.Random;

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
			return;
		}
		
		if (config.getBoolean("allow-fly-out-bounds")) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		Plot plot = arena.getPlot(player);
		
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
			if (arena.getWinner() == null) {
				return;
			}
			if (!arena.getWinner().getBoundary().isInside(from)) {
				player.teleport(arena.getWinner().getBoundary().getAllBlocks().get(new Random().nextInt(arena.getWinner().getBoundary().getAllBlocks().size())).getLocation());
				return;
			}
			
			if (!arena.getWinner().getBoundary().isInside(to)) {
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
			return;
		}
	}
}