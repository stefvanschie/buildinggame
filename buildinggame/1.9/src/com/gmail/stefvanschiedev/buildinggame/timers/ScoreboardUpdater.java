package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class ScoreboardUpdater extends BukkitRunnable {

	@Override
	public void run() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			if (arena.getState() == GameState.VOTING && !config.getBoolean("names-after-voting")) {
				for (Plot plot : arena.getUsedPlots()) {
					for (GamePlayer gamePlayer : plot.getGamePlayers()) {
						arena.getScoreboard().show(gamePlayer.getPlayer());
					}
				}
				return;
			}
			
			if (arena.getState() == GameState.RESETING && config.getBoolean("names-after-voting")) {
				for (Plot plot : arena.getUsedPlots()) {
					for (GamePlayer gamePlayer : plot.getGamePlayers()) {
						arena.getScoreboard().show(gamePlayer.getPlayer());
					}
				}
				return;
			}
			
			for (Plot plot : arena.getUsedPlots()) {
				for (GamePlayer gamePlayer : plot.getGamePlayers()) {
					arena.getBuildScoreboard().show(gamePlayer.getPlayer());
				}
			}
		}
	}
}