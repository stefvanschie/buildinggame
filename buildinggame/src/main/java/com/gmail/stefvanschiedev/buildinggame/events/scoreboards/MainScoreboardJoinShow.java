package com.gmail.stefvanschiedev.buildinggame.events.scoreboards;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.scoreboards.MainScoreboardManager;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Handles the main scoreboard for new players
 *
 * @since 3.1.1
 */
public class MainScoreboardJoinShow implements Listener {

    /**
     * Handles the main scoreboard for new players
     *
     * @param e an event representing a player joining
     * @see PlayerJoinEvent
     * @since 3.1.1
     */
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		var player = e.getPlayer();
		
		if (!config.getBoolean("scoreboards.main.enable"))
			return;
		
		if (config.getStringList("scoreboards.main.worlds.enable").contains(player.getWorld().getName())) {
            //schedule 1 tick later, so the player is fully connected
		    new BukkitRunnable() {
                @Override
                public void run() {
                    MainScoreboardManager.getInstance().register(player);
                }
            }.runTaskLater(Main.getInstance(), 1L);
		}
	}
}