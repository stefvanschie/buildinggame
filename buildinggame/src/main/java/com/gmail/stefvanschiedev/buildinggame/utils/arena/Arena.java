package com.gmail.stefvanschiedev.buildinggame.utils.arena;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.gmail.stefvanschiedev.buildinggame.utils.*;
import com.gmail.stefvanschiedev.buildinggame.utils.scoreboards.*;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Sign;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaJoinEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaLeaveEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaStartEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaStopEvent;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.id.IDDecompiler;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.scoreboards.MainScoreboardManager;
import com.gmail.stefvanschiedev.buildinggame.timers.BuildTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.VoteTimer;
import com.gmail.stefvanschiedev.buildinggame.timers.WaitTimer;
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
	private final Collection<Sign> signs = new ArrayList<>();

	/**
     * The lobby of this arena
     */
	private Lobby lobby;

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
	private final ArenaScoreboard buildScoreboard = new BuildScoreboard(this);

	/**
     * The lobby scoreboard
     */
	private final ArenaScoreboard lobbyScoreboard = new LobbyScoreboard(this);

	/**
     * The vote scoreboard
     */
	private VoteScoreboard voteScoreboard = new VoteScoreboard(this);

	/**
     * The win scoreboard
     */
	private final ArenaScoreboard winScoreboard = new WinScoreboard(this);

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
     * The wait timer
     */
    private WaitTimer waitTimer;

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
	}

	/**
     * Add a join sign to the list
     *
     * @param sign the sign to add
     * @since 2.1.0
     */
	public void addSign(Sign sign) {
		getSigns().add(sign);
	}

	/**
     * Returns whether this arena has the specified player
     *
     * @param player the player to look for
     * @return true if the players is in this arena, false otherwise
     * @since 2.2.1
     */
	public boolean contains(Player player) {
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				if (gamePlayer.getPlayer().equals(player))
					return true;
			}
		}

		return false;
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
		if (waitTimer.isActive())
			return waitTimer;

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
     * Returns the build scoreboard
     *
     * @return the build scoreboard
     * @see BuildScoreboard
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public ArenaScoreboard getBuildScoreboard() {
		return buildScoreboard;
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
     * @see Lobby
     * @since 5.5.3
     */
	@Nullable
	@Contract(pure = true)
	public Lobby getLobby() {
	    return lobby;
    }

	/**
     * Returns the lobby scoreboard or null if it doesn't exist
     *
     * @return the lobby scoreboard
     * @see LobbyScoreboard
     * @since 2.3.0
     */
	@Nullable
    @Contract(pure = true)
	public ArenaScoreboard getLobbyScoreboard() {
		return lobbyScoreboard;
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
		int players = 0;
		
		for (Plot plot : getUsedPlots())
			players += plot.getGamePlayers().size();
		
		return players;
	}

	/**
     * Returns the plot by the given ID or null if such a plot doesn;t exist
     *
     * @param ID the ID to look for
     * @return the plot with the given ID
     * @see Plot
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public Plot getPlot(int ID) {
		for (Plot plot : plots) {
			if (plot.getID() == ID)
				return plot;
		}

		return null;
	}

	/**
     * Returns the plot which contains the given player or null if such a plot doesn;t exist
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
	public Collection<Sign> getSigns() {
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
     * Returns the team selection and creates one if it doesn't exist yet
     *
     * @return the team selection
     * @see TeamSelection
     * @since 2.1.0
     */
	@NotNull
	private TeamSelection getTeamSelection() {
		if (teamSelection == null)
			this.teamSelection = new TeamSelection(this);
		
		return teamSelection;
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
		Collection<Plot> usedPlots = new ArrayList<>();
		
		for (Plot plot : getPlots()) {
			if (!plot.getGamePlayers().isEmpty())
				usedPlots.add(plot);
		}
		
		return usedPlots;
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
     * @return the vote scoreboard
     * @see VoteScoreboard
     * @since 2.3.0
     */
	@Nullable
    @Contract(pure = true)
	public VoteScoreboard getVoteScoreboard() {
		return voteScoreboard;
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
     * Returns the wait (lobby) timer
     *
     * @return the wait timer
     * @see WaitTimer
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public WaitTimer getWaitTimer() {
		return waitTimer;
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
	public ArenaScoreboard getWinScoreboard() {
		return winScoreboard;
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

		for (Plot plot : getPlots()) {
			if (plot.getBoundary() == null || plot.getFloor() == null)
				return false;
		}

		return true;
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

			for (Plot plot : getPlots()) {
				if (plot.getBoundary() == null)
					MessageManager.getInstance().send(player, ChatColor.RED + " - The boundary of plot " +
                            plot.getID() + " (/bg setbounds " + getName() + ' ' + plot.getID() + ')');
			}

			for (Plot plot : getPlots()) {
				if (plot.getFloor() == null)
					MessageManager.getInstance().send(player, ChatColor.RED + " - The floor of plot " +
                            plot.getID() + " (/bg setfloor " + getName() + ' ' + plot.getID() + ')');
			}

			return;
		}
		
		if (ArenaManager.getInstance().getArena(player) != null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You're already in a game");
			return;
		}
		
		if (getState() != GameState.STARTING && getState() != GameState.WAITING) {
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
		
		for (Plot plot : getPlots()) {
			if (!plot.isFull()) {
				plot.join(p);
				break;
			}
		}
		
		if (config.getBoolean("scoreboards.main.enable"))
			MainScoreboardManager.getInstance().remove(player);
		
		if (config.getBoolean("scoreboards.lobby.enable"))
			lobbyScoreboard.show(player);
		
		for (String message : messages.getStringList("join.message"))
			MessageManager.getInstance().send(player, message
					.replace("%players%", getPlayers() + "")
					.replace("%max_players%", getMaxPlayers() + ""));
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				Player pl = gamePlayer.getPlayer();
				
				for (String message : messages.getStringList("join.otherPlayers"))
					MessageManager.getInstance().send(pl, message
                            .replace("%player%", player.getName())
							.replace("%players%", getPlayers() + "")
							.replace("%max_players%", getMaxPlayers() + ""));
			}
		}
		
		
		if (lobby != null)
			player.teleport(lobby.getLocation());
		
		if (config.getBoolean("scoreboards.lobby.enable")) {
			for (Plot plot : getUsedPlots()) {
				for (GamePlayer gamePlayer : plot.getGamePlayers())
					lobbyScoreboard.show(gamePlayer.getPlayer());
			}
		}
		
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);
		//fill lives and hunger
		player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
		player.setFoodLevel(20);
		//gamemode
		player.setGameMode(GameMode.ADVENTURE);
		//time
		if (config.getBoolean("join.time-change.change"))
			player.setPlayerTime(config.getInt("join.time-change.time"), false);
		
		//bossbar
		getBossBar().addPlayer(player);
		
		//hide players from tab list
		if (config.getBoolean("tab-list.adjust")) {
			for (Player pl : Bukkit.getOnlinePlayers()) {
				if (!contains(pl))
					player.hidePlayer(Main.getInstance(), pl);
			}
		}
		//show current joined player to others
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers())
				gamePlayer.getPlayer().showPlayer(Main.getInstance(), player);
		}
		
		if (getPlayers() >= minPlayers && !waitTimer.isActive())
			waitTimer.runTaskTimer(Main.getInstance(), 0L, 20L);
		
		if (getPlayers() >= getMaxPlayers())
			waitTimer.setSeconds(0);
		
		//bukkit runnable because of instant leaving and instant subject opening
		BukkitRunnable runnable = new BukkitRunnable () {
			@Override
			public void run() {
				//give team selection
				if (getMode() == ArenaMode.TEAM) {
                    ItemBuilder itemBuilder = IDDecompiler.getInstance().decompile(player, config
                            .getString("team-selection.item.id")).setDisplayName(MessageManager
                            .translate(messages.getString("team-gui.item.name"), player)).setLore(MessageManager
                            .translate(messages.getStringList("team-gui.item.lores"), player)).setClickEvent(event -> {
                        getTeamSelection().open(player);
                        return true;
                    });
                    ItemBuilder.register(itemBuilder);
                    player.getInventory().setItem(0, itemBuilder);
                }
				
				//give paper for subject
				if (player.hasPermission("bg.subjectmenu") && config.getBoolean("enable-subject-voting")) {
                    ItemBuilder itemBuilder = IDDecompiler.getInstance().decompile(player, config
                            .getString("subject-gui.item.id")).setDisplayName(MessageManager.translate(messages
                            .getString("subject-gui.item.name"), player)).setLore(MessageManager
                            .translate(messages.getStringList("subject-gui.item.lores"), player))
                            .setClickEvent(event -> {
                        getSubjectMenu().open(player);
                        return false;
                    });
                    ItemBuilder.register(itemBuilder);
                    player.getInventory().setItem(config.getInt("subject-gui.slot"), itemBuilder);
                }

                ItemBuilder itemBuilder = IDDecompiler.getInstance().decompile(player, config
                        .getString("leave-item.id")).setDisplayName(MessageManager.translate(messages
                        .getString("leave-item.name"), player)).setClickEvent(event -> {
                    leave(player);
                    return true;
                });
				ItemBuilder.register(itemBuilder);
                player.getInventory().setItem(config.getInt("leave-item.slot"), itemBuilder);
                player.updateInventory();
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

        Plot plot = getPlot(player);

        //this shouldn't happen unless you screwed up with the api
        if (plot == null) {
            MessageManager.getInstance().send(player, "You're not in a game");
            ArenaManager.getInstance().getArena(player).leave(player);
            return;
        }

		GamePlayer p = plot.getGamePlayer(player);
		p.restore();
		
		ItemBuilder.check(player);
		
		if (MainSpawnManager.getInstance().getMainSpawn() != null)
			p.connect(MainSpawnManager.getInstance().getServer(), MainSpawnManager.getInstance().getMainSpawn());
		
		if (config.getBoolean("scoreboards.main.enable"))
			MainScoreboardManager.getInstance().register(player);
		
		player.resetPlayerTime();
		player.resetPlayerWeather();
		
		//show all players again
		for (Player pl : Bukkit.getOnlinePlayers())
			player.showPlayer(Main.getInstance(), pl);
		
		for (Plot usedPlot : getUsedPlots()) {
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
		}
		
		for (Plot usedPlot : getUsedPlots()) {
			for (GamePlayer gamePlayer : usedPlot.getGamePlayers()) {
				Player pl = gamePlayer.getPlayer();

				if (state == GameState.WAITING) {
                    for (String message : messages.getStringList("leave.other-players.lobby"))
                        MessageManager.getInstance().send(pl, message
                            .replace("%player%", player.getName()));
                } else {
                    for (String message : messages.getStringList("leave.other-players.in-game"))
                        MessageManager.getInstance().send(pl, message
                            .replace("%player%", player.getName()));
                }
				
				if (config.getBoolean("scoreboards.lobby.enable"))
					lobbyScoreboard.show(pl);
			}
		}
		
		if (getPlayers() <= 1) {
			if (getWaitTimer().isActive()) {
				waitTimer.cancel();
				setWaitTimer(new WaitTimer(arenas.getInt(name + ".lobby-timer"), this));
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
     * @see Lobby
     * @since 2.1.0
     */
	public void setLobby(Lobby lobby) {
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
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
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
					for (String message : messages.getStringList("voting.message"))
						MessageManager.getInstance().send(player, message
								.replace("%playerplot%", votingPlot.getPlayerFormat()));

					gamePlayer.addTitleAndSubtitle(messages.getString("voting.title")
							.replace("%playerplot%", votingPlot.getPlayerFormat()),
                            messages.getString("voting.subtitle")
							.replace("%playerplot%", votingPlot.getPlayerFormat()));
				}

				if (safeLocation == null)
                    player.teleport(boundary.getAllBlocks().get(ThreadLocalRandom.current().nextInt(votingPlot
                            .getBoundary().getAllBlocks().size())).getLocation());
				else
				    player.teleport(safeLocation);

				//give blocks
				player.getInventory().clear();
				
				ItemBuilder.check(player);
				
				if (gamePlayer.getGamePlayerType() == GamePlayerType.PLAYER)
					new VoteBlocks().give(player);
				
				//update scoreboard and update time and weather
				if (config.getBoolean("scoreboards.vote.enable"))
					getVoteScoreboard().show(player);
				
				player.setPlayerTime(plot.getTime().decode(), false);
				player.setPlayerWeather(plot.isRaining() ? WeatherType.DOWNFALL : WeatherType.CLEAR);
			}
		}
		
		getVotedPlots().add(votingPlot);
	}

	/**
     * Sets the wait (lobby) timer
     *
     * @param waitTimer the new wait (lobby) timer
     * @see WaitTimer
     * @since 2.1.0
     */
	public void setWaitTimer(WaitTimer waitTimer) {
		this.waitTimer = waitTimer;
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
     * Starts a new match. An ArenaStartEvent will be fired once this method is called.
     *
     * @since 2.1.0
     */
	public void start() {
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
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getGamePlayers()) {
				gamePlayer.getPlayer().teleport(plot.getLocation());
				
				MessageManager.getInstance().send(gamePlayer.getPlayer(), messages
                        .getStringList("gameStarts.message"));
				for (String message : messages.getStringList("gameStarts.subject"))
					MessageManager.getInstance().send(gamePlayer.getPlayer(), message
							.replace("%subject%", getSubject()));
				
				gamePlayer.addTitleAndSubtitle(messages.getString("gameStarts.title")
						.replace("%subject%", getSubject()), messages.getString("gameStarts.subtitle")
						.replace("%subject%", getSubject()));
				
				final Player player = gamePlayer.getPlayer();
				player.getInventory().clear();
				player.setGameMode(GameMode.CREATIVE);
				player.setPlayerTime(plot.getTime().decode(), false);
				
				ItemBuilder.check(player);
				
				//hotbar
				for (int i = 0; i < 9; i++)
					player.getInventory().setItem(i, IDDecompiler.getInstance().decompile(config
                            .getString("hotbar.default.slot-" + (i + 1))));
				
				//bossbar
				getBossBar().setVisible(true);

				if (config.getBoolean("gui.enable")) {
                    ItemBuilder itemBuilder = new ItemBuilder(player, Material.EMERALD).setDisplayName(MessageManager
                            .translate(messages.getString("gui.options-emerald"), player)).setLore(MessageManager
                            .translate(messages.getStringList("gui.options-lores"), player)).moveable(false)
                            .setClickEvent(e -> {
                        getPlot(player).getBuildMenu().open(player);
                        return true;
                    });
                    ItemBuilder.register(itemBuilder);
                    player.getInventory().setItem(config.getInt("gui.slot"), itemBuilder);
                }
			}
		}
		
		setState(GameState.BUILDING);
		
		//save blocks
		for (Plot plot : getPlots())
			plot.save();

        matches++;

		SignManager.getInstance().updateJoinSigns(this);

		buildTimer.runTaskTimer(Main.getInstance(), 20L, 20L);
	}

	/**
     * Moves on to the next match or stops the game if all matches have been played. This won't cancel any timers, and
     * if called incorrectly this will mess with the arena resulting in incorrect behviour.
     *
     * @since 4.0.6
     */
	public void nextMatch() {
        YamlConfiguration arenas = SettingsManager.getInstance().getArenas();

        setState(GameState.WAITING);
        this.waitTimer = new WaitTimer(arenas.getInt(name + ".lobby-timer"), this);
        this.buildTimer = new BuildTimer(arenas.getInt(name + ".timer"), this);
        this.voteTimer = new VoteTimer(arenas.getInt(name + ".vote-timer"), this);
        this.winTimer = new WinTimer(arenas.getInt(name + ".win-timer"), this);
        this.voteScoreboard = new VoteScoreboard(this);
        subject = null;

        setFirstPlot(null);
        setSecondPlot(null);
        setThirdPlot(null);

        getVotedPlots().clear();

        for (Plot plot : getUsedPlots()) {
            plot.getTimesVoted().clear();
            plot.getVotes().clear();

            for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
                Player player = gamePlayer.getPlayer();

                player.setPlayerTime(player.getWorld().getFullTime(), true);
                player.resetPlayerWeather();
            }
        }

        for (Plot plot : getPlots()) {
            plot.restore();

            for (Entity entity : plot.getEntities().keySet())
                entity.remove();

            plot.getEntities().clear();
        }

        subjectMenu = new SubjectMenu();
        SignManager.getInstance().updateJoinSigns(this);

        if (matches == maxMatches)
            stop();
        else
            start();
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
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getAllGamePlayers())
				gamePlayer.connect(MainSpawnManager.getInstance().getServer(), MainSpawnManager.getInstance().getMainSpawn());
		}

		//update bossbar
		getBossBar().setTitle(MessageManager.translate(messages.getString("global.bossbar-header")
				.replace("%subject%", "?")));
		getBossBar().setVisible(false);

		for (Player player : getBossBar().getPlayers())
			getBossBar().removePlayer(player);
		
		for (Plot plot : getUsedPlots()) {
			for (GamePlayer gamePlayer : plot.getAllGamePlayers()) {
				Player player = gamePlayer.getPlayer();
				
				gamePlayer.restore();
				player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
				
				//show all players again
				if (config.getBoolean("tab-list.adjust")) {
					for (Player pl : Bukkit.getOnlinePlayers())
						player.showPlayer(Main.getInstance(), pl);
				}
			}
		}
		
		for (Plot plot : getPlots())
			plot.getAllGamePlayers().clear();

		this.matches = 0;

		SignManager.getInstance().updateJoinSigns(this);
	}

    /**
     * {@inheritDoc}
     */
	@Override
    public boolean equals(Object obj) {
        return obj instanceof Arena && ((Arena) obj).getName().equals(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
	    return name.hashCode();
    }
}