package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Score;
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
 * @since 2.1.0
 */
public class VoteScoreboard extends ArenaScoreboard {

    /**
     * YAML configuration for the messages.yml
     */
	private final YamlConfiguration messages = SettingsManager.getInstance().getMessages();

    /**
     * Constructs a new VoteScoreboard
     *
     * @param arena the arena this scoreboard belongs to
     */
	public VoteScoreboard(Arena arena) {
		super(arena);
	}

	/**
     * Sets the score for the specified text to the amount of points
     *
     * @param name the name of the player
     * @param points the ne amount of points
     * @since 2.1.0
     */
	public void setScore(String name, int points) {
		Score score = objective.getScore(name);
		score.setScore(points);
	}

    /**
     * {@inheritDoc}
     */
    @Override
	@SuppressWarnings("deprecation")
	public void show(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (config.getBoolean("scoreboards.vote.text")) {
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
						.replace("%plot%", arena.getPlot(player).getID() + "")
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
						.replace("%vote_name%", arena.getVotingPlot() == null ? "?" : arena.getVotingPlot()
                                .getVote(player) == null ? "?" :
							arena.getVotingPlot().getVote(player).getPoints() == 2 ? ChatColor
                                    .translateAlternateColorCodes('&', messages
                                            .getString("voting.second-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 3 ? ChatColor
                                    .translateAlternateColorCodes('&', messages
                                            .getString("voting.third-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 4 ? ChatColor
                                    .translateAlternateColorCodes('&', messages
                                            .getString("voting.fourth-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 5 ? ChatColor
                                    .translateAlternateColorCodes('&', messages
                                            .getString("voting.fifth-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 6 ? ChatColor
                                    .translateAlternateColorCodes('&', messages
                                            .getString("voting.sixth-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 7 ? ChatColor
                                    .translateAlternateColorCodes('&', messages
                                            .getString("voting.seventh-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 8 ? ChatColor
                                    .translateAlternateColorCodes('&', messages
                                            .getString("voting.eighth-slot-block")) : "?")
						.replace("%playerplot%", arena.getVotingPlot() == null ? arena.getPlot(player) == null ?
                                "?" : arena.getPlot(player).getPlayerFormat() : arena.getVotingPlot().getPlayerFormat())
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
		}
		
		player.setScoreboard(scoreboard);
	}

    /**
     * {@inheritDoc}
     */
    @Nls
    @NotNull
    @Contract(pure = true)
    @Override
    public String getHeader() {
        return MessageManager.translate(SettingsManager.getInstance().getMessages()
                .getString("scoreboards.vote.header"));
    }

    /**
     * {@inheritDoc}
     */
    @NotNull
    @Contract(pure = true)
    @Override
    public List<String> getLines() {
        return SettingsManager.getInstance().getMessages().getStringList("scoreboards.vote.text");
    }
}