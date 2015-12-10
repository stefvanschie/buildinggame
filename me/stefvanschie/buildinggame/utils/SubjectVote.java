package me.stefvanschie.buildinggame.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class SubjectVote {

	private int votes = 0;
	private List<Player> players = new ArrayList<Player>();
	
	public SubjectVote(int votes) {
		this.votes = votes;
	}
	
	public void addPlayer(Player player) {
		players.add(player);
	}
	
	public int getVotes() {
		return votes;
	}
	
	public List<Player> getPlayers() {
		return players;
	}
	
	public void removePlayer(Player player) {
		players.remove(player);
	}
	
	public void setVotes(int votes) {
		this.votes = votes;
	}
}