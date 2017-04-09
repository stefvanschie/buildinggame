package com.gmail.stefvanschiedev.buildinggame.events.scoreboards;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.scoreboards.MainScoreboardManager;

public class MainScoreboardWorldChange implements Listener {

	@EventHandler
	public void onWorldChange(PlayerChangedWorldEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		Player player = e.getPlayer();
		MainScoreboardManager manager = MainScoreboardManager.getInstance();
		
		if (!config.getBoolean("scoreboards.main.enable"))
			return;
		
		if (config.getStringList("scoreboards.main.worlds.enable").contains(player.getWorld().getName())) {
			//show scoreboard and other stuff
			manager.register(player);
			manager.getScoreboard().show(player);
		} else if (config.getStringList("scoreboards.main.worlds.enable").contains(e.getFrom().getName())) {
			//show scoreboard and other stuff
			manager.remove(player);
			player.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
		}
	}
}