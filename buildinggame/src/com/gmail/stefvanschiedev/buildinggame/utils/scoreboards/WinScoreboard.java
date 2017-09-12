package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * The scoreboard displayed when the arena is in voting phase
 *
 * @since 2.3.0
 */
public class WinScoreboard extends ArenaScoreboard {

    /**
     * Constructs a new WinScoreboard
     *
     * @param arena the arena this scoreboard belongs to
     */
	public WinScoreboard(Arena arena) {
        super(arena);
	}

    /**
     * {@inheritDoc}
     */
    @Override
	@SuppressWarnings("deprecation")
	public void show(Player player) {
		for (int i = 0; i < strings.size(); i++) {
            LocalDateTime localDateTime = LocalDateTime.now();
			
			Team team = teams.get(i);
			String text = strings.get(i)
					.replace("%arena%", arena.getName())
					.replace("%players%", arena.getPlayers() + "")
					.replace("%max_players%", arena.getMaxPlayers() + "")
					.replace("%subject%", arena.getSubject() != null ? arena.getSubject() : "?")
					.replace("%seconds%", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer()
                            .getSeconds() + "")
					.replace("%minutes%", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer()
                            .getMinutes() + "")
					.replace("%plot%", arena.getPlot(player) == null ? "?" : arena.getPlot(player).getID() + "")
					.replace("%time%", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer()
                            .getMinutes() + ":" + arena.getActiveTimer().getSecondsFromMinute())
					.replace("%seconds_from_minute%", arena.getActiveTimer() == null ? "0" : arena
                            .getActiveTimer().getSecondsFromMinute() + "")
					.replace("%blocks_placed%", arena.getPlot(player).getGamePlayer(player)
                            .getBlocksPlaced() + "")
					.replace("%money%", SDVault.getInstance().isEnabled() ? SDVault.getEconomy()
                            .getBalance(player.getName()) + "" : "%money%")
					.replace("%vote%", arena.getVotingPlot() == null ? "0" : arena.getVotingPlot()
                            .getVote(player) == null ? "0" : arena.getVotingPlot().getVote(player) + "")
					.replace("%playerplot%", arena.getVotingPlot() == null ? arena.getPlot(player) == null ?
                            "?" : arena.getPlot(player).getPlayerFormat() : arena.getVotingPlot().getPlayerFormat())
					.replace("%first_players%", arena.getFirstPlot() == null ? "?" : arena.getFirstPlot()
                            .getPlayerFormat())
					.replace("%second_players%", arena.getSecondPlot() == null ? "?" : arena.getSecondPlot()
                            .getPlayerFormat())
					.replace("%third_players%", arena.getThirdPlot() == null ? "?" : arena.getThirdPlot()
                            .getPlayerFormat())
                    .replace("%date_day_of_month%", localDateTime.getDayOfMonth() + "")
                    .replace("%date_day_of_week%", localDateTime.getDayOfWeek() + "")
                    .replace("%date_day_of_year%", localDateTime.getDayOfYear() + "")
                    .replace("%date_hour%", localDateTime.getHour() + "")
                    .replace("%date_minute%", localDateTime.getMinute() + "")
                    .replace("%date_month%", localDateTime.getMonth().getDisplayName(TextStyle.FULL,
                            Locale.getDefault()))
                    .replace("%date_second%", localDateTime.getSecond() + "")
                    .replace("%date_year%", localDateTime.getYear() + "");
			
			int length = text.length();
			
			team.setPrefix(text.substring(0, length > 16 ? 16 : length));
			
			if (length > 16)
				team.setSuffix(ChatColor.getLastColors(team.getPrefix()) + text.substring(16, length > 32 ? 32 :
                        length));
			
			objective.getScore(ChatColor.values()[i].toString()).setScore(strings.size() - i);
		}

		player.setScoreboard(scoreboard);
	}

    /**
     * {@inheritDoc}
     */
    @Nls
    @Contract(pure = true)
    @NotNull
    @Override
    public String getHeader() {
        return MessageManager.translate(SettingsManager.getInstance().getMessages()
                .getString("scoreboards.win.header"));
    }

    /**
     * {@inheritDoc}
     */
    @Contract(pure = true)
    @NotNull
    @Override
    public List<String> getLines() {
        return SettingsManager.getInstance().getMessages().getStringList("scoreboards.win.text");
    }
}