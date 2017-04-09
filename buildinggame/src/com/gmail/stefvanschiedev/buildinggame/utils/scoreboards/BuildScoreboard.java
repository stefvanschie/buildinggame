package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import java.util.ArrayList;
import java.util.Calendar;
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

public class BuildScoreboard {

	private final ScoreboardManager manager = Bukkit.getScoreboardManager();
	private final Scoreboard scoreboard = manager.getNewScoreboard();
    private final Objective objective = scoreboard.registerNewObjective("bg-build", "dummy");
    
    private final Arena arena;
    
    private final List<String> strings = new ArrayList<>();
    private final List<Team> teams = new ArrayList<>();
    
	public BuildScoreboard(Arena arena) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(MessageManager.translate(messages.getString("scoreboards.build.header")));
		
		this.arena = arena;
		
		List<String> strings = messages.getStringList("scoreboards.build.text");
		
		for (int i = 0; i < strings.size(); i++) {
			Team team = scoreboard.registerNewTeam(i + "");
			team.addEntry(ChatColor.values()[i].toString());
			team.setDisplayName("");
			
			teams.add(team);
			this.strings.add(MessageManager.translate(strings.get(i)));
		}
	}
	
	@SuppressWarnings("deprecation")
	public void update(Player player) {
		for (int i = 0; i < strings.size(); i++) {
			Calendar calendar = Calendar.getInstance();
			
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
					.replace("%money%", SDVault.getInstance().isEnabled() ? SDVault.getInstance().getEconomy().getBalance(player.getName()) + "" : "%money%")
					.replace("%vote%", arena.getVotingPlot() == null ? "0" : arena.getVotingPlot().getVote(player) == null ? "0" : arena.getVotingPlot().getVote(player) + "")
					.replace("%playerplot%", arena.getVotingPlot() == null ? arena.getPlot(player) == null ? "?" : arena.getPlot(player).getPlayerFormat() : arena.getVotingPlot().getPlayerFormat())
					.replace("%date_day_of_month%", calendar.get(Calendar.DAY_OF_MONTH) + "")
					.replace("%date_day_of_week%", calendar.get(Calendar.DAY_OF_WEEK) + "")
					.replace("%date_day_of_year%", calendar.get(Calendar.DAY_OF_YEAR) + "")
					.replace("%date_hour%", calendar.get(Calendar.HOUR) + "")
					.replace("%date_hour_of_day%", calendar.get(Calendar.HOUR_OF_DAY) + "")
					.replace("%date_millisecond%", calendar.get(Calendar.MILLISECOND) + "")
					.replace("%date_minute%", calendar.get(Calendar.MINUTE) + "")
					.replace("%date_month%", calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()))
					.replace("%date_second%", calendar.get(Calendar.SECOND) + "")
					.replace("%date_week_of_month%", calendar.get(Calendar.WEEK_OF_MONTH) + "")
					.replace("%date_week_of_year%", calendar.get(Calendar.WEEK_OF_YEAR) + "")
					.replace("%date_year%", calendar.get(Calendar.YEAR) + "");
			
			int length = text.length();
			
			team.setPrefix(text.substring(0, length > 16 ? 16 : length));
			
			if (length > 16)
				team.setSuffix(ChatColor.getLastColors(team.getPrefix()) + text.substring(16, length > 32 ? 32 : length));
			
			objective.getScore(ChatColor.values()[i].toString()).setScore(strings.size() - i);
		}
		player.setScoreboard(scoreboard);
	}
}