package me.stefvanschie.buildinggame.utils.arena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.confuser.barapi.BarAPI;
import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.arenas.SignManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.mainspawn.MainSpawnManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.managers.softdependencies.SDBarApi;
import me.stefvanschie.buildinggame.timers.BuildTimer;
import me.stefvanschie.buildinggame.timers.VoteTimer;
import me.stefvanschie.buildinggame.timers.WaitTimer;
import me.stefvanschie.buildinggame.timers.WinTimer;
import me.stefvanschie.buildinggame.timers.utils.Timer;
import me.stefvanschie.buildinggame.utils.GamePlayer;
import me.stefvanschie.buildinggame.utils.GameState;
import me.stefvanschie.buildinggame.utils.Lobby;
import me.stefvanschie.buildinggame.utils.VoteBlocks;
import me.stefvanschie.buildinggame.utils.guis.SubjectMenu;
import me.stefvanschie.buildinggame.utils.guis.TeamSelection;
import me.stefvanschie.buildinggame.utils.plot.Plot;
import me.stefvanschie.buildinggame.utils.scoreboards.BuildScoreboard;
import me.stefvanschie.buildinggame.utils.scoreboards.VoteScoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.WeatherType;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Arena {

	private ArenaMode mode = ArenaMode.SOLO;
	private GameState state = GameState.WAITING;
	private List<Plot> plots = new ArrayList<Plot>();
	private List<Plot> votedPlots = new ArrayList<Plot>();
	private List<Sign> signs = new ArrayList<Sign>();
	private Lobby lobby;
	private String name;
	private int maxPlayers = plots.size();
	private int minPlayers;
	private Plot votingPlot;
	private Plot winner;
	private VoteScoreboard voteScoreboard = new VoteScoreboard();
	private BuildScoreboard buildScoreboard = new BuildScoreboard(this);
	private String subject;
	
	private SubjectMenu subjectMenu = new SubjectMenu();
	private TeamSelection teamSelection = new TeamSelection(this);
	
	private WaitTimer waitTimer = new WaitTimer(SettingsManager.getInstance().getConfig().getInt("waittimer"), this);
	private WinTimer winTimer = new WinTimer(SettingsManager.getInstance().getConfig().getInt("wintimer"), this);
	private BuildTimer buildTimer = new BuildTimer(SettingsManager.getInstance().getConfig().getInt("timer"), this);
	private VoteTimer voteTimer = new VoteTimer(SettingsManager.getInstance().getConfig().getInt("votetimer"), this);
	
	public Arena(String name) {
		this.name = name;
	}
	
	public void addPlot(Plot plot) {
		plots.add(plot);
	}
	
	public void addSign(Sign sign) {
		getSigns().add(sign);
	}
	
	public Timer getActiveTimer() {
		if (waitTimer.isActive()) {
			return waitTimer;
		} else if (buildTimer.isActive()) {
			return buildTimer;
		} else if (voteTimer.isActive()) {
			return voteTimer;
		} else if (winTimer.isActive()) {
			return winTimer;
		}
		return null;
	}
	
	public BuildScoreboard getBuildScoreboard() {
		return buildScoreboard;
	}
	
	public BuildTimer getBuildTimer() {
		return buildTimer;
	}
	
	public Lobby getLobby() {
		return lobby;
	}
	
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	public int getMinPlayers() {
		return minPlayers;
	}
	
	public ArenaMode getMode() {
		return mode;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPlayers() {
		int players = 0;
		
		for (Plot plot : getUsedPlots()) {
			players += plot.getGamePlayers().size();
		}
		
		return players;
	}
	
	public Plot getPlot(int ID) {
		for (Plot plot : plots) {
			if (plot.getID() == ID) {
				return plot;
			}
		}
		return null;
	}
	
	public Plot getPlot(Player player) {
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				if (gamePlayer.getPlayer() == player) {
					return plot;
				}
			}
		}
		return null;
	}
	
	public List<Plot> getPlots() {
		return plots;
	}
	
	public VoteScoreboard getScoreboard() {
		return voteScoreboard;
	}
	
	public List<Sign> getSigns() {
		return signs;
	}
	
	public GameState getState() {
		return state;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public SubjectMenu getSubjectMenu() {
		return subjectMenu;
	}
	
	public TeamSelection getTeamSelection() {
		return teamSelection;
	}
	
	public List<Plot> getUsedPlots() {
		List<Plot> usedPlots = new ArrayList<Plot>();
		
		for (Plot plot : getPlots()) {
			if (!plot.getGamePlayers().isEmpty()) {
				usedPlots.add(plot);
			}
		}
		
		return usedPlots;
	}
	
	public List<Plot> getVotedPlots() {
		return votedPlots;
	}
	
	public VoteTimer getVoteTimer() {
		return voteTimer;
	}
	
	public Plot getVotingPlot() {
		return votingPlot;
	}
	
	public WaitTimer getWaitTimer() {
		return waitTimer;
	}
	
	public Plot getWinner() {
		return winner;
	}
	
	public WinTimer getWinTimer() {
		return winTimer;
	}
	
	public boolean isEmpty() {
		return getUsedPlots().isEmpty();
	}
	
	public boolean isFull() {
		return getUsedPlots().size() >= getMaxPlayers();
	}
	
	public boolean isSetup() {
		if (getLobby() == null) {
			return false;
		}
		if (MainSpawnManager.getInstance().getMainSpawn() == null) {
			return false;
		}
		for (Plot plot : getPlots()) {
			if (plot.getBoundary() == null || plot.getFloor() == null) {
				return false;
			}
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public void join(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		//check if everything is set up
		if (!isSetup()) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Your arena isn't setup right, you still need to do this:");
			if (getLobby() == null) {
				MessageManager.getInstance().send(player, ChatColor.RED + " - The lobby of arena " + getName() + "(/bg setlobby " + getName() + ")");
			}
			if (MainSpawnManager.getInstance().getMainSpawn() == null) {
				MessageManager.getInstance().send(player, ChatColor.RED + " - The main spawn (/bg setmainspawn)");
			}
			for (Plot plot : getPlots()) {
				if (plot.getBoundary() == null) {
					MessageManager.getInstance().send(player, ChatColor.RED + " - The boundary of plot " + plot.getID() + " (/bg setbounds " + getName() + " " + plot.getID() + ")");
				}
			}
			for (Plot plot : getPlots()) {
				if (plot.getFloor() == null) {
					MessageManager.getInstance().send(player, ChatColor.RED + " - The floor of plot " + plot.getID() + " (/bg setfloor " + getName() + " " + plot.getID() + ")");
				}
			}
			return;
		}
		
		if (ArenaManager.getInstance().getArena(player) != null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're already in a game");
			return;
		}
		
		if (getState() != GameState.STARTING && getState() != GameState.WAITING) {
			MessageManager.getInstance().send(player, messages.getString("join.in-game"));
			return;
		}
		
		if (isFull()) {
			MessageManager.getInstance().send(player, ChatColor.RED + "This arena is full");
			return;
		}
		
		for (Plot plot : getPlots()) {
			if (!plot.isFull()) {
				plot.join(new GamePlayer(player));
				break;
			}
		}
		
		buildScoreboard.show(player);
		
		MessageManager.getInstance().send(player, messages.getString("join.message")
				.replace("%players%", getPlayers() + "")
				.replace("%max_players%", getMaxPlayers() + ""));
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player pl = gamePlayer.getPlayer();
				
				MessageManager.getInstance().send(pl, messages.getString("join.otherPlayers")
						.replace("%player%", player.getName())
						.replace("%players%", getPlayers() + "")
						.replace("%max_players%", getMaxPlayers() + ""));
			}
		}
		
		
		if (getLobby() != null) {
			player.teleport(getLobby().getLocation());
		}
		player.setGameMode(GameMode.ADVENTURE);
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				buildScoreboard.update(gamePlayer.getPlayer());
			}
		}
		
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		
		if (getPlayers() >= getMinPlayers()) {
			try {
				waitTimer.runTaskTimer(Main.getInstance(), 20L, 20L);
			} catch (IllegalStateException ise) {}
		}
		
		if (getPlayers() >= getMaxPlayers()) {
			waitTimer.setSeconds(0);
		}
		
		//give team selection
		if (getMode() == ArenaMode.TEAM) {
			ItemStack paper = new ItemStack(Material.PAPER, 1);
			ItemMeta paperMeta = paper.getItemMeta();
			paperMeta.setDisplayName(ChatColor.GREEN + "Team selection");
			paper.setItemMeta(paperMeta);
			
			player.getInventory().setItem(0, paper);
		}
		
		//give paper for subject
		if (player.hasPermission("bg.subjectmenu") && config.getBoolean("enable-subject-voting")) {
			ItemStack map = new ItemStack(Material.PAPER, 1);
			ItemMeta mapMeta = map.getItemMeta();
			mapMeta.setDisplayName(messages.getString("subject-gui.item.name")
					.replaceAll("&", "§"));
			List<String> mapLores = new ArrayList<String>();
			for (String lore : messages.getStringList("subject-gui.item.lores")) {
				mapLores.add(lore
						.replaceAll("&", "§"));
			}
			mapMeta.setLore(mapLores);
			map.setItemMeta(mapMeta);
			player.getInventory().setItem(8, map);
		}
		
		player.updateInventory();
		
		SignManager.getInstance().updateJoinSigns(this);
	}
	
	@SuppressWarnings("deprecation")
	public void join(Player player, Plot p) {
		
		//check if everything is set up
		if (!isSetup()) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Your arena isn't setup right, you still need to do this:");
			if (getLobby() == null) {
				MessageManager.getInstance().send(player, ChatColor.RED + " - The lobby of arena " + getName() + "(/bg setlobby " + getName() + ")");
			}
			if (MainSpawnManager.getInstance().getMainSpawn() == null) {
				MessageManager.getInstance().send(player, ChatColor.RED + " - The main spawn (/bg setmainspawn)");
			}
			for (Plot plot : getPlots()) {
				if (plot.getBoundary() == null) {
					MessageManager.getInstance().send(player, ChatColor.RED + " - The boundary of plot " + plot.getID() + " (/bg setbounds " + getName() + " " + plot.getID() + ")");
				}
			}
			for (Plot plot : getPlots()) {
				if (plot.getFloor() == null) {
					MessageManager.getInstance().send(player, ChatColor.RED + " - The floor of plot " + plot.getID() + " (/bg setfloor " + getName() + " " + plot.getID() + ")");
				}
			}
			return;
		}
		
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (ArenaManager.getInstance().getArena(player) != null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're already in a game");
			return;
		}
		
		if (getState() != GameState.STARTING && getState() != GameState.WAITING) {
			MessageManager.getInstance().send(player, messages.getString("join.in-game"));
			return;
		}
		
		if (isFull()) {
			MessageManager.getInstance().send(player, ChatColor.RED + "This arena is full");
			return;
		}
		
		if (p.isFull()) {
			MessageManager.getInstance().send(player, ChatColor.RED + "This team is full");
			return;
		} else {
			p.join(new GamePlayer(player));
		}
		
		buildScoreboard.show(player);
		
		MessageManager.getInstance().send(player, messages.getString("join.message")
				.replace("%players%", getPlayers() + "")
				.replace("%max_players%", getMaxPlayers() + ""));
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player pl = gamePlayer.getPlayer();
				
				MessageManager.getInstance().send(pl, messages.getString("join.otherPlayers")
						.replace("%player%", player.getName())
						.replace("%players%", getPlayers() + "")
						.replace("%max_players%", getMaxPlayers() + ""));
			}
		}
		
		
		if (getLobby() != null) {
			player.teleport(getLobby().getLocation());
		}
		player.setGameMode(GameMode.ADVENTURE);
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				buildScoreboard.update(gamePlayer.getPlayer());
			}
		}
		
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		
		if (getPlayers() >= getMinPlayers()) {
			try {
				waitTimer.runTaskTimer(Main.getInstance(), 20L, 20L);
			} catch (IllegalStateException ise) {}
		}
		
		if (getPlayers() >= getMaxPlayers()) {
			waitTimer.setSeconds(0);
		}
		
		//give paper for subject
		if (player.hasPermission("bg.subjectmenu")) {
			ItemStack map = new ItemStack(Material.PAPER, 1);
			ItemMeta mapMeta = map.getItemMeta();
			mapMeta.setDisplayName(messages.getString("subject-gui.item.name")
					.replaceAll("&", "§"));
			List<String> mapLores = new ArrayList<String>();
			for (String lore : messages.getStringList("subject-gui.item.lores")) {
				mapLores.add(lore
						.replaceAll("&", "§"));
			}
			mapMeta.setLore(mapLores);
			map.setItemMeta(mapMeta);
			player.getInventory().setItem(8, map);
			player.updateInventory();
		}
		
		SignManager.getInstance().updateJoinSigns(this);
	}
	
	public void leave(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're not in a game");
			return;
		}
		
		if (getPlot(player) == null) {
			MessageManager.getInstance().send(player, "You're not in a game");
			ArenaManager.getInstance().getArena(player).leave(player);
			return;
		}
		
		if (MainSpawnManager.getInstance().getMainSpawn() != null) { 
			player.teleport(MainSpawnManager.getInstance().getMainSpawn());
		}
		
		getPlot(player).getGamePlayer(player).restore();
		player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player p = gamePlayer.getPlayer();
				if (p == player) {
					plot.leave(gamePlayer);
					
					MessageManager.getInstance().send(player, messages.getString("leave.message"));
					break;
				}
			}
		}
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player p = gamePlayer.getPlayer();
				MessageManager.getInstance().send(p, messages.getString("leave.otherPlayers")
						.replace("%player%", player.getName()));
				buildScoreboard.update(p);
			}
		}
		
		if (getPlayers() <= 1) {
			if (getWaitTimer().isActive()) {
				waitTimer.cancel();
				setWaitTimer(new WaitTimer(config.getInt("waittimer"), this));
			}
			if (getBuildTimer().isActive()) {
				buildTimer.cancel();
				setBuildTimer(new BuildTimer(config.getInt("buildtimer"), this));
				stop();
			}
			if (getVoteTimer().isActive()) {
				voteTimer.cancel();
				setVoteTimer(new VoteTimer(config.getInt("votetimer"), this));
				stop();
			}
			if (getWinTimer().isActive()) {
				winTimer.cancel();
				setWinTimer(new WinTimer(config.getInt("wintimer"), this));
				stop();
			}
		}
		
		if (SDBarApi.getInstance().isEnabled() && BarAPI.hasBar(player)) {
			BarAPI.removeBar(player);
		}
		
		SignManager.getInstance().updateJoinSigns(this);
	}
	
	public void removePlot(Plot plot) {
		plots.remove(plot);
	}
	
	public void removeSign(Sign sign) {
		getSigns().remove(sign);
	}
	
	public void setBuildScoreboard(BuildScoreboard buildScoreboard) {
		this.buildScoreboard = buildScoreboard;
	}
	
	public void setBuildTimer(BuildTimer buildTimer) {
		this.buildTimer = buildTimer;
	}
	
	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}
	
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}
	
	public void setMode(ArenaMode mode) {
		this.mode = mode;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPlots(List<Plot> plots) {
		this.plots = plots;
	}
	
	public void setScoreboard(VoteScoreboard voteScoreboard) {
		this.voteScoreboard = voteScoreboard;
	}
	
	public void setSigns(List<Sign> signs) {
		this.signs = signs;
	}
	
	public void setState(GameState state) {
		this.state = state;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setVotedPlots(List<Plot> votedPlots) {
		this.votedPlots = votedPlots;
	}
	
	public void setVoteTimer(VoteTimer voteTimer) {
		this.voteTimer = voteTimer;
	}
	
	public void setVotingPlot(Plot votingPlot) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player player = gamePlayer.getPlayer();
			
				if (!config.getBoolean("names-after-voting")) {
					MessageManager.getInstance().send(player, messages.getString("voting.message")
							.replace("%playerplot%", votingPlot.getPlayerFormat()));
					gamePlayer.sendTitle(messages.getString("global.title")
							.replace("%playerplot%", votingPlot.getPlayerFormat()));
				}
				
				player.teleport(votingPlot.getBoundary().getAllBlocks().get(new Random().nextInt(votingPlot.getBoundary().getAllBlocks().size())).getLocation());
				
				//give blocks
				player.getInventory().clear();
				
				VoteBlocks blocks = new VoteBlocks();
				blocks.give(player);
			}
		}
		getVotedPlots().add(votingPlot);
		this.votingPlot = votingPlot;
	}
	
	public void setWaitTimer(WaitTimer waitTimer) {
		this.waitTimer = waitTimer;
	}
	
	public void setWinner(Plot winner) {
		this.winner = winner;
	}
	
	public void setWinTimer(WinTimer winTimer) {
		this.winTimer = winTimer;
	}
	
	public void start() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		setSubject(getSubjectMenu().getHighestVote());
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				gamePlayer.getPlayer().teleport(plot.getLocation());
				
				MessageManager.getInstance().send(gamePlayer.getPlayer(), messages.getString("gameStarts.message")
						.replaceAll("&", "§"));
				MessageManager.getInstance().send(gamePlayer.getPlayer(), messages.getString("gameStarts.subject")
						.replace("%subject%", getSubject())
						.replaceAll("&", "§"));
				
				gamePlayer.sendTitle(messages.getString("gameStarts.title")
						.replace("%subject%", getSubject()));
				gamePlayer.sendSubtitle(messages.getString("gameStarts.subtitle")
						.replace("%subject%", getSubject()));
				
				Player player = gamePlayer.getPlayer();
				player.getInventory().clear();
				player.setGameMode(GameMode.CREATIVE);
				
				ItemStack emerald = new ItemStack(Material.EMERALD, 1);
				ItemMeta emeraldMeta = emerald.getItemMeta();
				emeraldMeta.setDisplayName(messages.getString("gui.options-emerald")
						.replaceAll("&", "§"));
				List<String> emeraldLores = new ArrayList<String>();
				for (String lore : messages.getStringList("gui.options-lores")) {
					emeraldLores.add(lore
							.replaceAll("&", "§"));
				}
				emeraldMeta.setLore(emeraldLores);
				emerald.setItemMeta(emeraldMeta);
				
				player.getInventory().setItem(8, emerald);
				
				if (SDBarApi.getInstance().isEnabled()) {
					BarAPI.setMessage(player, messages.getString("global.barHeader")
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"), buildTimer.getSeconds());
				}
			}
		}
		
		setState(GameState.BUILDING);
		
		//save blocks
		for (Plot plot : getPlots()) {
			plot.save();
		}
		
		buildTimer.runTaskTimer(Main.getInstance(), 20L, 20L);
	}
	
	public void stop() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player player = gamePlayer.getPlayer();
				player.teleport(MainSpawnManager.getInstance().getMainSpawn());
			}
		}
		//reset
		setState(GameState.WAITING);
		setWaitTimer(new WaitTimer(config.getInt("waittimer"), this));
		setBuildTimer(new BuildTimer(config.getInt("timer"), this));
		setVoteTimer(new VoteTimer(config.getInt("votetimer"), this));
		setWinTimer(new WinTimer(config.getInt("wintimer"), this));
		setScoreboard(new VoteScoreboard());
		setSubject(null);
		getVotedPlots().clear();
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player player = gamePlayer.getPlayer();
				
				gamePlayer.restore();
				player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
				player.setPlayerTime(player.getWorld().getTime(), true);
				player.setPlayerWeather(player.getWorld().hasStorm() ? WeatherType.DOWNFALL : WeatherType.CLEAR);
				
				plot.getTimesVoted().clear();
			
				plot.getVotes().clear();
				plot.getParticles().clear();
			}
			plot.getGamePlayers().clear();
		}
		
		for (Plot plot : getPlots()) {
			plot.restore();
			
			for (Chunk chunk : plot.getBoundary().getAllChunks()) {
				for (Entity entity : chunk.getEntities()) {
					if (plot.getBoundary().isInside(entity.getLocation())) {
						entity.remove();
					}
				}
			}
		}
		
		subjectMenu = new SubjectMenu();
		
		SignManager.getInstance().updateJoinSigns(this);
	}
}