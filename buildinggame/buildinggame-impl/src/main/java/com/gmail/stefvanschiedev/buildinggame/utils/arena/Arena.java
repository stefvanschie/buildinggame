package com.gmail.stefvanschiedev.buildinggame.utils.arena;

import java.util.*;
import java.util.stream.Collectors;

import com.gmail.stefvanschiedev.buildinggame.game.LobbyGamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.util.GamePhase;
import com.gmail.stefvanschiedev.buildinggame.game.util.JoinObserver;
import com.gmail.stefvanschiedev.buildinggame.game.util.LeaveObserver;
import com.gmail.stefvanschiedev.buildinggame.game.util.TransitionSystem;
import com.gmail.stefvanschiedev.buildinggame.game.util.timed.TimedGamePhase;
import com.gmail.stefvanschiedev.buildinggame.utils.*;
import com.gmail.stefvanschiedev.buildinggame.utils.item.ClickEvent;
import com.gmail.stefvanschiedev.buildinggame.utils.item.ItemBuilder;
import com.gmail.stefvanschiedev.buildinggame.utils.item.datatype.ArenaDataType;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialBlockPosition;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialLocation;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaJoinEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaLeaveEvent;
import com.gmail.stefvanschiedev.buildinggame.api.events.ArenaStopEvent;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.scoreboards.MainScoreboardManager;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents an arena
 *
 * @since 2.1.0
 */
public class Arena implements TransitionSystem {

    /**
     * Whether this arena is in solo or team mode
     */
	private ArenaMode mode = ArenaMode.SOLO;

	/**
     * A list of all plots
     */
	private final List<Plot> plots = new ArrayList<>();

	/**
     * A list of all join signs belonging to this arena
     */
	private final Map<ChunkCoordinates, Collection<PotentialBlockPosition>> signs = new HashMap<>();

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
	private int maxPlayers;

	/**
     * The minimum amount of players
     */
	private int minPlayers;

	/**
     * The amount of matches which have been or are being played
     */
	private int matches;

	/**
     * The maximum amount of matches
     */
	private int maxMatches = 1;

    /**
     * Whether money is enabled or not
     */
    private boolean moneyEnabled;

    /**
     * The current game phase.
     */
    @NotNull
    private GamePhase currentGamePhase;

    /**
     * Constructs a new arena with the given name as identifier
     *
     * @param name the name of the arena
     */
	public Arena(String name) {
		this.name = name;

        this.currentGamePhase = new LobbyGamePhase(this);
        this.currentGamePhase.onPhaseStart();
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
     * Returns a collection of join signs belonging to this arena
     *
     * @return a collection of signs
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public Collection<PotentialBlockPosition> getSigns() {
        Collection<PotentialBlockPosition> allPositions = new HashSet<>();

        for (Collection<PotentialBlockPosition> positions : signs.values()) {
            allPositions.addAll(positions);
        }

		return allPositions;
	}

	/**
     * Returns the current phase of this arena
     *
     * @return the current game phase
     * @since 12.2.0
     */
	@NotNull
    @Contract(pure = true)
	public GamePhase getCurrentPhase() {
		return this.currentGamePhase;
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

		for (Plot plot : getPlots()) {
			if (!plot.isFull()) {
				plot.join(p);
				break;
			}
		}
		
		if (config.getBoolean("scoreboards.main.enable"))
			MainScoreboardManager.getInstance().remove(player);

        messages.getStringList("join.message").forEach(message ->
            MessageManager.getInstance().send(player, message
                .replace("%players%", String.valueOf(getPlayers()))
                .replace("%max_players%", String.valueOf(getMaxPlayers()))));

        String name = player.getName();

        getUsedPlots().stream().flatMap(pl -> pl.getGamePlayers().stream()).forEach(gamePlayer -> {
            Player pla = gamePlayer.getPlayer();

            messages.getStringList("join.otherPlayers").forEach(message ->
                MessageManager.getInstance().send(pla, message
                    .replace("%player%", name)
                    .replace("%players%", String.valueOf(getPlayers()))
                    .replace("%max_players%", String.valueOf(getMaxPlayers()))));
        });
		
		if (this.currentGamePhase instanceof LobbyGamePhase) {
            if (this.lobby == null) {
                throw new IllegalStateException("Lobby is not set");
            }

            this.lobby.teleport(player);
        }
		
		player.getInventory().clear();
		player.getInventory().setArmorContents(null);

        //noinspection deprecation
        AttributeInstance healthAttribute = player.getAttribute(Attribute.valueOf("GENERIC_MAX_HEALTH"));

        if (healthAttribute != null) {
            player.setHealth(healthAttribute.getValue());
        }

		player.setFoodLevel(20);

        if (this.currentGamePhase instanceof LobbyGamePhase) {
            player.setGameMode(GameMode.ADVENTURE);
        } else {
            player.setGameMode(GameMode.CREATIVE);
        }

		//time
		if (config.getBoolean("join.time-change.change"))
			player.setPlayerTime(config.getInt("join.time-change.time"), false);
		
		//hide players from tab list
		if (config.getBoolean("tab-list.adjust"))
            Bukkit.getOnlinePlayers().stream().filter(pl -> !contains(pl)).forEach(pl ->
                player.hidePlayer(Main.getInstance(), pl));

		//show current joined player to others
        getUsedPlots().stream().flatMap(pl -> pl.getGamePlayers().stream()).forEach(gamePlayer ->
            gamePlayer.getPlayer().showPlayer(Main.getInstance(), player));
		
		if (getPlayers() >= minPlayers && this.currentGamePhase instanceof TimedGamePhase<?>) {
            ((TimedGamePhase<?>) this.currentGamePhase).startTimer();
        }
		
		if (getPlayers() >= getMaxPlayers() && this.currentGamePhase instanceof TimedGamePhase<?>) {
            ((TimedGamePhase<?>) this.currentGamePhase).endTimer();
        }

		//bukkit runnable because of instant leaving and instant subject opening
		var runnable = new BukkitRunnable () {
			@Override
			public void run() {
				//give team selection
                if (Arena.this.currentGamePhase instanceof LobbyGamePhase) {
                    if (getMode() == ArenaMode.TEAM) {
                        Material material = SettingsManager.getInstance().getMaterial("team-selection.item.id",
                            Material.BARRIER);

                        player.getInventory().setItem(4, new ItemBuilder(player, material)
                            .setDisplayName(
                                MessageManager.translate(messages.getString("team-gui.item.name"), player)
                            ).setLore(
                                MessageManager.translate(messages.getStringList("team-gui.item.lores"), player)
                            )
                            .addContext("arena", ArenaDataType.getInstance(), Arena.this)
                            .setClickEvent(ClickEvent.TEAM_GUI_CLICK)
                            .build()
                        );
                    }

                    int slot = config.getInt("leave-item.slot");
                    ItemStack item = player.getInventory().getItem(slot);

                    if (item != null && item.getType() != Material.AIR) {
                        Main.getInstance().getLogger().warning(
                            "The leave item overrides a different item. This other item will not be visible. " +
                                "Please change the slots in the config.yml file to fix this."
                        );
                    }

                    Material material = SettingsManager.getInstance().getMaterial("leave-item.id",
                        Material.BARRIER);

                    player.getInventory().setItem(slot,
                        new ItemBuilder(player, material)
                            .setDisplayName(MessageManager.translate(messages.getString("leave-item.name"), player))
                            .addContext("arena", ArenaDataType.getInstance(), Arena.this)
                            .setClickEvent(ClickEvent.PLAYER_LEAVE_CLICK)
                            .build()
                    );
                    player.updateInventory();
                }
			}
		};

		runnable.runTaskLater(Main.getInstance(), 1L);
		
		SignManager.getInstance().updateJoinSigns(this);

        if (this.currentGamePhase instanceof JoinObserver) {
            ((JoinObserver) this.currentGamePhase).onJoin(p);
        }
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
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        Arena arena = ArenaManager.getInstance().getArena(player);

        if (arena == null) {
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
            arena.leave(player);
            return;
        }

		GamePlayer p = plot.getGamePlayer(player);

        if (p == null) {
            throw new IllegalStateException("Plot is missing game player");
        }

		p.restore();

		if (MainSpawnManager.getInstance().getMainSpawn() != null)
			p.connect(MainSpawnManager.getInstance().getServer(), MainSpawnManager.getInstance().getMainSpawn());
		
		if (config.getBoolean("scoreboards.main.enable"))
			MainScoreboardManager.getInstance().register(player);
		
		player.resetPlayerTime();
		player.resetPlayerWeather();
		
		//show all players again
		Bukkit.getOnlinePlayers().forEach(pl -> player.showPlayer(Main.getInstance(), pl));

        getPlots().forEach(pl -> {
            pl.getLobbyScoreboard().getRedTeam().removeEntry(player.getName());
            pl.getBuildScoreboard().getRedTeam().removeEntry(player.getName());
            pl.getVoteScoreboard().getRedTeam().removeEntry(player.getName());
            pl.getWinScoreboard().getRedTeam().removeEntry(player.getName());
        });

		getUsedPlots().forEach(usedPlot -> {
			for (GamePlayer gamePlayer : usedPlot.getGamePlayers()) {
				Player pl = gamePlayer.getPlayer();
				if (pl.equals(player)) {
					usedPlot.leave(gamePlayer);

					if (this.currentGamePhase instanceof LobbyGamePhase) {
                        MessageManager.getInstance().send(player, messages.getStringList("leave.message.lobby"));
                    } else {
                        MessageManager.getInstance().send(player, messages.getStringList("leave.message.in-game"));
                    }

					break;
				}
			}
		});
		
		getUsedPlots().forEach(usedPlot ->
            usedPlot.getGamePlayers().forEach(gamePlayer -> {
                Player pl = gamePlayer.getPlayer();

                if (this.currentGamePhase instanceof LobbyGamePhase) {
                    messages.getStringList("leave.other-players.lobby").forEach(message ->
                        MessageManager.getInstance().send(pl, message
                            .replace("%player%", player.getName())));
                } else {
                    messages.getStringList("leave.other-players.in-game").forEach(message ->
                        MessageManager.getInstance().send(pl, message
                            .replace("%player%", player.getName())));
                }
            })
        );

        //cancel wait timer when user amount drops below minimum
        if (getPlayers() < minPlayers && this.currentGamePhase instanceof TimedGamePhase<?>) {
            ((TimedGamePhase<?>) this.currentGamePhase).resetTimer();
        }

		if (getPlayers() <= 0) {
            this.currentGamePhase.forceEnd();
		}
		
		SignManager.getInstance().updateJoinSigns(this);

        if (currentGamePhase instanceof LeaveObserver) {
            ((LeaveObserver) currentGamePhase).onLeave(player);
        }
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
     * Stops the arena and resets it so it's open for new players.
     *
     * @since 2.1.0
     */
	public void stop() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
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
        return this.currentGamePhase.canJoin() && !isFull();
    }

    /**
     * Adds the sign of the given position to this arena.
     *
     * @param position the position to add
     * @since 10.0.3
     */
    public void addSign(@NotNull PotentialBlockPosition position) {
        this.signs.putIfAbsent(position.getChunkCoordinates(), new HashSet<>());
        this.signs.get(position.getChunkCoordinates()).add(position);
    }

    @Override
    public void transition(@NotNull GamePhase gamePhase) {
        this.currentGamePhase = gamePhase;
        this.currentGamePhase.onPhaseStart();
    }

    /**
     * Gets a collection of signs in the given chunk. If no signs are in the given chunk, an empty collection is
     * returned. The returned collection si unmodifiable.
     *
     * @param chunkCoordinates the chunk coordinates of the signs to get
     * @return the signs in the given chunk
     * @since 10.0.3
     */
    @NotNull
    @Contract(pure = true)
    public Collection<? extends PotentialBlockPosition> getSigns(@NotNull ChunkCoordinates chunkCoordinates) {
        return Collections.unmodifiableCollection(this.signs.getOrDefault(chunkCoordinates, new HashSet<>()));
    }

    /**
     * Clears all the signs of this arena.
     *
     * @since 10.0.3
     */
    public void clearSigns() {
        this.signs.clear();
    }

    /**
     * Increases the amount of matches that have been played.
     *
     * @since 12.2.0
     */
    public void increaseMatches() {
        this.matches++;
    }

    /**
     * Gets the amount of matches that have currently been played.
     *
     * @return the amount of matches
     * @since 12.2.0
     */
    public int getMatches() {
        return matches;
    }

    /**
     * Gets the maximum amount of matches this arena will play.
     *
     * @return the maximum amount of matches
     * @since 12.2.0
     */
    public int getMaxMatches() {
        return maxMatches;
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