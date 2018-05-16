package com.gmail.stefvanschiedev.buildinggame.events.stats.saved;

import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

/**
 * Handles statistics for walked blocks
 *
 * @since 2.2.0
 */
public class MoveStat implements Listener {

    /**
     * Handles statistics for walked blocks
     *
     * @param e an event representing a player moving
     * @see PlayerMoveEvent
     * @since 2.2.0
     */
	@EventHandler(ignoreCancelled = true)
	public void onPlayerMove(PlayerMoveEvent e) {
		Player player = e.getPlayer();
        Location from = e.getFrom();
        Location to = e.getTo();

		if ((Math.abs(from.getBlockX() - to.getBlockX()) == 0 && Math.abs(from.getBlockY() - to.getBlockY()) == 0 &&
            Math.abs(from.getBlockZ() - to.getBlockZ()) == 0) || ArenaManager.getInstance().getArena(player) == null)
		    return;

        StatManager instance = StatManager.getInstance();
        Stat stat = instance.getStat(player, StatType.WALKED);

        instance.registerStat(player, StatType.WALKED, stat == null ? 1 : stat.getValue() + 1);
		SignManager.getInstance().updateStatSigns(StatType.WALKED);
	}
}