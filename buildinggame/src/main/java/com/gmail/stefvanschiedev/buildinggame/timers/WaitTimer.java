package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.utils.Target;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.Contract;

/**
 * This timer handles the lobby time
 *
 * @since 2.1.0
 */
public class WaitTimer extends Timer {

    /**
     * The amount of seconds left
     */
	private int seconds;

	/**
     * The arena this timer belongs to
     */
	private final Arena arena;

    /**
     * Whether this timer is running or not
     */
    private boolean running;

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
	public WaitTimer(int seconds, Arena arena) {
		this.seconds = seconds;
		this.arena = arena;
	}

	/**
     * Called whenever a second has passed
     *
     * @since 2.1.0
     */
	@Override
	public void run() {
		if (seconds <= 0) {
			arena.start();
            running = false;
			this.cancel();
			return;
		} else if (seconds % 15 == 0 || (seconds <= 10 && seconds >= 1)) {
			for (Plot plot : arena.getUsedPlots()) {
				for (GamePlayer gamePlayer : plot.getGamePlayers()) {
					Player player = gamePlayer.getPlayer();

					for (String message : messages.getStringList("lobbyCountdown.message")) {
						MessageManager.getInstance().send(player, message
								.replace("%seconds%", seconds + "")
								.replace("%minutes%", getMinutes() + "")
								.replace("%time%", getMinutes() + ":" + getSecondsFromMinute())
								.replace("%seconds_from_minute%", getSecondsFromMinute() + ""));
					}
				}
			}
		}

        arena.getUsedPlots().forEach(plot -> plot.getGamePlayers().forEach(gamePlayer ->
                gamePlayer.getPlayer().setLevel(seconds)));
		
		//timings
		try {
			for (String key : config.getConfigurationSection("timings.lobby-timer.at").getKeys(false)) {
                if (seconds == Integer.parseInt(key)) {
                    for (String command : config.getStringList("timings.lobby-timer.at." + Integer
                        .parseInt(key))) {
                        command = command.replace("%arena%", arena.getName());

                        if (!command.isEmpty() && command.charAt(0) == '@') {
                            String targetText = command.split(" ")[0];

                            Target.parse(targetText).execute(command.substring(targetText.length() + 1));
                        } else
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                    }
                }
			}
			for (String key : config.getConfigurationSection("timings.lobby-timer.every").getKeys(false)) {
                if (seconds % Integer.parseInt(key) == 0) {
                    for (String command : config.getStringList("timings.lobby-timer.every." + Integer
                        .parseInt(key))) {
                        command = command.replace("%arena%", arena.getName());

                        if (!command.isEmpty() && command.charAt(0) == '@') {
                            String targetText = command.split(" ")[0];

                            Target.parse(targetText).execute(command.substring(targetText.length() + 1));
                        } else
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
                    }
                }
			}
		} catch (NullPointerException | NumberFormatException ignore) {}

		seconds--;
	}

    /**
     * {@inheritDoc}
     */
	@Override
    public synchronized BukkitTask runTaskTimer(Plugin plugin, long delay, long period) throws IllegalArgumentException,
            IllegalStateException {
        running = true;

	    return super.runTaskTimer(plugin, delay, period);
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
     * Returns whether this timer is active or not
     *
     * @return true if this timer is active, false otherwise
     * @since 2.1.0
     */
	@Contract(pure = true)
	public boolean isActive() {
		return running;
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