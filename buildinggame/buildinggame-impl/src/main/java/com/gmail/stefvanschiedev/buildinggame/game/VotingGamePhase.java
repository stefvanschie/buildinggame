package com.gmail.stefvanschiedev.buildinggame.game;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.game.util.GamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.util.JoinObserver;
import com.gmail.stefvanschiedev.buildinggame.game.util.TransitionSystem;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.Every;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.TimedGamePhase;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.CommandUtil;
import com.gmail.stefvanschiedev.buildinggame.utils.Vote;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.item.ClickEvent;
import com.gmail.stefvanschiedev.buildinggame.utils.item.ItemBuilder;
import com.gmail.stefvanschiedev.buildinggame.utils.item.datatype.ArenaDataType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import com.gmail.stefvanschiedev.buildinggame.utils.region.Region;
import org.bukkit.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

/**
 * The game phase where the players vote.
 *
 * @since 12.2.0
 */
public class VotingGamePhase extends GamePhase implements JoinObserver, TransitionSystem {

    /**
     * The arena that manages this phase.
     */
    @NotNull
    private final Arena arena;

    /**
     * The current game phase
     */
    @Nullable
    private PlotVoteGamePhase phase;

    /**
     * The chosen subject
     */
    @NotNull
    private final String subject;

    /**
     * The collection of plots that have been voted on.
     */
    @NotNull
    private final Collection<@NotNull Plot> votedOn = new HashSet<>();

    /**
     * The commands to be dispatched at the given remaining times.
     */
    @NotNull
    private final Map<Integer, Collection<String>> commands = new HashMap<>();

    /**
     * Creates a new timed game phase. Once the time is over, the game will transition to the next game phase. The timer
     * does not start automatically upon calling this constructor.
     *
     * @param arena the arena for which this phase exists
     * @param subject the chosen subject
     * @since 12.2.0
     */
    public VotingGamePhase(@NotNull Arena arena, @NotNull String subject) {
        this.arena = arena;
        this.subject = subject;

        initializeCommands();

        Plot plot = getNextPlot();

        if (plot != null) {
            this.votedOn.add(plot);

            this.phase = new PlotVoteGamePhase(plot);
        }
    }

    @Override
    public void onPhaseStart() {
        if (this.phase == null) {
            this.arena.transition(new WinningGamePhase(this.arena, subject));
        } else {
            this.phase.onPhaseStart();
        }
    }

    @Override
    public void onJoin(@NotNull GamePlayer gamePlayer) {
        for (Plot plot : this.arena.getPlots()) {
            if (plot.getGamePlayers().contains(gamePlayer)) {
                continue;
            }

            plot.getVoteScoreboard().getRedTeam().addEntry(gamePlayer.getPlayer().getName());
        }
    }

    @Override
    public void forceEnd() {
        if (this.phase != null) {
            this.phase.forceEnd();
        }

        for (Plot plot : this.arena.getPlots()) {
            plot.restore();
        }

        this.arena.transition(new LobbyGamePhase(this.arena));
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public DyeColor getColor() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        if (!config.contains("signs.glass-colors." + getName())) {
            return DyeColor.ORANGE;
        }

        return DyeColor.valueOf(config.getString("signs.glass-colors." + getName(), "").toUpperCase());
    }

    @Override
    public void transition(@NotNull GamePhase gamePhase) {
        if (gamePhase instanceof WinningGamePhase) {
            this.arena.transition(gamePhase);
        } else if (gamePhase instanceof PlotVoteGamePhase voteGamePhase) {
            this.phase = voteGamePhase;

            gamePhase.onPhaseStart();
        } else {
            throw new IllegalArgumentException("Game phase must be either plot vote game phase or winning game phase");
        }
    }

    /**
     * Gets the plot that is currently being voted on.
     *
     * @return the plot
     * @since 12.2.0
     */
    @Nullable
    @Contract(pure = true)
    public Plot getVotingPlot() {
        return this.phase.getPlot();
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
        return "voting";
    }

    @Override
    public boolean canJoin() {
        return false;
    }

    @Override
    public void onPhaseEnd() {}

    /**
     * Initialize the user-defined commands
     *
     * @since 12.2.0
     */
    private void initializeCommands() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        ConfigurationSection atSection = config.getConfigurationSection("timings.vote-timer.at");
        ConfigurationSection everySection = config.getConfigurationSection("timings.vote-timer.every");

        if (atSection != null) {
            for (String key : atSection.getKeys(false)) {
                int interval = Integer.parseInt(key);

                for (String command : atSection.getStringList(key)) {
                    String parsedCommand = command.replace("%arena%", arena.getName());

                    commands.computeIfAbsent(interval, (k) -> new HashSet<>()).add(parsedCommand);
                }
            }
        }

        if (everySection != null) {
            for (String key : everySection.getKeys(false)) {
                int interval = Integer.parseInt(key);

                for (String command : everySection.getStringList(key)) {
                    String parsedCommand = command.replace("%arena%", arena.getName());

                    for (int multiple = interval; multiple <= getTime(); multiple += interval) {
                        commands.computeIfAbsent(multiple, (k) -> new HashSet<>()).add(parsedCommand);
                    }
                }
            }
        }
    }

    /**
     * Gets how many seconds the vote phase should take.
     *
     * @return the time this phase should take
     * @since 12.2.0
     */
    @Contract(pure = true)
    private int getTime() {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        String name = this.arena.getName();

        if (!arenas.contains(name + ".vote-timer")) {
            return config.getInt("timers.vote");
        }

        return arenas.getInt(name + ".vote-timer");
    }

    /**
     * Gets the next plot to vote on or null if there is no more plot to vote on.
     *
     * @return the plot to vote on or null
     * @since 12.2.0
     */
    @Nullable
    @Contract(pure = true)
    private Plot getNextPlot() {
        for (Plot plot : arena.getUsedPlots()) {
            if (votedOn.contains(plot)) {
                continue;
            }

            return plot;
        }

        return null;
    }

    /**
     * Represents a game phase for voting on an individual plot.
     *
     * @since 12.2.0
     */
    public class PlotVoteGamePhase extends TimedGamePhase<VotingGamePhase> {

        /**
         * The plot to vote on
         */
        @NotNull
        private final Plot plot;

        /**
         * Creates a new timed game phase, which lasts the specified amount of time. This time is given in seconds. Once
         * this time is over, the game will transition to the next game phase as returned by the specified
         * {@link Supplier}. This timer does not start automatically upon calling this constructor.
         *
         * @param plot the plot to vote on
         * @since 12.2.0
         */
        public PlotVoteGamePhase(@NotNull Plot plot) {
            super(VotingGamePhase.this, getTime());

            this.plot = plot;

            startTimer();
        }

        @Override
        public void onPhaseStart() {
            YamlConfiguration config = SettingsManager.getInstance().getConfig();

            nextPlot();

            for (Plot plot : arena.getUsedPlots()) {
                for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
                    Player player = gamePlayer.getPlayer();

                    if (!config.getBoolean("names-after-voting") &&
                        config.getBoolean("scoreboards.vote.enable")) {
                        plot.getVoteScoreboard().show(player);
                    }

                    player.setPlayerTime(this.plot.getTime(), false);
                    player.setPlayerWeather(this.plot.isRaining() ? WeatherType.DOWNFALL : WeatherType.CLEAR);
                }
            }

            super.onPhaseStart();
        }

        @Override
        public void onPhaseEnd() {
            YamlConfiguration config = SettingsManager.getInstance().getConfig();
            YamlConfiguration messages = SettingsManager.getInstance().getMessages();

            for (Plot plot : arena.getUsedPlots()) {
                for (GamePlayer gamePlayer : plot.getGamePlayers()) {
                    Player player = gamePlayer.getPlayer();

                    if (config.getBoolean("names-after-voting")) {
                        for (String message : messages.getStringList("voting.message")) {
                            MessageManager.getInstance().send(player, message
                                .replace("%playerplot%", this.plot.getPlayerFormat()));
                        }

                        gamePlayer.addTitleAndSubtitle(messages.getString("voting.title", "")
                                .replace("%playerplot%", this.plot.getPlayerFormat()),
                            messages.getString("voting.subtitle", "")
                                .replace("%playerplot%", this.plot.getPlayerFormat()));
                        gamePlayer.sendActionbar(messages.getString("voting.actionbar", "")
                            .replace("%playerplot%", this.plot.getPlayerFormat()));
                    }

                    if (!this.plot.hasVoted(player) && !this.plot.getGamePlayers().contains(gamePlayer)) {
                        this.plot.addVote(new Vote(config.getInt("voting.default-vote-points"), player));
                    }
                }
            }

            super.onPhaseEnd();
        }

        @Every(1)
        public void dispatchCommands() {
            long seconds = getRemainingTime().getSeconds();

            if (seconds > Integer.MAX_VALUE) {
                Main.getInstance().getLogger().warning("Unable to dispatch commands, too much time left");
            }

            for (String command : VotingGamePhase.this.commands.getOrDefault((int) seconds, Collections.emptySet())) {
                CommandUtil.dispatch(command);
            }
        }

        @NotNull
        @Override
        public GamePhase getNextPhase() {
            Plot p = getNextPlot();

            if (p == null) {
                return new WinningGamePhase(arena, VotingGamePhase.this.subject);
            }

            VotingGamePhase.this.votedOn.add(p);

            return new PlotVoteGamePhase(p);
        }

        @Override
        public void forceEnd() {
            super.forceEnd();
        }

        @Override
        public boolean canJoin() {
            return false;
        }

        @NotNull
        @Contract(pure = true)
        @Override
        public DyeColor getColor() {
            return DyeColor.ORANGE;
        }

        @NotNull
        @Contract(pure = true)
        @Override
        public String getName() {
            return "voting";
        }

        /**
         * Sets the new voting plot, send messages and titles, teleports all players, gives them new vote items and
         * changes their time and weather.
         *
         * @since 12.2.0
         */
        private void nextPlot() {
            SettingsManager instance = SettingsManager.getInstance();
            YamlConfiguration config = instance.getConfig();
            YamlConfiguration messages = instance.getMessages();

            Region boundary = this.plot.getBoundary();

            if (boundary == null) {
                throw new IllegalStateException("No boundary set for plot");
            }

            Location safeLocation = boundary.getSafeLocation();
            Location center = boundary.getCenter();

            //turn head position to center of plot (thanks to bergerkiller)
            //https://bukkit.org/threads/lookat-and-move-functions.26768/
            if (safeLocation != null && center != null) {
                safeLocation = safeLocation.clone();

                double dx = center.getX() - safeLocation.getX();
                double dz = center.getZ() - safeLocation.getZ();

                if (dx != 0) {
                    safeLocation.setYaw((dx < 0 ? ((float) (1.5 * Math.PI)) : ((float) (0.5 * Math.PI))) -
                        (float) Math.atan(dz / dx));
                } else if (dz < 0) {
                    safeLocation.setYaw((float) Math.PI);
                }

                safeLocation.setPitch((float) -Math.atan((center.getY() - safeLocation.getY()) /
                    (Math.sqrt(Math.pow(dx, 2) + Math.pow(dz, 2)))));

                safeLocation.setYaw(-safeLocation.getYaw() * 180f / (float) Math.PI);
                safeLocation.setPitch(safeLocation.getPitch() * 180f / (float) Math.PI);
            }

            for (Plot plot : VotingGamePhase.this.arena.getUsedPlots()) {
                for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
                    Player player = gamePlayer.getPlayer();

                    if (!config.getBoolean("names-after-voting")) {
                        for (String message : messages.getStringList("voting.message")) {
                            MessageManager.getInstance().send(player, message
                                .replace("%playerplot%", this.plot.getPlayerFormat()));
                        }

                        gamePlayer.addTitleAndSubtitle(messages.getString("voting.title", "")
                                .replace("%playerplot%", this.plot.getPlayerFormat()),
                            messages.getString("voting.subtitle", "")
                                .replace("%playerplot%", this.plot.getPlayerFormat()));
                        gamePlayer.sendActionbar(messages.getString("voting.actionbar", "")
                            .replace("%playerplot%", this.plot.getPlayerFormat()));
                    }

                    int blockIndex = ThreadLocalRandom.current().nextInt(this.plot.getBoundary().getAllBlocks().size());

                    player.teleport(Objects.requireNonNullElseGet(safeLocation, () ->
                        boundary.getAllBlocks().get(blockIndex).getLocation()));

                    //give blocks
                    player.getInventory().clear();

                    if (gamePlayer.getGamePlayerType() == GamePlayerType.PLAYER) {
                        ConfigurationSection voteItems = config.getConfigurationSection("voting.items");

                        if (voteItems != null) {
                            for (String identifier : voteItems.getKeys(false)) {
                                boolean save = false;

                                if (!messages.contains("voting.items." + identifier + ".name")) {
                                    messages.set("voting.items." + identifier + ".name", "Type: Null");
                                    save = true;
                                }

                                if (!messages.contains("voting.items." + identifier + ".lore")) {
                                    messages.set("voting.items." + identifier + ".lore", Collections.emptyList());
                                    save = true;
                                }

                                if (save) {
                                    instance.save();
                                }

                                Material material = SettingsManager.getInstance().getMaterial(
                                    "voting.items." + identifier + ".id", Material.BARRIER
                                );
                                int points = voteItems.getInt(identifier + ".points");

                                player.getInventory().setItem(
                                    voteItems.getInt(identifier + ".slot") - 1,
                                    new ItemBuilder(player, material)
                                        .setDisplayName(MessageManager.translate(
                                            messages.getString("voting.items." + identifier + ".name", "")
                                        ))
                                        .setLore(MessageManager.translate(
                                            messages.getStringList("voting.items." + identifier + ".lore")
                                        ))
                                        .movable(false)
                                        .addContext("arena", ArenaDataType.getInstance(), VotingGamePhase.this.arena)
                                        .addContext("points", PersistentDataType.INTEGER, points)
                                        .setClickEvent(ClickEvent.VOTE_CLICK)
                                        .build()
                                );
                            }
                        }

                        boolean worldEditEnabled = Bukkit.getPluginManager().isPluginEnabled("WorldEdit");

                        if (worldEditEnabled && config.getBoolean("reports.enable")) {
                            player.getInventory().setItem(8, new ItemBuilder(player, Material.BOOK)
                                .setDisplayName(ChatColor.RED + "Report build")
                                .movable(false)
                                .addContext("arena", ArenaDataType.getInstance(), VotingGamePhase.this.arena)
                                .setClickEvent(ClickEvent.REPORT_CLICK)
                                .build()
                            );
                        }
                    }

                    if (config.getBoolean("scoreboards.vote.enable")) {
                        plot.getVoteScoreboard().show(player);
                    }

                    player.setPlayerTime(plot.getTime(), false);
                    player.setPlayerWeather(plot.isRaining() ? WeatherType.DOWNFALL : WeatherType.CLEAR);
                }
            }
        }

        /**
         * Gets the plot that is currently being voted on.
         *
         * @return the plot
         * @since 12.2.0
         */
        @NotNull
        @Contract(pure = true)
        public Plot getPlot() {
            return plot;
        }
    }
}
