package me.stefvanschie.buildinggame.utils.plot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.PlayerData;
import me.stefvanschie.buildinggame.utils.Time;
import me.stefvanschie.buildinggame.utils.Vote;
import me.stefvanschie.buildinggame.utils.particle.Particle;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.WeatherType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Plot {

	private boolean raining = false;
	private int ID;
	private PlayerData playerData;
	private List<BlockState> blocks = new ArrayList<BlockState>();
	private List<Vote> votes = new ArrayList<Vote>();
	private List<Particle> particles = new ArrayList<Particle>();
	private Location location;
	private Boundary boundary;
	private Arena arena;
	private Time time = Time.AM6;
	private Floor floor;
	
	public Plot(int ID) {
		this.ID = ID;
	}
	
	public void addParticle(Particle particle) {
		particles.add(particle);
	}
	
	public void addVote(Vote vote) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (vote.getSender() == getPlayerData().getPlayer()) {
			MessageManager.getInstance().send(vote.getSender(), ChatColor.RED + "You can't vote on your own plot");
			return;
		}
		
		MessageManager.getInstance().send(getPlayerData().getPlayer(), messages.getString("vote.message")
				.replace("%playerplot%", getArena().getVotingPlot().getPlayerData().getPlayer().getName())
				.replace("%points%", vote.getPoints() + ""));
		
		votes.add(vote);
		
		Iterator<Vote> iterator = votes.iterator();
		while (iterator.hasNext()) {
			Vote v = iterator.next();
			if (v.getSender() == vote.getSender()) {
				votes.remove(v);
			}
		}
		
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
	
	public Floor getFloor() {
		return floor;
	}
	
	public int getID() {
		return ID;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public List<Particle> getParticles() {
		return particles;
	}
	
	public PlayerData getPlayerData() {
		return playerData;
	}
	
	public int getPoints() {
		int points = 0;
		
		for (Vote vote : votes) {
			points += vote.getPoints();
		}
		
		return points;
	}
	
	public Time getTime() {
		return time;
	}
	
	public List<Vote> getVotes() {
		return votes;
	}
	
	public boolean isRaining() {
		return raining;
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
	
	public void removeParticle(int index) {
		particles.remove(index);
	}
	
	public void removeParticle(Particle particle) {
		particles.remove(particle);
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
	
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setParticles(List<Particle> particles) {
		this.particles = particles;
	}
	
	public void setPlayer(PlayerData playerData) {
		this.playerData = playerData;
	}
	
	public void setRaining(boolean raining) {
		this.raining = raining;
		if (raining == true) {
			getPlayerData().getPlayer().setPlayerWeather(WeatherType.DOWNFALL);
		} else {
			getPlayerData().getPlayer().setPlayerWeather(WeatherType.CLEAR);
		}
	}
	
	public void setTime(Time time) {
		this.time = time;
		getPlayerData().getPlayer().setPlayerTime(time.decode(time), false);
	}
	
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
}
