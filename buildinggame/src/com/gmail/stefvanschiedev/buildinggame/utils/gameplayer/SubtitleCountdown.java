package com.gmail.stefvanschiedev.buildinggame.utils.gameplayer;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

public class SubtitleCountdown extends BukkitRunnable {

	private final GamePlayer gamePlayer;
	
	public SubtitleCountdown(GamePlayer gamePlayer) {
		this.gamePlayer = gamePlayer;
	}
	
	@Override
	public void run() {			
		if (gamePlayer.getSubtitles().size() > 0) {
			YamlConfiguration config = SettingsManager.getInstance().getConfig();
			
			gamePlayer.sendSubtitle(gamePlayer.getSubtitles().get(0));	
			gamePlayer.setSubtitleCountdown(new SubtitleCountdown(gamePlayer));
			gamePlayer.getSubtitleCountdown().runTaskLater(Main.getInstance(), config.getInt("title.fade_in") + config.getInt("title.stay") + config.getInt("title.fade_out"));
		} else
			gamePlayer.setSubtitleCountdown(null);
		
		if (gamePlayer.getSubtitles().size() > 0)
			gamePlayer.getSubtitles().remove(0);
	}
}