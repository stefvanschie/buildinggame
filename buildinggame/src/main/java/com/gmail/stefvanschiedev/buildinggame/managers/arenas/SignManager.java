package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import java.util.*;

import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
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

/**
 * This class handles all join, leave and statistic signs
 *
 * @since 2.1.0
 */
public final class SignManager {

    private final Map<GameState, DyeColor> gameStatesColor= new HashMap<>();

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
     * A collection of all random join signs
     */
	private final Collection<PotentialBlockPosition> randomJoinSigns = new ArrayList<>();

	/**
     * A collection of all leave signs
     */
	private final Collection<PotentialBlockPosition> leaveSigns = new ArrayList<>();

	/**
     * A collection of all statistic signs
     */
	private final Collection<StatSign> statSigns = new ArrayList<>();

    /**
     * A map of all spectate signs
     */
	private final Map<PotentialBlockPosition, OfflinePlayer> spectateSigns = new HashMap<>();

	/**
     * Loads/Reloads all signs
     *
     * @since 2.1.0
     */
	public void setup() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		ArenaManager.getInstance().getArenas().forEach(arena -> arena.getSigns().clear());

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
			
			if (!signs.contains(string + ".type"))
				signs.set(string + ".type", "join");

            switch (signs.getString(string + ".type")) {
                case "join":
                    var arena = ArenaManager.getInstance().getArena(signs.getString(string + ".arena"));

                    if (arena == null) {
                        randomJoinSigns.add(blockPos);
                        continue;
                    }

                    arena.getSigns().add(blockPos);

                    if (config.getBoolean("debug"))
                        Main.getInstance().getLogger().info("Found join sign for arena " + arena.getName());
                    break;
                case "leave":
                    leaveSigns.add(blockPos);

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
                    spectateSigns.put(blockPos, Bukkit.getOfflinePlayer(UUID.fromString(signs.getString(string +
                            ".player"))));

                    if (config.getBoolean("debug"))
                        Main.getInstance().getLogger().info("Found spectate sign");
                    break;
            }
		}

        if(config.getBoolean("signs.glass-colors-enabled")) {
            config.getConfigurationSection("signs.glass-colors").getKeys(false).forEach(key -> {
                try {
                    if (config.isInt("signs.glass-colors." + key))
                        gameStatesColor.put(GameState.valueOf(key.toUpperCase(Locale.getDefault())),
                            DyeColor.values()[config.getInt("signs.glass-colors." + key)]);
                    else
                        gameStatesColor.put(GameState.valueOf(key.toUpperCase(Locale.getDefault())),
                            DyeColor.valueOf(config.getString("signs.glass-colors." + key)));
                } catch (IllegalArgumentException e) {
                    //catch IllegalArgumentException for the easy of your clients.
                    Main.getInstance().getLogger().warning("Wrong parameter in config at: sign.glass-colors." + key + '.');
                }
            });
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
	    updateSpectateSigns();
		updateLeaveSigns();
		updateRandomJoinSigns();
		updateJoinSigns();
	}

	/**
     * Updates all join signs
     *
     * @since 2.1.0
     */
	private void updateJoinSigns() {
		ArenaManager.getInstance().getArenas().forEach(this::updateJoinSigns);
	}

	/**
     * Updates all join signs for the given arena
     *
     * @param arena the arena to update the join signs for
     * @see Arena
     * @since 2.1.0
     */
	@Contract("null -> fail")
    public void updateJoinSigns(Arena arena) {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        if (config.getBoolean("signs.glass-colors-enabled"))
            updateBlockBehindJoinSigns(arena);

        //get lines
        String line1 = MessageManager.translate(messages.getString("signs.join.line-1")
                .replace("%arena%", arena.getName())
                .replace("%players%", arena.getPlayers() + "")
                .replace("%max_players%", arena.getMaxPlayers() + "")
                .replace("%status%", messages.getString("variables.join-sign.status." + arena.getState()
                        .toString().toLowerCase(Locale.getDefault()))));
        String line2 = MessageManager.translate(messages.getString("signs.join.line-2")
                .replace("%arena%", arena.getName())
                .replace("%players%", arena.getPlayers() + "")
                .replace("%max_players%", arena.getMaxPlayers() + "")
                .replace("%status%", messages.getString("variables.join-sign.status." + arena.getState()
                        .toString().toLowerCase(Locale.getDefault()))));
        String line3 = MessageManager.translate(messages.getString("signs.join.line-3")
                .replace("%arena%", arena.getName())
                .replace("%players%", arena.getPlayers() + "")
                .replace("%max_players%", arena.getMaxPlayers() + "")
                .replace("%status%", messages.getString("variables.join-sign.status." + arena.getState()
                        .toString().toLowerCase(Locale.getDefault()))));
        String line4 = MessageManager.translate(messages.getString("signs.join.line-4")
                .replace("%arena%", arena.getName())
                .replace("%players%", arena.getPlayers() + "")
                .replace("%max_players%", arena.getMaxPlayers() + "")
                .replace("%status%", messages.getString("variables.join-sign.status." + arena.getState()
                        .toString().toLowerCase(Locale.getDefault()))));

        if (config.getBoolean("bungeecord.enable"))
            BungeeCordHandler.getInstance().sign(BungeeCordHandler.Receiver.SUB_SERVER, arena, line1, line2, line3,
                    line4, null);

		arena.getSigns().forEach(blockPos -> {
            Block block = blockPos.getBlock();

            if (block == null || !(block.getState() instanceof Sign)) {
                return;
            }

            Sign sign = (Sign) block.getState();

            sign.setLine(0, line1);
            sign.setLine(1, line2);
            sign.setLine(2, line3);
            sign.setLine(3, line4);

            sign.update();
		});
	}

	/**
     * Updates all random join signs
     *
     * @since 4.0.6
     */
	private void updateRandomJoinSigns() {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        randomJoinSigns.forEach(blockPos -> {
            Block block = blockPos.getBlock();

            if (block == null || !(block.getState() instanceof Sign)) {
                return;
            }

            Sign sign = (Sign) block.getState();

            sign.setLine(0, MessageManager.translate(messages.getString("signs.join.random.line-1")));
            sign.setLine(1, MessageManager.translate(messages.getString("signs.join.random.line-2")));
            sign.setLine(2, MessageManager.translate(messages.getString("signs.join.random.line-3")));
            sign.setLine(3, MessageManager.translate(messages.getString("signs.join.random.line-4")));

            sign.update();
        });
    }

    /**
     * Updates all leave signs
     *
     * @since 3.1.0
     */
	private void updateLeaveSigns() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		leaveSigns.forEach(blockPos -> {
            Block block = blockPos.getBlock();

            if (block == null || !(block.getState() instanceof Sign)) {
                return;
            }

            Sign sign = (Sign) block.getState();

			sign.setLine(0, MessageManager.translate(messages.getString("signs.leave.line-1")));
			sign.setLine(1, MessageManager.translate(messages.getString("signs.leave.line-2")));
			sign.setLine(2, MessageManager.translate(messages.getString("signs.leave.line-3")));
			sign.setLine(3, MessageManager.translate(messages.getString("signs.leave.line-4")));

			sign.update();
		});
	}

    /**
     * Updates all spectator signs
     *
     * @since 5.4.0
     */
	private void updateSpectateSigns() {
        spectateSigns.forEach((blockPos, offlinePlayer) -> {
            Block block = blockPos.getBlock();

            if (block == null || !(block.getState() instanceof Sign)) {
                return;
            }

            Sign sign = (Sign) block.getState();

            sign.setLine(0, ChatColor.BOLD + "Building Game");
            sign.setLine(1, "spectate");
            sign.setLine(2, ChatColor.UNDERLINE + offlinePlayer.getName());

            sign.update();
        });
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
	    return randomJoinSigns;
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
		return leaveSigns;
	}

    /**
     * Returns a map of all spectate signs and the corresponding players
     *
     * @return all spectate signs
     * @since 5.4.0
     */
    @NotNull
    @Contract(pure = true)
    public Map<PotentialBlockPosition, OfflinePlayer> getSpectateSigns() {
        return spectateSigns;
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
            MaterialData signMaterialData = sign.getBlock().getState().getData();

            if (signMaterialData instanceof Attachable) {
                Block attachedBlock = sign.getBlock().getRelative(((Attachable) signMaterialData).getAttachedFace());
                DyeColor dyeColor = gameStatesColor.get(arena.getState());

                attachedBlock.setType(Material.valueOf(dyeColor.name() + "_STAINED_GLASS"));

                if (dyeColor != null)
                    attachedBlock.getState().update();
                else
                    Main.getInstance().getLogger().warning("Wrong input at config.yml at signs.glass-colors." +
                            arena.getState().toString().toLowerCase(Locale.getDefault()));
            }
        });
    }
}