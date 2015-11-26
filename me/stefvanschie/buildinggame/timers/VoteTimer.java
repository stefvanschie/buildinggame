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
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.GameState;
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
					Player player = plot.getGamePlayer().getPlayer();
						
					player.getInventory().clear();
					player.teleport(first.getLocation());
						
					MessageManager.getInstance().send(player, messages.getString("game-ends.message"));
				
					MessageManager.getInstance().send(player, first.getGamePlayer() == null ? "" : ChatColor.GOLD + "1. " + ChatColor.AQUA + first.getGamePlayer().getPlayer().getName());
					MessageManager.getInstance().send(player, second.getGamePlayer() == null ? "" : ChatColor.GOLD + "2. " + ChatColor.AQUA + second.getGamePlayer().getPlayer().getName());
					MessageManager.getInstance().send(player, third.getGamePlayer() == null ? "" : ChatColor.GOLD + "3. " + ChatColor.AQUA + third.getGamePlayer().getPlayer().getName());
					
					plot.getGamePlayer().sendTitle(messages.getString("winner.title")
							.replace("%first%", first.getGamePlayer() == null ? "" : first.getGamePlayer().getPlayer().getName())
							.replace("%second%", second.getGamePlayer() == null ? "" : second.getGamePlayer().getPlayer().getName())
							.replace("%third%", third.getGamePlayer() == null ? "" : third.getGamePlayer().getPlayer().getName())
							.replace("%first_points%", first == null ? "0" : first.getPoints() + "")
							.replace("%second_points%", second == null ? "0" : second.getPoints() + "")
							.replace("%third_points%", third == null ? "0" : third.getPoints() + ""));
					plot.getGamePlayer().sendSubtitle(messages.getString("winner.subtitle")
							.replace("%first%", first.getGamePlayer() == null ? "" : first.getGamePlayer().getPlayer().getName())
							.replace("%second%", second.getGamePlayer() == null ? "" : second.getGamePlayer().getPlayer().getName())
							.replace("%third%", third.getGamePlayer() == null ? "" : third.getGamePlayer().getPlayer().getName())
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
				if (first.getGamePlayer() != null) {
					for (String command : config.getStringList("win-commands")) {
						Bukkit.dispatchCommand(first.getGamePlayer().getPlayer(), command
								.replace("%winner%", first.getGamePlayer().getPlayer().getName())
								.replaceAll("&", "§"));
					}
				}
				running = false;
				this.cancel();
				return;
			}

			arena.setVotingPlot(plot);
			for (Plot plot : arena.getUsedPlots()) {
				Player player = plot.getGamePlayer().getPlayer();
					
				arena.getScoreboard().show(player);
				player.setPlayerTime(this.plot.getTime().decode(this.plot.getTime()), false);
				player.setPlayerWeather(this.plot.isRaining() ? WeatherType.DOWNFALL : WeatherType.CLEAR);
			}
		}
		seconds--;
		if (seconds <= 0) {
			if (config.getBoolean("names-after-voting")) {
				for (Plot plot : arena.getUsedPlots()) {
					MessageManager.getInstance().send(plot.getGamePlayer().getPlayer(), messages.getString("voting.message")
							.replace("%playerplot%", this.plot.getGamePlayer().getPlayer().getName()
									.replaceAll("&", "§")));
					plot.getGamePlayer().sendTitle(messages.getString("global.title")
							.replace("%playerplot%", this.plot.getGamePlayer().getPlayer().getName()));
				}
			}
			seconds = config.getInt("votetimer");
			originalSeconds = seconds;
		}
	}
	
	public Plot getNextPlot() {
		for (Plot plot : arena.getPlots()) {
			if (!arena.getVotedPlots().contains(plot)) {
				if (plot.getGamePlayer() != null) {
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
