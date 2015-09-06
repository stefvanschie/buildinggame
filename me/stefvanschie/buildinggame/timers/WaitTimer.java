package me.stefvanschie.buildinggame.timers;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.Plot;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class WaitTimer extends BukkitRunnable {

	private int seconds;
	private int originalSeconds;
	private Arena arena;
	
	public WaitTimer(int seconds, Arena arena) {
		this.seconds = seconds;
		originalSeconds = seconds;
		this.arena = arena;
	}
	
	@Override
	public void run() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (seconds <= 0) {
			arena.start();
			this.cancel();
		} else if ((seconds != originalSeconds && seconds % 15 == 0) || (seconds <= 10 && seconds >= 1)) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getPlayerData() != null) {
					Player player = plot.getPlayerData().getPlayer();
					MessageManager.getInstance().send(player, messages.getString("lobbyCountdown.message")
							.replace("%seconds%", seconds + "")
							.replaceAll("&", "§"));
				}
			}
		}
		for (Plot plot : arena.getPlots()) {
			if (plot.getPlayerData() != null) {
				Player player = plot.getPlayerData().getPlayer();
				
				player.setLevel(seconds);
			}
		}
		seconds--;
	}
	
	public int getSeconds() {
		return seconds;
	}
	
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}
