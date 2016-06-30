package com.gmail.stefvanschiedev.buildinggame.managers.stats;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.Stat;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

public class StatManager {
	
	private static StatManager instance = new StatManager();
	
	private List<Stat> stats = new ArrayList<Stat>();
	
	private StatManager() {}
	
	public void setup() {
		YamlConfiguration stats = SettingsManager.getInstance().getStats();
		
		for (String uuid : stats.getKeys(false)) {
			OfflinePlayer player = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
			
			for (String stat : stats.getConfigurationSection(uuid).getKeys(false)) {
				if (stat.equalsIgnoreCase("plays"))
					this.stats.add(new Stat(StatType.PLAYS, player, stats.getInt(uuid + "." + stat)));
				else if (stat.equalsIgnoreCase("first"))
					this.stats.add(new Stat(StatType.FIRST, player, stats.getInt(uuid + "." + stat)));
				else if (stat.equalsIgnoreCase("second"))
					this.stats.add(new Stat(StatType.SECOND, player, stats.getInt(uuid + "." + stat)));
				else if (stat.equalsIgnoreCase("third"))
					this.stats.add(new Stat(StatType.THIRD, player, stats.getInt(uuid + "." + stat)));
				else if (stat.equalsIgnoreCase("broken"))
					this.stats.add(new Stat(StatType.BROKEN, player, stats.getInt(uuid + "." + stat)));
				else if (stat.equalsIgnoreCase("placed"))
					this.stats.add(new Stat(StatType.PLACED, player, stats.getInt(uuid + "." + stat)));
				else if (stat.equalsIgnoreCase("walked"))
					this.stats.add(new Stat(StatType.WALKED, player, stats.getInt(uuid + "." + stat)));
			}
		}
	}
	
	public Stat getStat(Player player, StatType type) {
		for (Stat stat : stats) {
			if (stat.getPlayer().getPlayer() == player && stat.getType() == type)
				return stat;
		}
		return null;
	}
	
	public List<Stat> getStats() {
		return stats;
	}
	
	public void registerStat(Player player, StatType type, int value) {
		if (getStat(player, type) != null)
			stats.remove(getStat(player, type));
		
		stats.add(new Stat(type, player, value));
	}
	
	/**
	 * Because of massive amount of stat saving,
	 * we need to do this every once in a while.
	 */
	public void saveToFile() {
		YamlConfiguration stats = SettingsManager.getInstance().getStats();
		
		for (Stat stat : this.stats)
			stats.set(stat.getPlayer().getUniqueId() + "." + stat.getType().toString().toLowerCase(), stat.getValue());
		
		SettingsManager.getInstance().save();
	}
	
	public static StatManager getInstance() {
		return instance;
	}
}