package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import java.util.*;

import com.gmail.stefvanschiedev.buildinggame.game.util.GamePhase;
import com.gmail.stefvanschiedev.buildinggame.utils.ChunkCoordinates;
import com.gmail.stefvanschiedev.buildinggame.utils.SpectateSign;
import com.gmail.stefvanschiedev.buildinggame.utils.potential.PotentialBlockPosition;
import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.BungeeCordHandler;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatSign;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.bukkit.material.Attachable;
import org.bukkit.material.MaterialData;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class handles all join, leave and statistic signs
 *
 * @since 2.1.0
 */
public final class SignManager {

    /**
     * The colors to use as a background for signs for each specific game phase.
     */
    private final Map<Class<GamePhase>, DyeColor> gameStatesColor = new HashMap<>();

    /**
     * Constructs a new SignManager. This shouldn't be called to keep this class a singleton.
     */
	private SignManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final SignManager INSTANCE = new SignManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return this instance
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static SignManager getInstance() {
		return INSTANCE;
	}

	/**
     * A map of all random join signs
     */
    @NotNull
	private final Map<ChunkCoordinates, Collection<PotentialBlockPosition>> randomJoinSigns = new HashMap<>();

	/**
     * A map of all leave signs
     */
    @NotNull
	private final Map<ChunkCoordinates, Collection<PotentialBlockPosition>> leaveSigns = new HashMap<>();

	/**
     * A collection of all statistic signs
     */
    @NotNull
	private final Collection<StatSign> statSigns = new HashSet<>();

    /**
     * A map of all spectate signs
     */
    @NotNull
	private final Map<ChunkCoordinates, Collection<SpectateSign>> spectateSigns = new HashMap<>();

	/**
     * Loads/Reloads all signs
     *
     * @since 2.1.0
     */
	public void setup() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration signs = SettingsManager.getInstance().getSigns();

        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            arena.clearSigns();
        }

		randomJoinSigns.clear();
		leaveSigns.clear();
		statSigns.clear();
		spectateSigns.clear();
		
		for (var string : signs.getKeys(false)) {
		    int x = signs.getInt(string + ".x");
		    int y = signs.getInt(string + ".y");
		    int z = signs.getInt(string + ".z");

            var blockPos = new PotentialBlockPosition(() ->
                Bukkit.getWorld(signs.getString(string + ".world")), x, y, z);
            ChunkCoordinates chunkCoordinates = blockPos.getChunkCoordinates();

            if (!signs.contains(string + ".type"))
				signs.set(string + ".type", "join");

            switch (signs.getString(string + ".type")) {
                case "join":
                    var arena = ArenaManager.getInstance().getArena(signs.getString(string + ".arena"));

                    if (arena == null) {
                        randomJoinSigns.putIfAbsent(chunkCoordinates, new HashSet<>());
                        randomJoinSigns.get(chunkCoordinates).add(blockPos);
                        continue;
                    }

                    arena.addSign(blockPos);

                    if (config.getBoolean("debug"))
                        Main.getInstance().getLogger().info("Found join sign for arena " + arena.getName());
                    break;
                case "leave":
                    leaveSigns.putIfAbsent(chunkCoordinates, new HashSet<>());
                    leaveSigns.get(chunkCoordinates).add(blockPos);

                    if (config.getBoolean("debug"))
                        Main.getInstance().getLogger().info("Found leave sign");
                    break;
                case "stat":
                    statSigns.add(new StatSign(blockPos, StatType.valueOf(signs.getString(string + ".stat")),
                            Integer.parseInt(signs.getString(string + ".number"))));

                    if (config.getBoolean("debug"))
                        Main.getInstance().getLogger().info("Found stat sign");
                    break;
                case "spectate":
                    UUID uuid = UUID.fromString(signs.getString(string + ".player"));

                    spectateSigns.putIfAbsent(chunkCoordinates, new HashSet<>());
                    spectateSigns.get(chunkCoordinates).add(new SpectateSign(blockPos, Bukkit.getOfflinePlayer(uuid)));

                    if (config.getBoolean("debug"))
                        Main.getInstance().getLogger().info("Found spectate sign");
                    break;
            }
		}

		updateSigns();
		
		SettingsManager.getInstance().save();
	}

	/**
     * Updates the text of all signs
     *
     * @since 3.1.0
     */
	private void updateSigns() {
        for (SpectateSign spectateSign : getSpectateSigns()) {
            updateSpectateSign(spectateSign);
        }

        for (PotentialBlockPosition position : getLeaveSigns()) {
            updateLeaveSign(position);
        }

        for (PotentialBlockPosition position : getRandomJoinSigns()) {
            updateRandomJoinSign(position);
        }

        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            updateJoinSigns(arena);
        }
	}

    /**
     * Updates all join signs for the given arena. This only updates the signs that are in loaded chunks.
     *
     * @param arena the arena to update the join signs for
     * @see Arena
     * @since 2.1.0
     */
    public void updateJoinSigns(@NotNull Arena arena) {
        for (PotentialBlockPosition position : arena.getSigns()) {
            if (!position.isLoaded()) {
                continue;
            }

            updateJoinSign(arena, position);
        }
    }

	/**
     * Updates all join signs for the given arena
     *
     * @param arena the arena to update the join signs for
     * @param blockPos the block position of the sign to update
     * @see Arena
     * @since 2.1.0
     */
    public void updateJoinSign(@NotNull Arena arena, @NotNull PotentialBlockPosition blockPos) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();

        Sign sign = tryGetSign(blockPos);

        if (sign == null) {
            return;
        }

        if (config.getBoolean("signs.glass-colors-enabled"))
            updateBlockBehindJoinSigns(arena);

        //get lines
        String[] lines = getJoinSignLines(arena);

        if (lines == null) {
            throw new IllegalStateException("Unable to find required settings for join signs in messages.yml.");
        }

        if (config.getBoolean("bungeecord.enable"))
            BungeeCordHandler.getInstance().sign(BungeeCordHandler.Receiver.SUB_SERVER, arena, lines[0], lines[1],
                lines[2], lines[3], null);

        sign.setLine(0, lines[0]);
        sign.setLine(1, lines[1]);
        sign.setLine(2, lines[2]);
        sign.setLine(3, lines[3]);

        sign.update();
	}

    /**
     * Gets the lines for a join sign for the given arena. This does not update any sign. The returned lines are given
     * in an array, where the first element corresponds to the first line, the second element corresponds to the second
     * element, etc. The returned array will always have four elements if it's not null. This method returns null if one
     * of the required values from the messages.yml cannot be found.
     *
     * @param arena the arena to get the lines for a join sign for
     * @return an array containing the lines for a join sign
     * @since 12.4.0
     */
    @Contract(pure = true)
    public @NotNull String @Nullable [] getJoinSignLines(@NotNull Arena arena) {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        String name = arena.getName();
        String players = String.valueOf(arena.getPlayers());
        String maxPlayers = String.valueOf(arena.getMaxPlayers());
        String status = messages.getString("variables.join-sign.status." +
            arena.getCurrentPhase().getName());

        String line1 = messages.getString("signs.join.line-1");
        String line2 = messages.getString("signs.join.line-2");
        String line3 = messages.getString("signs.join.line-3");
        String line4 = messages.getString("signs.join.line-4");

        if (line1 == null || line2 == null || line3 == null || line4 == null || status == null) {
            return null;
        }

        return new String[] {
            MessageManager.translate(line1
                .replace("%arena%", name)
                .replace("%players%", players)
                .replace("%max_players%", maxPlayers)
                .replace("%status%", status)),
            MessageManager.translate(line2
                .replace("%arena%", name)
                .replace("%players%", players)
                .replace("%max_players%", maxPlayers)
                .replace("%status%", status)),
            MessageManager.translate(line3
                .replace("%arena%", name)
                .replace("%players%", players)
                .replace("%max_players%", maxPlayers)
                .replace("%status%", status)),
            MessageManager.translate(line4
                .replace("%arena%", name)
                .replace("%players%", players)
                .replace("%max_players%", maxPlayers)
                .replace("%status%", status))
        };
    }

	/**
     * Updates all random join signs
     *
     * @since 4.0.6
     */
	private void updateRandomJoinSign(@NotNull PotentialBlockPosition blockPos) {
        Sign sign = tryGetSign(blockPos);

        if (sign == null) {
            return;
        }

        String[] lines = getRandomJoinSignLines();

        if (lines == null) {
            throw new IllegalStateException("Unable to find required settings for random join signs in messages.yml.");
        }

        sign.setLine(0, lines[0]);
        sign.setLine(1, lines[1]);
        sign.setLine(2, lines[2]);
        sign.setLine(3, lines[3]);

        sign.update();
    }

    /**
     * Gets the lines for a random join sign. This does not update any sign. The returned lines are given in an array,
     * where the first element corresponds to the first line, the second element corresponds to the second element, etc.
     * The returned array will always have four elements if it's not null. This method returns null if one of the
     * required values from the messages.yml cannot be found.
     *
     * @return an array containing the lines for a random join sign
     * @since 12.4.0
     */
    @Contract(pure = true)
    public @NotNull String @Nullable [] getRandomJoinSignLines() {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        String line1 = messages.getString("signs.join.random.line-1");
        String line2 = messages.getString("signs.join.random.line-2");
        String line3 = messages.getString("signs.join.random.line-3");
        String line4 = messages.getString("signs.join.random.line-4");

        if (line1 == null || line2 == null || line3 == null || line4 == null) {
            return null;
        }

        return new String[] {
            MessageManager.translate(line1),
            MessageManager.translate(line2),
            MessageManager.translate(line3),
            MessageManager.translate(line4)
        };
    }

    /**
     * Updates all leave signs
     *
     * @since 3.1.0
     */
	private void updateLeaveSign(@NotNull PotentialBlockPosition blockPos) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        Sign sign = tryGetSign(blockPos);

        if (sign == null) {
            return;
        }

        sign.setLine(0, MessageManager.translate(messages.getString("signs.leave.line-1")));
        sign.setLine(1, MessageManager.translate(messages.getString("signs.leave.line-2")));
        sign.setLine(2, MessageManager.translate(messages.getString("signs.leave.line-3")));
        sign.setLine(3, MessageManager.translate(messages.getString("signs.leave.line-4")));

        sign.update();
	}

    /**
     * Updates all spectator signs
     *
     * @since 5.4.0
     */
	private void updateSpectateSign(@NotNull SpectateSign spectateSign) {
        Sign sign = tryGetSign(spectateSign.getPotentialBlockPosition());

        if (sign == null) {
            return;
        }

        sign.setLine(0, ChatColor.BOLD + "Building Game");
        sign.setLine(1, "spectate");
        sign.setLine(2, ChatColor.UNDERLINE + spectateSign.getOfflinePlayer().getName());

        sign.update();
    }

    /**
     * Updates all the signs in the given chunk.
     *
     * @param chunkCoordinates the chunk for which to load all signs contained herein.
     * @since 10.0.3
     */
    public void updateSigns(@NotNull ChunkCoordinates chunkCoordinates) {
        for (Arena arena : ArenaManager.getInstance().getArenas()) {
            for (PotentialBlockPosition position : arena.getSigns(chunkCoordinates)) {
                updateJoinSign(arena, position);
            }
        }

        for (PotentialBlockPosition position : this.randomJoinSigns.getOrDefault(chunkCoordinates, new HashSet<>())) {
            updateRandomJoinSign(position);
        }

        for (PotentialBlockPosition position : this.leaveSigns.getOrDefault(chunkCoordinates, new HashSet<>())) {
            updateLeaveSign(position);
        }

        for (SpectateSign spectateSign : this.spectateSigns.getOrDefault(chunkCoordinates, new HashSet<>())) {
            updateSpectateSign(spectateSign);
        }
    }

    /**
     * Tries to get a sign from the given block position. This will return null if the location at the given position is
     * not loaded or, if the location is loaded, the block at the given location is not a sign. If this succeeds, it
     * will return the sign at the given position.
     *
     * @param position the position of the sign
     * @return the sign, or null
     * @since 10.0.3
     */
    @Nullable
    @Contract(pure = true)
    private Sign tryGetSign(@NotNull PotentialBlockPosition position) {
        if (!position.isLoaded()) {
            return null;
        }

        Block block = position.getBlock();

        if (block == null || !(block.getState() instanceof Sign)) {
            return null;
        }

        return (Sign) block.getState();
    }

	/**
     * Returns a collection of all random join signs
     *
     * @return all random join signs
     * @since 4.0.6
     */
	@NotNull
	@Contract(pure = true)
    public Collection<PotentialBlockPosition> getRandomJoinSigns() {
        Collection<PotentialBlockPosition> allPositions = new HashSet<>();

        for (Collection<PotentialBlockPosition> positions : this.randomJoinSigns.values()) {
            allPositions.addAll(positions);
        }

        return allPositions;
    }

    /**
     * Returns a collection of all leave signs
     *
     * @return all leave signs
     * @since 3.1.0
     */
    @NotNull
	@Contract(pure = true)
    public Collection<PotentialBlockPosition> getLeaveSigns() {
        Collection<PotentialBlockPosition> allPositions = new HashSet<>();

        for (Collection<PotentialBlockPosition> positions : this.leaveSigns.values()) {
            allPositions.addAll(positions);
        }

        return allPositions;
	}

    /**
     * Returns a map of all spectate signs and the corresponding players
     *
     * @return all spectate signs
     * @since 5.4.0
     */
    @NotNull
    @Contract(pure = true)
    public Collection<SpectateSign> getSpectateSigns() {
        Collection<SpectateSign> allSigns = new HashSet<>();

        for (Collection<SpectateSign> signs : this.spectateSigns.values()) {
            allSigns.addAll(signs);
        }

        return allSigns;
    }

    /**
     * Returns a collection of all statistic signs
     *
     * @return all stat signs
     * @since 5.8.5
     */
    @NotNull
    @Contract(pure = true)
    public Collection<StatSign> getStatSigns() {
        return statSigns;
    }

    /**
     * Updates the blocks behind the signs according to the values given in the configuration.
     * @param arena The arena wherefrom the signs need to be updated.
     */
    @SuppressWarnings("deprecation")
    private void updateBlockBehindJoinSigns(@NotNull Arena arena){
        arena.getSigns().forEach(sign -> {
            if (!sign.isLoaded()) {
                return;
            }

            MaterialData signMaterialData = sign.getBlock().getState().getData();

            if (signMaterialData instanceof Attachable) {
                Block attachedBlock = sign.getBlock().getRelative(((Attachable) signMaterialData).getAttachedFace());
                DyeColor dyeColor = arena.getCurrentPhase().getColor();

                attachedBlock.setType(Material.valueOf(dyeColor.name() + "_STAINED_GLASS"));
                attachedBlock.getState().update();
            }
        });
    }
}