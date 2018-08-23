package com.gmail.stefvanschiedev.buildinggame.timers;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.scoreboards.MainScoreboardManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;

/**
 * Loads/Reloads all scoreboards
 *
 * @since 2.1.0
 */
public class ScoreboardUpdater extends BukkitRunnable {

    /**
     * Loads/Reloads all scoreboards for all arenas and plots
     *
     * @since 2.1.0
     */
	@Override
	public void run() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		ArenaManager.getInstance().getArenas().forEach(arena -> {
			if ((arena.getState() == GameState.WAITING || arena.getState() == GameState.STARTING) &&
                    config.getBoolean("scoreboards.lobby.enable"))
                arena.getUsedPlots().forEach(plot -> plot.getGamePlayers().forEach(gamePlayer ->
                        arena.getLobbyScoreboard(plot).show(gamePlayer.getPlayer())));
			else if (arena.getState() == GameState.BUILDING && config.getBoolean("scoreboards.build.enable"))
				arena.getUsedPlots().forEach(plot -> plot.getGamePlayers().forEach(gamePlayer ->
                        arena.getBuildScoreboard(plot).show(gamePlayer.getPlayer())));
			else if (arena.getState() == GameState.VOTING && !config.getBoolean("names-after-voting") &&
                    config.getBoolean("scoreboards.vote.enable"))
                arena.getUsedPlots().forEach(plot -> plot.getGamePlayers().forEach(gamePlayer ->
                        arena.getVoteScoreboard(plot).show(gamePlayer.getPlayer())));
			else if (arena.getState() == GameState.RESETING && !config.getBoolean("names-after-voting") &&
                    config.getBoolean("scoreboards.win.enable"))
                arena.getUsedPlots().forEach(plot -> plot.getGamePlayers().forEach(gamePlayer ->
                        arena.getWinScoreboard(plot).show(gamePlayer.getPlayer())));
			else if (arena.getState() == GameState.RESETING && config.getBoolean("names-after-voting") &&
                    config.getBoolean("scoreboards.vote.enable"))
                arena.getUsedPlots().forEach(plot -> plot.getGamePlayers().forEach(gamePlayer ->
                        arena.getVoteScoreboard(plot).show(gamePlayer.getPlayer())));
		});
		
		if (config.getBoolean("scoreboards.main.enable"))
			MainScoreboardManager.getInstance().update();
	}
}