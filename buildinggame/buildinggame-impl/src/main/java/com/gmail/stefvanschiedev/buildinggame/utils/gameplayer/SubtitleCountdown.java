package com.gmail.stefvanschiedev.buildinggame.utils.gameplayer;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

/**
 * Handles the countdown for subtitles
 *
 * @since 2.1.0
 */
class SubtitleCountdown extends BukkitRunnable {

    /**
     * The game player who is assigned to this countdown
     */
	private final GamePlayer gamePlayer;

	/**
     * Constructs a new SubtitleCountdown for the given game player
     *
     * @param gamePlayer the game player who belongs to this countdown
     * @see GamePlayer
     */
    SubtitleCountdown(GamePlayer gamePlayer) {
		this.gamePlayer = gamePlayer;
	}

	/**
     * Runs whenever the subtitle has completely faded out and therefore should display a new one
     *
     * @since 2.1.0
     */
	@Override
	public void run() {			
		if (!gamePlayer.getSubtitles().isEmpty()) {
			YamlConfiguration config = SettingsManager.getInstance().getConfig();
			
			gamePlayer.sendSubtitle(gamePlayer.getSubtitles().get(0));	
			gamePlayer.setSubtitleCountdown(new SubtitleCountdown(gamePlayer));
			gamePlayer.getSubtitleCountdown().runTaskLater(Main.getInstance(),
                    config.getInt("title.fade-in") + config.getInt("title.stay") +
                            config.getInt("title.fade-out"));
		} else
			gamePlayer.setSubtitleCountdown(null);
		
		if (!gamePlayer.getSubtitles().isEmpty())
			gamePlayer.getSubtitles().remove(0);
	}
}