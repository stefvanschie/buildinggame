package com.gmail.stefvanschiedev.buildinggame.managers.stats;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.gmail.stefvanschiedev.buildinggame.utils.Achievement;
import com.gmail.stefvanschiedev.buildinggame.utils.TopStatHologram;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;

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
     * All statistics from all players. The statistics inside the list are sorted in descending order (the element at
     * index zero has the highest value).
     */
	private final Map<StatType, List<Stat>> stats = new ConcurrentHashMap<>();

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
				database.getAllPlayers().forEach(uuid -> {
				    for (StatType statType : StatType.values())
				        registerStat(Bukkit.getOfflinePlayer(uuid), statType, database.getStat(uuid.toString(), statType
                            .toString().toLowerCase(Locale.getDefault())));
                });
				
				return;
			}

			database = null;
			Main.getInstance().getLogger().warning("Database usage failed; returning to flat-file storage");
		}
		
		stats.getKeys(false).forEach(uuid -> {
			OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
			
			stats.getConfigurationSection(uuid).getKeys(false).forEach(stat -> {
				if (stat.equalsIgnoreCase("plays") && StatType.PLAYS.isEnabled(config)) {
                    registerStat(player, StatType.PLAYS, stats.getInt(uuid + '.' + stat));
                } else if (stat.equalsIgnoreCase("first") && StatType.FIRST.isEnabled(config)) {
                    registerStat(player, StatType.FIRST, stats.getInt(uuid + '.' + stat));
                } else if (stat.equalsIgnoreCase("second") && StatType.SECOND.isEnabled(config)) {
                    registerStat(player, StatType.SECOND, stats.getInt(uuid + '.' + stat));
                } else if (stat.equalsIgnoreCase("third") && StatType.THIRD.isEnabled(config)) {
                    registerStat(player, StatType.THIRD, stats.getInt(uuid + '.' + stat));
                } else if (stat.equalsIgnoreCase("broken") && StatType.BROKEN.isEnabled(config)) {
                    registerStat(player, StatType.BROKEN, stats.getInt(uuid + '.' + stat));
                } else if (stat.equalsIgnoreCase("placed") && StatType.PLACED.isEnabled(config)) {
                    registerStat(player, StatType.PLACED, stats.getInt(uuid + '.' + stat));
                } else if (stat.equalsIgnoreCase("walked") && StatType.WALKED.isEnabled(config)) {
                    registerStat(player, StatType.WALKED, stats.getInt(uuid + '.' + stat));
                } else if (stat.equalsIgnoreCase("points_given") &&
                    StatType.POINTS_GIVEN.isEnabled(config)) {
                    registerStat(player, StatType.POINTS_GIVEN, stats.getInt(uuid + '.' + stat));
                } else if (stat.equalsIgnoreCase("points_received") &&
                    StatType.POINTS_RECEIVED.isEnabled(config)) {
                    registerStat(player, StatType.POINTS_RECEIVED, stats.getInt(uuid + '.' + stat));
                }
			});
		});
	}

	/**
     * Checks to see if the there are stats available for the given UUID
     *
     * @param uuid the UUId to search for
     * @return whether the UUId was found or not
     * @since 4.0.0
     */
	@Contract("null -> false")
	public synchronized boolean containsUUID(UUID uuid) {
	    return stats.entrySet().stream().anyMatch(entry -> entry.getValue().stream().anyMatch(stat ->
            stat.getPlayer().getUniqueId().equals(uuid)
        ));
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
    public synchronized Stat getStat(OfflinePlayer player, StatType type) {
        List<Stat> stats = getStats(type);

        if (stats == null)
            return null;

        return stats.stream().filter(stat -> player.equals(stat.getPlayer().getPlayer())).findAny().orElse(null);
	}

	/**
     * Returns all stats by the given type
     *
     * @param type the stat type to look for
     * @return an iterable of all stats with the given type
     * @since 3.1.0
     */
	@Nullable
	public List<Stat> getStats(StatType type) {
        return this.stats.get(type);
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
	public synchronized void registerStat(OfflinePlayer player, @NotNull StatType type, int value) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();

		if (!type.isEnabled(config)) {
            return;
        }

        Stat oldStat = getStat(player, type);

        if (oldStat != null)
			stats.get(type).remove(oldStat);

        if (!stats.containsKey(type))
            stats.put(type, Collections.synchronizedList(new ArrayList<>()));

        List<Stat> statsByType = stats.get(type);
        int size = statsByType.size();

        int index = 0;

        for (; index <= size; index++) {
            if (index == size)
                break;

            if (statsByType.get(index).getValue() < value)
                break;
        }

        Stat newStat = new Stat(player, value);

        statsByType.add(index, newStat);

        TopStatHologram.update(type);

        if (player.isOnline()) {
            Achievement.getAchievements(type).stream()
                .filter(achievement ->
                    !achievement.checkConditions(type, oldStat) && achievement.checkConditions(type, newStat))
                .forEach(achievement -> achievement.grant(player.getPlayer()));
        }
	}

    /**
     * Saves all statistics to the stats.yml file
     *
     * @since 2.2.0
     */
	public synchronized void saveToFile() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration stats = SettingsManager.getInstance().getStats();

        this.stats.forEach((statType, statList) -> statList.forEach(stat -> {
            String type = statType.toString().toLowerCase(Locale.getDefault());

            if (statType.isEnabled(config)) {
                stats.set(stat.getPlayer().getUniqueId() + "." + type, stat.getValue());
            }
        }));
		
		SettingsManager.getInstance().save();
	}

	/**
     * Saves all statistics to the database
     *
     * @since 4.0.0
     */
	public synchronized void saveToDatabase() {
	    YamlConfiguration config = SettingsManager.getInstance().getConfig();

        this.stats.entrySet().stream().filter(entry -> entry.getKey().isEnabled(config)).forEach(entry ->
            entry.getValue().forEach(stat -> {
                getMySQLDatabase().setStat(stat.getPlayer().getUniqueId().toString(), entry.getKey(), stat.getValue());
            })
        );
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