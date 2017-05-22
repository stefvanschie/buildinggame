package com.gmail.stefvanschiedev.buildinggame.events.scoreboards;

import com.gmail.stefvanschiedev.buildinggame.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.scoreboards.MainScoreboardManager;
import org.bukkit.scheduler.BukkitRunnable;

public class MainScoreboardJoinShow implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		Player player = e.getPlayer();
		MainScoreboardManager manager = MainScoreboardManager.getInstance();
		
		if (!config.getBoolean("scoreboards.main.enable"))
			return;
		
		if (config.getStringList("scoreboards.main.worlds.enable").contains(player.getWorld().getName())) {
            //schedule 1 tick later, so the player is fully connected
		    new BukkitRunnable() {
                @Override
                public void run() {
                    manager.getScoreboard().show(player);
                    manager.register(player);
                }
            }.runTaskLater(Main.getInstance(), 1L);
		}
	}
}