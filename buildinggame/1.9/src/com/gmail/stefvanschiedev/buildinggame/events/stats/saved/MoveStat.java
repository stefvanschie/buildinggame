package com.gmail.stefvanschiedev.buildinggame.events.stats.saved;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

public class MoveStat implements Listener {

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
		
		int x = Math.abs(e.getFrom().getBlockX() - e.getTo().getBlockX());
		int y = Math.abs(e.getFrom().getBlockY() - e.getTo().getBlockY());
		int z = Math.abs(e.getFrom().getBlockZ() - e.getTo().getBlockZ());
		     
		if (x == 0 && y == 0 && z == 0)
			return;
		
		if (ArenaManager.getInstance().getArena(player) == null)
			return;
		
		StatManager.getInstance().registerStat(player, StatType.WALKED, StatManager.getInstance().getStat(player, StatType.WALKED) == null ? 1 : StatManager.getInstance().getStat(player, StatType.WALKED).getValue() + 1);
		SignManager.getInstance().updateStatSigns();
	}
}