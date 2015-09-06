package me.stefvanschie.buildinggame.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

public class Plot {

	private int ID;
	private int points;
	private PlayerData playerData;
	private List<BlockState> blocks = new ArrayList<BlockState>();
	private List<Vote> votes = new ArrayList<Vote>();
	private Location location;
	private Boundary boundary;
	private Arena arena;
	
	public Plot(int ID) {
		this.ID = ID;
	}
	
	public void addVote(Vote vote) {
		votes.add(vote);
		arena.getScoreboard().setScore(getPlayerData().getPlayer().getName(), arena.getScoreboard().getScore(getPlayerData().getPlayer().getName()).getScore() + vote.getPoints());
		for (Plot p : arena.getPlots()) {
			if (p.getPlayerData() != null) {
				Player player = p.getPlayerData().getPlayer();
				arena.getScoreboard().show(player);
			}
		}
	}
	
	public Arena getArena() {
		return arena;
	}
	
	public List<BlockState> getBlocks() {
		return blocks;
	}
	
	public Boundary getBoundary() {
		return boundary;
	}
	
	public int getID() {
		return ID;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public PlayerData getPlayerData() {
		return playerData;
	}
	
	public int getPoints() {
		return points;
	}
	
	public List<Vote> getVotes() {
		return votes;
	}
	
	public void join(PlayerData playerData) {
		if (this.playerData != null) {
			leave();
		}
		this.playerData = playerData;
	}
	
	public void leave() {
		playerData = null;
	}
	
	public void removeVote(Vote vote) {
		votes.remove(vote);
	}
	
	@SuppressWarnings("deprecation")
	public void restore() {
		for (BlockState blockState : blocks) {
			blockState.getLocation().getBlock().setType(blockState.getType());
			blockState.getLocation().getBlock().setData(blockState.getRawData());
		}
	}
	
	public void save() {
		for (Block block : getBoundary().getAllBlocks()) {
			blocks.add(block.getState());
		}
	}
	
	public void setArena(Arena arena) {
		this.arena = arena;
	}
	
	public void setBlocks(List<BlockState> blocks) {
		this.blocks = blocks;
	}
	
	public void setBoundary(Boundary boundary) {
		this.boundary = boundary;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setPlayer(PlayerData playerData) {
		this.playerData = playerData;
	}
	
	public void setPoints(int points) {
		this.points = points;
	}
	
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
}
