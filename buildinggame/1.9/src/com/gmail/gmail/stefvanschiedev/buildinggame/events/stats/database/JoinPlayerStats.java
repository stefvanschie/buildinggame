package com.gmail.stefvanschiedev.buildinggame.events.stats.database;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by TomVerschueren on 17/10/2016.
 */
public class JoinPlayerStats implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        final Player player = event.getPlayer();
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
            	if (!StatManager.getInstance().containsUUID(player.getUniqueId()) && StatManager.getInstance().getMySQLDatabase() != null)
            		StatManager.getInstance().getMySQLDatabase().insertPlayer(player.getUniqueId().toString());
            	
                for (StatType statType : StatType.values())
                    StatManager.getInstance().registerStat(player, statType, StatManager.getInstance().getMySQLDatabase().getStat(player.getUniqueId().toString(),statType.toString().toLowerCase()));
            }
        });
    }
}