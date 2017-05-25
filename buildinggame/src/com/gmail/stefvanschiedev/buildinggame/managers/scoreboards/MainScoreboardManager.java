package com.gmail.stefvanschiedev.buildinggame.managers.scoreboards;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.utils.scoreboards.MainScoreboard;
import org.jetbrains.annotations.Contract;

public final class MainScoreboardManager {

	private final Collection<Player> players = new ArrayList<>();
	private final MainScoreboard scoreboard = new MainScoreboard();
	
	@Contract(pure = true)
    public MainScoreboard getScoreboard() {
		return scoreboard;
	}
	
	public void register(Player player) {
		if (!players.contains(player))
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
	
	private static final MainScoreboardManager INSTANCE = new MainScoreboardManager();
	
	@Contract(pure = true)
    public static MainScoreboardManager getInstance() {
		return INSTANCE;
	}
}