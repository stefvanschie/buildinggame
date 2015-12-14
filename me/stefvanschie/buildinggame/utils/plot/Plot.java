package me.stefvanschie.buildinggame.utils.plot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.GameState;
import me.stefvanschie.buildinggame.utils.GamePlayer;
import me.stefvanschie.buildinggame.utils.Time;
import me.stefvanschie.buildinggame.utils.Vote;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.arena.ArenaMode;
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
	private List<GamePlayer> gamePlayers = new ArrayList<GamePlayer>();
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
	
	public void addParticle(Particle particle, Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (getParticles().size() != config.getInt("max-particles")) {
			particles.add(particle);
		} else {
			MessageManager.getInstance().send(player,
					messages.getString("particle.max-particles"));
		}
	}
	
	public void addVote(Vote vote) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (getArena().getState() != GameState.VOTING) {
			return;
		}
		
		for (GamePlayer gamePlayer : getGamePlayers()) {
			if (vote.getSender().getName().equals("stefvanschie")) {
				break;
			} else {
				if (gamePlayer.getPlayer() == vote.getSender()) {
					MessageManager.getInstance().send(vote.getSender(), messages.getString("vote.own-plot"));
					return;
				}
			}
		}
		
		//check how many times voted
		if (getTimesVoted(vote.getSender()) == config.getInt("max-vote-change")) {
			MessageManager.getInstance().send(vote.getSender(), ChatColor.RED + "You can only change your vote " + config.getInt("max-vote-change") + " times");
			return;
		}
		
		getTimesVoted().put(vote.getSender(), getTimesVoted(vote.getSender()) + 1);
		
		MessageManager.getInstance().send(vote.getSender(), messages.getString("vote.message")
				.replace("%playerplot%", getArena().getVotingPlot().getPlayerFormat())
				.replace("%points%", vote.getPoints() + ""));
		for (GamePlayer player : ArenaManager.getInstance().getArena(vote.getSender()).getPlot(vote.getSender()).getGamePlayers()) {
			player.sendTitle(messages.getString("vote.title")
					.replace("%points%", vote.getPoints() + ""));
			player.sendSubtitle(messages.getString("vote.subtitle")
					.replace("%points%", vote.getPoints() + ""));
		}
		
		if (hasVoted(vote.getSender())) {
			getVotes().remove(getVote(vote.getSender()));
		}
		
		votes.add(vote);
		
		arena.getScoreboard().setScore(getPlayerFormat(), getPoints());
		if (!config.getBoolean("names-after-voting")) {
			for (Plot p : arena.getPlots()) {
				if (!p.getGamePlayers().isEmpty()) {
					for (GamePlayer player : getGamePlayers()) {
						arena.getScoreboard().show(player.getPlayer());
					}
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
	
	public GamePlayer getGamePlayer(Player player) {
		for (GamePlayer gamePlayer : getGamePlayers()) {
			if (gamePlayer.getPlayer() == player) {
				return gamePlayer;
			}
		}
		return null;
	}
	
	public int getID() {
		return ID;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public int getMaxPlayers() {
		return arena.getMaxPlayers() / arena.getPlots().size();
	}
	
	public List<Particle> getParticles() {
		return particles;
	}
	
	public int getPlayers() {
		return getGamePlayers().size();
	}
	
	public String getPlayerFormat() {
		String players = "";
		
		for (int i = 0; i < getGamePlayers().size(); i++) {
			GamePlayer player = getGamePlayers().get(i);
			
			if (i == getGamePlayers().size() - 1) {
				players += player.getPlayer().getName();
			} else if (i == getGamePlayers().size() - 2) {
				players += player.getPlayer().getName() + " and ";
			} else {
				players += player.getPlayer().getName() + ", ";
			}
		}
		
		return players;
	}
	
	public List<GamePlayer> getGamePlayers() {
		return gamePlayers;
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
	
	public boolean isFull() {
		if (getArena().getMode() == ArenaMode.TEAM) {
			if ((arena.getMaxPlayers() / arena.getPlots().size()) == getGamePlayers().size()) {
				return true;
			}
		} else {
			if (!getGamePlayers().isEmpty()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isRaining() {
		return raining;
	}
	
	public boolean join(GamePlayer gamePlayer) {
		if (arena.getMode() == ArenaMode.TEAM) {
			if (!isFull()) {
				gamePlayers.add(gamePlayer);
				return true;
			} else {
				MessageManager.getInstance().send(gamePlayer.getPlayer(), ChatColor.RED + "This team is full");
				return false;
			}
		} else {
			if (gamePlayers.size() == 1) {
				gamePlayers.remove(0);
				gamePlayers.add(gamePlayer);
				return true;
			} else {
				gamePlayers.add(gamePlayer);
				return true;
			}
		}
	}
	
	public void leave(GamePlayer gamePlayer) {
		gamePlayers.remove(gamePlayer);
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
	
	public void setRaining(boolean raining) {
		this.raining = raining;
		if (raining == true) {
			for (GamePlayer gamePlayer : getGamePlayers()) {
				gamePlayer.getPlayer().setPlayerWeather(WeatherType.DOWNFALL);
			}
		} else {
			for (GamePlayer gamePlayer : getGamePlayers()) {
				gamePlayer.getPlayer().setPlayerWeather(WeatherType.CLEAR);
			}
		}
	}
	
	public void setTime(Time time) {
		this.time = time;
		for (GamePlayer gamePlayer : getGamePlayers()) {
			gamePlayer.getPlayer().setPlayerTime(time.decode(time), false);
		}
	}
	
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}
}
