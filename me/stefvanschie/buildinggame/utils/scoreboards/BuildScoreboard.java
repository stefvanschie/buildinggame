package me.stefvanschie.buildinggame.utils.scoreboards;

import java.util.List;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.softdependencies.SDVault;
import me.stefvanschie.buildinggame.utils.arena.Arena;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class BuildScoreboard {

	YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard scoreboard = manager.getNewScoreboard();  
    Objective objective = scoreboard.registerNewObjective("buildinggame", "dummy");
	
    Arena arena;
    
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
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		List<String> list = messages.getStringList("global.buildScoreboardText");
		int place = 0;
		for (int i = list.size(); i > 0; i--) {
			setScore(list.get(place)
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
					.replace("%minutes", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer().getMinutes() + "")
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
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		List<String> list = messages.getStringList("global.buildScoreboardText");
		for (String string : scoreboard.getEntries()) {
			if (!list.get(list.size() - objective.getScore(string).getScore()).contains("%")) {
				continue;
			}
			scoreboard.resetScores(string);
		}
		
		int place = 0;
		for (int i = list.size(); i > 0; i--) {
			if (!list.get(place).contains("%")) {
				place++;
				continue;
			}
			setScore(list.get(place)
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
					.replace("%minutes", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer().getMinutes() + "")
					.replace("%time%", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer().getMinutes() + ":" + arena.getActiveTimer().getSecondsFromMinute())
					.replace("%seconds_from_minute%", arena.getActiveTimer() == null ? "0" : arena.getActiveTimer().getSecondsFromMinute() + "")
					.replace("%blocks_placed%", arena.getPlot(player).getGamePlayer(player).getBlocksPlaced() + "")
					.replace("%money%", SDVault.getInstance().isEnabled() ? SDVault.getInstance().getEconomy().getBalance(player.getName()) + "" : "%money%")
					.replaceAll("&", "§"), i);
			place++;
		}
		player.setScoreboard(scoreboard);
	}
	
	private void setScore(String name, int points) {
		Score score = objective.getScore(name);
		score.setScore(points);
	}
}
