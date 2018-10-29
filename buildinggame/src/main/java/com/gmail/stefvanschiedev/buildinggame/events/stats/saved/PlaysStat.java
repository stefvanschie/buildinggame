package com.gmail.stefvanschiedev.buildinggame.events.stats.saved;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaStartEvent;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

/**
 * Handles statistics for games played
 *
 * @since 2.2.0
 */
public class PlaysStat implements Listener {

    /**
     * Handles statistics for games played
     *
     * @param e an event that represents an arena starting
     * @see ArenaStartEvent
     * @since 2.2.0
     */
	@EventHandler
	public static void onArenaStart(ArenaStartEvent e) {
        StatManager instance = StatManager.getInstance();

        e.getArena().getUsedPlots().stream().flatMap(plot -> plot.getGamePlayers().stream()).forEach(gamePlayer -> {
            var player = gamePlayer.getPlayer();
            var stat = instance.getStat(player, StatType.PLAYS);

            instance.registerStat(player, StatType.PLAYS, stat == null ? 1 : stat.getValue() + 1);
        });
    }
}