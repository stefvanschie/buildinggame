package me.stefvanschie.buildinggame.utils.plot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.GameState;
import me.stefvanschie.buildinggame.utils.GamePlayer;
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
	private Map<Player, Integer> timesVoted = new HashMap<Player, Integer>();
	private GamePlayer gamePlayer;
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
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (getParticles().size() != config.getInt("max-particles")) {
			particles.add(particle);
		} else {
			MessageManager.getInstance().send(getGamePlayer().getPlayer(),
					messages.getString("particle.max-particles"));
		}
	}
	
	public void addVote(Vote vote) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (getArena().getState() != GameState.VOTING) {
			return;
		}
		
		if (vote.getSender() == getGamePlayer().getPlayer()) {
			if (!vote.getSender().getName().equals("stefvanschie")) {
				//just so I can bypass not able to vote
				//makes my life easier :)
				MessageManager.getInstance().send(vote.getSender(), messages.getString("vote.own-plot"));
				return;
			}
		}
		
		//check how many times voted
		if (getTimesVoted(vote.getSender()) == config.getInt("max-vote-change")) {
			MessageManager.getInstance().send(vote.getSender(), ChatColor.RED + "You can only change your vote " + config.getInt("max-vote-change") + " times");
			return;
		}
		
		getTimesVoted().put(vote.getSender(), getTimesVoted(vote.getSender()) + 1);
		
		MessageManager.getInstance().send(vote.getSender(), messages.getString("vote.message")
				.replace("%playerplot%", getArena().getVotingPlot().getGamePlayer().getPlayer().getName())
				.replace("%points%", vote.getPoints() + ""));
		
		ArenaManager.getInstance().getArena(vote.getSender()).getPlot(vote.getSender()).getGamePlayer().sendTitle(messages.getString("vote.title")
				.replace("%points%", vote.getPoints() + ""));
		ArenaManager.getInstance().getArena(vote.getSender()).getPlot(vote.getSender()).getGamePlayer().sendSubtitle(messages.getString("vote.subtitle")
				.replace("%points%", vote.getPoints() + ""));
		
		if (hasVoted(vote.getSender())) {
			getVotes().remove(getVote(vote.getSender()));
		}
		
		votes.add(vote);
		
		arena.getScoreboard().setScore(getGamePlayer().getPlayer().getName(), getPoints());
		if (!config.getBoolean("names-after-voting")) {
			for (Plot p : arena.getPlots()) {
				if (p.getGamePlayer() != null) {
					Player player = p.getGamePlayer().getPlayer();
					arena.getScoreboard().show(player);
				}
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
	
	public GamePlayer getGamePlayer() {
		return gamePlayer;
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
	
	public Map<Player, Integer> getTimesVoted() {
		return timesVoted;
	}
	
	public List<Player> getTimesVoted(int times) {
		List<Player> players = new ArrayList<Player>();
		
		for (Player player : timesVoted.keySet()) {
			if (timesVoted.get(player) == times) {
				players.add(player);
			}
		}
		
		return players;
	}
	
	public int getTimesVoted(Player player) {
		if (timesVoted.get(player) == null) {
			return 0;
		}
		return timesVoted.get(player);
	}
	
	public Vote getVote(Player player) {
		for (Vote vote : getVotes()) {
			if (vote.getSender() == player) {
				return vote;
			}
		}
		return null;
	}
	
	public List<Vote> getVotes() {
		return votes;
	}
	
	public boolean hasVoted(Player player) {
		for (Vote vote : getVotes()) {
			if (vote.getSender() == player) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isRaining() {
		return raining;
	}
	
	public void join(GamePlayer gamePlayer) {
		if (this.gamePlayer != null) {
			leave();
		}
		this.gamePlayer = gamePlayer;
	}
	
	public void leave() {
		gamePlayer = null;
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
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (!config.getBoolean("restore-plots")) {
			return;
		}
		
		for (BlockState blockState : blocks) {
			blockState.getLocation().getBlock().setType(blockState.getType());
			blockState.getLocation().getBlock().setData(blockState.getRawData());
		}
	}
	
	public void save() {
		if (getBoundary() == null) {
			Main.getInstance().getLogger().warning("No boundary's found. Disabling auto-resetting plots...");
			return;
		}
		
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
	
	public void setPlayer(GamePlayer gamePlayer) {
		this.gamePlayer = gamePlayer;
	}
	
	public void setRaining(boolean raining) {
		this.raining = raining;
		if (raining == true) {
			getGamePlayer().getPlayer().setPlayerWeather(WeatherType.DOWNFALL);
		} else {
			getGamePlayer().getPlayer().setPlayerWeather(WeatherType.CLEAR);
		}
	}
	
	public void setTime(Time time) {
		this.time = time;
		getGamePlayer().getPlayer().setPlayerTime(time.decode(time), false);
	}
	
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
}
