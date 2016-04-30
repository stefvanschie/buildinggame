package com.gmail.stefvanschiedev.buildinggame.utils.arena;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.confuser.barapi.BarAPI;

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
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaJoinEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaLeaveEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaStartEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaStopEvent;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDBarApi;
import com.gmail.stefvanschiedev.buildinggame.timers.BuildTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.VoteTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.WaitTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.WinTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.CustomBlock;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.Lobby;
import com.gmail.stefvanschiedev.buildinggame.utils.VoteBlocks;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.SubjectMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.TeamSelection;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import com.gmail.stefvanschiedev.buildinggame.utils.scoreboards.BuildScoreboard;
import com.gmail.stefvanschiedev.buildinggame.utils.scoreboards.VoteScoreboard;

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
	
	public boolean contains(Player player) {
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				if (gamePlayer.getPlayer() == player)
					return true;
			}
		}
		return false;
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
			for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
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
	public void join(final Player player) {
		final YamlConfiguration config = SettingsManager.getInstance().getConfig();
		final YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
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
			MessageManager.getInstance().send(player, messages.getStringList("join.in-game"));
			return;
		}
		
		if (isFull()) {
			MessageManager.getInstance().send(player, ChatColor.RED + "This arena is full");
			return;
		}
		
		for (Plot plot : getPlots()) {
			if (!plot.isFull()) {
				plot.join(new GamePlayer(player, GamePlayerType.PLAYER));
				break;
			}
		}
		
		//call event
		ArenaJoinEvent event = new ArenaJoinEvent(this, player);
		Bukkit.getPluginManager().callEvent(event);
		if (event.isCancelled())
			return;
		
		buildScoreboard.show(player);
		
		for (String message : messages.getStringList("join.message")) {
			MessageManager.getInstance().send(player, message
					.replace("%players%", getPlayers() + "")
					.replace("%max_players%", getMaxPlayers() + ""));
		}
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player pl = gamePlayer.getPlayer();
				
				for (String message : messages.getStringList("join.otherPlayers")) {
					MessageManager.getInstance().send(pl, message
							.replace("%player%", player.getName())
							.replace("%players%", getPlayers() + "")
							.replace("%max_players%", getMaxPlayers() + ""));
				}
			}
		}
		
		
		if (getLobby() != null) {
			player.teleport(getLobby().getLocation());
		}
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				buildScoreboard.show(gamePlayer.getPlayer());
			}
		}
		
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		//fill lives and hunger
		player.setHealth(20);
		player.setFoodLevel(20);
		//gamemode
		player.setGameMode(GameMode.ADVENTURE);
		//time
		player.setPlayerTime(6000, false);
		
		//hide players from tab list
		for (Player pl : Bukkit.getOnlinePlayers()) {
			if (!contains(pl))
				player.hidePlayer(pl);
		}
		//show current joined player to others
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers())
				gamePlayer.getPlayer().showPlayer(player);
		}
		
		if (getPlayers() >= getMinPlayers()) {
			try {
				waitTimer.runTaskTimer(Main.getInstance(), 20L, 20L);
			} catch (IllegalStateException ise) {}
		}
		
		if (getPlayers() >= getMaxPlayers()) {
			waitTimer.setSeconds(0);
		}
		
		//bukkit runnable because of instant leaving and instant subject opening
		BukkitRunnable runnable = new BukkitRunnable () {
			@Override
			public void run() {
				//give team selection
				if (getMode() == ArenaMode.TEAM) {
					CustomBlock cb = IDDecompiler.getInstance().decompile(config.getString("team-selection.item.id"));
					
					ItemStack item = new ItemStack(cb.getMaterial(), 1);
					item.setDurability(cb.getData());
					ItemMeta itemMeta = item.getItemMeta();
					itemMeta.setDisplayName(messages.getString("team-gui.item.name")
							.replace("%:a%", "ä")
							.replace("%:e%", "ë")
							.replace("%:i%", "ï")
							.replace("%:o%", "ö")
							.replace("%:u%", "ü")
							.replace("%ss%", "ß")
							.replaceAll("&", "§"));
					List<String> lores = new ArrayList<String>();
					for (String lore : messages.getStringList("team-gui.item.lores")) {
						lores.add(lore
								.replace("%:a%", "ä")
								.replace("%:e%", "ë")
								.replace("%:i%", "ï")
								.replace("%:o%", "ö")
								.replace("%:u%", "ü")
								.replace("%ss%", "ß")
								.replaceAll("&", "§"));
					}
					itemMeta.setLore(lores);
					item.setItemMeta(itemMeta);
					
					player.getInventory().setItem(0, item);
				}
				
				//give paper for subject
				if (player.hasPermission("bg.subjectmenu") && config.getBoolean("enable-subject-voting")) {
					CustomBlock cb = IDDecompiler.getInstance().decompile(config.getString("subject-gui.item.id"));
					
					ItemStack item = new ItemStack(cb.getMaterial(), 1);
					item.setDurability(cb.getData());
					ItemMeta itemMeta = item.getItemMeta();
					itemMeta.setDisplayName(messages.getString("subject-gui.item.name")
							.replaceAll("&", "§"));
					List<String> itemLores = new ArrayList<String>();
					for (String lore : messages.getStringList("subject-gui.item.lores")) {
						itemLores.add(lore
								.replaceAll("&", "§"));
					}
					itemMeta.setLore(itemLores);
					item.setItemMeta(itemMeta);
					player.getInventory().setItem(8, item);
				}
				
				CustomBlock cb = IDDecompiler.getInstance().decompile(config.getString("leave-item.id"));
				
				ItemStack leave = new ItemStack(cb.getMaterial(), 1, cb.getData());
				ItemMeta leaveMeta = leave.getItemMeta();
				leaveMeta.setDisplayName(MessageManager.translate(messages.getString("leave-item.name")));
				leave.setItemMeta(leaveMeta);
				
				player.getInventory().setItem(config.getInt("leave-item.slot"), leave);
				player.updateInventory();
			}
		};
		
		runnable.runTaskLater(Main.getInstance(), 1L);
		
		SignManager.getInstance().updateJoinSigns(this);
	}
	
	public void leave(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (ArenaManager.getInstance().getArena(player) == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're not in a game");
			return;
		}
		
		//call event
		ArenaLeaveEvent event = new ArenaLeaveEvent(this, player);
		Bukkit.getPluginManager().callEvent(event);
		if (event.isCancelled())
			return;
		
		GamePlayer p = getPlot(player).getGamePlayer(player);
		p.restore();
		
		if (getPlot(player) == null) {
			MessageManager.getInstance().send(player, "You're not in a game");
			ArenaManager.getInstance().getArena(player).leave(player);
			return;
		}
		
		if (MainSpawnManager.getInstance().getMainSpawn() != null)
			p.connect(MainSpawnManager.getInstance().getServer(), MainSpawnManager.getInstance().getMainSpawn());
		
		player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
		player.resetPlayerTime();
		player.resetPlayerWeather();
		
		//show all players again
		for (Player pl : Bukkit.getOnlinePlayers())
			player.showPlayer(pl);
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player pl = gamePlayer.getPlayer();
				if (pl == player) {
					plot.leave(gamePlayer);
					
					MessageManager.getInstance().send(player, messages.getStringList("leave.message"));
					break;
				}
			}
		}
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player pl = gamePlayer.getPlayer();
				
				for (String message : messages.getStringList("leave.otherPlayers")) {
					MessageManager.getInstance().send(pl, message
							.replace("%player%", player.getName()));
				}
				
				buildScoreboard.update(pl);
			}
		}
		
		if (getPlayers() <= 1) {
			if (getWaitTimer().isActive()) {
				waitTimer.cancel();
				setWaitTimer(new WaitTimer(config.getInt("waittimer"), this));
				setState(GameState.WAITING);
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
		
		if (SDBarApi.getInstance().isEnabled()) {
			if (BarAPI.hasBar(player))
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
		
		this.votingPlot = votingPlot;
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player player = gamePlayer.getPlayer();
			
				if (!config.getBoolean("names-after-voting")) {
					for (String message : messages.getStringList("voting.message"))
						MessageManager.getInstance().send(player, message
								.replace("%playerplot%", votingPlot.getPlayerFormat()));
					gamePlayer.addTitleAndSubtitle(messages.getString("voting.title")
							.replace("%playerplot%", votingPlot.getPlayerFormat()), messages.getString("voting.subtitle")
							.replace("%playerplot%", votingPlot.getPlayerFormat()));
				}
				
				player.teleport(votingPlot.getBoundary().getAllBlocks().get(new Random().nextInt(votingPlot.getBoundary().getAllBlocks().size())).getLocation());
				
				//give blocks
				player.getInventory().clear();
				
				VoteBlocks blocks = new VoteBlocks();
				blocks.give(player);
				
				//update scoreboard and update time and weather
				getScoreboard().show(player);
				player.setPlayerTime(plot.getTime().decode(plot.getTime()), false);
				player.setPlayerWeather(plot.isRaining() ? WeatherType.DOWNFALL : WeatherType.CLEAR);
			}
		}
		
		getVotedPlots().add(votingPlot);
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
		
		//call event
		ArenaStartEvent event = new ArenaStartEvent(this);
		Bukkit.getPluginManager().callEvent(event);
		if (event.isCancelled())
			return;
		
		setSubject(getSubjectMenu().getHighestVote());
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				gamePlayer.getPlayer().teleport(plot.getLocation());
				
				MessageManager.getInstance().send(gamePlayer.getPlayer(), messages.getStringList("gameStarts.message"));
				for (String message : messages.getStringList("gameStarts.subject"))
					MessageManager.getInstance().send(gamePlayer.getPlayer(), message
							.replace("%subject%", getSubject()));
				
				gamePlayer.addTitleAndSubtitle(messages.getString("gameStarts.title")
						.replace("%subject%", getSubject()), messages.getString("gameStarts.subtitle")
						.replace("%subject%", getSubject()));
				
				Player player = gamePlayer.getPlayer();
				player.getInventory().clear();
				player.setGameMode(GameMode.CREATIVE);
				player.setPlayerTime(plot.getTime().decode(plot.getTime()), false);
				
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
		
		//call event
		ArenaStopEvent event = new ArenaStopEvent(this);
		Bukkit.getPluginManager().callEvent(event);
		if (event.isCancelled())
			return;
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getAllGamePlayers())
				gamePlayer.connect(MainSpawnManager.getInstance().getServer(), MainSpawnManager.getInstance().getMainSpawn());
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
			for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
				Player player = gamePlayer.getPlayer();
				
				gamePlayer.restore();
				player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
				player.resetPlayerTime();
				player.resetPlayerWeather();
				
				//show all players again
				for (Player pl : Bukkit.getOnlinePlayers())
					player.showPlayer(pl);
				
				plot.getTimesVoted().clear();
			
				plot.getVotes().clear();
			}
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
			
			plot.getAllGamePlayers().clear();
		}
		
		subjectMenu = new SubjectMenu();
		
		SignManager.getInstance().updateJoinSigns(this);
	}
}