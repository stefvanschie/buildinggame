package com.gmail.stefvanschiedev.buildinggame.utils.plot;

import java.util.*;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.WeatherType;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.ItemBuilder;
import com.gmail.stefvanschiedev.buildinggame.utils.Time;
import com.gmail.stefvanschiedev.buildinggame.utils.Vote;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.ArenaMode;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.BuildMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.spectatormenu.SpectatorMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.entity.NbtFactory;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.entity.NmsClasses;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.entity.NbtFactory.NbtCompound;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.Particle;

public class Plot {

	private Arena arena;
	private boolean raining;
	private Boundary boundary;
	private Floor floor;
	private final int ID;
	private final List<GamePlayer> gamePlayers = new ArrayList<>();
	private final Collection<BlockState> blocks = new ArrayList<>();
	private final Map<Entity, Location> entities;
	private final Collection<Vote> votes = new ArrayList<>();
	private final Collection<Particle> particles = new ArrayList<>();
	private Location location;
	private final Map<Player, Integer> timesVoted = new HashMap<>();
	private Time time = Time.AM6;
	private final BuildMenu buildMenu;
	
	public Plot(int ID) {
		this.ID = ID;
		
		this.buildMenu = new BuildMenu(this);
		this.entities = new HashMap<>();
	}
	
	public boolean addEntity(Entity entity) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (getArena().getState() == GameState.WAITING || getArena().getState() == GameState.STARTING)
			return false;
		
		if (!config.getBoolean("mobs.allow"))
			return false;
		
		if (config.getStringList("blocked-entities").contains(entity.getType().toString().toLowerCase(Locale.getDefault())))
			return false;
		
		if (config.getBoolean("mobs.enable-noai")) {
			NbtCompound nbt = NbtFactory.createCompound();
			nbt.put("NoAI", 1);
			NmsClasses.setTag(entity, nbt.getHandle());
		}
		
		entities.put(entity, entity.getLocation());
		return true;
	}
	
	public void addParticle(Particle particle, CommandSender player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (getParticles().size() != config.getInt("max-particles"))
			particles.add(particle);
		else
			MessageManager.getInstance().send(player, messages.getStringList("particle.max-particles"));
	}
	
	public void addSpectator(final Player spectator, GamePlayer spectates) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		final GamePlayer gamePlayer = new GamePlayer(spectator, GamePlayerType.SPECTATOR);
		gamePlayer.setSpectates(spectates);
		
		getAllGamePlayers().add(gamePlayer);
		
		for (GamePlayer player : getAllGamePlayers())
			player.getPlayer().hidePlayer(spectator);
		
		spectator.getInventory().setItem(config.getInt("leave-item.slot"), IDDecompiler.getInstance().decompile(spectator, config.getString("leave-item.id")).setDisplayName(MessageManager.translate(messages.getString("leave-item.name"))).setClickEvent(event -> {
            gamePlayer.connect(MainSpawnManager.getInstance().getServer(), MainSpawnManager.getInstance().getMainSpawn());
            removeSpectator(gamePlayer);
            MessageManager.getInstance().send(spectator, ChatColor.GREEN + "Stopped spectating");
            return true;
        }));
		spectator.getInventory().setItem(8, new ItemBuilder(spectator, Material.EMERALD).setDisplayName(ChatColor.GREEN + "Spectator menu").setClickEvent(event -> {
            new SpectatorMenu().open(spectator);
            return true;
        }));
		
		spectator.teleport(spectates.getPlayer().getLocation());
		spectator.setGameMode(GameMode.CREATIVE);
		spectator.setCanPickupItems(false);
	}
	
	public void addVote(Vote vote) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (getArena().getState() != GameState.VOTING)
			return;
		
		for (GamePlayer gamePlayer : getGamePlayers()) {
			if (vote.getSender().getName().equals("stefvanschie"))
				break;
			else {
				if (gamePlayer.getPlayer().equals(vote.getSender())) {
					MessageManager.getInstance().send(vote.getSender(), messages.getStringList("vote.own-plot"));
					return;
				}
			}
		}
		
		//check how many times voted
		if (getTimesVoted(vote.getSender()) == config.getInt("max-vote-change")) {
			for (String message : messages.getStringList("vote.maximum-votes"))
				MessageManager.getInstance().send(vote.getSender(), message
						.replace("%max_votes%", config.getInt("max-votes-change") + ""));

			return;
		}
		
		getTimesVoted().put(vote.getSender(), getTimesVoted(vote.getSender()) + 1);
		
		for (String message : messages.getStringList("vote.message"))
			MessageManager.getInstance().send(vote.getSender(), message
					.replace("%playerplot%", getArena().getVotingPlot().getPlayerFormat())
					.replace("%points%", vote.getPoints() + ""));
		
		for (String message : messages.getStringList("vote.receiver")) {
			for (GamePlayer player : getArena().getVotingPlot().getGamePlayers())
				MessageManager.getInstance().send(player.getPlayer(), message
						.replace("%points%", vote.getPoints() + "")
						.replace("%sender%", vote.getSender().getName()));
		}

		Arena senderArena = ArenaManager.getInstance().getArena(vote.getSender());

		if (senderArena != null) {
            for (GamePlayer player : senderArena.getPlot(vote.getSender()).getGamePlayers())
                player.addTitleAndSubtitle(messages.getString("vote.title")
                        .replace("%points%", vote.getPoints() + ""), messages.getString("vote.subtitle")
                        .replace("%points%", vote.getPoints() + ""));
        }
		
		if (hasVoted(vote.getSender()))
			getVotes().remove(getVote(vote.getSender()));
		
		votes.add(vote);
		
		if (!config.getBoolean("scoreboards.vote.text"))
			arena.getVoteScoreboard().setScore(getPlayerFormat(), getPoints());
		
		if (!config.getBoolean("names-after-voting") && config.getBoolean("scoreboards.vote.enable")) {
			for (Plot p : arena.getPlots()) {
				if (!p.getGamePlayers().isEmpty()) {
					for (GamePlayer player : getGamePlayers())
						arena.getVoteScoreboard().show(player.getPlayer());
				}
			}
		}
	}
	
	public Collection<GamePlayer> getAllGamePlayers() {
		return gamePlayers;
	}
	
	private Arena getArena() {
		return arena;
	}
	
	public Boundary getBoundary() {
		return boundary;
	}
	
	public BuildMenu getBuildMenu() {
		return buildMenu;
	}
	
	public Map<Entity, Location> getEntities() {
		return entities;
	}
	
	public Floor getFloor() {
		return floor;
	}
	
	public GamePlayer getGamePlayer(Player player) {
		for (GamePlayer gamePlayer : getAllGamePlayers()) {
			if (gamePlayer.getPlayer().equals(player)) {
				return gamePlayer;
			}
		}
		return null;
	}
	
	public List<GamePlayer> getGamePlayers() {
		List<GamePlayer> gamePlayers = new ArrayList<>();
		
		for (GamePlayer gamePlayer : getAllGamePlayers()) {
			if (gamePlayer.getGamePlayerType() == GamePlayerType.PLAYER)
				gamePlayers.add(gamePlayer);
		}
		
		return gamePlayers;
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
	
	public Collection<Particle> getParticles() {
		return particles;
	}
	
	public int getPlayers() {
		return getGamePlayers().size();
	}
	
	public String getPlayerFormat() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		StringBuilder players = new StringBuilder();
		
		for (int i = 0; i < getGamePlayers().size(); i++) {
			GamePlayer player = getGamePlayers().get(i);
			
			if (i == getGamePlayers().size() - 1) {
				players.append(player.getPlayer().getName());
			} else if (i == getGamePlayers().size() - 2) {
				players.append(player.getPlayer().getName()).append(messages.getString("global.combine-names"));
			} else {
				players.append(player.getPlayer().getName()).append(", ");
			}
		}
		
		return players.toString();
	}
	
	public int getPoints() {
		int points = 0;
		
		for (Vote vote : votes) {
			points += vote.getPoints();
		}
		
		return points;
	}
	
	public Iterable<GamePlayer> getSpectators() {
		Collection<GamePlayer> spectators = new ArrayList<>();
		
		for (GamePlayer gamePlayer : getAllGamePlayers()) {
			if (gamePlayer.getGamePlayerType() == GamePlayerType.SPECTATOR)
				spectators.add(gamePlayer);
		}
		
		return spectators;
	}
	
	public Time getTime() {
		return time;
	}
	
	public Map<Player, Integer> getTimesVoted() {
		return timesVoted;
	}
	
	private int getTimesVoted(Player player) {
		if (timesVoted.get(player) == null) {
			return 0;
		}
		return timesVoted.get(player);
	}
	
	public Vote getVote(Player player) {
		for (Vote vote : getVotes()) {
			if (vote.getSender().equals(player)) {
				return vote;
			}
		}
		return null;
	}
	
	public Collection<Vote> getVotes() {
		return votes;
	}
	
	public boolean hasVoted(Player player) {
		for (Vote vote : getVotes()) {
			if (vote.getSender().equals(player)) {
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
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (arena.getMode() == ArenaMode.TEAM) {
			if (!isFull()) {
				gamePlayers.add(gamePlayer);
				
				for (String s : MessageManager.translate(messages.getStringList("join.plot.message")))
					MessageManager.getInstance().send(gamePlayer.getPlayer(), s.replace("%plot%", getID() + ""));
				
				return true;
			} else {
				MessageManager.getInstance().send(gamePlayer.getPlayer(), MessageManager.translate(messages.getStringList("join.plot.full")));
				return false;
			}
		} else {
			if (gamePlayers.size() == 1) {
				gamePlayers.remove(0);
				gamePlayers.add(gamePlayer);
			} else
				gamePlayers.add(gamePlayer);
			
			for (String s : MessageManager.translate(messages.getStringList("join.plot.message")))
				MessageManager.getInstance().send(gamePlayer.getPlayer(), s.replace("%plot%", getID() + ""));
			
			return true;
		}
	}
	
	public void leave(GamePlayer gamePlayer) {
		gamePlayers.remove(gamePlayer);
	}
	
	public void removeSpectator(GamePlayer spectator) {
		getAllGamePlayers().remove(spectator);
		
		for (GamePlayer player : getAllGamePlayers())
			player.getPlayer().showPlayer(spectator.getPlayer());
		
		Player spPlayer = spectator.getPlayer();
		spectator.restore();
		spPlayer.setCanPickupItems(true);
		
		ItemBuilder.check(spPlayer);
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
		
		setRaining(false);
		setTime(Time.AM6);
		
		getParticles().clear();
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
	
	public void setBoundary(Boundary boundary) {
		this.boundary = boundary;
	}
	
	public void setFloor(Floor floor) {
		this.floor = floor;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void setRaining(boolean raining) {
		this.raining = raining;
		if (raining) {
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
			gamePlayer.getPlayer().setPlayerTime(time.decode(), false);
		}
	}
}
