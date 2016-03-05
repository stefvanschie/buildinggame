package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class BonemealEvent implements Listener {

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Action action  = e.getAction();
		Block block = e.getClickedBlock();
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		Plot plot = arena.getPlot(player);
		
		if (action != Action.RIGHT_CLICK_BLOCK) {
			return;
		}
		
		if (block.getType() != Material.GRASS) {
			return;
		}
		
		if (plot.getBoundary().isInside(block.getLocation())) {
			return;
		}
		
		MessageManager.getInstance().send(player, messages.getString("in-game.build-out-bounds")
				.replaceAll("&", "§"));
		e.setCancelled(true);
	}
}