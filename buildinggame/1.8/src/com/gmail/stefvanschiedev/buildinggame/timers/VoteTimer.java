package com.gmail.stefvanschiedev.buildinggame.timers;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.WeatherType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.api.Win;
import com.gmail.stefvanschiedev.buildinggame.api.events.PlayerWinEvent;
import com.gmail.stefvanschiedev.buildinggame.managers.commands.CommandExecuter;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.Vote;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class VoteTimer extends Timer {

	private boolean running = false;
	private int seconds;
	private int originalSeconds;
	private Arena arena;
	private Plot plot;
	
	private YamlConfiguration config = SettingsManager.getInstance().getConfig();
	private YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public VoteTimer(int seconds, Arena arena) {
		this.seconds = seconds;
		originalSeconds = seconds;
		this.arena = arena;
	}

	@Override
	public void run() {
		running = true;
		
		if (seconds == originalSeconds) {
			plot = getNextPlot();
			if (plot == null) {
				arena.setState(GameState.RESETING);
				
				Plot first = null;
				Plot second = null;
				Plot third = null;
				
				for (Plot plot : arena.getPlots()) {
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
				
				//call events
				if (first != null)
					Bukkit.getPluginManager().callEvent(new PlayerWinEvent(arena, first.getGamePlayers(), Win.FIRST));
				if (second != null)
					Bukkit.getPluginManager().callEvent(new PlayerWinEvent(arena, second.getGamePlayers(), Win.SECOND));
				if (third != null)
					Bukkit.getPluginManager().callEvent(new PlayerWinEvent(arena, third.getGamePlayers(), Win.THIRD));
				
				arena.setWinner(first);
				
				for (Plot plot : arena.getUsedPlots()) {
					for (GamePlayer gamePlayer : plot.getGamePlayers()) {
						Player player = gamePlayer.getPlayer();
						
						player.getInventory().clear();
						player.teleport(first.getLocation());
						
						MessageManager.getInstance().send(player, messages.getStringList("game-ends.message"));
						if (first != null && second != null && third != null) {
							for (String message : messages.getStringList("game-ends.winners")) {
								MessageManager.getInstance().send(gamePlayer.getPlayer(), message
										.replace("%first_players%", first.getPlayerFormat())
										.replace("%second_players%", second.getPlayerFormat())
										.replace("%third_players%", third.getPlayerFormat()));
							}
						}

						gamePlayer.addTitleAndSubtitle(messages.getString("winner.title")
								.replace("%first%", first == null ? "" : first.getPlayerFormat())
								.replace("%second%", second == null ? "" : second.getPlayerFormat())
								.replace("%third%", third == null ? "" : third.getPlayerFormat())
								.replace("%first_points%", first == null ? "0" : first.getPoints() + "")
								.replace("%second_points%", second == null ? "0" : second.getPoints() + "")
								.replace("%third_points%", third == null ? "0" : third.getPoints() + ""),
								messages.getString("winner.subtitle")
								.replace("%first%", first == null ? "" : first.getPlayerFormat())
								.replace("%second%", second == null ? "" : second.getPlayerFormat())
								.replace("%third%", third == null ? "" : third.getPlayerFormat())
								.replace("%first_points%", first == null ? "0" : first.getPoints() + "")
								.replace("%second_points%", second == null ? "0" : second.getPoints() + "")
								.replace("%third_points%", third == null ? "0" : second.getPoints() + ""));
					
						if(SDVault.getInstance().isEnabled()) {
							Economy vault = SDVault.getInstance().getEconomy();
							if (first == plot) {
								double money = config.getInt("money.first");
								
								if (player.hasPermission("bg.rewards.money.double")) {
									money *= 2;
								}
								
								EconomyResponse r = vault.depositPlayer(player, money);
					
								for (String message : messages.getStringList("winner.first")) {
									MessageManager.getInstance().send(player, message
											.replace("%points%", plot.getPoints() + ""));
								}
						
								for (String command : config.getStringList("commands.first")) {
									String cmd = CommandExecuter.execute(command);
									if (cmd != null)
										player.performCommand(command);
								}
						
								if (r.transactionSuccess()) {
									for (String message : messages.getStringList("vault.message")) {
										MessageManager.getInstance().send(player, message
												.replace("%money%", money + ""));
									}
								}
							} else if (second == plot) {
								double money = config.getInt("money.second");
								
								if (player.hasPermission("bg.rewards.money.double")) {
									money *= 2;
								}
								
								EconomyResponse r = vault.depositPlayer(player, money);
								
								for (String message : messages.getStringList("winner.second")) {
									MessageManager.getInstance().send(player, message
											.replace("%points%", plot.getPoints() + ""));
								}
						
								for (String command : config.getStringList("commands.second")) {
									String cmd = CommandExecuter.execute(command);
									if (cmd != null)
										player.performCommand(command);
								}
						
								if (r.transactionSuccess()) {
									for (String message : messages.getStringList("vault.message")) {
										MessageManager.getInstance().send(player, message
												.replace("%money%", money + ""));
									}
								}
							} else if (third == plot) {
								double money = config.getInt("money.third");
								
								if (player.hasPermission("bg.rewards.money.double")) {
									money *= 2;
								}
								
								EconomyResponse r = vault.depositPlayer(player, money);
					
								for (String message : messages.getStringList("winner.third")) {
									MessageManager.getInstance().send(player, message
											.replace("%points%", plot.getPoints() + ""));
								}
						
								for (String command : config.getStringList("commands.third")) {
									String cmd = CommandExecuter.execute(command);
									if (cmd != null)
										player.performCommand(command);
								}
						
								if (r.transactionSuccess()) {
									for (String message : messages.getStringList("vault.message")) {
										MessageManager.getInstance().send(player, message
												.replace("%money%", money + ""));
									}
								}
							} else {
								double money = config.getInt("money.others");
								
								if (player.hasPermission("bg.rewards.money.double")) {
									money *= 2;
								}
								
								EconomyResponse r = vault.depositPlayer(player, money);
							
								for (String command : config.getStringList("commands.others")) {
									String cmd = CommandExecuter.execute(command);
									if (cmd != null)
										player.performCommand(command);
								}
						
								if (r.transactionSuccess()) {
									for (String message : messages.getStringList("vault.message")) {
										MessageManager.getInstance().send(player, message
												.replace("%money%", money + ""));
									}
								}
							}
						}
					}
				}
				if (!first.getGamePlayers().isEmpty()) {
					for (GamePlayer gamePlayer : first.getGamePlayers()) {
						for (String command : config.getStringList("win-commands")) {
							String cmd = CommandExecuter.execute(command
									.replace("%winner%", gamePlayer.getPlayer().getName()));
							if (cmd != null)
								gamePlayer.getPlayer().performCommand(command
										.replace("%winner%", gamePlayer.getPlayer().getName()).trim());
						}
					}
				}
				arena.getWinTimer().runTaskTimer(Main.getInstance(), 20L, 20L);
				running = false;
				this.cancel();
				return;
			}

			arena.setVotingPlot(plot);
			for (Plot plot : arena.getUsedPlots()) {
				for (GamePlayer gamePlayer : plot.getGamePlayers()) {
					Player player = gamePlayer.getPlayer();
					
					arena.getVoteScoreboard().show(player);
					player.setPlayerTime(this.plot.getTime().decode(this.plot.getTime()), false);
					player.setPlayerWeather(this.plot.isRaining() ? WeatherType.DOWNFALL : WeatherType.CLEAR);
				}
			}
		}
		//timings
		try {
			for (String key : config.getConfigurationSection("timings.vote-timer.at").getKeys(false)) {
				try {
					if (seconds == Integer.parseInt(key)) {
						for (String command : config.getStringList("timings.vote-timer.at." + Integer.parseInt(key)))
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
					}
				} catch (NumberFormatException e) {}
			}
			for (String key : config.getConfigurationSection("timings.vote-timer.every").getKeys(false)) {
				try {
					if (seconds % Integer.parseInt(key) == 0) {
						for (String command : config.getStringList("timings.vote-timer.every." + Integer.parseInt(key)))
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%arena%", arena.getName()));
					}
				} catch (NumberFormatException e) {}
			}
		} catch (NullPointerException e) {}
		
		seconds--;
		if (seconds <= 0) {
				for (Plot plot : arena.getUsedPlots()) {
					for (GamePlayer player : plot.getGamePlayers()) {
						if (config.getBoolean("names-after-voting")) {
							for (String message : messages.getStringList("voting.message")) {
								MessageManager.getInstance().send(player.getPlayer(), message
										.replace("%playerplot%", this.plot.getPlayerFormat()));
							}
							player.addTitleAndSubtitle(messages.getString("voting.title")
									.replace("%playerplot%", this.plot.getPlayerFormat()), messages.getString("voting.subtitle")
									.replace("%playerplot%", this.plot.getPlayerFormat()));
						}
						if (!this.plot.hasVoted(player.getPlayer())) {
							this.plot.addVote(new Vote(config.getInt("voting.default-vote-points"), player.getPlayer()));
						}
					}
				}
			seconds = config.getInt("votetimer");
			originalSeconds = seconds;
		}
	}
	
	public Plot getNextPlot() {
		for (Plot plot : arena.getPlots()) {
			if (!arena.getVotedPlots().contains(plot)) {
				if (!plot.getGamePlayers().isEmpty()) {
					return plot;
				}
			}
		}
		return null;
	}

	@Override
	public int getSeconds() {
		return seconds;
	}

	@Override
	public boolean isActive() {
		return running;
	}

	@Override
	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}
}