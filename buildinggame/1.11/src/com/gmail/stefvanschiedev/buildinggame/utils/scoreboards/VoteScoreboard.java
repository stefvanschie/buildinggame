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
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class VoteScoreboard {
	
	YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard scoreboard = manager.getNewScoreboard();  
    Objective objective = scoreboard.registerNewObjective("bg-vote", "dummy");
	
    private Arena arena;
    
    private List<String> strings = new ArrayList<>();
    private List<Team> teams = new ArrayList<>();
    
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
	
	public String getDisplayName() {
		return objective.getDisplayName();
	}
	
	public DisplaySlot getDisplaySlot() {
		return objective.getDisplaySlot();
	}
	
	public Score getScore(String name) {
		return objective.getScore(name);
	}
	
	public void setDisplayName(String displayName) {
		objective.setDisplayName(displayName);
	}
	
	public void setDisplaySlot(DisplaySlot displaySlot) {
		objective.setDisplaySlot(displaySlot);
	}
	
	public void setScore(String name, int points) {
		Score score = objective.getScore(name);
		score.setScore(points);
	}
	
	@SuppressWarnings("deprecation")
	public void show(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (config.getBoolean("scoreboards.vote.text")) {
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
						.replace("%vote_name%", arena.getVotingPlot() == null ? "?" : arena.getVotingPlot().getVote(player) == null ? "?" :
							arena.getVotingPlot().getVote(player).getPoints() == 2 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.second-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 3 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.third-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 4 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.fourth-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 5 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.fifth-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 6 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.sixth-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 7 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.seventh-slot-block")) :
							arena.getVotingPlot().getVote(player).getPoints() == 8 ? ChatColor.translateAlternateColorCodes('&', messages.getString("voting.eighth-slot-block")) : "?")
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
		}
		
		player.setScoreboard(scoreboard);
	}
}