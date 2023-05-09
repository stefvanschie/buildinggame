package com.gmail.stefvanschiedev.buildinggame.game;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.game.util.GamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.util.JoinObserver;
import com.gmail.stefvanschiedev.buildinggame.game.util.SubjectVoting;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.At;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.Every;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.TimedGamePhase;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.CommandUtil;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.SubjectMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.TeamSelection;
import com.gmail.stefvanschiedev.buildinggame.utils.item.ClickEvent;
import com.gmail.stefvanschiedev.buildinggame.utils.item.ItemBuilder;
import com.gmail.stefvanschiedev.buildinggame.utils.item.datatype.ArenaDataType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * The game phase where players wait in the lobby for the game to start.
 *
 * @since 12.2.0
 */
public class LobbyGamePhase extends TimedGamePhase<Arena> implements JoinObserver, SubjectVoting {

    /**
     * The subject menu
     */
    @NotNull
    private final SubjectMenu subjectMenu = new SubjectMenu();

    /**
     * The team selection
     */
    @NotNull
    private final TeamSelection teamSelection;

    /**
     * The commands to be dispatched at the given remaining times
     */
    @NotNull
    private final Map<Integer, Collection<String>> commands = new HashMap<>();

    /**
     * Creates a new timed game phase. Once this phase is over, the game will transition to the next game phase.
     *
     * @param arena the arena for which this phase exists
     * @since 12.2.0
     */
    public LobbyGamePhase(@NotNull Arena arena) {
        super(arena, getTime(arena));

        initializeCommands();

        this.teamSelection = new TeamSelection(arena);
    }

    @Override
    public void onPhaseEnd() {
        super.onPhaseEnd();
    }

    /**
     * Sends messages indicating how much time is left.
     *
     * @since 12.2.0
     */
    @Every(15)
    @At({10, 9, 8, 7, 6, 5, 4, 3, 2, 1})
    public void sendTimeLeftMessages() {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        long seconds = getRemainingTime().getSeconds();
        long minutes = getRemainingTime().toMinutes();
        long secondsFromMinute = seconds - (minutes * 60);

        for (Plot plot : this.transitionSystem.getUsedPlots()) {
            for (GamePlayer gamePlayer : plot.getGamePlayers()) {
                var player = gamePlayer.getPlayer();

                for (String message : messages.getStringList("lobbyCountdown.message")) {
                    MessageManager.getInstance().send(player, message
                        .replace("%seconds%", String.valueOf(seconds))
                        .replace("%minutes%", String.valueOf(minutes))
                        .replace("%time%", minutes + ":" + secondsFromMinute)
                        .replace("%seconds_from_minute%", String.valueOf(secondsFromMinute)));
                }
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

        for (Plot plot : this.transitionSystem.getUsedPlots()) {
            for (GamePlayer gamePlayer : plot.getGamePlayers()) {
                gamePlayer.getPlayer().setLevel((int) seconds);
            }
        }
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

    @NotNull
    @Contract(pure = true)
    @Override
    public DyeColor getColor() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        if (!config.contains("signs.glass-colors." + getName())) {
            return DyeColor.GREEN;
        }

        return DyeColor.valueOf(config.getString("signs.glass-colors." + getName(), "").toUpperCase());
    }

    @NotNull
    @Contract(pure = true)
    @Override
    public GamePhase getNextPhase() {
        if (this.subjectMenu.getWhen() == SubjectMenu.When.BEFORE_BUILD) {
            return new SubjectVotePhase(this.transitionSystem);
        }

        return new BuildingGamePhase(this.transitionSystem, this.subjectMenu.getHighestVote());
    }

    @Override
    public void onJoin(@NotNull GamePlayer gamePlayer) {
        showScoreboard(gamePlayer);

        Bukkit.getScheduler().runTask(Main.getInstance(), () -> giveSubjectMenuItem(gamePlayer.getPlayer()));
    }

    @Override
    public void forceEnd() {
        super.forceEnd();

        this.transitionSystem.transition(new LobbyGamePhase(this.transitionSystem));
    }

    @NotNull
    @Override
    public SubjectMenu getSubjectMenu() {
        return subjectMenu;
    }

    /**
     * Gets the team selection.
     *
     * @return the team selection
     * @since 12.2.0
     */
    @NotNull
    @Contract(pure = true)
    public TeamSelection getTeamSelection() {
        return teamSelection;
    }

    @NotNull
    @Contract(pure  = true)
    @Override
    public String getName() {
        return "lobby";
    }

    /**
     * Initializes the user-defined commands.
     *
     * @since 12.2.0
     */
    private void initializeCommands() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        ConfigurationSection atSection = config.getConfigurationSection("timings.lobby-timer.at");
        ConfigurationSection everySection = config.getConfigurationSection("timings.lobby-timer.every");

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
     * Shows the scoreboard to the provided game player.
     *
     * @param gamePlayer the game player to show the scoreboard to
     * @since 12.2.0
     */
    private void showScoreboard(@NotNull GamePlayer gamePlayer) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        boolean enableScoreboard = config.getBoolean("scoreboards.lobby.enable");
        Player player = gamePlayer.getPlayer();

        if (enableScoreboard) {
            Plot plot = this.transitionSystem.getPlot(player);

            if (plot != null) {
                plot.getLobbyScoreboard().show(player);
            }
        }

        for (Plot plot : this.transitionSystem.getPlots()) {
            if (plot.getGamePlayers().contains(gamePlayer)) {
                continue;
            }

            plot.getLobbyScoreboard().getRedTeam().addEntry(player.getName());
        }

        if (enableScoreboard) {
            for (Plot plot : this.transitionSystem.getUsedPlots()) {
                for (GamePlayer gp : plot.getGamePlayers()) {
                    plot.getLobbyScoreboard().show(gp.getPlayer());
                }
            }
        }
    }

    /**
     * Gives the subject menu item to the provided player iff. the player has the right permission, subject voting is
     * enabled and subject voting is done in the lobby phase.
     *
     * @param player the player to give the subject menu item to
     * @since 12.2.0
     */
    public void giveSubjectMenuItem(@NotNull Player player) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        if (player.hasPermission("bg.subjectmenu") && config.getBoolean("enable-subject-voting") &&
            this.subjectMenu.getWhen() == SubjectMenu.When.LOBBY) {

            int slot = config.getInt("subject-gui.slot");
            ItemStack item = player.getInventory().getItem(slot);

            if (item != null && item.getType() != Material.AIR) {
                Main.getInstance().getLogger().warning(
                    "Subject gui item overrides a different item. This other item will not be visible. Please " +
                        "change the slots in the config.yml file to fix this."
                );
            }

            Material material = SettingsManager.getInstance().getMaterial("subject-gui.item.id", Material.BARRIER);

            player.getInventory().setItem(
                slot,
                new ItemBuilder(player, material)
                    .setDisplayName(MessageManager.translate(messages.getString("subject-gui.item.name"),
                        player))
                    .setLore(MessageManager.translate(messages.getStringList("subject-gui.item.lores"),
                        player))
                    .addContext("arena", ArenaDataType.getInstance(), this.transitionSystem)
                    .setClickEvent(ClickEvent.SUBJECT_GUI_CLICK)
                    .build()
            );


            if (this.subjectMenu.opensInstantly()) {
                this.subjectMenu.show(player);
            }
        }
    }

    @Override
    public boolean canJoin() {
        return true;
    }

    /**
     * Gets how many seconds the lobby phase should take for the specified arena.
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

        if (!arenas.contains(name + ".lobby-timer")) {
            return config.getInt("timers.lobby");
        }

        return arenas.getInt(name + ".lobby-timer");
    }
}
