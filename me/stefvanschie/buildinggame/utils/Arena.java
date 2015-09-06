package me.stefvanschie.buildinggame.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import me.confuser.barapi.BarAPI;
import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.mainspawn.MainSpawnManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.managers.softdependencies.SDBarApi;
import me.stefvanschie.buildinggame.managers.softdependencies.SDVault;
import me.stefvanschie.buildinggame.timers.BuildTimer;
import me.stefvanschie.buildinggame.timers.VoteTimer;
import me.stefvanschie.buildinggame.timers.WaitTimer;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Arena {

	private GameState state = GameState.WAITING;
	private List<Plot> plots = new ArrayList<Plot>();
	private List<Plot> votedPlots = new ArrayList<Plot>();
	private Lobby lobby;
	private String name;
	private int maxPlayers = plots.size();
	private int minPlayers;
	private int players = 0;
	private Plot votingPlot;
	private VoteScoreboard voteScoreboard = new VoteScoreboard();
	
	private WaitTimer waitTimer = new WaitTimer(SettingsManager.getInstance().getConfig().getInt("waittimer"), this);
	private BuildTimer buildTimer = new BuildTimer(SettingsManager.getInstance().getConfig().getInt("timer"), this);
	private VoteTimer voteTimer = new VoteTimer(SettingsManager.getInstance().getConfig().getInt("votetimer"), this);
	
	public Arena(String name) {
		this.name = name;
	}
	
	public void addPlot(Plot plot) {
		plots.add(plot);
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
	
	public String getName() {
		return name;
	}
	
	public int getPlayers() {
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
		for (Plot plot : getPlots()) {
			if (plot.getPlayerData() != null) {
				if (plot.getPlayerData().getPlayer() == player) {
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
	
	public GameState getState() {
		return state;
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
	
	public boolean isEmpty() {
		for (Plot plot : getPlots()) {
			if (plot.getPlayerData() != null) {
				return false;
			}
		}
		return true;
	}
	
	public void join(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		player.teleport(getLobby().getLocation());
		
		MessageManager.getInstance().send(player, messages.getString("join.message"));
		
		for (Plot plot : getPlots()) {
			if (plot.getPlayerData() != null) {
				Player pl = plot.getPlayerData().getPlayer();
				MessageManager.getInstance().send(pl, messages.getString("join.otherPlayers")
						.replaceAll("%player%", player.getName()));
			}
		}
		
		for (int i = 1; i <= getPlots().size(); i++) {
			if (getPlot(i).getPlayerData() == null) {
				getPlot(i).join(new PlayerData(player));
				break;
			}
		}
		
		setPlayers(getPlayers() + 1);
		
		if (getPlayers() >= getMinPlayers()) {
			try {
				waitTimer.runTaskTimer(Main.getInstance(), 20L, 20L);
			} catch (IllegalStateException ise) {}
		}
		
		if (getPlayers() >= getMaxPlayers()) {
			waitTimer.setSeconds(0);
		}
		
		//sign update
		if (config.getBoolean("update-signs")) {
			for (World world : Bukkit.getWorlds()) {
				for (Chunk chunk : world.getLoadedChunks()) {
					for (BlockState blockState : chunk.getTileEntities()) {
						if (blockState.getBlock().getState() instanceof Sign) {
							Sign sign = (Sign) blockState.getBlock().getState();
						
							if (sign.getLine(0).equals(ChatColor.BOLD + "BuildingGame")) {
								if (sign.getLine(1).equals(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "join")) {
									if (ArenaManager.getInstance().getArena(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "")) != null) {
										Arena arena = ArenaManager.getInstance().getArena(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", ""));
										sign.setLine(3, arena.getPlayers() + "/" + arena.getMaxPlayers());
										sign.update();
									}
								}
							}
						}
					}
				}	
			}
		}
	}
	
	public void leave(Player player) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (Plot plot : getPlots()) {
			if (plot.getPlayerData() != null) {
				Player p = plot.getPlayerData().getPlayer();
				if (p == player) {
					plot.leave();
					setPlayers(getPlayers() - 1);
					MessageManager.getInstance().send(player, messages.getString("leave.message"));
					break;
				}
			}
		}
		
		for (Plot plot : getPlots()) {
			if (plot.getPlayerData() != null) {
				Player p = plot.getPlayerData().getPlayer();
				MessageManager.getInstance().send(p, messages.getString("leave.otherPlayers")
						.replace("%player%", player.getName()));
			}
		}
		
		player.teleport(MainSpawnManager.getInstance().getMainSpawn());
		if (isEmpty()) {
			try {
				waitTimer.cancel();
				setWaitTimer(new WaitTimer(config.getInt("waittimer"), this));
			} catch (IllegalStateException ise) {}
			try {
				buildTimer.cancel();
				setBuildTimer(new BuildTimer(config.getInt("buildtimer"), this));
			} catch (IllegalStateException ise) {}
			try {
				voteTimer.cancel();
				setVoteTimer(new VoteTimer(config.getInt("votetimer"), this));
			} catch (IllegalStateException ise) {}
		}
		
		//update signs
		if (config.getBoolean("update-signs")) {
			for (World world : Bukkit.getWorlds()) {
				for (Chunk chunk : world.getLoadedChunks()) {
					for (BlockState blockState : chunk.getTileEntities()) {
						if (blockState.getBlock().getState() instanceof Sign) {
							Sign sign = (Sign) blockState.getBlock().getState();
						
							if (sign.getLine(0).equals(ChatColor.BOLD + "BuildingGame")) {
								if (sign.getLine(1).equals(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "join")) {
									if (ArenaManager.getInstance().getArena(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "")) != null) {
										Arena arena = ArenaManager.getInstance().getArena(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", ""));
										sign.setLine(3, arena.getPlayers() + "/" + arena.getMaxPlayers());
										sign.update();
									}
								}
							}
						}
					}
				}	
			}
		}
	}
	
	public void removePlot(Plot plot) {
		plots.remove(plot);
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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPlayers(int players) {
		this.players = players;
	}
	
	public void setPlots(List<Plot> plots) {
		this.plots = plots;
	}
	
	public void setScoreboard(VoteScoreboard voteScoreboard) {
		this.voteScoreboard = voteScoreboard;
	}
	
	public void setState(GameState state) {
		this.state = state;
	}
	
	public void setVotedPlots(List<Plot> votedPlots) {
		this.votedPlots = votedPlots;
	}
	
	public void setVoteTimer(VoteTimer voteTimer) {
		this.voteTimer = voteTimer;
	}
	
	public void setVotingPlot(Plot votingPlot) {	
		for (Plot plot : getPlots()) {
			if (plot.getPlayerData() != null) {
				Player player = plot.getPlayerData().getPlayer();
				player.teleport(plot.getLocation());
				
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
	
	public void start() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		Random random = new Random();
		
		String subject = config.getStringList("subjects").get(random.nextInt(config.getStringList("subjects").size()));
		
		for (Plot plot : getPlots()) {
			if (plot.getPlayerData() != null) {
				PlayerData playerData = plot.getPlayerData();
				playerData.getPlayer().teleport(plot.getLocation());
				MessageManager.getInstance().send(playerData.getPlayer(), messages.getString("gameStarts.message")
						.replaceAll("&", "§"));
				MessageManager.getInstance().send(playerData.getPlayer(), messages.getString("gameStarts.subject")
						.replace("%subject%", subject)
						.replaceAll("&", "§"));
				Player player = plot.getPlayerData().getPlayer();
						
				if (SDBarApi.getInstance().isEnabled()) {
					BarAPI.setMessage(player, messages.getString("global.barHeader")
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
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Plot first = null;
		Plot second = null;
		Plot third = null;
		
		for (Plot plot : getPlots()) {
			if (first == null || first.getPoints() < plot.getPoints()) {
				third = second;
				second = first;
				first = plot;
				continue;
			}
			if (second == null || second.getPoints() < plot.getPoints()) {
				third = second;
				second = plot;
				continue;
			}
			if (third == null || third.getPoints() < plot.getPoints()) {
				third = plot;
				continue;
			}
		}
		
		for (Plot plot : getPlots()) {
			if (plot.getPlayerData() != null) {
				Player player = plot.getPlayerData().getPlayer();
				player.teleport(MainSpawnManager.getInstance().getMainSpawn());
				
				if(SDVault.getInstance().isEnabled()) {
					MessageManager.getInstance().send(player, ChatColor.GOLD + "The game ended!");
				
					Economy vault = SDVault.getInstance().getVault();
					if (first == plot) {
						double money = config.getInt("money.first");
						EconomyResponse r = vault.depositPlayer(player, money);
					
						MessageManager.getInstance().send(player, messages.getString("winner.first")
								.replace("%points%", plot.getPoints() + ""));
						
						for (String command : config.getStringList("commands.first")) {
							player.performCommand(command);
						}
						
						if (r.transactionSuccess()) {
							MessageManager.getInstance().send(player, messages.getString("vault.message")
									.replace("%money%", money + ""));
						}
					} else if (second == plot) {
						double money = config.getInt("money.second");
						EconomyResponse r = vault.depositPlayer(player, money);
					
						MessageManager.getInstance().send(player, messages.getString("winner.second")
								.replace("%points%", plot.getPoints() + ""));
						
						for (String command : config.getStringList("commands.second")) {
							player.performCommand(command);
						}
						
						if (r.transactionSuccess()) {
							MessageManager.getInstance().send(player, messages.getString("vault.message")
									.replace("%money%", money + ""));
						}
					} else if (third == plot) {
						double money = config.getInt("money.third");
						EconomyResponse r = vault.depositPlayer(player, money);
					
						MessageManager.getInstance().send(player, messages.getString("winner.third")
								.replace("%points%", plot.getPoints() + ""));
						
						for (String command : config.getStringList("commands.third")) {
							player.performCommand(command);
						}
						
						if (r.transactionSuccess()) {
							MessageManager.getInstance().send(player, messages.getString("vault.message")
									.replace("%money%", money + ""));
						}
					} else {
						continue;
					}
				}
			}
		}
		//reset
		setPlayers(0);
		setState(GameState.WAITING);
		setWaitTimer(new WaitTimer(config.getInt("waittimer"), this));
		setBuildTimer(new BuildTimer(config.getInt("timer"), this));
		setVoteTimer(new VoteTimer(config.getInt("votetimer"), this));
		
		for (Plot plot : getPlots()) {
			if (plot.getPlayerData() != null) {
				Player player = plot.getPlayerData().getPlayer();
				
				player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
				player.getInventory().setContents(plot.getPlayerData().getInventory());
				
				plot.setPlayer(null);
			}
			plot.restore();
		}
		
		if (config.getBoolean("update-signs")) {
			for (World world : Bukkit.getWorlds()) {
				for (Chunk chunk : world.getLoadedChunks()) {
					for (BlockState blockState : chunk.getTileEntities()) {
						if (blockState.getBlock().getState() instanceof Sign) {
							Sign sign = (Sign) blockState.getBlock().getState();
						
							if (sign.getLine(0).equals(ChatColor.BOLD + "BuildingGame")) {
								if (sign.getLine(1).equals(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "join")) {
									if (ArenaManager.getInstance().getArena(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "")) != null) {
										Arena arena = ArenaManager.getInstance().getArena(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", ""));
										sign.setLine(3, arena.getPlayers() + "/" + arena.getMaxPlayers());
										sign.update();
									}
								}
							}
						}
					}
				}	
			}
		}
	}
}
