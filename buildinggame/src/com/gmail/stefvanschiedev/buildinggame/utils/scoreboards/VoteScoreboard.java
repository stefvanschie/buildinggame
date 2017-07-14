package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

/**
 * The scoreboard displayed when the arena is in voting phase
 *
 * @since 2.1.0
 */
public class VoteScoreboard {

    /**
     * YAML configuration for the messages.yml
     */
	private final YamlConfiguration messages = SettingsManager.getInstance().getMessages();

    /**
     * The global scoreboard manager
     */
	private final ScoreboardManager manager = Bukkit.getScoreboardManager();

    /**
     * The scoreboard this class is a wrapper for
     */
	private final Scoreboard scoreboard = manager.getNewScoreboard();

    /**
     * The objective used for this scoreboard
     */
    private final Objective objective = scoreboard.registerNewObjective("bg-vote", "dummy");

    /**
     * The arena this scoreboard belongs to
     */
    private final Arena arena;

    /**
     * A list of the text to display on the scoreboard after the basic placeholders have been parsed
     */
    private final List<String> strings = new ArrayList<>();

    /**
     * A list of teams that's used to hold the text
     */
    private final List<Team> teams = new ArrayList<>();

    /**
     * Constructs a new VoteScoreboard
     *
     * @param arena the arena this scoreboard belongs to
     */
	public VoteScoreboard(Arena arena) {
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(MessageManager.translate(messages.getString("scoreboards.vote.header")));
	
        this.arena = arena;
        
        List<String> strings = messages.getStringList("scoreboards.vote.text");
		
		for (int i = 0; i < strings.size(); i++) {
			Team team = scoreboard.registerNewTeam(i + "");
			team.addEntry(ChatColor.values()[i].toString());
			team.setDisplayName("");
			
			teams.add(team);
			this.strings.add(MessageManager.translate(strings.get(i)));
		}
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
     * Shows the scoreboard for the specified player
     *
     * @param player the player to show the scoreboard to
     * @since 2.1.0
     */
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
						.replace("%seconds%", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer().getSeconds() + "")
						.replace("%minutes%", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer().getMinutes() + "")
						.replace("%plot%", arena.getPlot(player).getID() + "")
						.replace("%time%", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer().getMinutes() + ":" + arena.getActiveTimer().getSecondsFromMinute())
						.replace("%seconds_from_minute%", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer().getSecondsFromMinute() + "")
						.replace("%blocks_placed%", arena.getPlot(player).getGamePlayer(player).getBlocksPlaced() + "")
						.replace("%money%", SDVault.getInstance().isEnabled() ? SDVault.getEconomy().getBalance(player.getName()) + "" : "%money%")
						.replace("%vote%", arena.getVotingPlot() == null ? "0" : arena.getVotingPlot().getVote(player) == null ? "0" : arena.getVotingPlot().getVote(player) + "")
						.replace("%vote_name%", arena.getVotingPlot() == null ? "?" : arena.getVotingPlot().getVote(player) == null ? "?" :
							arena.getVotingPlot().getVote(player).getPoints() == 2 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.second-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 3 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.third-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 4 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.fourth-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 5 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.fifth-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 6 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.sixth-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 7 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.seventh-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 8 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.eighth-slot-block")) : "?")
						.replace("%playerplot%", arena.getVotingPlot() == null ? arena.getPlot(player) == null ? "?" : arena.getPlot(player).getPlayerFormat() : arena.getVotingPlot().getPlayerFormat())
                        .replace("%date_day_of_month%", localDateTime.getDayOfMonth() + "")
                        .replace("%date_day_of_week%", localDateTime.getDayOfWeek() + "")
                        .replace("%date_day_of_year%", localDateTime.getDayOfYear() + "")
                        .replace("%date_hour%", localDateTime.getHour() + "")
                        .replace("%date_minute%", localDateTime.getMinute() + "")
                        .replace("%date_month%", localDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault()))
                        .replace("%date_second%", localDateTime.getSecond() + "")
                        .replace("%date_year%", localDateTime.getYear() + "");
				
				int length = text.length();
				
				team.setPrefix(text.substring(0, length > 16 ? 16 : length));
				
				if (length > 16)
					team.setSuffix(ChatColor.getLastColors(team.getPrefix()) + text.substring(16, length > 32 ? 32 : length));
				
				objective.getScore(ChatColor.values()[i].toString()).setScore(strings.size() - i);
			}
		}
		
		player.setScoreboard(scoreboard);
	}
}