package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.utils.CommandUtil;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

/**
 * This timer handles the lobby time
 *
 * @since 2.1.0
 */
public class LobbyTimer extends Timer {

	/**
     * The config.yml YAML configuration
     */
	private final YamlConfiguration config = SettingsManager.getInstance().getConfig();

	/**
     * The messages.yml YAML configuration
     */
	private final YamlConfiguration messages = SettingsManager.getInstance().getMessages();

	/**
     * Constructs a new WaitTimer with the given amount of seconds
     *
     * @param seconds the amount of time
     * @param arena the arena this timer belongs to
     */
	public LobbyTimer(int seconds, Arena arena) {
	    super(arena);

		this.seconds = seconds;
	}

	/**
     * Called whenever a second has passed
     *
     * @since 2.1.0
     */
	@Override
	public void run() {
		if (seconds <= 0) {
			arena.preStart();
            running = false;
			this.cancel();
			return;
		} else if (seconds % 15 == 0 || (seconds <= 10 && seconds >= 1)) {
            arena.getUsedPlots().stream().flatMap(plot -> plot.getGamePlayers().stream()).forEach(gamePlayer -> {
                var player = gamePlayer.getPlayer();

                messages.getStringList("lobbyCountdown.message").forEach(message ->
                    MessageManager.getInstance().send(player, message
                        .replace("%seconds%", seconds + "")
                        .replace("%minutes%", getMinutes() + "")
                        .replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
                        .replace("%seconds_from_minute%", getSecondsFromMinute() + ""))
                );
            });
		}

        arena.getUsedPlots().forEach(plot -> plot.getGamePlayers().forEach(gamePlayer ->
                gamePlayer.getPlayer().setLevel(seconds)));
		
		//timings
		try {
            config.getConfigurationSection("timings.lobby-timer.at").getKeys(false).forEach(key -> {
                if (seconds == Integer.parseInt(key)) {
                    config.getStringList("timings.lobby-timer.at." + Integer.parseInt(key)).forEach(command ->
                        CommandUtil.dispatch(command.replace("%arena%", arena.getName())));
                }
            });
            config.getConfigurationSection("timings.lobby-timer.every").getKeys(false).forEach(key -> {
                if (seconds % Integer.parseInt(key) == 0) {
                    config.getStringList("timings.lobby-timer.every." + Integer.parseInt(key)).forEach(command ->
                        CommandUtil.dispatch(command.replace("%arena%", arena.getName())));
                }
            });
		} catch (NullPointerException | NumberFormatException ignore) {}

		seconds--;
	}

    /**
     * {@inheritDoc}
     */
	@NotNull
    @Override
    public synchronized BukkitTask runTaskTimer(@NotNull Plugin plugin, long delay, long period)
        throws IllegalArgumentException, IllegalStateException {
        running = true;

	    return super.runTaskTimer(plugin, delay, period);
    }

	/**
     * Changes the amount of seconds left
     *
     * @param seconds the new amount of seconds left
     * @since 2.1.0
     */
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}