package com.gmail.stefvanschiedev.buildinggame.events.scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.scoreboards.MainScoreboardManager;

public class MainScoreboardWorldChange implements Listener {

	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent e) {
		Player player = e.getPlayer();
		World world = MainSpawnManager.getInstance().getMainSpawn().getWorld();
		MainScoreboardManager manager = MainScoreboardManager.getInstance();
		
		if (player.getWorld() == world) {
			//show scoreboard and other stuff
			manager.register(player);
			manager.getScoreboard().show(player);
			return;
		}
		
		if (e.getFrom() == world) {
			//remove scoreboard and other stuff
			manager.remove(player);
			player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
			return;
		}
	}
}