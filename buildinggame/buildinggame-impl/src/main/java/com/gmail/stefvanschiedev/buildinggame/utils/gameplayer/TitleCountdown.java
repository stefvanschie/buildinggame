package com.gmail.stefvanschiedev.buildinggame.utils.gameplayer;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

/**
 * Handles the countdown for titles
 *
 * @since 2.1.0
 */
class TitleCountdown extends BukkitRunnable {

    /**
     * The game player who is assigned to this countdown
     */
	private final GamePlayer gamePlayer;

    /**
     * Constructs a new TitleCountdown for the given game player
     *
     * @param gamePlayer the game player who belongs to this countdown
     * @see GamePlayer
     */
    TitleCountdown(GamePlayer gamePlayer) {
		this.gamePlayer = gamePlayer;
	}

    /**
     * Runs whenever the title has completely faded out and therefore should display a new one
     *
     * @since 2.1.0
     */
	@Override
	public void run() {	
		if (!gamePlayer.getTitles().isEmpty()) {
			YamlConfiguration config = SettingsManager.getInstance().getConfig();
			
			gamePlayer.sendTitle(gamePlayer.getTitles().get(0));	
			gamePlayer.setTitleCountdown(new TitleCountdown(gamePlayer));
			gamePlayer.getTitleCountdown().runTaskLater(Main.getInstance(), config.getInt("title.fade-in") +
                    config.getInt("title.stay") + config.getInt("title.fade-out"));
		} else
			gamePlayer.setTitleCountdown(null);
		
		if (!gamePlayer.getTitles().isEmpty())
			gamePlayer.getTitles().remove(0);
		
	}
}
