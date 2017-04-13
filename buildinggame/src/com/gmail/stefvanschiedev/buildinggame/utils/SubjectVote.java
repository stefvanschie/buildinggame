package com.gmail.stefvanschiedev.buildinggame.utils;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.entity.Player;

public class SubjectVote {

	private int votes;
	private final Collection<Player> players = new ArrayList<>();
	
	public SubjectVote(int votes) {
		this.votes = votes;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public int getVotes() {
		return votes;
	}
	
	public Collection<Player> getPlayers() {
		return players;
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	public void setVotes(int votes) {
		this.votes = votes;
	}
}