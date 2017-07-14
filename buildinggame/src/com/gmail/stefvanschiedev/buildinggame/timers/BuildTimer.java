package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;

/**
 * This handles the building time for an arena
 *
 * @since 2.1.0
 */
public class BuildTimer extends Timer {

    /**
     * Whether this timer is active or not
     */
	private boolean running;

	/**
     * The original amount of seconds
     */
	private final int originalSeconds;

	/**
     * Amount of seconds this timer has left
     */
	private int seconds;

	/**
     * The arena this timer belongs to
     */
	private final Arena arena;

	/**
     * The config.yml YAML configuration
     */
	private final YamlConfiguration config = SettingsManager.getInstance().getConfig();

	/**
     * The messages.yml YAML configuration
     */
	private final YamlConfiguration messages = SettingsManager.getInstance().getMessages();

	/**
     * Constructs a new BuildTimer with the given amount of seconds
     *
     * @param seconds the amount of time
     * @param arena the arena this timer belongs to
     */
	public BuildTimer(int seconds, Arena arena) {
		this.seconds = seconds;
		this.arena = arena;
		originalSeconds = seconds;
	}

	/**
     * Called when a second has passed
     *
     * @since 2.1.0
     */
	@Override
	public void run() {
		running = true;
		if (seconds <= 0) {
			//voten
			for (Plot plot : arena.getUsedPlots()) {
				for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
					Player player = gamePlayer.getPlayer();
					
					player.setGameMode(GameMode.CREATIVE);
					player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
				
					//messages
					MessageManager.getInstance().send(player, messages.getStringList("buildingCountdown.time-up.message"));
					
					gamePlayer.addTitleAndSubtitle(messages.getString("buildingCountdown.time-up.title"),
							messages.getString("buildingCountdown.time-up.subtitle"));
				
					if (arena.getBossBar().getPlayers().contains(player))
						arena.getBossBar().removePlayer(player);
				}
			}
			arena.setState(GameState.VOTING);
			arena.getVoteTimer().runTaskTimer(Main.getInstance(), 20L, 20L);
			running = false;
			this.cancel();
			return;
		} else if (seconds % 60 == 0 || seconds == 30 || seconds == 15 || (seconds <= 10 && seconds >= 1)) {
			for (Plot plot : arena.getUsedPlots()) {
				for (GamePlayer gamePlayer : plot.getGamePlayers()) {
					Player player = gamePlayer.getPlayer();
					for (String message : messages.getStringList("buildingCountdown.message"))
						MessageManager.getInstance().send(player, message
								.replace("%seconds%", getSeconds() + "")
								.replace("%minutes%", getMinutes() + "")
								.replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
								.replace("%seconds_from_minute%", getSecondsFromMinute() + ""));
					gamePlayer.addTitleAndSubtitle(messages.getString("buildingCountdown.title")
							.replace("%seconds%", getSeconds() + "")
							.replace("%minutes%", getMinutes() + "")
							.replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
							.replace("%seconds_from_minute%", getSecondsFromMinute() + ""), messages.getString("buildingCountdown.subtitle")
							.replace("%seconds%", getSeconds() + "")
							.replace("%minutes%", getMinutes() + "")
							.replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
							.replace("%seconds_from_minute%", getSecondsFromMinute() + ""));
				}
			}
		}
		for (Plot plot : arena.getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player player = gamePlayer.getPlayer();
				
				player.setLevel(getSeconds());
			}
		}
		
		//bossbar
		arena.getBossBar().setTitle(MessageManager.translate(messages.getString("global.bossbar-header"))
				.replace("%seconds%", getSeconds() + "")
				.replace("%seconds_from_minutes%", getSecondsFromMinute() + "")
				.replace("%minutes%", getMinutes() + "")
				.replace("%subject%", arena.getSubject()));
		arena.getBossBar().setProgress((double) getSeconds() / (double) getOriginalSeconds());
		
		//timings
		try {
			for (String key : config.getConfigurationSection("timings.build-timer.at").getKeys(false)) {
                if (seconds == Integer.parseInt(key)) {
                    for (String command : config.getStringList("timings.build-timer.at." + Integer.parseInt(key)))
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
                }
			}
			for (String key : config.getConfigurationSection("timings.build-timer.every").getKeys(false)) {
                if (seconds % Integer.parseInt(key) == 0) {
                    for (String command : config.getStringList("timings.build-timer.every." + Integer.parseInt(key)))
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
                }
			}
		} catch (NullPointerException | NumberFormatException e) {}
		seconds--;
	}

	/**
     * Returns the original amount of seconds
     *
     * @return original amount of time
     * @since 2.1.0
     */
	@Contract(pure = true)
    private int getOriginalSeconds() {
		return originalSeconds;
	}

	/**
     * Returns the amount of seconds left
     *
     * @return amount of seconds left
     * @since 2.1.0
     */
	@Contract(pure = true)
	@Override
	public int getSeconds() {
		return seconds;
	}

	/**
     * Returns whether this timer is running or not
     *
     * @return true if this timer is running, false otherwise
     * @since 2.1.0
     */
	@Contract(pure = true)
	public boolean isActive() {
		return running;
	}
}