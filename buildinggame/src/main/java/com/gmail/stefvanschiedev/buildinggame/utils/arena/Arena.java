package com.gmail.stefvanschiedev.buildinggame.utils.arena;

import java.io.File;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.gmail.stefvanschiedev.buildinggame.utils.*;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.SubjectMenu.When;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialBlockPosition;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.region.Region;
import com.gmail.stefvanschiedev.buildinggame.utils.scoreboards.*;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaJoinEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaLeaveEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaStartEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaStopEvent;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.scoreboards.MainScoreboardManager;
import com.gmail.stefvanschiedev.buildinggame.timers.BuildTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.VoteTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.LobbyTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.WinTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.utils.Timer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.SubjectMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.TeamSelection;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an arena
 *
 * @since 2.1.0
 */
public class Arena {

    /**
     * Whether this aren is in solo or team mode
     */
	private ArenaMode mode = ArenaMode.SOLO;

	/**
     * The bossbar for the building phase
     */
	private BossBar bossbar;

	/**
     * The state of this arena
     */
	private GameState state = GameState.WAITING;

	/**
     * A list of all plots
     */
	private final List<Plot> plots = new ArrayList<>();

	/**
     * A list of all plots which has been voted on
     */
	private final Collection<Plot> votedPlots = new ArrayList<>();

	/**
     * A list of all join signs belonging to this arena
     */
	private final Collection<PotentialBlockPosition> signs = new ArrayList<>();

	/**
     * The lobby of this arena
     */
	@Nullable
	private PotentialLocation lobby;

	/**
     * The name of this arena
     */
	private final String name;

	/**
     * The maximum amount of players
     */
	private int maxPlayers = plots.size();

	/**
     * The minimum amount of players
     */
	private int minPlayers;

	/**
     * The plot which is currently being voted for
     */
	private Plot votingPlot;

	/**
     * The build scoreboard
     */
	private final Map<Plot, ArenaScoreboard> buildScoreboards = new HashMap<>();

	/**
     * The lobby scoreboard
     */
	private final Map<Plot, ArenaScoreboard> lobbyScoreboards = new HashMap<>();

	/**
     * The vote scoreboard
     */
	private final Map<Plot, VoteScoreboard> voteScoreboards = new HashMap<>();

	/**
     * The win scoreboard
     */
	private final Map<Plot, ArenaScoreboard> winScoreboards = new HashMap<>();

	/**
     * The subject
     */
	private String subject;

	/**
     * The amount of matches which have been or are being played
     */
	private int matches;

	/**
     * The maximum amount of matches
     */
	private int maxMatches;

	/**
     * The plot that became first
     */
	private Plot first;

	/**
     * The plot that became second
     */
	private Plot second;

	/**
     * The plot that become third
     */
	private Plot third;

	/**
     * The subject menu
     */
	private SubjectMenu subjectMenu = new SubjectMenu();

	/**
     * The team selection
     */
	private TeamSelection teamSelection;

	/**
     * The lobby timer
     */
    private LobbyTimer lobbyTimer;

    /**
     * The win timer
     */
    private WinTimer winTimer;

    /**
     * The build timer
     */
    private BuildTimer buildTimer;

    /**
     * The vote timer
     */
    private VoteTimer voteTimer;

    /**
     * Whether money is enabled or not
     */
    private boolean moneyEnabled;

    /**
     * Constructs a new arena with the given name as identifier
     *
     * @param name the name of the arena
     */
	public Arena(String name) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		this.name = name;

        try {
			this.bossbar = Bukkit.createBossBar(MessageManager.translate(SettingsManager.getInstance().getMessages()
                            .getString("global.bossbar-header").replace("%subject%", "?")),
                    BarColor.valueOf(config.getString("bossbar.color").toUpperCase(Locale.getDefault())),
                    BarStyle.valueOf(config.getString("bossbar.style").toUpperCase(Locale.getDefault())));

			getBossBar().setVisible(false);
		} catch (IllegalArgumentException e) {
			Main.getInstance().getLogger().warning("Bossbar couldn't be loaded, check the data and try again.");
		}
	}

	/**
     * Adds a plot to the list
     *
     * @param plot the plot to add
     * @see Plot
     * @since 2.1.0
     */
	public void addPlot(Plot plot) {
		plots.add(plot);

		lobbyScoreboards.put(plot, new LobbyScoreboard(this));
        buildScoreboards.put(plot, new BuildScoreboard(this));
        voteScoreboards.put(plot, new VoteScoreboard(this));
        winScoreboards.put(plot, new WinScoreboard(this));
	}

	/**
     * Returns whether this arena has the specified player
     *
     * @param player the player to look for
     * @return true if the players is in this arena, false otherwise
     * @since 2.2.1
     */
	public boolean contains(Player player) {
	    return getUsedPlots().stream()
            .flatMap(plot -> plot.getGamePlayers().stream())
            .anyMatch(gamePlayer -> gamePlayer.getPlayer().equals(player));
	}

	/**
     * Forces this arena to stop no matter how many matches have been played
     *
     * @since 5.0.0
     */
	private void forceStop() {
	    this.matches = maxMatches;
	    nextMatch();
    }

    /**
     * Returns the timer that is currently active
     *
     * @return the timer which is currently active or null if there is no timer active
     * @see Timer
     * @since 2.1.0
     */
    @Nullable
    @Contract(pure = true)
	public Timer getActiveTimer() {
		if (lobbyTimer.isActive())
			return lobbyTimer;

		if (buildTimer.isActive())
			return buildTimer;

		if (voteTimer.isActive())
			return voteTimer;

		if (winTimer.isActive())
			return winTimer;

		return null;
	}

	/**
     * Returns the bossbar
     *
     * @return the bossbar
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public BossBar getBossBar() {
		return bossbar;
	}

	/**
     * Returns the build scoreboard for a specific plot
     *
     * @param plot the plot this build scoreboard belongs to
     * @return the build scoreboard
     * @see BuildScoreboard
     * @since 5.9.0
     */
	@NotNull
    @Contract(pure = true)
	public ArenaScoreboard getBuildScoreboard(@NotNull Plot plot) {
		return buildScoreboards.get(plot);
	}

	/**
     * Returns the plot that became first or null if voting isn't over yet
     *
     * @return the plot that became first
     * @see Plot
     * @since 3.0.0
     */
	@Nullable
    @Contract(pure = true)
	public Plot getFirstPlot() {
		return first;
	}

    /**
     * Returns the lobby for this arena, may return null when the lobby hasn't been set or hasn't been loaded yet
     *
     * @return the lobby
     * @since 9.1.2
     */
	@Nullable
	@Contract(pure = true)
	public PotentialLocation getLobby() {
	    return lobby;
    }

	/**
     * Returns the lobby scoreboard or null if it doesn't exist
     *
     * @param plot the plot this lobby scoreboard belongs to
     * @return the lobby scoreboard
     * @see LobbyScoreboard
     * @since 2.3.0
     */
	@Nullable
    @Contract(pure = true)
	public ArenaScoreboard getLobbyScoreboard(@NotNull Plot plot) {
		return lobbyScoreboards.get(plot);
	}

	/**
     * Returns the maximum amount of players
     *
     * @return the max. amount of players
     * @since 2.1.0
     */
	@Contract(pure = true)
	public int getMaxPlayers() {
		return maxPlayers;
	}

	/**
     * Returns the mode this arena is in
     *
     * @return the arena mode
     * @see ArenaMode
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
	public ArenaMode getMode() {
		return mode;
	}

	/**
     * Returns the name of this arena
     *
     * @return the name of this arena
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
	public String getName() {
		return name;
	}

	/**
     * Returns the amount of players in this arena (this excludes spectators)
     *
     * @return the amount of players
     * @since 2.1.0
     */
	@Contract(pure = true)
	public int getPlayers() {
	    return getUsedPlots().stream().mapToInt(plot -> plot.getGamePlayers().size()).sum();
	}

	/**
     * Returns the plot by the given ID or null if such a plot doesn't exist
     *
     * @param ID the ID to look for
     * @return the plot with the given ID
     * @see Plot
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public Plot getPlot(int ID) {
	    return plots.stream().filter(plot -> plot.getId() == ID).findAny().orElse(null);
	}

	/**
     * Returns the plot which contains the given player or null if such a plot doesn't exist
     *
     * @param player the player to look for
     * @return the plot the given player is in
     * @see Plot
     * @since 2.1.0
     */
	@Nullable
    @Contract(value = "null -> null", pure = true)
	public Plot getPlot(Player player) {
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
				if (gamePlayer.getPlayer().equals(player))
					return plot;
			}
		}

		return null;
	}

	/**
     * Returns a list of all plots belonging to this arena
     *
     * @return a list of plots
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public List<Plot> getPlots() {
		return plots;
	}

	/**
     * Returns the plot that became second or null if voting isn't over yet
     *
     * @return the plot that became second
     * @see Plot
     * @since 3.0.0
     */
	@Nullable
    @Contract(pure = true)
	public Plot getSecondPlot() {
		return second;
	}

	/**
     * Returns a collection of join signs belonging to this arena
     *
     * @return a collection of signs
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public Collection<PotentialBlockPosition> getSigns() {
		return signs;
	}

	/**
     * Returns the current state of this arena
     *
     * @return the current game state
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public GameState getState() {
		return state;
	}

	/**
     * Returns the subject or null if no subject has been chosen yet
     *
     * @return the subject
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public String getSubject() {
		return subject;
	}

	/**
     * Returns the subject menu
     *
     * @return the subject menu
     * @see SubjectMenu
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public SubjectMenu getSubjectMenu() {
		return subjectMenu;
	}

	/**
     * Returns the plot that became third or null if voting isn't over yet
     *
     * @return the plot that became third
     * @see Plot
     * @since 3.0.0
     */
	@Nullable
    @Contract(pure = true)
	public Plot getThirdPlot() {
		return third;
	}

	/**
     * Returns a collection of used plots; which contain at least one player
     *
     * @return a collection of used plots
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public Collection<Plot> getUsedPlots() {
		return getPlots().stream().filter(plot -> !plot.getGamePlayers().isEmpty()).collect(Collectors.toSet());
	}

	/**
     * Returns a collection of plots which haven been or are currently being voted for
     *
     * @return a collection of voted plots
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public Collection<Plot> getVotedPlots() {
		return votedPlots;
	}

	/**
     * Returns the vote scoreboard or null if it doesn't exist
     *
     * @param plot the plot this scoreboard is indexed by
     * @return the vote scoreboard
     * @see VoteScoreboard
     * @since 5.9.0
     */
	@Nullable
    @Contract(pure = true)
	public VoteScoreboard getVoteScoreboard(@NotNull Plot plot) {
		return voteScoreboards.get(plot);
	}

	/**
     * Returns the vote timer
     *
     * @return the vote timer
     * @see VoteTimer
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public VoteTimer getVoteTimer() {
		return voteTimer;
	}

	/**
     * Returns the plot which is currently being voted for
     *
     * @return the plot currently being voted for
     * @see Plot
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public Plot getVotingPlot() {
		return votingPlot;
	}

	/**
     * Returns the lobby timer
     *
     * @return the lobby timer
     * @see LobbyTimer
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public LobbyTimer getLobbyTimer() {
		return lobbyTimer;
	}

	/**
     * Returns the win scoreboard or null if it doesn't exist
     *
     * @return the win scoreboard
     * @see WinScoreboard
     * @since 2.3.0
     */
	@Nullable
    @Contract(pure = true)
	public ArenaScoreboard getWinScoreboard(@NotNull Plot plot) {
		return winScoreboards.get(plot);
	}

	/**
     * Returns the win timer
     *
     * @return the win timer
     * @see WinTimer
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public WinTimer getWinTimer() {
		return winTimer;
	}

    /**
     * Returns true if this money has money enabled, false otherwise
     *
     * @return whether money is enabled
     * @since 5.5.1
     */
	@Contract(pure = true)
	public boolean hasMoneyEnabled() {
	    return moneyEnabled;
    }

	/**
     * Returns whether tis arena is empty; no players are present
     *
     * @return true if this arena is empty, false otherwise
     * @since 4.0.6
     */
	@Contract(pure = true)
	public boolean isEmpty() {
	    return getPlayers() == 0;
	}

	/**
     * Returns whether the amount of plots in use are greater than the maximum amount of players
     *
     * @return true if this arena is full, false otherwise
     * @since 2.1.0
     */
	@Contract(pure = true)
	public boolean isFull() {
		return getUsedPlots().size() >= getMaxPlayers();
	}

	/**
     * Returns whether all necessary steps are taken to make this arena's setup complete
     *
     * @return true if this arena is setup fully, false otherwise
     */
	@Contract(pure = true)
	private boolean isSetup() {
		if (lobby == null || MainSpawnManager.getInstance().getMainSpawn() == null)
			return false;

		return getPlots().stream().noneMatch(plot -> plot.getBoundary() == null || plot.getFloor() == null);
	}

	/**
     * Joins the given player this arena, with all messages being send and all items given to the player. It'll teleport
     * the player to the {@link #lobby} and will join the first open plot. An ArenaJoinEvent may fire once this method
     * is called.
     *
     * @param player the player to join this arena
     * @since 2.1.0
     */
	public void join(final Player player) {
		final YamlConfiguration config = SettingsManager.getInstance().getConfig();
		final YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		//check if everything is set up
		if (!isSetup()) {
			MessageManager.getInstance().send(player, ChatColor.RED +
                    "Your arena isn't setup right, you still need to do this:");

			if (lobby == null)
				MessageManager.getInstance().send(player, ChatColor.RED + " - The lobby of arena " + getName()
                        + "(/bg setlobby " + getName() + ')');

			if (MainSpawnManager.getInstance().getMainSpawn() == null)
				MessageManager.getInstance().send(player, ChatColor.RED +
                        " - The main spawn (/bg setmainspawn)");

			getPlots().stream().filter(plot -> plot.getBoundary() == null).forEach(plot ->
					MessageManager.getInstance().send(player, ChatColor.RED + " - The boundary of plot " +
                            plot.getId() + " (/bg setbounds " + getName() + ' ' + plot.getId() + ')'));

			getPlots().stream().filter(plot -> plot.getFloor() == null).forEach(plot ->
					MessageManager.getInstance().send(player, ChatColor.RED + " - The floor of plot " +
                            plot.getId() + " (/bg setfloor " + getName() + ' ' + plot.getId() + ')'));

			return;
		}
		
		if (ArenaManager.getInstance().getArena(player) != null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're already in a game");
			return;
		}

        if (!canJoin()) {
			MessageManager.getInstance().send(player, messages.getStringList("join.in-game"));
			return;
		}
		
		if (isFull()) {
			MessageManager.getInstance().send(player, ChatColor.RED + "This arena is full");
			return;
		}
		
		//call event
		ArenaJoinEvent event = new ArenaJoinEvent(this, player);
		Bukkit.getPluginManager().callEvent(event);
		if (event.isCancelled())
			return;
		
		GamePlayer p = new GamePlayer(player, GamePlayerType.PLAYER);
		Plot plot = null;

		for (Plot pl : getPlots()) {
			if (!pl.isFull()) {
			    plot = pl;

				pl.join(p);
				break;
			}
		}
		
		if (config.getBoolean("scoreboards.main.enable"))
			MainScoreboardManager.getInstance().remove(player);

        boolean enableLobbyScoreboard = config.getBoolean("scoreboards.lobby.enable");

        if (enableLobbyScoreboard && (getState() == GameState.WAITING || getState() == GameState.STARTING)) {
            getLobbyScoreboard(plot).show(player);
        } else {
            getBuildScoreboard(plot).show(player);
        }

        String name = player.getName();

        //add player to red scoreboard of others
        getPlots().stream().filter(pl -> !pl.getGamePlayers().contains(p)).forEach(pl -> {
            getLobbyScoreboard(pl).getRedTeam().addEntry(name);
            getBuildScoreboard(pl).getRedTeam().addEntry(name);
            getVoteScoreboard(pl).getRedTeam().addEntry(name);
            getWinScoreboard(pl).getRedTeam().addEntry(name);
        });

        messages.getStringList("join.message").forEach(message ->
            MessageManager.getInstance().send(player, message
                .replace("%players%", getPlayers() + "")
                .replace("%max_players%", getMaxPlayers() + "")));

        getUsedPlots().stream().flatMap(pl -> pl.getGamePlayers().stream()).forEach(gamePlayer -> {
            Player pla = gamePlayer.getPlayer();

            messages.getStringList("join.otherPlayers").forEach(message ->
                MessageManager.getInstance().send(pla, message
                    .replace("%player%", name)
                    .replace("%players%", getPlayers() + "")
                    .replace("%max_players%", getMaxPlayers() + "")));
        });
		
		if (lobby != null && (getState() == GameState.WAITING || getState() == GameState.STARTING)) {
            lobby.teleport(player);
        } else {
            plot.getLocation().teleport(player);
        }

		if (enableLobbyScoreboard && (getState() == GameState.WAITING || getState() == GameState.STARTING)) {
            getUsedPlots().forEach(pl ->
                pl.getGamePlayers().forEach(gamePlayer -> lobbyScoreboards.get(pl).show(gamePlayer.getPlayer())));
        } else {
            getUsedPlots().forEach(pl ->
                pl.getGamePlayers().forEach(gamePlayer -> buildScoreboards.get(pl).show(gamePlayer.getPlayer())));
        }
		
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		//fill lives and hunger
		player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
		player.setFoodLevel(20);

        if (getState() == GameState.WAITING || getState() == GameState.STARTING) {
            player.setGameMode(GameMode.ADVENTURE);
        } else {
            player.setGameMode(GameMode.CREATIVE);
        }

		//time
		if (config.getBoolean("join.time-change.change"))
			player.setPlayerTime(config.getInt("join.time-change.time"), false);
		
		//bossbar
		getBossBar().addPlayer(player);
		
		//hide players from tab list
		if (config.getBoolean("tab-list.adjust"))
            Bukkit.getOnlinePlayers().stream().filter(pl -> !contains(pl)).forEach(pl ->
                player.hidePlayer(Main.getInstance(), pl));

		//show current joined player to others
        getUsedPlots().stream().flatMap(pl -> pl.getGamePlayers().stream()).forEach(gamePlayer ->
            gamePlayer.getPlayer().showPlayer(Main.getInstance(), player));
		
		if (getPlayers() >= minPlayers && !lobbyTimer.isActive() &&
            (getState() == GameState.WAITING || getState() == GameState.STARTING)) {
            lobbyTimer.runTaskTimer(Main.getInstance(), 0L, 20L);
        }
		
		if (getPlayers() >= getMaxPlayers())
			lobbyTimer.setSeconds(0);

		var arena = this;

		//bukkit runnable because of instant leaving and instant subject opening
		var runnable = new BukkitRunnable () {
			@Override
			public void run() {
				//give team selection
                if (getState() == GameState.WAITING || getState() == GameState.STARTING) {
                    if (getMode() == ArenaMode.TEAM) {
                        Material material = SettingsManager.getInstance().getMaterial("team-selection.item.id",
                            Material.BARRIER);

                        player.getInventory().setItem(0, new ItemBuilder(player, material)
                            .setDisplayName(
                                MessageManager.translate(messages.getString("team-gui.item.name"), player)
                            ).setLore(
                                MessageManager.translate(messages.getStringList("team-gui.item.lores"), player)
                            ).setClickEvent(event -> {
                                getTeamSelection().show(player);
                                event.setCancelled(true);
                            }).build());
                    }

                    //give paper for subject
                    if (player.hasPermission("bg.subjectmenu") && config.getBoolean("enable-subject-voting") &&
                        getSubjectMenu().getWhen() == SubjectMenu.When.LOBBY) {
                        giveSubjectMenuItem(player);

                        if (getSubjectMenu().opensInstantly()) {
                            getSubjectMenu().show(player);
                        }
                    }

                    Material material = SettingsManager.getInstance().getMaterial("leave-item.id",
                        Material.BARRIER);

                    player.getInventory().setItem(config.getInt("leave-item.slot"),
                        new ItemBuilder(player, material)
                            .setDisplayName(MessageManager.translate(messages.getString("leave-item.name"), player))
                            .setClickEvent(event -> {
                                leave(player);
                                event.setCancelled(true);
                            }).build());
                    player.updateInventory();
                } else if (getState() == GameState.BUILDING) {
                    tryGiveOptionsMenu(player);
                }
			}

            /**
             * Returns the team selection and creates one if it doesn't exist yet
             *
             * @return the team selection
             * @see TeamSelection
             * @since 2.1.0
             */
            @NotNull
            private TeamSelection getTeamSelection() {
                if (teamSelection == null)
                    teamSelection = new TeamSelection(arena);

                return teamSelection;
            }
		};

		runnable.runTaskLater(Main.getInstance(), 1L);
		
		SignManager.getInstance().updateJoinSigns(this);
	}

	/**
     * Leaves the specified player. This will send messages to the player, restore their inventory, exp, armor etc.,
     * reset their time and weather to the one by the server, will make all invisible players visible again, cancel
     * timers if needed, updates the join signs for this arena and will leave the plot for the player. An
     * ArenaLeaveEvert may fire once this method is called.
     *
     * @param player the player to leave
     * @since 2.1.0
     */
	public void leave(Player player) {
	    YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
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

        var plot = getPlot(player);

        //this shouldn't happen unless you screwed up with the api
        if (plot == null) {
            MessageManager.getInstance().send(player, "You're not in a game");
            ArenaManager.getInstance().getArena(player).leave(player);
            return;
        }

		GamePlayer p = plot.getGamePlayer(player);
		p.restore();

		if (MainSpawnManager.getInstance().getMainSpawn() != null)
			p.connect(MainSpawnManager.getInstance().getServer(), MainSpawnManager.getInstance().getMainSpawn());
		
		if (config.getBoolean("scoreboards.main.enable"))
			MainScoreboardManager.getInstance().register(player);
		
		player.resetPlayerTime();
		player.resetPlayerWeather();
		
		//show all players again
		Bukkit.getOnlinePlayers().forEach(pl -> player.showPlayer(Main.getInstance(), pl));

        //reset player display name of removed player
        getPlots().forEach(pl -> {
            getLobbyScoreboard(pl).getRedTeam().removeEntry(player.getName());
            getBuildScoreboard(pl).getRedTeam().removeEntry(player.getName());
            getVoteScoreboard(pl).getRedTeam().removeEntry(player.getName());
            getWinScoreboard(pl).getRedTeam().removeEntry(player.getName());
        });

		getUsedPlots().forEach(usedPlot -> {
			for (GamePlayer gamePlayer : usedPlot.getGamePlayers()) {
				Player pl = gamePlayer.getPlayer();
				if (pl.equals(player)) {
					usedPlot.leave(gamePlayer);

					if (state == GameState.WAITING)
					    MessageManager.getInstance().send(player, messages.getStringList("leave.message.lobby"));
					else
                        MessageManager.getInstance().send(player, messages.getStringList("leave.message.in-game"));

					break;
				}
			}
		});
		
		getUsedPlots().forEach(usedPlot ->
            usedPlot.getGamePlayers().forEach(gamePlayer -> {
                Player pl = gamePlayer.getPlayer();

                if (state == GameState.WAITING)
                    messages.getStringList("leave.other-players.lobby").forEach(message ->
                        MessageManager.getInstance().send(pl, message
                            .replace("%player%", player.getName())));
                else
                    messages.getStringList("leave.other-players.in-game").forEach(message ->
                        MessageManager.getInstance().send(pl, message
                            .replace("%player%", player.getName())));

                if (config.getBoolean("scoreboards.lobby.enable"))
                    getLobbyScoreboard(usedPlot).show(pl);
            })
        );

        //cancel wait timer when user amount drops below minimum
        if (getPlayers() < minPlayers && lobbyTimer.isActive()) {
            lobbyTimer.cancel();
            setLobbyTimer(new LobbyTimer(arenas.getInt(name + ".lobby-timer"), this));
        }

		if (getPlayers() <= 1) {
			if (getLobbyTimer().isActive()) {
				lobbyTimer.cancel();
				setLobbyTimer(new LobbyTimer(arenas.getInt(name + ".lobby-timer"), this));
				setState(GameState.WAITING);
			}
			if (buildTimer.isActive()) {
				buildTimer.cancel();
				setBuildTimer(new BuildTimer(arenas.getInt(name + ".timer"), this));
				forceStop();
			}
			if (getVoteTimer().isActive()) {
				voteTimer.cancel();
				setVoteTimer(new VoteTimer(arenas.getInt(name + ".vote-timer"), this));
				forceStop();
			}
			if (getWinTimer().isActive()) {
				winTimer.cancel();
				setWinTimer(new WinTimer(arenas.getInt(name + ".win-timer"), this));
				forceStop();
			}
		}
		
		if (getBossBar().getPlayers().contains(player))
			getBossBar().removePlayer(player);
		
		SignManager.getInstance().updateJoinSigns(this);
	}

    /**
     * Tries to give the options menu item to the specified player. This may not work in case the options menu has been
     * disabled in the config.yml.
     *
     * @since 9.0.1
     */
	public void tryGiveOptionsMenu(@NotNull Player player) {
	    YamlConfiguration config = SettingsManager.getInstance().getConfig();
	    YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        if (config.getBoolean("gui.enable")) {
            player.getInventory().setItem(config.getInt("gui.slot"), new ItemBuilder(player,
                Material.EMERALD).setDisplayName(MessageManager.translate(messages
                .getString("gui.options-emerald"), player)).setLore(MessageManager.translate(messages
                .getStringList("gui.options-lores"), player)).movable(false).setClickEvent(e -> {
                getPlot(player).getBuildMenu().show(player);
                e.setCancelled(true);
            }).build());
        }
	}

	/**
     * Sets a new build timer. This won't cancel the current build timer if started.
     *
     * @param buildTimer the new build timer
     * @see BuildTimer
     * @since 2.1.0
     */
	public void setBuildTimer(BuildTimer buildTimer) {
		this.buildTimer = buildTimer;
	}

	/**
     * Sets the pot that became first after voting
     *
     * @param first the plot that became first
     * @see Plot
     * @since 3.0.0
     */
	public void setFirstPlot(Plot first) {
		this.first = first;
	}

	/**
     * Sets a new lobby
     *
     * @param lobby the new lobby
     * @since 9.1.2
     */
	public void setLobby(@NotNull PotentialLocation lobby) {
		this.lobby = lobby;
	}

	/**
     * Sets the maximum amount of matches to be played
     *
     * @param maxMatches the max. amount of matches
     * @since 4.0.6
     */
	public void setMaxMatches(int maxMatches) {
	    this.maxMatches = maxMatches;
    }

    /**
     * Sets the maximum amount of players
     *
     * @param maxPlayers the new max. amount of players
     * @since 2.1.0
     */
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	/**
     * Sets the minimum amount of players
     *
     * @param minPlayers the new min. amount of players
     * @since 2.1.0
     */
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	/**
     * Sets the arena mode
     *
     * @param mode the new mode
     * @see ArenaMode
     * @since 2.1.0
     */
	public void setMode(ArenaMode mode) {
		this.mode = mode;
	}

    /**
     * Enables/Disables money for this arena
     *
     * @param enabled whether money is enabled/disabled
     * @since 5.5.1
     */
	public void setMoneyEnabled(boolean enabled) {
	    this.moneyEnabled = enabled;
    }

	/**
     * Sets the plot that became second after voting
     *
     * @param second the plot that became second
     * @see Plot
     * @since 3.0.0
     */
	public void setSecondPlot(Plot second) {
		this.second = second;
	}

	/**
     * Sets the game state
     *
     * @param state the new state
     * @see GameState
     * @since 2.1.0
     */
	public void setState(GameState state) {
		this.state = state;
	}

	/**
     * Sets the plot that became third after voting
     *
     * @param third the plot that became third
     * @see Plot
     * @since 3.0.0
     */
	public void setThirdPlot(Plot third) {
		this.third = third;
	}

	/**
     * Sets the vote timer
     *
     * @param voteTimer the new vote timer
     * @see VoteTimer
     * @since 2.1.0
     */
	public void setVoteTimer(VoteTimer voteTimer) {
		this.voteTimer = voteTimer;
	}

	/**
     * Sets the new voting plot, send messages and titles, teleports all players, gives them new vote items and changes
     * their time and weather.
     *
     * @param votingPlot the new voting plot
     * @see Plot
     * @since 2.1.0
     */
	public void setVotingPlot(Plot votingPlot) {
        SettingsManager instance = SettingsManager.getInstance();
        YamlConfiguration config = instance.getConfig();
		YamlConfiguration messages = instance.getMessages();
		
		this.votingPlot = votingPlot;

		Region boundary = votingPlot.getBoundary();
        Location safeLocation = boundary.getSafeLocation();
        Location center = boundary.getCenter();

        //turn head position to center of plot (thanks to bergerkiller)
        //https://bukkit.org/threads/lookat-and-move-functions.26768/
        if (safeLocation != null) {
            //Clone the loc to prevent applied changes to the input loc
            safeLocation = safeLocation.clone();

            // Values of change in distance (make it relative)
            double dx = center.getX() - safeLocation.getX();
            double dz = center.getZ() - safeLocation.getZ();

            // Set yaw
            if (dx != 0)
                safeLocation.setYaw((dx < 0 ? ((float) (1.5 * Math.PI)) : ((float) (0.5 * Math.PI))) -
                        (float) Math.atan(dz / dx));
            else if (dz < 0)
                safeLocation.setYaw((float) Math.PI);

            // Set pitch
            safeLocation.setPitch((float) -Math.atan((center.getY() - safeLocation.getY()) /
                    (Math.sqrt(Math.pow(dx, 2) + Math.pow(dz, 2)))));

            // Set values, convert to degrees (invert the yaw since Bukkit uses a different yaw dimension format)
            safeLocation.setYaw(-safeLocation.getYaw() * 180f / (float) Math.PI);
            safeLocation.setPitch(safeLocation.getPitch() * 180f / (float) Math.PI);
        }

		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
				Player player = gamePlayer.getPlayer();
			
				if (!config.getBoolean("names-after-voting")) {
					messages.getStringList("voting.message").forEach(message ->
						MessageManager.getInstance().send(player, message
								.replace("%playerplot%", votingPlot.getPlayerFormat())));

					gamePlayer.addTitleAndSubtitle(messages.getString("voting.title")
							.replace("%playerplot%", votingPlot.getPlayerFormat()),
                            messages.getString("voting.subtitle")
							.replace("%playerplot%", votingPlot.getPlayerFormat()));
					gamePlayer.sendActionbar(messages.getString("voting.actionbar")
                        .replace("%playerplot%", votingPlot.getPlayerFormat()));
				}

                int blockIndex = ThreadLocalRandom.current().nextInt(votingPlot.getBoundary().getAllBlocks().size());

                player.teleport(Objects.requireNonNullElseGet(safeLocation, () ->
                    boundary.getAllBlocks().get(blockIndex).getLocation()));

				//give blocks
				player.getInventory().clear();
				
				if (gamePlayer.getGamePlayerType() == GamePlayerType.PLAYER) {
                    config.getConfigurationSection("voting.items").getKeys(false).forEach(identifier -> {
                        boolean save = false;

                        if (!messages.contains("voting.items." + identifier + ".name")) {
                            messages.set("voting.items." + identifier + ".name", "Type: Null");
                            save = true;
                        }

                        if (!messages.contains("voting.items." + identifier + ".lore")) {
                            messages.set("voting.items." + identifier + ".lore", new ArrayList<String>(0));
                            save = true;
                        }

                        if (save)
                            instance.save();

                        Material material = SettingsManager.getInstance().getMaterial(
                            "voting.items." + identifier + ".id", Material.BARRIER
                        );

                        player.getInventory().setItem(
                            config.getInt("voting.items." + identifier + ".slot") - 1,
                            new ItemBuilder(player, material)
                                .setDisplayName(MessageManager.translate(
                                    messages.getString("voting.items." + identifier + ".name")
                                ))
                                .setLore(MessageManager.translate(
                                    messages.getStringList("voting.items." + identifier + ".lore")
                                ))
                                .movable(false)
                                .setClickEvent(event -> {
                                    int points = config.getInt("voting.items." + identifier + ".points");

                                    votingPlot.addVote(new Vote(points, player));
                                    event.setCancelled(true);
                                }).build()
                        );
                    });

                    boolean worldEditEnabled = Bukkit.getPluginManager().isPluginEnabled("WorldEdit");

                    if (worldEditEnabled && config.getBoolean("reports.enable")) {
                        player.getInventory().setItem(8, new ItemBuilder(player, Material.BOOK)
                            .setDisplayName(ChatColor.RED + "Report build")
                            .movable(false)
                            .setClickEvent(event -> {
                                var dateTimeFormatter = DateTimeFormatter.ofPattern("yyy-MM-dd_HH-mm-ss");
                                String players = getVotingPlot().getGamePlayers().stream()
                                    .map(gp -> '-' + gp.getPlayer().getName())
                                    .reduce("", String::concat);
                                var fileName = LocalDateTime.now().format(dateTimeFormatter) + players + ".schem";
                                var file = new File(instance.getReportsSchematicsFolder(), fileName);

                                getVotingPlot().getBoundary().saveSchematic(file, () ->
                                    MessageManager.getInstance().send(event.getPlayer(),
                                        ChatColor.GREEN + "Your report has been saved."));

                                getVotingPlot().getGamePlayers().forEach(gp ->
                                    Report.add(new Report(gp.getPlayer(), player, ZonedDateTime.now(), file)));
                            }).build());
                    }
                }

				//update scoreboard and update time and weather
				if (config.getBoolean("scoreboards.vote.enable"))
					getVoteScoreboard(plot).show(player);
				
				player.setPlayerTime(plot.getTime(), false);
				player.setPlayerWeather(plot.isRaining() ? WeatherType.DOWNFALL : WeatherType.CLEAR);
			}
		}
		
		getVotedPlots().add(votingPlot);
	}

    /**
     * This will give the subject menu item to the specified player.
     *
     * @param player the player who should receive the subject menu item
     * @since 6.4.0
     */
	private void giveSubjectMenuItem(@NotNull Player player) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        Material material = SettingsManager.getInstance().getMaterial("subject-gui.item.id", Material.BARRIER);

        player.getInventory().setItem(
            config.getInt("subject-gui.slot"),
            new ItemBuilder(player, material)
                .setDisplayName(MessageManager.translate(messages.getString("subject-gui.item.name"),
                    player))
                .setLore(MessageManager.translate(messages.getStringList("subject-gui.item.lores"),
                    player))
                .setClickEvent(event -> {
                    getSubjectMenu().show(player);
                    event.setCancelled(true);
                }).build()
        );
    }

	/**
     * Sets the lobby timer
     *
     * @param lobbyTimer the new lobby timer
     * @see LobbyTimer
     * @since 2.1.0
     */
	public void setLobbyTimer(LobbyTimer lobbyTimer) {
		this.lobbyTimer = lobbyTimer;
	}

	/**
     * Sets the win timer
     *
     * @param winTimer the new win timer
     * @see WinTimer
     * @since 2.1.0
     */
	public void setWinTimer(WinTimer winTimer) {
		this.winTimer = winTimer;
	}

    /**
     * This is called before starting the game as to allow the players to vote on a subject if the subject choosing
     * should be done at {@link When#BEFORE_BUILD}. This will automatically progress the game when needed. When starting
     * the game this should be called rather than {@link #postStart()}.
     *
     * @since 6.4.0
     */
	public void preStart() {
        if (getSubjectMenu().getWhen() == SubjectMenu.When.BEFORE_BUILD) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    postStart();
                }
            }.runTaskLater(Main.getInstance(), 200L);

            getUsedPlots().forEach(plot -> plot.getGamePlayers().forEach(gamePlayer -> {
                var player = gamePlayer.getPlayer();

                plot.getLocation().teleport(player);

                giveSubjectMenuItem(player);

                if (getSubjectMenu().opensInstantly()) {
                    getSubjectMenu().show(player);
                }
            }));

            return;
        }

        postStart();
    }

	/**
     * Starts a new match. An ArenaStartEvent will be fired once this method is called.
     *
     * @since 2.1.0
     */
	private void postStart() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();

		//call event
		ArenaStartEvent event = new ArenaStartEvent(this);
		Bukkit.getPluginManager().callEvent(event);
		if (event.isCancelled())
			return;
		
		subject = getSubjectMenu().getHighestVote();
		
		//update bossbar
		getBossBar().setTitle(MessageManager.translate(messages.getString("global.bossbar-header")
				.replace("%subject%", getSubject())));
		
		getUsedPlots().forEach(plot ->
			plot.getGamePlayers().forEach(gamePlayer -> {
                plot.getLocation().teleport(gamePlayer.getPlayer());
				
				MessageManager.getInstance().send(gamePlayer.getPlayer(), messages
                        .getStringList("gameStarts.message"));

                messages.getStringList("gameStarts.subject").forEach(message ->
                    MessageManager.getInstance().send(gamePlayer.getPlayer(), message
                        .replace("%subject%", getSubject())));
				
				gamePlayer.addTitleAndSubtitle(messages.getString("gameStarts.title")
						.replace("%subject%", getSubject()), messages.getString("gameStarts.subtitle")
						.replace("%subject%", getSubject()));
				gamePlayer.sendActionbar(messages.getString("gameStarts.actionbar")
                    .replace("%subject%", subject));
				
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
				
				//bossbar
				getBossBar().setVisible(true);

                tryGiveOptionsMenu(player);
			})
		);
		
		setState(GameState.BUILDING);
		
		//save blocks
		getPlots().forEach(Plot::save);

        matches++;

		SignManager.getInstance().updateJoinSigns(this);

		buildTimer.runTaskTimer(Main.getInstance(), 20L, 20L);
	}

	/**
     * Moves on to the next match or stops the game if all matches have been played. This won't cancel any timers, and
     * if called incorrectly this will mess with the arena resulting in incorrect behaviour.
     *
     * @since 4.0.6
     */
	public void nextMatch() {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

        setState(GameState.WAITING);
        this.lobbyTimer = new LobbyTimer(arenas.getInt(name + ".lobby-timer"), this);
        this.buildTimer = new BuildTimer(arenas.getInt(name + ".timer"), this);
        this.voteTimer = new VoteTimer(arenas.getInt(name + ".vote-timer"), this);
        this.winTimer = new WinTimer(arenas.getInt(name + ".win-timer"), this);
        voteScoreboards.replaceAll((plot, voteScoreboard) -> new VoteScoreboard(this));
        subject = null;

        setFirstPlot(null);
        setSecondPlot(null);
        setThirdPlot(null);

        getVotedPlots().clear();

        getUsedPlots().forEach(plot -> {
            plot.getTimesVoted().clear();
            plot.getVotes().clear();

            plot.getAllGamePlayers().forEach(gamePlayer -> {
                var player = gamePlayer.getPlayer();

                player.setPlayerTime(player.getWorld().getFullTime(), true);
                player.resetPlayerWeather();
            });
        });

        getPlots().forEach(plot -> {
            plot.restore();

            var entities = plot.getEntities();

            entities.keySet().forEach(Entity::remove);
            entities.clear();
        });

        subjectMenu = new SubjectMenu();
        SignManager.getInstance().updateJoinSigns(this);

        if (matches == maxMatches)
            stop();
        else
            postStart();
    }

    /**
     * Stops the arena and resets it so it's open for new players. If you want to stop the arena while it's still
     * running use {@link #forceStop()}.
     *
     * @since 2.1.0
     */
	public void stop() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		//call event
		ArenaStopEvent event = new ArenaStopEvent(this);
		Bukkit.getPluginManager().callEvent(event);
		if (event.isCancelled())
			return;

        getUsedPlots().stream().flatMap(plot -> plot.getAllGamePlayers().stream()).forEach(gamePlayer ->
            gamePlayer.connect(
                MainSpawnManager.getInstance().getServer(),
                MainSpawnManager.getInstance().getMainSpawn()
            )
        );

		//update bossbar
		getBossBar().setTitle(MessageManager.translate(messages.getString("global.bossbar-header")
				.replace("%subject%", "?")));
		getBossBar().setVisible(false);

		getBossBar().getPlayers().forEach(player -> getBossBar().removePlayer(player));

        getUsedPlots().stream().flatMap(plot -> plot.getAllGamePlayers().stream()).forEach(gamePlayer -> {
            Player player = gamePlayer.getPlayer();

            gamePlayer.restore();
            player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

            //show all players again
            if (config.getBoolean("tab-list.adjust"))
                Bukkit.getOnlinePlayers().forEach(pl -> player.showPlayer(Main.getInstance(), pl));

            //reset scoreboard
            getUsedPlots().stream()
                .flatMap(p -> p.getGamePlayers().stream())
                .forEach(gp -> gp.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard()));
        });

		getPlots().forEach(plot -> plot.getAllGamePlayers().clear());

		this.matches = 0;

		SignManager.getInstance().updateJoinSigns(this);
	}

    /**
     * Checks if this arena can be joined at this moment
     *
     * @return true if this arena can be joined, false otherwise
     * @since 9.0.1
     */
	@Contract(pure = true)
	public boolean canJoin() {
	    YamlConfiguration config = SettingsManager.getInstance().getConfig();
        boolean joinInGame = config.getBoolean("join-during-game");

        return ((getState() == GameState.STARTING || getState() == GameState.WAITING || getState() == GameState.BUILDING) &&
            (joinInGame || getState() != GameState.BUILDING) && !isFull());
    }

    /**
     * {@inheritDoc}
     */
	@Override
    public boolean equals(Object obj) {
        return obj instanceof Arena && ((Arena) obj).getName().equals(name);
    }

    /**
     * Removes a registered plot
     *
     * @param plot the plot to remove
     * @since 7.0.0
     */
    public void removePlot(@NotNull Plot plot) {
	    plots.remove(plot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
	    return name.hashCode();
    }
}