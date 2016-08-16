package com.gmail.stefvanschiedev.buildinggame.managers.scoreboards;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.utils.scoreboards.MainScoreboard;

public class MainScoreboardManager {

	private List<Player> players = new ArrayList<>();
	private MainScoreboard scoreboard = new MainScoreboard();
	
	public MainScoreboard getScoreboard() {
		return scoreboard;
	}
	
	public void register(Player player) {
		players.add(player);
	}
	
	public void remove(Player player) {
		players.remove(player);
	}
	
	public void update() {
		for (Player player : players)
			scoreboard.update(player);
	}
	
	private MainScoreboardManager() {}
	
	private static MainScoreboardManager instance = new MainScoreboardManager();
	
	public static MainScoreboardManager getInstance() {
		return instance;
	}
}