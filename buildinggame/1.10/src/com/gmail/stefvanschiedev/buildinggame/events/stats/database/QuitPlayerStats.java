package com.gmail.stefvanschiedev.buildinggame.events.stats.database;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

public class QuitPlayerStats implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        final Player player = event.getPlayer();
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new BukkitRunnable() {
            @Override
            public void run() {
                for (StatType type : StatType.values())
                    StatManager.getInstance().getMySQLDatabase().setStat(player.getUniqueId().toString(), type.toString().toLowerCase(), StatManager.getInstance().getStat(player, type).getValue());
            }
        });
	}
}