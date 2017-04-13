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
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

public class MainScoreboard {

	private final ScoreboardManager manager = Bukkit.getScoreboardManager();
	private final Scoreboard scoreboard = manager.getNewScoreboard();
    private final Objective objective = scoreboard.registerNewObjective("bg-main", "dummy");
    
    private final List<String> strings = new ArrayList<>();
    private final List<Team> teams = new ArrayList<>();
    
	public MainScoreboard() {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(MessageManager.translate(messages.getString("scoreboards.main.header")));
		
		List<String> strings = messages.getStringList("scoreboards.main.text");
		
		for (int i = 0; i < strings.size(); i++) {
			Team team = scoreboard.registerNewTeam(i + "");
			team.addEntry(ChatColor.values()[i].toString());
			team.setDisplayName("");
			
			teams.add(team);
			this.strings.add(MessageManager.translate(strings.get(i)));
		}
	}
	
	public void show(Player player) {
		if (!player.isOnline())
			return;
		
		int place = 0;
		for (int i = teams.size(); i > 0; i--) {
			Team team = teams.get(place);
			
			StatManager manager = StatManager.getInstance();
            LocalDateTime localDateTime = LocalDateTime.now();
			
			String text = strings.get(place)
					.replace("%stat_plays%", manager.getStat(player, StatType.PLAYS) == null ? "0" : manager.getStat(player, StatType.PLAYS).getValue() + "")
					.replace("%stat_first%", manager.getStat(player, StatType.FIRST) == null ? "0" : manager.getStat(player, StatType.FIRST).getValue() + "")
					.replace("%stat_second%", manager.getStat(player, StatType.SECOND) == null ? "0" : manager.getStat(player, StatType.SECOND).getValue() + "")
					.replace("%stat_third%", manager.getStat(player, StatType.THIRD) == null ? "0" : manager.getStat(player, StatType.THIRD).getValue() + "")
					.replace("%stat_broken%", manager.getStat(player, StatType.BROKEN) == null ? "0" : manager.getStat(player, StatType.BROKEN).getValue() + "")
					.replace("%stat_placed%", manager.getStat(player, StatType.PLACED) == null ? "0" : manager.getStat(player, StatType.PLACED).getValue() + "")
					.replace("%stat_walked%", manager.getStat(player, StatType.WALKED) == null ? "0" : manager.getStat(player, StatType.WALKED).getValue() + "")
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
	

	public void update(Player player) {
		if (!player.isOnline())
			return;
		
		for (int i = 0; i < strings.size(); i++) {
			Team team = teams.get(i);
			
			StatManager manager = StatManager.getInstance();
			LocalDateTime localDateTime = LocalDateTime.now();
			
			String text = strings.get(i)
					.replace("%stat_plays%", manager.getStat(player, StatType.PLAYS) == null ? "0" : manager.getStat(player, StatType.PLAYS).getValue() + "")
					.replace("%stat_first%", manager.getStat(player, StatType.FIRST) == null ? "0" : manager.getStat(player, StatType.FIRST).getValue() + "")
					.replace("%stat_second%", manager.getStat(player, StatType.SECOND) == null ? "0" : manager.getStat(player, StatType.SECOND).getValue() + "")
					.replace("%stat_third%", manager.getStat(player, StatType.THIRD) == null ? "0" : manager.getStat(player, StatType.THIRD).getValue() + "")
					.replace("%stat_broken%", manager.getStat(player, StatType.BROKEN) == null ? "0" : manager.getStat(player, StatType.BROKEN).getValue() + "")
					.replace("%stat_placed%", manager.getStat(player, StatType.PLACED) == null ? "0" : manager.getStat(player, StatType.PLACED).getValue() + "")
					.replace("%stat_walked%", manager.getStat(player, StatType.WALKED) == null ? "0" : manager.getStat(player, StatType.WALKED).getValue() + "")
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