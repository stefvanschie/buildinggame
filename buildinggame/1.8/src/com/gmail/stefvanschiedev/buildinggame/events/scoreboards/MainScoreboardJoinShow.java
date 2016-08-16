package com.gmail.stefvanschiedev.buildinggame.events.scoreboards;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.scoreboards.MainScoreboardManager;

public class MainScoreboardJoinShow implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		MainScoreboardManager manager = MainScoreboardManager.getInstance();
		
		if (player.getWorld() == MainSpawnManager.getInstance().getMainSpawn().getWorld()) {
			manager.getScoreboard().show(player);
			manager.register(player);
		}
	}
}