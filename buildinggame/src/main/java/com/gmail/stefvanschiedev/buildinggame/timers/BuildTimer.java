package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.utils.CommandUtil;
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
import org.jetbrains.annotations.Contract;

/**
 * This handles the building time for an arena
 *
 * @since 2.1.0
 */
public class BuildTimer extends Timer {

	/**
     * The original amount of seconds
     */
	private final int originalSeconds;

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
	    super(arena);

		this.seconds = seconds;
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
        var bossBar = arena.getBossBar();

        if (seconds <= 0) {
			//vote
            arena.getUsedPlots().stream().flatMap(plot -> plot.getAllGamePlayers().stream()).forEach(gamePlayer -> {
                var player = gamePlayer.getPlayer();

                player.setGameMode(GameMode.CREATIVE);
                player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

                //messages
                MessageManager.getInstance().send(player,
                    messages.getStringList("buildingCountdown.time-up.message"));

                gamePlayer.addTitleAndSubtitle(messages.getString("buildingCountdown.time-up.title"),
                    messages.getString("buildingCountdown.time-up.subtitle"));
                gamePlayer.sendActionbar(messages.getString("buildingCountdown.time-up.actionbar"));

                if (bossBar.getPlayers().contains(player))
                    bossBar.removePlayer(player);
            });

			arena.setState(GameState.VOTING);
			arena.getVoteTimer().runTaskTimer(Main.getInstance(), 20L, 20L);
			running = false;
			this.cancel();
			return;
		} else if (seconds % 60 == 0 || seconds == 30 || seconds == 15 || (seconds <= 10 && seconds >= 1))
            arena.getUsedPlots().stream().flatMap(plot -> plot.getGamePlayers().stream()).forEach(gamePlayer -> {
                Player player = gamePlayer.getPlayer();

                messages.getStringList("buildingCountdown.message").forEach(message ->
                    MessageManager.getInstance().send(player, message
                        .replace("%seconds%", getSeconds() + "")
                        .replace("%minutes%", getMinutes() + "")
                        .replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
                        .replace("%seconds_from_minute%", getSecondsFromMinute() + ""))
                );

                gamePlayer.addTitleAndSubtitle(messages.getString("buildingCountdown.title")
                        .replace("%seconds%", getSeconds() + "")
                        .replace("%minutes%", getMinutes() + "")
                        .replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
                        .replace("%seconds_from_minute%", getSecondsFromMinute() + ""),
                    messages.getString("buildingCountdown.subtitle")
                        .replace("%seconds%", getSeconds() + "")
                        .replace("%minutes%", getMinutes() + "")
                        .replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
                        .replace("%seconds_from_minute%", getSecondsFromMinute() + ""));
                gamePlayer.sendActionbar(messages.getString("buildingCountdown.actionbar")
                    .replace("%seconds%", String.valueOf(seconds))
                    .replace("%minutes%", String.valueOf(getMinutes()))
                    .replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
                    .replace("%seconds_from_minutes%", String.valueOf(getSecondsFromMinute())));
            });

        arena.getUsedPlots().forEach(plot -> plot.getGamePlayers().forEach(gamePlayer ->
                gamePlayer.getPlayer().setLevel(getSeconds())));
		
		//bossbar
		bossBar.setTitle(MessageManager.translate(messages.getString("global.bossbar-header"))
				.replace("%seconds%", getSeconds() + "")
				.replace("%seconds_from_minutes%", getSecondsFromMinute() + "")
				.replace("%minutes%", getMinutes() + "")
				.replace("%subject%", arena.getSubject()));
		bossBar.setProgress((double) getSeconds() / (double) getOriginalSeconds());
		
		//timings
		try {
            config.getConfigurationSection("timings.build-timer.at").getKeys(false).forEach(key -> {
                if (seconds == Integer.parseInt(key)) {
                    config.getStringList("timings.build-timer.at." + Integer.parseInt(key)).forEach(command ->
                        CommandUtil.dispatch(command.replace("%arena%", arena.getName())));
                }
            });
            config.getConfigurationSection("timings.build-timer.every").getKeys(false).forEach(key -> {
                if (seconds % Integer.parseInt(key) == 0) {
                    config.getStringList("timings.build-timer.every." + Integer.parseInt(key)).forEach(command ->
                        CommandUtil.dispatch(command.replace("%arena%", arena.getName())));
                }
            });
		} catch (NullPointerException | NumberFormatException ignore) {}

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
}