package com.gmail.stefvanschiedev.buildinggame.events.stats.saved;

import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaStartEvent;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
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

        for (Plot plot : e.getArena().getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
                Player player = gamePlayer.getPlayer();
                Stat stat = instance.getStat(player, StatType.PLAYS);

                instance.registerStat(player, StatType.PLAYS, stat == null ? 1 : stat.getValue() + 1);
            }
        }
		
		SignManager.getInstance().updateStatSigns(StatType.PLAYS);
	}
}