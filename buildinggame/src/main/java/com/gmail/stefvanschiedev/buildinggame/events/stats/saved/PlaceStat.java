package com.gmail.stefvanschiedev.buildinggame.events.stats.saved;

import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

/**
 * Handles statistics for placed blocks
 *
 * @since 2.2.0
 */
public class PlaceStat implements Listener {

    /**
     * Handles statistics for placed blocks
     *
     * @param e an event that represents a block being placed
     * @see BlockPlaceEvent
     * @since 2.2.0
     */
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e) {
		Player player = e.getPlayer();

		if (ArenaManager.getInstance().getArena(player) == null)
			return;

        StatManager instance = StatManager.getInstance();
        Stat stat = instance.getStat(player, StatType.PLACED);

        instance.registerStat(player, StatType.PLACED, stat == null ? 1 : stat.getValue() + 1);
		SignManager.getInstance().updateStatSigns(StatType.PLACED);
	}
}