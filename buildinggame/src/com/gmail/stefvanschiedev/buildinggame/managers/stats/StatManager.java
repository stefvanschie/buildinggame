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
import org.jetbrains.annotations.Nullable;

public final class StatManager {
	
	private static final StatManager INSTANCE = new StatManager();
	private MySQLDatabase database;
	
	private final List<Stat> stats = new ArrayList<>();
	
	private StatManager() {}
	
	public void setup() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration stats = SettingsManager.getInstance().getStats();
		
		if (config.getBoolean("stats.database.enable")) {
			database = new MySQLDatabase(Main.getInstance());
			
			if (database.setup()) {
				Set<UUID> uuids = database.getAllPlayers();
				
				for (UUID uuid : uuids) {
					for (StatType statType : StatType.values())
						this.stats.add(new Stat(statType, Bukkit.getOfflinePlayer(uuid), database.getStat(uuid.toString(), statType.toString().toLowerCase(Locale.getDefault()))));
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
	
	public boolean containsUUID(UUID uuid) {
		for (Stat stat : stats) {
			if (stat.getPlayer().getUniqueId().equals(uuid))
				return true;
		}
		
		return false;
	}
	
	@Nullable
    public Stat getStat(Player player, StatType type) {
		for (Stat stat : stats) {
			if (player.equals(stat.getPlayer().getPlayer()) && stat.getType() == type)
				return stat;
		}
		return null;
	}
	
	public Iterable<Stat> getStats(StatType type) {
		Collection<Stat> stats = new ArrayList<>();
		
		for (Stat stat : this.stats) {
			if (stat.getType() == type)
				stats.add(stat);
		}
		
		return stats;
	}
	
	public void registerStat(Player player, StatType type, int value) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		if (!config.getBoolean("stats.enable." + type.toString().toLowerCase(Locale.getDefault())))
			return;
		
		if (getStat(player, type) != null)
			stats.remove(getStat(player, type));
		
		stats.add(new Stat(type, player, value));
	}
	
	/*
	 * Because of massive amount of stat saving,
	 * we need to do this every once in a while.
	 */
	public synchronized void saveToFile() {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration stats = SettingsManager.getInstance().getStats();
		
		for (Stat stat : this.stats) {
		    String type = stat.getType().toString().toLowerCase(Locale.getDefault());

		    if (config.getBoolean("stats.enable." + type))
                stats.set(stat.getPlayer().getUniqueId() + "." + type, stat.getValue());
        }
		
		SettingsManager.getInstance().save();
	}
	
	public void saveToDatabase() {
	    YamlConfiguration config = SettingsManager.getInstance().getConfig();

		List<Stat> stats = this.stats;

		for (Stat stat : stats) {
		    String type = stat.getType().toString().toLowerCase(Locale.getDefault());

		    if (config.getBoolean("stats.enable." + type))
                getMySQLDatabase().setStat(stat.getPlayer().getUniqueId().toString(), type, stat.getValue());
        }
	}
	
	@Contract(pure = true)
    public static StatManager getInstance() {
		return INSTANCE;
	}
	
	@Contract(pure = true)
    public MySQLDatabase getMySQLDatabase() {
		return database;
	}
}