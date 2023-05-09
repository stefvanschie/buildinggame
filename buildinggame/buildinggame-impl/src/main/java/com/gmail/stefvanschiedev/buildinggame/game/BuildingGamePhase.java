package com.gmail.stefvanschiedev.buildinggame.game;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaStartEvent;
import com.gmail.stefvanschiedev.buildinggame.game.util.GamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.util.JoinObserver;
import com.gmail.stefvanschiedev.buildinggame.game.util.LeaveObserver;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.At;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.Every;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.TimedGamePhase;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.CommandUtil;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.item.ClickEvent;
import com.gmail.stefvanschiedev.buildinggame.utils.item.ItemBuilder;
import com.gmail.stefvanschiedev.buildinggame.utils.item.datatype.ArenaDataType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialLocation;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.ScoreboardManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

/**
 * The game phase where the players build.
 *
 * @since 12.2.0
 */
public class BuildingGamePhase extends TimedGamePhase<Arena> implements JoinObserver, LeaveObserver {

    /**
     * The boss bar
     */
    private BossBar bossBar;

    /**
     * The chosen subject
     */
    @NotNull
    private final String subject;

    /**
     * The commands to be dispatched at the given remaining times
     */
    @NotNull
    private final Map<Integer, Collection<String>> commands = new HashMap<>();

    /**
     * Creates a new timed game phase. Once the time is over, the game will transition to the next game phase.
     *
     * @param arena the arena for which this phase exists
     * @since 12.2.0
     */
    public BuildingGamePhase(@NotNull Arena arena, @NotNull String subject) {
        super(arena, getTime(arena));

        this.subject = subject;

        initializeCommands();
        initializeBossBar();

        startTimer();
    }

    @Override
    public void onPhaseEnd() {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();

        for (Plot plot : super.transitionSystem.getUsedPlots()) {
            for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
                Player player = gamePlayer.getPlayer();

                player.setGameMode(GameMode.CREATIVE);

                if (scoreboardManager == null) {
                    Main.getInstance().getLogger().warning("Unable to remove scoreboard");
                } else {
                    player.setScoreboard(scoreboardManager.getNewScoreboard());
                }

                //messages
                MessageManager.getInstance().send(player,
                    messages.getStringList("buildingCountdown.time-up.message"));

                gamePlayer.addTitleAndSubtitle(messages.getString("buildingCountdown.time-up.title", ""),
                    messages.getString("buildingCountdown.time-up.subtitle"));
                gamePlayer.sendActionbar(messages.getString("buildingCountdown.time-up.actionbar", ""));

                if (this.bossBar.getPlayers().contains(player)) {
                    this.bossBar.removePlayer(player);
                }
            }
        }

        super.onPhaseEnd();
    }

    /**
     * Sends the messages indicating how much time is left.
     *
     * @since 12.2.0
     */
    @Every(60)
    @At({30, 15, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1})
    public void sendTimeLeftMessages() {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        long seconds = getRemainingTime().getSeconds();
        long minutes = getRemainingTime().toMinutes();
        long secondsFromMinute = seconds - (minutes * 60);

        for (Plot plot : super.transitionSystem.getUsedPlots()) {
            for (GamePlayer gamePlayer : plot.getGamePlayers()) {
                Player player = gamePlayer.getPlayer();

                messages.getStringList("buildingCountdown.message").forEach(message ->
                    MessageManager.getInstance().send(player, message
                        .replace("%seconds%", String.valueOf(seconds))
                        .replace("%minutes%", String.valueOf(minutes))
                        .replace("%time%", minutes + ":" + secondsFromMinute)
                        .replace("%seconds_from_minute%", String.valueOf(secondsFromMinute)))
                );

                gamePlayer.addTitleAndSubtitle(messages.getString("buildingCountdown.title", "")
                        .replace("%seconds%", String.valueOf(seconds))
                        .replace("%minutes%", String.valueOf(minutes))
                        .replace("%time%", minutes + ":" + secondsFromMinute)
                        .replace("%seconds_from_minute%", String.valueOf(secondsFromMinute)),
                    messages.getString("buildingCountdown.subtitle", "")
                        .replace("%seconds%", String.valueOf(seconds))
                        .replace("%minutes%", String.valueOf(minutes))
                        .replace("%time%", minutes + ":" + secondsFromMinute)
                        .replace("%seconds_from_minute%", String.valueOf(secondsFromMinute)));
                gamePlayer.sendActionbar(messages.getString("buildingCountdown.actionbar", "")
                    .replace("%seconds%", String.valueOf(seconds))
                    .replace("%minutes%", String.valueOf(minutes))
                    .replace("%time%", minutes + ":" + secondsFromMinute)
                    .replace("%seconds_from_minutes%", String.valueOf(secondsFromMinute)));
            }
        }
    }

    /**
     * Updates the player's level to indicate how much time is left.
     *
     * @since 12.2.0
     */
    @Every(1)
    public void updateLevel() {
        long seconds = getRemainingTime().toSeconds();

        if (seconds > Integer.MAX_VALUE) {
            Main.getInstance().getLogger().warning("Unable to display level, too much time left");
            return;
        }

        for (Plot plot : super.transitionSystem.getUsedPlots()) {
            for (GamePlayer gamePlayer : plot.getGamePlayers()) {
                gamePlayer.getPlayer().setLevel((int) seconds);
            }
        }
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

    /**
     * Updates the boss bar to indicate how much time is left.
     *
     * @since 12.2.0
     */
    @Every(1)
    public void updateBossBar() {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        long seconds = getRemainingTime().getSeconds();
        long minutes = getRemainingTime().toMinutes();
        long secondsFromMinute = seconds - (minutes * 60);

        this.bossBar.setTitle(MessageManager.translate(messages.getString("global.bossbar-header", ""))
            .replace("%seconds%", String.valueOf(seconds))
            .replace("%seconds_from_minutes%", String.valueOf(secondsFromMinute))
            .replace("%minutes%", String.valueOf(minutes))
            .replace("%subject%", this.subject));
        this.bossBar.setProgress((double) seconds / (double) getOriginalTime());
    }

    /**
     * Dispatches the user-defined commands.
     *
     * @since 12.2.0
     */
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
    public void onPhaseStart() {
        for (Plot plot : this.transitionSystem.getUsedPlots()) {
            for (GamePlayer player : plot.getGamePlayers()) {
                this.bossBar.addPlayer(player.getPlayer());
            }
        }

        start();

        super.onPhaseStart();
    }

    @Override
    public void onJoin(@NotNull GamePlayer gamePlayer) {
        showScoreboard(gamePlayer);

        Bukkit.getScheduler().runTask(Main.getInstance(), () -> tryGiveOptionsMenu(gamePlayer.getPlayer()));
    }

    @Override
    public void forceEnd() {
        super.forceEnd();

        for (Plot plot : this.transitionSystem.getPlots()) {
            plot.restore();
        }

        this.transitionSystem.transition(new LobbyGamePhase(this.transitionSystem));
    }

    @Override
    public void onLeave(@NotNull Player player) {
        resetBossBar(player);
    }

    @Override
    public boolean canJoin() {
        return SettingsManager.getInstance().getConfig().getBoolean("join-during-game");
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public GamePhase getNextPhase() {
        return new VotingGamePhase(this.transitionSystem, this.subject);
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
        return "building";
    }

    /**
     * Starts a new match. An ArenaStartEvent will be fired once this method is called.
     *
     * @since 12.2.0
     */
    private void start() {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        //call event
        ArenaStartEvent event = new ArenaStartEvent(this.transitionSystem);
        Bukkit.getPluginManager().callEvent(event);

        if (event.isCancelled()) {
            return;
        }

        for (Plot plot : this.transitionSystem.getUsedPlots()) {
            for (GamePlayer gamePlayer : plot.getGamePlayers()) {
                PotentialLocation location = plot.getLocation();

                if (location == null) {
                    throw new IllegalStateException("Plot has no location");
                }

                location.teleport(gamePlayer.getPlayer());

                MessageManager.getInstance().send(gamePlayer.getPlayer(), messages
                    .getStringList("gameStarts.message"));

                for (String message : messages.getStringList("gameStarts.subject")) {
                    MessageManager.getInstance().send(gamePlayer.getPlayer(), message
                        .replace("%subject%", this.subject));
                }

                gamePlayer.addTitleAndSubtitle(messages.getString("gameStarts.title", "")
                    .replace("%subject%", this.subject), messages.getString("gameStarts.subtitle", "")
                    .replace("%subject%", this.subject));
                gamePlayer.sendActionbar(messages.getString("gameStarts.actionbar", "")
                    .replace("%subject%", this.subject));

                final var player = gamePlayer.getPlayer();
                player.getInventory().clear();
                player.setGameMode(GameMode.CREATIVE);
                player.setPlayerTime(plot.getTime(), false);

                //hotbar
                for (int i = 0; i < 9; i++) {
                    Material material = SettingsManager.getInstance().getMaterial(
                        "hotbar.default.slot-" + (i + 1), Material.AIR
                    );

                    player.getInventory().setItem(i, new ItemStack(material));
                }

                tryGiveOptionsMenu(player);
            }
        }

        //save blocks
        for (Plot plot : this.transitionSystem.getPlots()) {
            plot.save();
        }

        this.transitionSystem.increaseMatches();

        SignManager.getInstance().updateJoinSigns(this.transitionSystem);
    }

    /**
     * Initializes the user-defined commands.
     *
     * @since 12.2.0
     */
    private void initializeCommands() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        ConfigurationSection atSection = config.getConfigurationSection("timings.build-timer.at");
        ConfigurationSection everySection = config.getConfigurationSection("timings.build-timer.every");

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
     * Shows the scoreboard for the provided game player.
     *
     * @param gamePlayer the game player to show the scoreboard to
     * @since 12.2.0
     */
    private void showScoreboard(@NotNull GamePlayer gamePlayer) {
        Player player = gamePlayer.getPlayer();

        Plot plot = this.transitionSystem.getPlot(player);

        if (plot == null) {
            throw new IllegalStateException("Joined player does not have plot");
        }

        plot.getBuildScoreboard().show(player);

        for (Plot p : this.transitionSystem.getPlots()) {
            if (p.getGamePlayers().contains(gamePlayer)) {
                continue;
            }

            plot.getBuildScoreboard().getRedTeam().addEntry(player.getName());
        }

        for (Plot p : this.transitionSystem.getUsedPlots()) {
            for (GamePlayer gp : p.getGamePlayers()) {
                plot.getBuildScoreboard().show(gp.getPlayer());
            }
        }
    }

    /**
     * Initializes the boss bar.
     *
     * @since 12.2.0
     */
    private void initializeBossBar() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        try {
            this.bossBar = Bukkit.createBossBar(MessageManager.translate(SettingsManager.getInstance().getMessages()
                    .getString("global.bossbar-header", "").replace("%subject%", this.subject)),
                BarColor.valueOf(config.getString("bossbar.color", "").toUpperCase(Locale.getDefault())),
                BarStyle.valueOf(config.getString("bossbar.style", "").toUpperCase(Locale.getDefault())));
        } catch (IllegalArgumentException e) {
            Main.getInstance().getLogger().warning("Boss bar couldn't be loaded, check the data and try again.");
        }
    }

    /**
     * Tries to give the options menu item to the specified player. This may not work in case the options menu has been
     * disabled in the config.yml.
     *
     * @since 12.2.0
     */
    private void tryGiveOptionsMenu(@NotNull Player player) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        if (config.getBoolean("gui.enable")) {
            player.getInventory().setItem(config.getInt("gui.slot"), new ItemBuilder(player,
                Material.EMERALD).setDisplayName(MessageManager.translate(messages
                    .getString("gui.options-emerald"), player)).setLore(MessageManager.translate(messages
                    .getStringList("gui.options-lores"), player)).movable(false)
                .addContext("arena", ArenaDataType.getInstance(), this.transitionSystem)
                .setClickEvent(ClickEvent.OPTIONS_GUI_CLICK)
                .build()
            );
        }
    }

    /**
     * Resets the boss bar for the specified player.
     *
     * @param player the player to reset the boss bar for
     * @since 12.2.0
     */
    private void resetBossBar(@NotNull Player player) {
        this.bossBar.removePlayer(player);
    }

    /**
     * Gets how many seconds the building phase should take for the specified arena.
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

        if (!arenas.contains(name + ".timer")) {
            return config.getInt("timers.build");
        }

        return arenas.getInt(name + ".timer");
    }
}
