package com.gmail.stefvanschiedev.buildinggame.events.stats.database;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Locale;
import java.util.UUID;

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
        final var player = event.getPlayer();

        new BukkitRunnable() {
            @Override
            public void run() {
                StatManager instance = StatManager.getInstance();
                UUID uniqueId = player.getUniqueId();
                String uuidString = uniqueId.toString();

                if (!instance.containsUUID(uniqueId) && instance.getMySQLDatabase() != null)
                    instance.getMySQLDatabase().insertPlayer(uuidString);

                for (var statType : StatType.values())
                    instance.registerStat(player, statType, instance.getMySQLDatabase().getStat(uuidString,
                            statType.toString().toLowerCase(Locale.getDefault())));
            }
        }.runTaskAsynchronously(Main.getInstance());
    }
}