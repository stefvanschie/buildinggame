package com.gmail.stefvanschiedev.buildinggame.timers;

import com.gmail.stefvanschiedev.buildinggame.utils.*;
import com.gmail.stefvanschiedev.buildinggame.utils.math.MathElement;
import com.gmail.stefvanschiedev.buildinggame.utils.math.util.MathElementFactory;
import com.gmail.stefvanschiedev.buildinggame.utils.region.Region;
import org.bukkit.Bukkit;
import org.bukkit.WeatherType;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.api.Win;
import com.gmail.stefvanschiedev.buildinggame.api.events.PlayerWinEvent;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This handles the voting time for this arena
 *
 * @since 2.1.0
 */
public class VoteTimer extends Timer {

	/**
     * The original amount of seconds per plot
     */
	private final int originalSeconds;

	/**
     * The plot which is currently being voted on
     */
	private Plot plot;

	/**
     * The config.yml YAML configuration
     */
	private final YamlConfiguration config = SettingsManager.getInstance().getConfig();

	/**
     * The messages.yml YAML configuration
     */
	private final YamlConfiguration messages = SettingsManager.getInstance().getMessages();

	/**
     * Constructs a new VoteTimer with the given amount of seconds
     *
     * @param seconds the amount of time per plot
     * @param arena the arena this timer belongs to
     */
	public VoteTimer(int seconds, Arena arena) {
	    super(arena);

		this.seconds = seconds;
		originalSeconds = seconds;
	}

    /**
     * Called whenever a second has passed. This will generate a new plot if needed or end the game if all plots have
     * been voted on.
     *
     * @since 2.1.0
     */
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
				
				for (var plot : arena.getPlots()) {
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

					if (third == null || third.getPoints() < plot.getPoints())
						third = plot;
				}
				
				//call events
				if (first != null)
					Bukkit.getPluginManager().callEvent(new PlayerWinEvent(arena, first.getGamePlayers(), Win.FIRST));
				if (second != null)
					Bukkit.getPluginManager().callEvent(new PlayerWinEvent(arena, second.getGamePlayers(), Win.SECOND));
				if (third != null)
					Bukkit.getPluginManager().callEvent(new PlayerWinEvent(arena, third.getGamePlayers(), Win.THIRD));
				
				arena.setFirstPlot(first);
				arena.setSecondPlot(second);
				arena.setThirdPlot(third);

				//create a schematic of the first plot
                if (config.getBoolean("schematics.enable") &&
                    Bukkit.getPluginManager().isPluginEnabled("WorldEdit")) {
                    Region region = arena.getFirstPlot().getBoundary();

                    var dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd_HH-mm-ss");
                    String players = arena.getFirstPlot().getGamePlayers().stream()
                        .map(gp -> '-' + gp.getPlayer().getName())
                        .reduce("", String::concat);
                    var fileName = LocalDateTime.now().format(dateTimeFormatter) + players + ".schem";
                    var file = new File(SettingsManager.getInstance().getWinnerSchematicsFolder(), fileName);

                    region.saveSchematic(file);
                }

				for (var plot : arena.getUsedPlots()) {
					for (var gamePlayer : plot.getAllGamePlayers()) {
						var player = gamePlayer.getPlayer();
						
						player.getInventory().clear();

						if (first != null)
                            first.getLocation().teleport(player);

						MessageManager.getInstance().send(player, messages.getStringList("game-ends.message"));

						if (second != null && third != null) {
							for (String message : messages.getStringList("game-ends.winners"))
								MessageManager.getInstance().send(player, message
										.replace("%first_players%", first.getPlayerFormat())
										.replace("%second_players%", second.getPlayerFormat())
										.replace("%third_players%", third.getPlayerFormat()));
						}

                        //noinspection ConstantConditions
                        gamePlayer.addTitleAndSubtitle(messages.getString("winner.title")
								.replace("%first%", first.getPlayerFormat())
								.replace("%second%", second == null ? "" : second.getPlayerFormat())
								.replace("%third%", third == null ? "" : third.getPlayerFormat())
								.replace("%first_points%", first.getPoints() + "")
								.replace("%second_points%", second == null ? "0" : second.getPoints() + "")
								.replace("%third_points%", third == null ? "0" : third.getPoints() + ""),
								messages.getString("winner.subtitle")
								.replace("%first%", first.getPlayerFormat())
								.replace("%second%", second == null ? "" : second.getPlayerFormat())
								.replace("%third%", third == null ? "" : third.getPlayerFormat())
								.replace("%first_points%", first.getPoints() + "")
								.replace("%second_points%", second == null ? "0" : second.getPoints() + "")
								.replace("%third_points%", third == null ? "0" : second.getPoints() + ""));
						gamePlayer.sendActionbar(messages.getString("winner.actionbar")
                            .replace("%first%", first.getPlayerFormat())
                            .replace("%second%", second == null ? "" : second.getPlayerFormat())
                            .replace("%third%", third == null ? "" : third.getPlayerFormat())
                            .replace("%first_points%", String.valueOf(first.getPoints()))
                            .replace("%second_points%", second == null ? "0" : String.valueOf(second
                                .getPoints()))
                            .replace("third_points", third == null ? "0" : String.valueOf(third.getPoints())));
					
						if (SDVault.getInstance().isEnabled() &&
                                gamePlayer.getGamePlayerType() == GamePlayerType.PLAYER) {
							String moneyString;

							if (first.equals(plot)) {
								moneyString = config.getString("money.first");

                                messages.getStringList("winner.first").forEach(message ->
                                    MessageManager.getInstance().send(player, message
                                        .replace("%points%", plot.getPoints() + "")));
						
								config.getStringList("commands.first").forEach(command ->
                                    CommandUtil.dispatch(command.replace("%player%", player.getName())));
							} else if (second.equals(plot)) {
								moneyString = config.getString("money.second");

                                messages.getStringList("winner.second").forEach(message ->
                                    MessageManager.getInstance().send(player, message
                                        .replace("%points%", plot.getPoints() + "")));

                                config.getStringList("commands.second").forEach(command ->
                                    CommandUtil.dispatch(command.replace("%player%", player.getName())));
							} else if (third.equals(plot)) {
								moneyString = config.getString("money.third");
					
								messages.getStringList("winner.third").forEach(message ->
									MessageManager.getInstance().send(player, message
											.replace("%points%", plot.getPoints() + "")));
						
								config.getStringList("commands.third").forEach(command ->
                                    CommandUtil.dispatch(command.replace("%player%", player.getName())));
							} else {
								moneyString = config.getString("money.others");
							
								config.getStringList("commands.others").forEach(command ->
                                    CommandUtil.dispatch(command.replace("%player%", player.getName())));
							}

							//compute money
                            MathElement element = MathElementFactory.parseText(moneyString.replace("%points%",
                                String.valueOf(arena.getPlot(player).getVotes().stream().mapToInt(Vote::getPoints)
                                    .sum())));

                            double money = element == null ? Double.NaN : element.compute();

                            if (Double.isNaN(money))
                                Main.getInstance().getLogger().warning("Unable to parse mathematical equation");

                            if (Double.isFinite(money) && arena.hasMoneyEnabled()) {
                                if (player.hasPermission("bg.rewards.money.double"))
                                    money *= 2;

                                //booster multiplier
                                money *= Booster.getMultiplier(player);

                                if (SDVault.getEconomy().depositPlayer(player, money).transactionSuccess()) {
                                    if (Booster.hasBooster(player)) {
                                        for (String message : messages.getStringList("vault.message.booster"))
                                            MessageManager.getInstance().send(player, message
                                                .replace("%money%", money + ""));
                                    } else {
                                        for (String message :
                                            messages.getStringList("vault.message.no-booster"))
                                            MessageManager.getInstance().send(player, message
                                                .replace("%money%", money + ""));
                                    }
                                }
                            }
						}
					}
				}

				if (first != null) {
					first.getGamePlayers().forEach(gamePlayer -> config.getStringList("win-commands").forEach(command -> {
                        command = command.replace("%winner%", gamePlayer.getPlayer().getName());

                        if (!command.isEmpty() && command.charAt(0) == '@') {
                            String targetText = command.split(" ")[0];

                            Target.parse(targetText).execute(command.substring(targetText.length() + 1));
                        } else {
                            Bukkit.dispatchCommand(gamePlayer.getPlayer(), command);
                        }
                    }));
				}

				arena.getWinTimer().runTaskTimer(Main.getInstance(), 20L, 20L);
				running = false;
				this.cancel();
				return;
			}

			arena.setVotingPlot(plot);

			arena.getUsedPlots().forEach(plot -> plot.getAllGamePlayers().forEach(gamePlayer -> {
                var player = gamePlayer.getPlayer();

                if (!config.getBoolean("names-after-voting") &&
                    config.getBoolean("scoreboards.vote.enable")) {
                    arena.getVoteScoreboard(plot).show(player);
                }

                player.setPlayerTime(this.plot.getTime(), false);
                player.setPlayerWeather(this.plot.isRaining() ? WeatherType.DOWNFALL : WeatherType.CLEAR);
            }));
		}
		//timings
		try {
            config.getConfigurationSection("timings.vote-timer.at").getKeys(false).forEach(key -> {
                if (seconds == Integer.parseInt(key)) {
                    config.getStringList("timings.vote-timer.at." + Integer.parseInt(key)).forEach(command ->
                        CommandUtil.dispatch(command.replace("%arena%", arena.getName())));
                }
            });
            config.getConfigurationSection("timings.vote-timer.every").getKeys(false).forEach(key -> {
                if (seconds % Integer.parseInt(key) == 0) {
                    config.getStringList("timings.vote-timer.every." + Integer.parseInt(key)).forEach(command ->
                        CommandUtil.dispatch(command.replace("%arena%", arena.getName())));
                }
            });
		} catch (NullPointerException | NumberFormatException ignore) {}
		
		seconds--;

		if (seconds <= 0) {
            arena.getUsedPlots().stream().flatMap(plot -> plot.getGamePlayers().stream()).forEach(player -> {
                Player pl = player.getPlayer();

                if (config.getBoolean("names-after-voting")) {
                    messages.getStringList("voting.message").forEach(message ->
                        MessageManager.getInstance().send(pl, message
                            .replace("%playerplot%", this.plot.getPlayerFormat())));

                    player.addTitleAndSubtitle(messages.getString("voting.title")
                            .replace("%playerplot%", this.plot.getPlayerFormat()),
                        messages.getString("voting.subtitle")
                            .replace("%playerplot%", this.plot.getPlayerFormat()));
                    player.sendActionbar(messages.getString("voting.actionbar")
                        .replace("%playerplot%", this.plot.getPlayerFormat()));
                }

                if (!this.plot.hasVoted(pl) && !this.plot.getGamePlayers().contains(player))
                    this.plot.addVote(new Vote(config.getInt("voting.default-vote-points"),
                        pl));
            });

			seconds = originalSeconds;
		}
	}

	/**
     * Returns a plot which we haven't voted for yet
     *
     * @return the next unvoted plot
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
    private Plot getNextPlot() {
	    return arena.getPlots().stream()
            .filter(plot -> !arena.getVotedPlots().contains(plot) && !plot.getGamePlayers().isEmpty())
            .findAny()
            .orElse(null);
	}
}