package com.gmail.stefvanschiedev.buildinggame.game;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.api.Win;
import com.gmail.stefvanschiedev.buildinggame.api.events.PlayerWinEvent;
import com.gmail.stefvanschiedev.buildinggame.game.util.GamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.util.JoinObserver;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.Every;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.TimedGamePhase;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.softdependencies.SDVault;
import com.gmail.stefvanschiedev.buildinggame.utils.Booster;
import com.gmail.stefvanschiedev.buildinggame.utils.CommandUtil;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.math.MathElement;
import com.gmail.stefvanschiedev.buildinggame.utils.math.util.MathElementFactory;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.region.Region;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * The game phase when the game shows the plot of the winning players.
 *
 * @since 12.2.0
 */
public class WinningGamePhase extends TimedGamePhase<Arena> implements JoinObserver {

    /**
     * The chosen subject
     */
    @NotNull
    private final String subject;

    /**
     * The winning plots
     */
    private Plot firstPlot, secondPlot, thirdPlot;

    /**
     * The commands to be dispatched at the given remaining times
     */
    @NotNull
    private final Map<Integer, Collection<String>> commands = new HashMap<>();

    /**
     * Creates a new timed game phase. Once the time is over, the game will transition to the next game phase.
     *
     * @param arena the arena for which this phase exists
     * @param subject the chosen subject
     * @since 12.2.0
     */
    public WinningGamePhase(@NotNull Arena arena, @NotNull String subject) {
        super(arena, getTime(arena));

        this.subject = subject;

        initializeCommands();

        startTimer();
    }

    @Every(1)
    public void dispatchCommands() {
        long seconds = getRemainingTime().getSeconds();

        if (seconds > Integer.MAX_VALUE) {
            Main.getInstance().getLogger().warning("Unable to dispatch commands, too much time left");
        }

        for (String command : this.commands.getOrDefault((int) seconds, Collections.emptySet())) {
            CommandUtil.dispatch(command);
        }
    }

    @Override
    public void onJoin(@NotNull GamePlayer gamePlayer) {
        for (Plot plot : this.transitionSystem.getPlots()) {
            if (plot.getGamePlayers().contains(gamePlayer)) {
                continue;
            }

            plot.getWinScoreboard().getRedTeam().addEntry(gamePlayer.getPlayer().getName());
        }
    }

    @NotNull
    @Override
    public GamePhase getNextPhase() {
        if (this.transitionSystem.getMatches() == this.transitionSystem.getMaxMatches()) {
            this.transitionSystem.stop();

            return new LobbyGamePhase(this.transitionSystem);
        }

        return new BuildingGamePhase(this.transitionSystem, this.subject);
    }

    @Override
    public void forceEnd() {
        for (Plot plot : this.transitionSystem.getPlots()) {
            plot.restore();
        }

        this.transitionSystem.transition(new LobbyGamePhase(this.transitionSystem));
    }

    @Override
    public void onPhaseEnd() {
        nextMatch();

        super.onPhaseEnd();
    }

    @Override
    public void onPhaseStart() {
        super.onPhaseStart();

        startTimer();

        List<? extends Plot> orderedPlots = determineWinners();

        //if there aren't any plots you can't start the game
        if (orderedPlots.size() < 1) {
            endTimer();

            return;
        }

        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        this.firstPlot = orderedPlots.get(0);
        Supplier<Plot> secondPlot = () -> orderedPlots.get(1);
        Supplier<Plot> thirdPlot = () -> orderedPlots.get(2);

        boolean hasSecond = orderedPlots.size() > 1;
        boolean hasThird = orderedPlots.size() > 2;

        if (hasSecond) {
            this.secondPlot = secondPlot.get();
        }

        if (hasThird) {
            this.thirdPlot = thirdPlot.get();
        }

        PotentialLocation location = firstPlot.getLocation();

        //can't do much if the world we need to go to isn't loaded
        if (location == null || location.getWorld() == null) {
            endTimer();

            return;
        }

        saveSchematic(firstPlot);

        String firstPlayerFormat = firstPlot.getPlayerFormat();
        Supplier<String> secondPlayerFormat = () -> orderedPlots.get(1).getPlayerFormat();
        Supplier<String> thirdPlayerFormat = () -> orderedPlots.get(2).getPlayerFormat();

        int firstPoints = firstPlot.getPoints();
        Supplier<Integer> secondPoints = () -> orderedPlots.get(1).getPoints();
        Supplier<Integer> thirdPoints = () -> orderedPlots.get(2).getPoints();

        Collection<String> gameEndsWinners = new ArrayList<>();

        for (String message : messages.getStringList("game-ends.winners")) {
            gameEndsWinners.add(message
                .replace("%first_players%", firstPlayerFormat)
                .replace("%second_players%", hasSecond ? secondPlayerFormat.get() : "")
                .replace("%third_players%", hasThird ? thirdPlayerFormat.get() : ""));
        }

        String winnerTitle = messages.getString("winner.title", "")
            .replace("%first%", firstPlayerFormat)
            .replace("%second%", hasSecond ? secondPlayerFormat.get() : "")
            .replace("%third%", hasThird ? thirdPlayerFormat.get() : "")
            .replace("%first_points%", String.valueOf(firstPoints))
            .replace("%second_points%", hasSecond ? String.valueOf(secondPoints.get()) : "0")
            .replace("%third_points%", hasThird ? String.valueOf(thirdPoints.get()) : "0");
        String winnerSubtitle = messages.getString("winner.subtitle", "")
            .replace("%first%", firstPlayerFormat)
            .replace("%second%", hasSecond ? secondPlayerFormat.get() : "")
            .replace("%third%", hasThird ? thirdPlayerFormat.get() : "")
            .replace("%first_points%", String.valueOf(firstPoints))
            .replace("%second_points%", hasSecond ? String.valueOf(secondPoints.get()) : "0")
            .replace("%third_points%", hasThird ? String.valueOf(thirdPoints.get()) : "0");
        String winnerActionbar = messages.getString("winner.actionbar", "")
            .replace("%first%", firstPlayerFormat)
            .replace("%second%", hasSecond ? secondPlayerFormat.get() : "")
            .replace("%third%", hasThird ? thirdPlayerFormat.get() : "")
            .replace("%first_points%", String.valueOf(firstPoints))
            .replace("%second_points%", hasSecond ? String.valueOf(secondPoints.get()) : "0")
            .replace("third_points", hasThird ? String.valueOf(thirdPoints.get()) : "0");

        for (var plot : super.transitionSystem.getUsedPlots()) {
            for (var gamePlayer : plot.getAllGamePlayers()) {
                var player = gamePlayer.getPlayer();

                player.getInventory().clear();

                location.teleport(player);

                MessageManager.getInstance().send(player, messages.getStringList("game-ends.message"));

                if (hasThird) {
                    MessageManager.getInstance().send(player, gameEndsWinners);
                }

                gamePlayer.addTitleAndSubtitle(winnerTitle, winnerSubtitle);
                gamePlayer.sendActionbar(winnerActionbar);

                if (firstPlot.equals(plot)) {
                    messages.getStringList("winner.first").forEach(message ->
                        MessageManager.getInstance().send(player, message
                            .replace("%points%", String.valueOf(plot.getPoints()))));

                    config.getStringList("commands.first").forEach(command ->
                        CommandUtil.dispatch(command.replace("%player%", player.getName())));
                } else if (hasSecond && secondPlot.get().equals(plot)) {
                    messages.getStringList("winner.second").forEach(message ->
                        MessageManager.getInstance().send(player, message
                            .replace("%points%", String.valueOf(plot.getPoints()))));

                    config.getStringList("commands.second").forEach(command ->
                        CommandUtil.dispatch(command.replace("%player%", player.getName())));
                } else if (hasThird && thirdPlot.get().equals(plot)) {
                    messages.getStringList("winner.third").forEach(message ->
                        MessageManager.getInstance().send(player, message
                            .replace("%points%", String.valueOf(plot.getPoints()))));

                    config.getStringList("commands.third").forEach(command ->
                        CommandUtil.dispatch(command.replace("%player%", player.getName())));
                } else {
                    config.getStringList("commands.others").forEach(command ->
                        CommandUtil.dispatch(command.replace("%player%", player.getName())));
                }

                if (!SDVault.getInstance().isEnabled() || gamePlayer.getGamePlayerType() != GamePlayerType.PLAYER ||
                    !super.transitionSystem.hasMoneyEnabled()) {
                    continue;
                }

                String moneyString;

                if (firstPlot.equals(plot)) {
                    moneyString = config.getString("money.first");
                } else if (hasSecond && secondPlot.get().equals(plot)) {
                    moneyString = config.getString("money.second");
                } else if (hasThird && thirdPlot.get().equals(plot)) {
                    moneyString = config.getString("money.third");
                } else {
                    moneyString = config.getString("money.others");
                }

                if (moneyString == null) {
                    throw new IllegalStateException("Missing config.yml value for money");
                }

                MathElement element = MathElementFactory.parseText(moneyString.replace("%points%",
                    String.valueOf(plot.getPoints())));

                awardMoney(player, element == null ? Double.NaN : element.compute());
            }
        }

        dispatchWinCommands(firstPlot.getGamePlayers());

        startTimer();
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public DyeColor getColor() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        if (!config.contains("signs.glass-colors." + getName())) {
            return DyeColor.RED;
        }

        return DyeColor.valueOf(config.getString("signs.glass-colors." + getName(), "").toUpperCase());
    }

    /**
     * Gets the subject
     *
     * @return the subject
     * @since 12.2.0
     */
    @NotNull
    @Contract(pure = true)
    public String getSubject() {
        return this.subject;
    }

    @NotNull
    @Contract(pure  = true)
    @Override
    public String getName() {
        return "winning";
    }

    /**
     * Gets the plot that came in first.
     *
     * @return the winning plot
     * @since 12.2.0
     */
    @Contract(pure = true)
    public Plot getFirstPlot() {
        return firstPlot;
    }

    /**
     * Gets the plot that came in second.
     *
     * @return the second plot
     * @since 12.2.0
     */
    @Contract(pure = true)
    public Plot getSecondPlot() {
        return this.secondPlot;
    }

    /**
     * Gets the plot that came in third.
     *
     * @return the third plot
     * @since 12.2.0
     */
    @Contract(pure = true)
    public Plot getThirdPlot() {
        return this.thirdPlot;
    }

    @Override
    public boolean canJoin() {
        return false;
    }

    /**
     * Initializes the user-defined commands.
     *
     * @since 12.2.0
     */
    private void initializeCommands() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        ConfigurationSection atSection = config.getConfigurationSection("timings.win-timer.at");
        ConfigurationSection everySection = config.getConfigurationSection("timings.win-timer.every");

        if (atSection != null) {
            for (String key : atSection.getKeys(false)) {
                int interval = Integer.parseInt(key);

                for (String command : atSection.getStringList(key)) {
                    String parsedCommand = command.replace("%arena%", this.transitionSystem.getName());

                    commands.computeIfAbsent(interval, (k) -> new HashSet<>()).add(parsedCommand);
                }
            }
        }

        if (everySection != null) {
            for (String key : everySection.getKeys(false)) {
                int interval = Integer.parseInt(key);

                for (String command : everySection.getStringList(key)) {
                    String parsedCommand = command.replace("%arena%", this.transitionSystem.getName());

                    for (int multiple = interval; multiple <= getOriginalTime(); multiple += interval) {
                        commands.computeIfAbsent(multiple, (k) -> new HashSet<>()).add(parsedCommand);
                    }
                }
            }
        }
    }

    /**
     * Determines who came in first, second, and third place. This will fire {@link PlayerWinEvent}s for the first,
     * second, and third place. This returns a list of plots ordered by points, with the plot with the highest amount of
     * points first.
     *
     * @return a list of all the plots in the arena, ordered by points
     * @since 12.2.0
     */
    @NotNull
    private List<? extends Plot> determineWinners() {
        List<? extends Plot> plots = new ArrayList<>(super.transitionSystem.getPlots());
        plots.sort(Comparator.comparingInt(Plot::getPoints).reversed());

        if (plots.size() > 0) {
            List<GamePlayer> gamePlayers = plots.get(0).getGamePlayers();
            Bukkit.getPluginManager().callEvent(new PlayerWinEvent(super.transitionSystem, gamePlayers, Win.FIRST));
        }

        if (plots.size() > 1) {
            List<GamePlayer> gamePlayers = plots.get(1).getGamePlayers();
            Bukkit.getPluginManager().callEvent(new PlayerWinEvent(super.transitionSystem, gamePlayers, Win.SECOND));
        }

        if (plots.size() > 2) {
            List<GamePlayer> gamePlayers = plots.get(2).getGamePlayers();
            Bukkit.getPluginManager().callEvent(new PlayerWinEvent(super.transitionSystem, gamePlayers, Win.THIRD));
        }

        return plots;
    }

    /**
     * Saves a schematic of the given plot. This will fail silently if schematics are disabled in the configuration, the
     * given plot does not have a boundary, or if WorldEdit is not enabled on the server.
     *
     * @param plot the plot to save
     * @since 12.2.0
     */
    private void saveSchematic(@NotNull Plot plot) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        if (!config.getBoolean("schematics.enable") ||
            !Bukkit.getPluginManager().isPluginEnabled("WorldEdit")) {
            return;
        }

        Region region = plot.getBoundary();

        if (region == null) {
            return;
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd_HH-mm-ss");
        StringBuilder playerNames = new StringBuilder();

        for (GamePlayer gamePlayer : plot.getGamePlayers()) {
            playerNames.append('-').append(gamePlayer.getPlayer().getName());
        }

        var fileName = LocalDateTime.now().format(dateTimeFormatter) + playerNames + ".schem";
        var file = new File(SettingsManager.getInstance().getWinnerSchematicsFolder(), fileName);

        region.saveSchematic(file);
    }

    /**
     * Awards the provided amount of money to the specified player. This takes into account boosters and multipliers.
     * The provided player will be sent a message as specified in the configuration for being awarded this money.
     *
     * @param player the player to award the provided money
     * @param money the amount of money to award
     * @since 12.2.0
     */
    private void awardMoney(@NotNull Player player, double money) {
        if (SDVault.getEconomy() == null) {
            return;
        }

        if (Double.isNaN(money)) {
            Main.getInstance().getLogger().warning("Unable to parse mathematical equation");
        }

        if (!Double.isFinite(money)) {
            return;
        }

        if (player.hasPermission("bg.rewards.money.double")) {
            money *= 2;
        }

        //booster multiplier
        money *= Booster.getMultiplier(player);

        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        if (SDVault.getEconomy().depositPlayer(player, money).transactionSuccess()) {
            if (Booster.hasBooster(player)) {
                for (String message : messages.getStringList("vault.message.booster"))
                    MessageManager.getInstance().send(player, message
                        .replace("%money%", String.valueOf(money)));
            } else {
                for (String message :
                    messages.getStringList("vault.message.no-booster"))
                    MessageManager.getInstance().send(player, message
                        .replace("%money%", String.valueOf(money)));
            }
        }
    }

    /**
     * Moves on to the next match or stops the game if all matches have been played.
     *
     * @since 12.2.0
     */
    private void nextMatch() {
        for (Plot plot : this.transitionSystem.getUsedPlots()) {
            for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
                Player player = gamePlayer.getPlayer();

                player.setPlayerTime(player.getWorld().getFullTime(), true);
                player.resetPlayerWeather();
            }
        }

        for (Plot plot : this.transitionSystem.getPlots()) {
            plot.restore();
        }

        SignManager.getInstance().updateJoinSigns(this.transitionSystem);
    }

    /**
     * Dispatches the win commands as specified in the configuration to all provided game players.
     *
     * @param gamePlayers the game players to dispatch the win commands for
     * @since 12.2.0
     */
    private void dispatchWinCommands(@NotNull Iterable<? extends GamePlayer> gamePlayers) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        for (GamePlayer gamePlayer : gamePlayers) {
            for (String command : config.getStringList("win-commands")) {
                CommandUtil.dispatch(command.replace("%winner%", gamePlayer.getPlayer().getName()));
            }
        }
    }

    /**
     * Gets how many seconds the win phase should take for the specified arena.
     *
     * @param arena the arena for which this time should be measured
     * @return the time this phase should take
     * @since 12.2.0
     */
    @Contract(pure = true)
    private static int getTime(@NotNull Arena arena) {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        String name = arena.getName();

        if (!arenas.contains(name + ".win-timer")) {
            return config.getInt("timers.win");
        }

        return arenas.getInt(name + ".win-timer");
    }
}
