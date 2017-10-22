package com.gmail.stefvanschiedev.buildinggame.events.stats.database;

import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

import java.util.Locale;

/**
 * Handles MySQL statistic saving for disconnecting players
 *
 * @author TomVerschueren
 * @since 4.0.0
 */
public class QuitPlayerStats implements Listener {

    /**
     * Handles MySQL statistic saving for disconnecting players
     *
     * @author TomVerschueren
     * @param event an event representing a player disconnecting
     * @see PlayerQuitEvent
     * @since 4.0.0
     */
	@EventHandler
    public static void onPlayerQuit(PlayerQuitEvent event){
        final Player player = event.getPlayer();

        new BukkitRunnable() {
            @Override
            public void run() {
                StatManager instance = StatManager.getInstance();

                for (StatType type : StatType.values()) {
                    Stat stat = instance.getStat(player, type);

                    instance.getMySQLDatabase().setStat(player.getUniqueId().toString(),
                            type.toString().toLowerCase(Locale.getDefault()), stat == null ? 0 : stat.getValue());
                }
            }
        }.runTaskAsynchronously(Main.getInstance());
	}
}