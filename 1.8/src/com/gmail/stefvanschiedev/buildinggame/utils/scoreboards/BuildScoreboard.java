package com.gmail.stefvanschiedev.buildinggame.utils.scoreboards;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class BuildScoreboard {

	YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard scoreboard = manager.getNewScoreboard();  
    Objective objective = scoreboard.registerNewObjective("buildinggame", "dummy");
	
    Arena arena;
    
    private List<String> strings = new ArrayList<String>();
    
	public BuildScoreboard(Arena arena) {
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName(messages.getString("global.buildScoreboardHeader")
				.replace("%:a%", "ä")
				.replace("%:e%", "ë")
				.replace("%:i%", "ï")
				.replace("%:o%", "ö")
				.replace("%:u%", "ü")
				.replace("%ss%", "ß")
				.replaceAll("&", "§"));
		
		this.arena = arena;
		
		for (String line : messages.getStringList("global.buildScoreboardText")) {
			strings.add(line);
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
	
	@SuppressWarnings("deprecation")
	public void show(Player player) {
		int place = 0;
		for (int i = strings.size(); i > 0; i--) {
			setScore(strings.get(place)
					.replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
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
					.replaceAll("&", "§"), i);
			place++;
		}
		
		player.setScoreboard(scoreboard);
	}
	
	@SuppressWarnings("deprecation")
	public void update(Player player) {
		List<String> text = new ArrayList<String>();
		for (int i = 0; i < strings.size(); i++) {
			text.add(strings.get(i).replace("%:a%", "ä")
					.replace("%:e%", "ë")
					.replace("%:i%", "ï")
					.replace("%:o%", "ö")
					.replace("%:u%", "ü")
					.replace("%ss%", "ß")
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
					.replaceAll("&", "§"));
		}
		for (String string : scoreboard.getEntries()) {
			if (!strings.get(strings.size() - objective.getScore(string).getScore()).contains("%")) {
				continue;
			}
			scoreboard.resetScores(string);
		}
		
		int place = 0;
		for (int i = strings.size(); i > 0; i--) {
			if (!strings.get(place).contains("%")) {
				place++;
				continue;
			}
			setScore(text.get(place), i);
			place++;
		}
		player.setScoreboard(scoreboard);
	}
	
	private void setScore(String name, int points) {
		Score score = objective.getScore(name);
		score.setScore(points);
	}
}