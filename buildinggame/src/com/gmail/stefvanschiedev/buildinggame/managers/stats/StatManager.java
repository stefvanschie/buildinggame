package com.gmail.stefvanschiedev.buildinggame.managers.stats;

import java.util.*;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * This class handles all statistics of all players
 */
public final class StatManager {

    /**
     * An instance of this class for the singleton principle
     */
	private static final StatManager INSTANCE = new StatManager();

	/**
     * The MySQL database containing the statistics
     */
	private MySQLDatabase database;

	/**
     * All statistics from all players
     */
	private final List<Stat> stats = Collections.synchronizedList(new ArrayList<>());

	/**
     * Constructs a new StatManager. This shouldn't be called to keep this class a singleton.
     */
	private StatManager() {}

	/**
     * Loads/Reloads all statistics and configures the database if necessary
     *
     * @since 2.2.0
     */
	public void setup() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration stats = SettingsManager.getInstance().getStats();
		
		if (config.getBoolean("stats.database.enable")) {
			database = new MySQLDatabase(Main.getInstance());
			
			if (database.setup()) {
				Set<UUID> uuids = database.getAllPlayers();
				
				for (UUID uuid : uuids) {
					for (StatType statType : StatType.values())
						this.stats.add(new Stat(statType, Bukkit.getOfflinePlayer(uuid), database.getStat(uuid
                                .toString(), statType.toString().toLowerCase(Locale.getDefault()))));
				}
				
				return;
			}

			database = null;
			Main.getInstance().getLogger().warning("Database usage failed; returning to flat-file storage");
		}
		
		for (String uuid : stats.getKeys(false)) {
			OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
			
			for (String stat : stats.getConfigurationSection(uuid).getKeys(false)) {
				if (stat.equalsIgnoreCase("plays") && config.getBoolean("stats.enable.plays"))
					this.stats.add(new Stat(StatType.PLAYS, player, stats.getInt(uuid + '.' + stat)));
				else if (stat.equalsIgnoreCase("first") && config.getBoolean("stats.enable.first"))
					this.stats.add(new Stat(StatType.FIRST, player, stats.getInt(uuid + '.' + stat)));
				else if (stat.equalsIgnoreCase("second") && config.getBoolean("stats.enable.second"))
					this.stats.add(new Stat(StatType.SECOND, player, stats.getInt(uuid + '.' + stat)));
				else if (stat.equalsIgnoreCase("third") && config.getBoolean("stats.enable.third"))
					this.stats.add(new Stat(StatType.THIRD, player, stats.getInt(uuid + '.' + stat)));
				else if (stat.equalsIgnoreCase("broken") && config.getBoolean("stats.enable.broken"))
					this.stats.add(new Stat(StatType.BROKEN, player, stats.getInt(uuid + '.' + stat)));
				else if (stat.equalsIgnoreCase("placed") && config.getBoolean("stats.enable.placed"))
					this.stats.add(new Stat(StatType.PLACED, player, stats.getInt(uuid + '.' + stat)));
				else if (stat.equalsIgnoreCase("walked") && config.getBoolean("stats.enable.walked"))
					this.stats.add(new Stat(StatType.WALKED, player, stats.getInt(uuid + '.' + stat)));
			}
		}
	}

	/**
     * Checks to see if the there are stats available for the given UUID
     *
     * @param uuid the UUId to search for
     * @return whether the UUId was found or not
     * @since 4.0.0
     */
	@Contract("null -> false")
	public boolean containsUUID(UUID uuid) {
		for (Stat stat : stats) {
			if (stat.getPlayer().getUniqueId().equals(uuid))
				return true;
		}
		
		return false;
	}

	/**
     * Returns the statistic for the given player and stat type
     *
     * @param player the player to look for
     * @param type the stat type to filter by
     * @return the statistic matching the two parameters
     * @see Stat
     * @since 2.2.0
     */
	@Nullable
    @Contract("_, null -> null")
    public Stat getStat(Player player, StatType type) {
		for (Stat stat : stats) {
			if (player.equals(stat.getPlayer().getPlayer()) && stat.getType() == type)
				return stat;
		}

		return null;
	}

	/**
     * Returns all stats by the given type
     *
     * @param type the stat type to look for
     * @return an iterable of all stats with the given type
     * @since 3.1.0
     */
	@NotNull
	public Iterable<Stat> getStats(StatType type) {
		Collection<Stat> stats = new ArrayList<>();
		
		for (Stat stat : this.stats) {
			if (stat.getType() == type)
				stats.add(stat);
		}
		
		return stats;
	}

	/**
     * Registers the stat with the given player, type and value unless the config has the given stat type disabled
     *
     * @param player the player who obtained the statistic
     * @param type the type of statistic
     * @param value the value of the statistic
     * @since 2.2.0
     */
	@Contract("_, null, _ -> fail")
	public void registerStat(Player player, StatType type, int value) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (!config.getBoolean("stats.enable." + type.toString().toLowerCase(Locale.getDefault())))
			return;
		
		if (getStat(player, type) != null)
			stats.remove(getStat(player, type));
		
		stats.add(new Stat(type, player, value));
	}

    /**
     * Saves all statistics to the stats.yml file
     *
     * @since 2.2.0
     */
	public synchronized void saveToFile() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration stats = SettingsManager.getInstance().getStats();

		synchronized (this.stats) {
            for (Stat stat : this.stats) {
                String type = stat.getType().toString().toLowerCase(Locale.getDefault());

                if (config.getBoolean("stats.enable." + type))
                    stats.set(stat.getPlayer().getUniqueId() + "." + type, stat.getValue());
            }
        }
		
		SettingsManager.getInstance().save();
	}

	/**
     * Saves all statistics to the database
     *
     * @since 4.0.0
     */
	public synchronized void saveToDatabase() {
	    YamlConfiguration config = SettingsManager.getInstance().getConfig();

	    synchronized (stats) {
            for (Stat stat : stats) {
                String type = stat.getType().toString().toLowerCase(Locale.getDefault());

                if (config.getBoolean("stats.enable." + type))
                    getMySQLDatabase().setStat(stat.getPlayer().getUniqueId().toString(), type, stat.getValue());
            }
        }
	}

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.2.0
     */
	@NotNull
	@Contract(pure = true)
    public static StatManager getInstance() {
		return INSTANCE;
	}

	/**
     * Returns the MySQL database assigned to this manager
     *
     * @return the MySQL database
     * @since 4.0.0
     */
	@Nullable
	@Contract(pure = true)
    public MySQLDatabase getMySQLDatabase() {
		return database;
	}
}