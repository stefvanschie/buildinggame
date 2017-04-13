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
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class LobbyScoreboard {

	private final ScoreboardManager manager = Bukkit.getScoreboardManager();
	private final Scoreboard scoreboard = manager.getNewScoreboard();
    private final Objective objective = scoreboard.registerNewObjective("bg-lobby", "dummy");
	
    private final Arena arena;
    
    private final List<String> strings = new ArrayList<>();
    private final List<Team> teams = new ArrayList<>();
    
	public LobbyScoreboard(Arena arena) {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(MessageManager.translate(messages.getString("scoreboards.lobby.header")));
		
		this.arena = arena;
		
		List<String> strings = messages.getStringList("scoreboards.lobby.text");
		
		for (int i = 0; i < strings.size(); i++) {
			Team team = scoreboard.registerNewTeam(i + "");
			team.addEntry(ChatColor.values()[i].toString());
			team.setDisplayName("");
			
			teams.add(team);
			this.strings.add(MessageManager.translate(strings.get(i)));
		}
	}
	
	@SuppressWarnings("deprecation")
	public void show(Player player) {
		int place = 0;
		for (int i = teams.size(); i > 0; i--) {
			LocalDateTime localDateTime = LocalDateTime.now();
			
			Team team = teams.get(place);
			String text = strings.get(place)
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
			
			objective.getScore(ChatColor.values()[place].toString()).setScore(i);
			place++;
		}
		
		player.setScoreboard(scoreboard);
	}
	
	@SuppressWarnings("deprecation")
	public void update(Player player) {
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
		player.setScoreboard(scoreboard);
	}
}