package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import java.util.*;

import com.gmail.stefvanschiedev.buildinggame.utils.GameState;
import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.BungeeCordHandler;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
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
	private final Collection<Sign> randomJoinSigns = new ArrayList<>();

	/**
     * A collection of all leave signs
     */
	private final Collection<Sign> leaveSigns = new ArrayList<>();

	/**
     * A collection of all statistic signs
     */
	private final Collection<StatSign> statSigns = new ArrayList<>();

	/**
     * Loads/Reloads all signs
     *
     * @since 2.1.0
     */
	public void setup() {
        YamlConfiguration config = SettingsManager.getInstance().getConfig();
        YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		for (Arena arena : ArenaManager.getInstance().getArenas())
			arena.getSigns().clear();

		randomJoinSigns.clear();
		leaveSigns.clear();
		statSigns.clear();
		
		for (String string : signs.getKeys(false)) {
            BlockState state = new Location(Bukkit.getWorld(signs.getString(string + ".world")),
                    signs.getInt(string + ".x"),
                    signs.getInt(string + ".y"),
                    signs.getInt(string + ".z")).getBlock().getState();

            if (!(state instanceof Sign)) {
				signs.set(string, null);
				continue;
			}
			
			Sign sign = (Sign) state;
			
			if (!signs.contains(string + ".type"))
				signs.set(string + ".type", "join");
			
			if (signs.getString(string + ".type").equals("join")) {
				Arena arena = ArenaManager.getInstance().getArena(signs.getString(string + ".arena"));
			
				if (arena == null) {
					randomJoinSigns.add(sign);
					continue;
				}
			
				arena.addSign(sign);

				if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
					Main.getInstance().getLogger().info("Found join sign for arena " + arena.getName());
			} else if (signs.getString(string + ".type").equals("leave")) {
				leaveSigns.add(sign);
				
				if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
					Main.getInstance().getLogger().info("Found leave sign");
			} else if (signs.getString(string + ".type").equals("stat")) {
				statSigns.add(new StatSign(sign, StatType.valueOf(signs.getString(string + ".stat")),
						Integer.parseInt(signs.getString(string + ".number"))));
				
				if (SettingsManager.getInstance().getConfig().getBoolean("debug"))
					Main.getInstance().getLogger().info("Found stat sign");
			}
		}

        if(config.getBoolean("signs.glass-colors-enabled")) {
            for (String key : config.getConfigurationSection("signs.glass-colors").getKeys(false)) {
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
		updateStatSigns();
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
		for (Arena arena : ArenaManager.getInstance().getArenas())
			updateJoinSigns(arena);
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

        if (config.getBoolean("bungeecord.enable") && Bukkit.getPluginManager().isPluginEnabled("Socket4MC"))
            BungeeCordHandler.getInstance().sign(BungeeCordHandler.Receiver.SUB_SERVER, arena, line1, line2, line3,
                    line4, null);

		for (Sign sign : arena.getSigns()) {
			sign.setLine(0, line1);
			sign.setLine(1, line2);
			sign.setLine(2, line3);
			sign.setLine(3, line4);

			sign.update();
		}
	}

	/**
     * Updates all random join signs
     *
     * @since 4.0.6
     */
	private void updateRandomJoinSigns() {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        for (Sign sign : randomJoinSigns) {
            sign.setLine(0, MessageManager.translate(messages.getString("signs.join.random.line-1")));
            sign.setLine(1, MessageManager.translate(messages.getString("signs.join.random.line-2")));
            sign.setLine(2, MessageManager.translate(messages.getString("signs.join.random.line-3")));
            sign.setLine(3, MessageManager.translate(messages.getString("signs.join.random.line-4")));

            sign.update();
        }
    }

    /**
     * Updates all leave signs
     *
     * @since 3.1.0
     */
	private void updateLeaveSigns() {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (Sign sign : leaveSigns) {
			sign.setLine(0, MessageManager.translate(messages.getString("signs.leave.line-1")));
			sign.setLine(1, MessageManager.translate(messages.getString("signs.leave.line-2")));
			sign.setLine(2, MessageManager.translate(messages.getString("signs.leave.line-3")));
			sign.setLine(3, MessageManager.translate(messages.getString("signs.leave.line-4")));

			sign.update();
		}
	}

	/**
     * Updates all statistic signs
     *
     * @since 3.1.0
     */
	public void updateStatSigns() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		for (StatSign sign : statSigns) {
			Sign s = sign.getSign();
			
			if (config.getBoolean("stats.enable." + sign.getType().toString().toLowerCase(Locale.getDefault()))) {
				Map<OfflinePlayer, Integer> stats = new HashMap<>();
				
				for (Stat stat : StatManager.getInstance().getStats(sign.getType()))
					stats.put(stat.getPlayer(), stat.getValue());
				
				List<Integer> values = new ArrayList<>(stats.values());
				Collections.sort(values);
				Collections.reverse(values);
				
				int value = -1;
				
				if (values.size() >= sign.getNumber())
					value = values.get(sign.getNumber() - 1);
				
				OfflinePlayer player = null;
				
				for (OfflinePlayer op : stats.keySet()) {
					if (stats.get(op) == value)
						player = op;
				}
				
				s.setLine(0, MessageManager.translate(messages.getString("signs.stat." + sign.getType()
                        .toString().toLowerCase(Locale.getDefault()) + ".line-1"))
                        .replace("%number%", sign.getNumber() + "")
						.replace("%player%",
                                player == null || player.getName() == null ? "missingno" : player.getName())
						.replace("%amount%", value + ""));
				s.setLine(1, MessageManager.translate(messages.getString("signs.stat." + sign.getType()
                        .toString().toLowerCase(Locale.getDefault()) + ".line-2"))
						.replace("%number%", sign.getNumber() + "")
						.replace("%player%",
                                player == null || player.getName() == null ? "missingno" : player.getName())
						.replace("%amount%", value + ""));
				s.setLine(2, MessageManager.translate(messages.getString("signs.stat." + sign.getType()
                        .toString().toLowerCase(Locale.getDefault()) + ".line-3"))
						.replace("%number%", sign.getNumber() + "")
						.replace("%player%",
                                player == null || player.getName() == null ? "missingno" : player.getName())
						.replace("%amount%", value + ""));
				s.setLine(3, MessageManager.translate(messages.getString("signs.stat." + sign.getType()
                        .toString().toLowerCase(Locale.getDefault()) + ".line-4"))
						.replace("%number%", sign.getNumber() + "")
						.replace("%player%",
                                player == null || player.getName() == null ? "missingno" : player.getName())
						.replace("%amount%", value + ""));
			} else {
				s.setLine(0, "");
				s.setLine(1, ChatColor.RED + "Stat type");
				s.setLine(2, ChatColor.RED + "is disabled");
				s.setLine(3, "");
			}
			
			s.update(true);
		}
	}

	/**
     * Returns a collection of all random join signs
     *
     * @return all random join signs
     * @since 4.0.6
     */
	@NotNull
	@Contract(pure = true)
    public Collection<Sign> getRandomJoinSigns() {
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
    public Collection<Sign> getLeaveSigns() {
		return leaveSigns;
	}

    /**
     * Updates the blocks behind the signs according to the values given in the configuration.
     * @param arena The arena wherefrom the signs need to be updated.
     */
    @SuppressWarnings("deprecation")
    private void updateBlockBehindJoinSigns(Arena arena){
        for (Sign sign : arena.getSigns()) {
            MaterialData signMaterialData = sign.getBlock().getState().getData();

            if (signMaterialData instanceof Attachable) {
                Block attachedBlock = sign.getBlock().getRelative(((Attachable) signMaterialData).getAttachedFace());
                DyeColor dyeColor = gameStatesColor.get(arena.getState());

                attachedBlock.setType(Material.STAINED_GLASS);

                if (dyeColor != null) {
                    //((Colorable) attachedBlock.getState()).setColor((gameStatesColor.get(arena.getState())));
                    //No other viable method found for setting the color of stained glass. Above method does not work but who knows, in the future.
                    attachedBlock.setData((byte) dyeColor.ordinal());
                    attachedBlock.getState().update();
                } else
                    Main.getInstance().getLogger().warning("Wrong input at config.yml at signs.glass-colors." +
                            arena.getState().toString().toLowerCase(Locale.getDefault()));
            }
        }
    }
}