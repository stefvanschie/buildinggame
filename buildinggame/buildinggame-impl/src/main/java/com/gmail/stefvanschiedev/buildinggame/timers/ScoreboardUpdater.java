package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.game.BuildingGamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.LobbyGamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.SubjectVotePhase;
import com.gmail.stefvanschiedev.buildinggame.game.VotingGamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.WinningGamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.util.GamePhase;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.scoreboards.MainScoreboardManager;

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

        boolean namesAfterVoting = config.getBoolean("names-after-voting");

        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            GamePhase phase = arena.getCurrentPhase();

            for (Plot plot : arena.getUsedPlots()) {
                for (GamePlayer gamePlayer : plot.getGamePlayers()) {
                    if ((phase instanceof LobbyGamePhase || phase instanceof SubjectVotePhase) &&
                        config.getBoolean("scoreboards.lobby.enable")) {
                        plot.getLobbyScoreboard().show(gamePlayer.getPlayer());
                    } else if (phase instanceof BuildingGamePhase &&
                        config.getBoolean("scoreboards.build.enable")) {
                        plot.getBuildScoreboard().show(gamePlayer.getPlayer());
                    } else if (phase instanceof VotingGamePhase &&
                        config.getBoolean("scoreboards.voting.enable") && !namesAfterVoting) {
                        plot.getVoteScoreboard().show(gamePlayer.getPlayer());
                    } else if (phase instanceof WinningGamePhase &&
                        config.getBoolean("scoreboards.win.enable")) {
                        if (namesAfterVoting) {
                            plot.getVoteScoreboard().show(gamePlayer.getPlayer());
                        } else {
                            plot.getWinScoreboard().show(gamePlayer.getPlayer());
                        }
                    }
                }
            }
        }
		
		if (config.getBoolean("scoreboards.main.enable"))
			MainScoreboardManager.getInstance().update();
	}
}