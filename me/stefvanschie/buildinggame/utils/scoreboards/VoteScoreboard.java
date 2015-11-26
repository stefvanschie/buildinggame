package me.stefvanschie.buildinggame.utils.scoreboards;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class VoteScoreboard {
	
	YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard scoreboard = manager.getNewScoreboard();  
    Objective objective = scoreboard.registerNewObjective("votes", "dummy");
	
	public VoteScoreboard() {
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(messages.getString("global.scoreboardHeader")
         		.replaceAll("&", "§"));
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
	
	public void show(Player player) {
		player.setScoreboard(scoreboard);
	}
}
