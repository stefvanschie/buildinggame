package com.gmail.stefvanschiedev.buildinggame.events.stats.saved;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

/**
 * Handles statistics for broken blocks
 *
 * @since 2.2.0
 */
public class BreakStat implements Listener {

    /**
     * Handles statistics for broken blocks
     *
     * @param e an event representing a block being broken
     * @see BlockBreakEvent
     * @since 2.2.0
     */
	@EventHandler
	public void onBlockBreak(BlockBreakEvent e) {
		Player player = e.getPlayer();
		
		if (ArenaManager.getInstance().getArena(player) == null)
			return;
		
		StatManager.getInstance().registerStat(player, StatType.BROKEN, StatManager.getInstance().getStat(player, StatType.BROKEN) == null ? 1 : StatManager.getInstance().getStat(player, StatType.BROKEN).getValue() + 1);
		SignManager.getInstance().updateStatSigns();
	}
}