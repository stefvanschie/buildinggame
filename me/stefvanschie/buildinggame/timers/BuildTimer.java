package me.stefvanschie.buildinggame.timers;

import me.confuser.barapi.BarAPI;
import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.managers.softdependencies.SDBarApi;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.GameState;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BuildTimer extends BukkitRunnable {

	private int seconds;
	private Arena arena;
	
	public BuildTimer(int seconds, Arena arena) {
		this.seconds = seconds;
		this.arena = arena;
	}
	
	@Override
	public void run() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (seconds <= 0) {
			//voten
			for (Plot plot : arena.getPlots()) {
				if (plot.getPlayerData() != null) {
					Player player = plot.getPlayerData().getPlayer();
					player.setGameMode(GameMode.CREATIVE);
					if (SDBarApi.getInstance().isEnabled()) {
						if (BarAPI.hasBar(player)) {
							BarAPI.removeBar(player);
						}
					}
				}
			}
			arena.getVoteTimer().runTaskTimer(Main.getInstance(), 20L, 20L);
			arena.setState(GameState.VOTING);
			this.cancel();
		} else if (seconds % 60 == 0 || seconds == 30 || seconds == 15 || (seconds <= 10 && seconds >= 1)) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getPlayerData() != null) {
					Player player = plot.getPlayerData().getPlayer();
					MessageManager.getInstance().send(player, messages.getString("buildingCountdown.message")
							.replace("%seconds%", seconds + "")
							.replaceAll("&", "§"));
				}
			}
		}
		seconds--;
	}
	
	public int getSeconds() {
		return seconds;
	}
}
