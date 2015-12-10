package me.stefvanschie.buildinggame.timers;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WeatherType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import me.stefvanschie.buildinggame.Main;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.managers.softdependencies.SDVault;
import me.stefvanschie.buildinggame.timers.utils.Timer;
import me.stefvanschie.buildinggame.utils.GamePlayer;
import me.stefvanschie.buildinggame.utils.GameState;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.plot.Plot;

public class VoteTimer extends Timer {

	private boolean running = false;
	private int seconds;
	private int originalSeconds;
	private Arena arena;
	private Plot plot;
	
	public VoteTimer(int seconds, Arena arena) {
		this.seconds = seconds;
		originalSeconds = seconds;
		this.arena = arena;
	}

	@Override
	public void run() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		running = true;
		
		if (seconds == originalSeconds) {
			plot = getNextPlot();
			if (plot == null) {
				arena.getWinTimer().runTaskTimer(Main.getInstance(), 0L, 20L);
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
				
				arena.setWinner(first);
				
				for (Plot plot : arena.getUsedPlots()) {
					for (GamePlayer gamePlayer : plot.getGamePlayers()) {
						Player player = gamePlayer.getPlayer();
						
						player.getInventory().clear();
						player.teleport(first.getLocation());
						
						MessageManager.getInstance().send(player, messages.getString("game-ends.message"));
						if (first != null)
							MessageManager.getInstance().send(player, first.getGamePlayers().isEmpty() ? "" : ChatColor.GOLD + "1. " + ChatColor.AQUA + first.getPlayerFormat());
						if (second != null)
							MessageManager.getInstance().send(player, second.getGamePlayers().isEmpty() ? "" : ChatColor.GOLD + "2. " + ChatColor.AQUA + second.getPlayerFormat());
						if (third != null)
							MessageManager.getInstance().send(player, third.getGamePlayers().isEmpty() ? "" : ChatColor.GOLD + "3. " + ChatColor.AQUA + third.getPlayerFormat());
					
						gamePlayer.sendTitle(messages.getString("winner.title")
								.replace("%first%", first == null ? "" : first.getPlayerFormat())
								.replace("%second%", second == null ? "" : second.getPlayerFormat())
								.replace("%third%", third == null ? "" : third.getPlayerFormat())
								.replace("%first_points%", first == null ? "0" : first.getPoints() + "")
								.replace("%second_points%", second == null ? "0" : second.getPoints() + "")
								.replace("%third_points%", third == null ? "0" : third.getPoints() + ""));
						gamePlayer.sendSubtitle(messages.getString("winner.subtitle")
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
								double money = config.getInt("money.others");
								EconomyResponse r = vault.depositPlayer(player, money);
							
								for (String command : config.getStringList("commands.others")) {
									player.performCommand(command);
								}
						
								if (r.transactionSuccess()) {
									MessageManager.getInstance().send(player, messages.getString("vault.message")
											.replace("%money%", money + ""));
								}
							}
						}
					}
				}
				if (first.getGamePlayers().isEmpty()) {
					for (GamePlayer gamePlayer : first.getGamePlayers()) {
						for (String command : config.getStringList("win-commands")) {
							Bukkit.dispatchCommand(gamePlayer.getPlayer(), command
									.replace("%winner%", gamePlayer.getPlayer().getName())
									.replaceAll("&", "§"));
						}
					}
				}
				running = false;
				this.cancel();
				return;
			}

			arena.setVotingPlot(plot);
			for (Plot plot : arena.getUsedPlots()) {
				for (GamePlayer gamePlayer : plot.getGamePlayers()) {
					Player player = gamePlayer.getPlayer();
					
					arena.getScoreboard().show(player);
					player.setPlayerTime(this.plot.getTime().decode(this.plot.getTime()), false);
					player.setPlayerWeather(this.plot.isRaining() ? WeatherType.DOWNFALL : WeatherType.CLEAR);
				}
			}
		}
		seconds--;
		if (seconds <= 0) {
			if (config.getBoolean("names-after-voting")) {
				for (Plot plot : arena.getUsedPlots()) {
					for (GamePlayer player : plot.getGamePlayers()) {
						MessageManager.getInstance().send(player.getPlayer(), messages.getString("voting.message")
								.replace("%playerplot%", this.plot.getPlayerFormat()));
						player.sendTitle(messages.getString("global.title")
							.replace("%playerplot%", this.plot.getPlayerFormat()));
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