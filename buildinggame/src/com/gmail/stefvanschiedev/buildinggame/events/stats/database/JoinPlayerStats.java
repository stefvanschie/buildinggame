package com.gmail.stefvanschiedev.buildinggame.events.stats.database;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Locale;

/**
 * Handles MySQL statistic loading for new players
 *
 * @author TomVerschueren
 * @since 4.0.0
 */
public class JoinPlayerStats implements Listener {

    /**
     * Handles MySQL statistic loading for new players
     *
     * @author TomVerschueren
     * @param event an event representing a player joining
     * @see PlayerJoinEvent
     * @since 4.0.0
     */
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        final Player player = event.getPlayer();
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
            if (!StatManager.getInstance().containsUUID(player.getUniqueId()) && StatManager.getInstance().getMySQLDatabase() != null)
                StatManager.getInstance().getMySQLDatabase().insertPlayer(player.getUniqueId().toString());

            for (StatType statType : StatType.values())
                StatManager.getInstance().registerStat(player, statType, StatManager.getInstance().getMySQLDatabase().getStat(player.getUniqueId().toString(),statType.toString().toLowerCase(Locale.getDefault())));
        });
    }
}