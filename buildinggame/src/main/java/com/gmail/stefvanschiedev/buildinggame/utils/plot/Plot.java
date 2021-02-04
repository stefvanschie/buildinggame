package com.gmail.stefvanschiedev.buildinggame.utils.plot;

import java.util.*;
import java.util.stream.Collectors;

import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.*;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialLocation;
import com.gmail.stefvanschiedev.buildinggame.utils.region.Region;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.mainspawn.MainSpawnManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.ArenaMode;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayer;
import com.gmail.stefvanschiedev.buildinggame.utils.gameplayer.GamePlayerType;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.BuildMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.spectatormenu.SpectatorMenu;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.Particle;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * A plot representing the building area for one team of players
 *
 * @since 2.1.0
 */
public class Plot {

    /**
     * The arena this plot belongs to
     */
	private final Arena arena;

	/**
     * Whether it's raining on the plot or not
     */
	private boolean raining;

	/**
     * The boundary for this plot
     */
	private Region boundary;

	/**
     * The floor for this plot
     */
	private Region floor;

	/**
     * The id assigned to this plot
     */
	private int id;

	/**
     * A list of all game players playing and spectating the game
     */
	private final List<GamePlayer> gamePlayers = new ArrayList<>();

	/**
     * A collection of the states of the blocks before the building phase started
     */
	private final Map<BlockState, Biome> blocks = new HashMap<>();

	/**
     * A map containing an entity and their previous stored location
     */
	private final Map<Entity, Location> entities;

	/**
     * A collection of all votes given for this plot
     */
	private final Collection<Vote> votes = new ArrayList<>();

	/**
     * A collection of particles placed on this plot
     */
	private final Collection<Particle> particles = new ArrayList<>();

	/**
     * The spawn location for this plot
     */
	@Nullable
	private PotentialLocation location;

	/**
     * The amount of times a player has voted for this plot
     */
	private final Map<Player, Integer> timesVoted = new HashMap<>();

	/**
     * The time its on the plot right now
     */
	private long time;

	/**
     * The build menu assigned to this plot
     */
	private final BuildMenu buildMenu;

	/**
     * Constructs a new Plot
     *
     * @param arena the arena this plot belongs to
     * @param id the id of this plot
     */
	public Plot(@NotNull Arena arena, int id) {
	    this.arena = arena;
		this.id = id;
		
		this.buildMenu = new BuildMenu(this);
		this.entities = new HashMap<>();
	}

	/**
     * Adds an entity to the plot and registers it
     *
     * @param entity the entity to be added
     * @return true if the entity was added successfully, false otherwise
     * @since 4.0.0
     */
	public boolean addEntity(Entity entity) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (arena.getState() == GameState.WAITING || arena.getState() == GameState.STARTING ||
                !config.getBoolean("mobs.allow") || config.getStringList("blocked-entities")
                .contains(entity.getType().toString().toLowerCase(Locale.getDefault())))
			return false;
		
		if (config.getBoolean("mobs.enable-noai") && entity instanceof LivingEntity)
            ((LivingEntity) entity).setAI(false);
		
		entities.put(entity, entity.getLocation());
		return true;
	}

	/**
     * Adds a particle to the plot by the specified command sender
     *
     * @param particle the particle to add
     * @param player the command sender that added the particle
     * @since 2.1.0
     */
	public void addParticle(Particle particle, CommandSender player) {
		if (getParticles().size() != SettingsManager.getInstance().getConfig().getInt("max-particles"))
			particles.add(particle);
		else
			MessageManager.getInstance().send(player, SettingsManager.getInstance().getMessages()
                    .getStringList("particle.max-particles"));
	}

	/**
     * Adds a spectator to the plot
     *
     * @param spectator the player that wants to spectate
     * @param spectates the player the spectator wants to spectate
     * @since 2.1.0
     */
	@Contract("null, _ -> fail; _, null -> fail")
	public void addSpectator(final Player spectator, GamePlayer spectates) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		final var gamePlayer = new GamePlayer(spectator, GamePlayerType.SPECTATOR);
		gamePlayer.setSpectates(spectates);
		
		getAllGamePlayers().add(gamePlayer);
		
		getAllGamePlayers().forEach(player -> player.getPlayer().hidePlayer(Main.getInstance(), spectator));

        Material material = SettingsManager.getInstance().getMaterial("leave-item.id", Material.BARRIER);

        spectator.getInventory().setItem(config.getInt("leave-item.slot"),
            new ItemBuilder(spectator, material)
                .setDisplayName(MessageManager.translate(SettingsManager.getInstance().getMessages()
                    .getString("leave-item.name"), spectator)).setClickEvent(event -> {
                        gamePlayer.connect(MainSpawnManager.getInstance().getServer(),
                            MainSpawnManager.getInstance().getMainSpawn());
                        removeSpectator(gamePlayer);
                        MessageManager.getInstance().send(spectator, ChatColor.GREEN + "Stopped spectating");
                        event.setCancelled(true);
                    }).build());

        spectator.getInventory().setItem(8, new ItemBuilder(spectator, Material.EMERALD)
            .setDisplayName(ChatColor.GREEN + "Spectator menu").setClickEvent(event -> {
                new SpectatorMenu().show(spectator);
                event.setCancelled(true);
            }).build());
		
		spectator.teleport(spectates.getPlayer().getLocation());
		spectator.setGameMode(GameMode.CREATIVE);
		spectator.setCanPickupItems(false);
	}

	/**
     * Adds a vote to this plot
     *
     * @param vote the vote to be added
     * @since 2.1.0
     */
	@Contract("null -> fail")
	public void addVote(Vote vote) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();

		if (arena.getState() != GameState.VOTING)
			return;

        Player sender = vote.getSender();

        //check if player votes on his/her own plot
		for (GamePlayer gamePlayer : getGamePlayers()) {
            if (gamePlayer.getPlayer().equals(sender)) {
                MessageManager.getInstance().send(sender, messages.getStringList("vote.own-plot"));
                return;
            }
		}

		//check how many times voted
		if (getTimesVoted(sender) == config.getInt("max-vote-change")) {
            messages.getStringList("vote.maximum-votes").forEach(message ->
                MessageManager.getInstance().send(sender, message
                    .replace("%max_votes%", config.getInt("max-votes-change") + "")));

			return;
		}

		getTimesVoted().put(sender, getTimesVoted(sender) + 1);

        messages.getStringList("vote.message").forEach(message ->
            MessageManager.getInstance().send(sender, message
                .replace("%playerplot%", arena.getVotingPlot().getPlayerFormat())
                .replace("%points%", vote.getPoints() + "")));

        messages.getStringList("vote.receiver").forEach(message ->
			arena.getVotingPlot().getGamePlayers().forEach(player ->
                MessageManager.getInstance().send(player.getPlayer(), message
                    .replace("%points%", vote.getPoints() + "")
                    .replace("%sender%", sender.getName()))
			)
		);

		var senderArena = ArenaManager.getInstance().getArena(sender);

		if (senderArena != null)
            senderArena.getPlot(sender).getGamePlayers().forEach(player -> {
                player.addTitleAndSubtitle(messages.getString("vote.title")
                    .replace("%points%", vote.getPoints() + ""), messages.getString("vote.subtitle")
                    .replace("%points%", vote.getPoints() + ""));
                player.sendActionbar(messages.getString("vote.actionbar")
                    .replace("%points%", String.valueOf(vote.getPoints())));
            });

        int previousPoints = getPoints();

		if (hasVoted(sender))
			getVotes().remove(getVote(sender));

		votes.add(vote);
		
		if (!config.getBoolean("scoreboards.vote.text"))
			arena.getVoteScoreboard(this).setScore(getPlayerFormat(), getPoints());
		
		if (!config.getBoolean("names-after-voting") && config.getBoolean("scoreboards.vote.enable"))
		    arena.getPlots().stream()
                .filter(p -> !p.getGamePlayers().isEmpty())
                .flatMap(p -> getGamePlayers().stream())
                .forEach(player -> arena.getVoteScoreboard(this).show(player.getPlayer()));

		//point actions
        var configurationSection = config.getConfigurationSection("voting.point-actions");

		configurationSection.getKeys(false).forEach(key -> {
		    int points;

		    try {
		        points = Integer.parseInt(key);
            } catch (NumberFormatException e) {
		        if (config.getBoolean("debug"))
		            Main.getInstance().getLogger()
                        .warning("Unsupported value found in config.yml in voting > point-actions > " + key);

		        return;
            }

            //ensure the amount of points is higher and that this is the first time we get this (e.g. the added amount
            //of points made the amount go over the minimum, it shouldn't already have been higher than the minimum)
            if (getPoints() < points || previousPoints >= points)
                return;

            configurationSection.getStringList(key).forEach(command -> {
                if (!command.isEmpty() && command.charAt(0) == '@') {
                    String targetText = command.split(" ")[0];

                    Target.parse(targetText).execute(command.substring(targetText.length() + 1));
                } else
                    getGamePlayers().forEach(gamePlayer -> Bukkit.dispatchCommand(gamePlayer.getPlayer(), command));
            });
        });

        //track stats
        var statManager = StatManager.getInstance();

        getGamePlayers().forEach(gamePlayer -> {
            var player = gamePlayer.getPlayer();
            var stat = statManager.getStat(player, StatType.POINTS_RECEIVED);

            statManager.registerStat(player, StatType.POINTS_RECEIVED,
                    (stat == null ? 0 : stat.getValue()) + vote.getPoints());
        });

        var stat = statManager.getStat(sender, StatType.POINTS_GIVEN);

        statManager.registerStat(sender, StatType.POINTS_GIVEN,
                (stat == null ? 0 : stat.getValue()) + vote.getPoints());
	}

	/**
     * Returns a collection of all game players (players and spectators)
     *
     * @return all game players
     * @since 4.0.6
     */
	@NotNull
	@Contract(pure = true)
	public Collection<GamePlayer> getAllGamePlayers() {
		return gamePlayers;
	}

    /**
     * Returns the arena this plot belongs to
     *
     * @return the arena
     * @since 5.2.0
     */
	@NotNull
    @Contract(pure = true)
    public Arena getArena() {
	    return arena;
    }

	/**
     * Returns the boundary of this plot
     *
     * @return the boundary
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public Region getBoundary() {
		return boundary;
	}

	/**
     * Returns the build menu of this plot
     *
     * @return the build menu
     * @since 4.0.0
     */
	@NotNull
    @Contract(pure = true)
	public BuildMenu getBuildMenu() {
		return buildMenu;
	}

	/**
     * Returns a map with registered entities and their previous locations
     *
     * @return a map with entities and locations
     * @since 4.0.0
     */
	@NotNull
    @Contract(pure = true)
	public Map<Entity, Location> getEntities() {
		return entities;
	}

	/**
     * Returns the floor of this plot
     *
     * @return the floor
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	public Region getFloor() {
		return floor;
	}

	/**
     * Returns the game player wrapper for the specified player
     *
     * @param player the player to look for
     * @return the game player wrapper
     * @since 2.1.0
     */
    @Nullable
    @Contract(pure = true)
	public GamePlayer getGamePlayer(Player player) {
        return getAllGamePlayers().stream()
            .filter(gamePlayer -> gamePlayer.getPlayer().equals(player))
            .findAny()
            .orElse(null);
	}

	/**
     * Returns a list of game players which are playing (so no spectators)
     *
     * @return all playing game players
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public List<GamePlayer> getGamePlayers() {
	    return getAllGamePlayers().stream()
            .filter(gamePlayer -> gamePlayer.getGamePlayerType() == GamePlayerType.PLAYER)
            .collect(Collectors.toList());
	}

	/**
     * Returns the id for this plot
     *
     * @return the id
     * @since 2.1.0
     */
    @Contract(pure = true)
	public int getId() {
		return id;
	}

	/**
     * Returns the spawn location for this plot
     *
     * @return the spawn location
     * @since 9.1.2
     */
	@Nullable
    @Contract(pure = true)
	public PotentialLocation getLocation() {
		return location;
	}

	/**
     * Returns the maximum amount of players this plot may have
     *
     * @return the max. amount of players
     * @since 2.1.0
     */
	@Contract(pure = true)
	public int getMaxPlayers() {
		return arena.getMaxPlayers() / arena.getPlots().size();
	}

	/**
     * Returns a collection of particles placed on this plot
     *
     * @return all particles
     * @since 4.0.6
     */
	@NotNull
	@Contract(pure = true)
	public Collection<Particle> getParticles() {
		return particles;
	}

	/**
     * Returns the amount of players on this plot
     *
     * @return the amount of players
     * @since 2.1.0
     */
	@Contract(pure = true)
	public int getPlayers() {
		return getGamePlayers().size();
	}

	/**
     * Returns a formatted string containing all players' name
     *
     * @return a formatted string of players
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
	public String getPlayerFormat() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		StringBuilder players = new StringBuilder();
		
		for (var i = 0; i < getGamePlayers().size(); i++) {
			GamePlayer player = getGamePlayers().get(i);
			
			if (i == getGamePlayers().size() - 1)
				players.append(player.getPlayer().getName());
			else if (i == getGamePlayers().size() - 2)
				players.append(player.getPlayer().getName()).append(messages.getString("global.combine-names"));
			else
				players.append(player.getPlayer().getName()).append(", ");
		}
		
		return players.toString();
	}

	/**
     * Returns the amount of points this plot got by votes
     *
     * @return the voting points
     * @since 2.1.0
     */
	@Contract(pure = true)
	public int getPoints() {
	    return votes.stream().mapToInt(Vote::getPoints).sum();
	}

	/**
     * Returns an iterable of game players who are spectating a person on this plot
     *
     * @return all spectators
     * @since 4.0.6
     */
	@NotNull
	@Contract(pure = true)
	public Collection<GamePlayer> getSpectators() {
	    return getAllGamePlayers().stream()
            .filter(gamePlayer -> gamePlayer.getGamePlayerType() == GamePlayerType.SPECTATOR)
            .collect(Collectors.toSet());
	}

	/**
     * Returns the time this plot is currently set to
     *
     * @return the time
     * @since 2.1.0
     */
	@Contract(pure = true)
	public long getTime() {
		return time;
	}

	/**
     * Returns a map containing players who have voted on this plot and the amount of times they've done
     *
     * @return the amount of times voted per player
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
	public Map<Player, Integer> getTimesVoted() {
		return timesVoted;
	}

    /**
     * Returns the amount of times the player has voted on this plot
     *
     * @param player the player to look for
     * @return the amount fo times voted by the player
     * @since 2.1.0
     */
	@Contract(pure = true)
	private int getTimesVoted(Player player) {
		return timesVoted.get(player) == null ? 0 : timesVoted.get(player);
	}

	/**
     * Returns the vote that has been given by the specified player
     *
     * @param player the player who's vote we're looking for
     * @return the vote that has been given by the player
     * @since 2.1.0
     */
	@Nullable
	@Contract(pure = true)
	public Vote getVote(Player player) {
	    return getVotes().stream().filter(vote -> vote.getSender().equals(player)).findAny().orElse(null);
	}

	/**
     * Returns a collection of all votes given to this plot
     *
     * @return all votes
     * @since 4.0.6
     */
	@NotNull
    @Contract(pure = true)
	public Collection<Vote> getVotes() {
		return votes;
	}

	/**
     * Returns whether or not the specified player has already voted on this plot
     *
     * @param player the player to see if it has voted on this plot
     * @return true if the player has voted on this plot, false otherwise
     * @since 2.1.0
     */
	@Contract(value = "null -> false", pure = true)
	public boolean hasVoted(Player player) {
	    return getVotes().stream().anyMatch(vote -> vote.getSender().equals(player));
	}

	/**
     * Returns whether or not this plot is full; when it's full no more players can join this plot
     *
     * @return true if no one can join on this plot, false otherwise
     * @since 2.1.0
     */
	@Contract(pure = true)
	public boolean isFull() {
        return arena.getMode() == ArenaMode.TEAM ? (arena.getMaxPlayers() / arena.getPlots().size()) == getGamePlayers()
                .size() : !getGamePlayers().isEmpty();
    }

	/**
     * Returns whether or not it's raining on this plot
     *
     * @return true if it's raining, false otherwise
     * @since 2.1.0
     */
	@Contract(pure = true)
	public boolean isRaining() {
		return raining;
	}

    /**
     * Makes the specified game player join this plot. If the arena is in solo mode and someone has already joined this
     * plot, that person will be kicked from this plot
     *
     * @param gamePlayer the player to join
     * @return whether ot not the player was able to join the plot
     * @since 2.1.0
     */
	public boolean join(GamePlayer gamePlayer) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        var name = gamePlayer.getPlayer().getName();

        if (arena.getMode() == ArenaMode.TEAM) {
			if (!isFull()) {
				gamePlayers.add(gamePlayer);

                MessageManager.translate(messages.getStringList("join.plot.message")).forEach(s ->
                    MessageManager.getInstance().send(gamePlayer.getPlayer(), s
                        .replace("%plot%", getId() + "")));

                arena.getLobbyScoreboard(this).getGreenTeam().addEntry(name);
                arena.getBuildScoreboard(this).getGreenTeam().addEntry(name);
                arena.getVoteScoreboard(this).getGreenTeam().addEntry(name);
                arena.getWinScoreboard(this).getGreenTeam().addEntry(name);

				return true;
			} else {
				MessageManager.getInstance().send(gamePlayer.getPlayer(), MessageManager.translate(messages
                        .getStringList("join.plot.full")));
				return false;
			}
		} else {
			if (gamePlayers.size() == 1)
				gamePlayers.remove(0).getPlayer().getName();

            gamePlayers.add(gamePlayer);

            MessageManager.translate(messages.getStringList("join.plot.message")).forEach(s ->
                MessageManager.getInstance().send(gamePlayer.getPlayer(), s
                    .replace("%plot%", getId() + "")));

            arena.getLobbyScoreboard(this).getGreenTeam().addEntry(name);
            arena.getBuildScoreboard(this).getGreenTeam().addEntry(name);
            arena.getVoteScoreboard(this).getGreenTeam().addEntry(name);
            arena.getWinScoreboard(this).getGreenTeam().addEntry(name);

			return true;
		}
	}

    /**
     * Makes the specified game player leave this plot
     *
     * @param gamePlayer the player to leave this plot
     * @since 2.1.0
     */
	public void leave(GamePlayer gamePlayer) {
		gamePlayers.remove(gamePlayer);
	}

	/**
     * Removes the specified spectator from this plot and thus makes him stop spectating
     *
     * @param spectator the spectator to remove
     * @since 2.1.0
     */
	@Contract("null -> fail")
	public void removeSpectator(GamePlayer spectator) {
		getAllGamePlayers().remove(spectator);
		
		getAllGamePlayers().forEach(player -> player.getPlayer().showPlayer(Main.getInstance(), spectator.getPlayer()));
		
		Player spPlayer = spectator.getPlayer();
		spectator.restore();
		spPlayer.setCanPickupItems(true);
	}

	/**
     * Restores the previous state of this plot which includes its block states and data, its time, rain state and
     * particles
     *
     * @since 2.1.0
     */
	public void restore() {
		if (!SettingsManager.getInstance().getConfig().getBoolean("restore-plots"))
			return;
		
		blocks.forEach((blockState, biome) -> {
            Block block = blockState.getLocation().getBlock();

            block.setType(blockState.getType());
            block.setBiome(biome);
		});

        //refresh chunks because of the biomes
        arena.getPlots().forEach(plot -> plot.getBoundary().getChunks().forEach(chunk ->
                gamePlayers.forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));
		
		setRaining(false);
		setTime(0);
		
		getParticles().clear();
	}

	/**
     * Saves the current state of the blocks of the plot into memory, so it can be reset later on. This will overwrite
     * any pre-existing data
     *
     * @since 2.1.0
     */
	public void save() {
		if (getBoundary() == null) {
			Main.getInstance().getLogger().warning("No boundary's found. Disabling auto-resetting plots...");
			return;
		}
		
		getBoundary().getAllBlocks().forEach(block -> blocks.put(block.getState(), block.getBiome()));
	}

    /**
     * Sets the boundary of this plot
     *
     * @param boundary the new boundary
     * @since 2.1.0
     */
	public void setBoundary(Region boundary) {
		this.boundary = boundary;
	}

    /**
     * Sets the floor of this plot
     *
     * @param floor the new floor
     * @since 2.1.0
     */
	public void setFloor(Region floor) {
		this.floor = floor;
	}

	/**
     * Sets the spawn location of this plot
     *
     * @param location the new location
     * @since 9.1.2
     */
	public void setLocation(@NotNull PotentialLocation location) {
		this.location = location;
	}

    /**
     * Sets whether it should rain or not on this plot. This will also update the weather state for all players.
     *
     * @param raining the new raining state
     * @since 2.1.0
     */
	public void setRaining(boolean raining) {
		this.raining = raining;

		getGamePlayers().forEach(gamePlayer ->
            gamePlayer.getPlayer().setPlayerWeather(raining ? WeatherType.DOWNFALL : WeatherType.CLEAR));
	}

    /**
     * Sets the new time that it should be on this plot. This will also update the time for all players.
     *
     * @param time the new time
     * @since 2.1.0
     */
	public void setTime(long time) {
		this.time = time;

		getGamePlayers().forEach(gamePlayer -> gamePlayer.getPlayer().setPlayerTime(time, false));
	}

    /**
     * Returns the plot by the given block based on the boundary
     *
     * @param block the block inside the boundary
     * @return the plot which boundary contains the given block
     * @since 9.1.0
     */
    @Nullable
    @Contract(pure = true)
    public static Plot getPlot(@NotNull Block block) {
        return getPlot(block.getLocation());
    }

    /**
     * Returns the plot by the given location based on the boundary
     *
     * @param location the location inside the boundary
     * @return the plot which boundary contains the given location
     * @see Plot
     * @since 4.0.4
     */
    @Nullable
    @Contract(pure = true)
    public static Plot getPlot(Location location) {
        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            for (Plot plot : arena.getPlots()) {
                Region boundary = plot.getBoundary();

                if (boundary == null)
                    continue;

                if (boundary.isInside(location))
                    return plot;
            }
        }

        return null;
    }

    /**
     * {@inheritDoc}
     */
	@Override
	public boolean equals(Object obj) {
	    if (!(obj instanceof Plot))
	        return false;

	    Plot plot = (Plot) obj;

	    return plot.getId() == id && plot.getArena().equals(arena);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = 31 * hashCode + arena.hashCode();
        hashCode = 31 * hashCode + id;

        return hashCode;
    }

    /**
     * Sets the id of this plot
     *
     * @param id the new id
     * @since 7.0.0
     */
    public void setId(int id) {
        this.id = id;
    }
}