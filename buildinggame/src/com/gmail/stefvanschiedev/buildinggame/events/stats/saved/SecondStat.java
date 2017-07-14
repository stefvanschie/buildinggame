package com.gmail.stefvanschiedev.buildinggame.events.stats.saved;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.gmail.stefvanschiedev.buildinggame.api.Win;
import com.gmail.stefvanschiedev.buildinggame.api.events.PlayerWinEvent;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

/**
 * Handles statistics for players becoming second
 *
 * @since 2.2.0
 */
public class SecondStat implements Listener {

    /**
     * Handles statistics for players becoming second
     *
     * @param e an event representing a player winning
     * @see PlayerWinEvent
     * @since 2.2.0
     */
	@EventHandler
	public static void onPlayerWin(PlayerWinEvent e) {
		if (e.getWin() != Win.SECOND)
			return;
		
		for (GamePlayer gamePlayer : e.getPlayers())
			StatManager.getInstance().registerStat(gamePlayer.getPlayer(), StatType.SECOND, StatManager.getInstance().getStat(gamePlayer.getPlayer(), StatType.SECOND) == null ? 1 : StatManager.getInstance().getStat(gamePlayer.getPlayer(), StatType.SECOND).getValue() + 1);
	
		SignManager.getInstance().updateStatSigns();
	}
}