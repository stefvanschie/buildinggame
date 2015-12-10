package me.stefvanschie.buildinggame.events.block;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.GameState;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		Plot plot = arena.getPlot(player);
		
		if (arena.getState() != GameState.BUILDING) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You can not build right now");
			e.setCancelled(true);
			return;
		}
		
		if (!plot.getBoundary().isInside(e.getBlock().getLocation())) {
			MessageManager.getInstance().send(player, messages.getString("in-game.build-out-bounds")
					.replaceAll("&", "§"));
			e.setCancelled(true);
			return;
		}
	}
}