package me.stefvanschie.buildinggame.managers.arenas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.Arena;
import me.stefvanschie.buildinggame.utils.Plot;

import org.bukkit.entity.Player;

public class ArenaManager {

	private ArenaManager() {
		
	}
	
	private static ArenaManager instance = new ArenaManager();
	
	public static ArenaManager getInstance() {
		return instance;
	}
	
	private List<Arena> arenas = new ArrayList<Arena>();
	
	public void setup() {
		Set<String> arenas = SettingsManager.getInstance().getArenas().getKeys(false);
		for (String arena : arenas) {
			if (!arena.equals("main-spawn"))
				this.arenas.add(new Arena(arena));
		}
	}
	
	public List<Arena> getArenas() {
		return arenas;
	}
	
	public Arena getArena(String name) {
		for (Arena arena : arenas) {
			if (arena.getName().equals(name))
				return arena;
		}
		return null;
	}
	
	public Arena getArena(Player player) {
		for (Arena arena : arenas) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getPlayerData() != null) {
					if (plot.getPlayerData().getPlayer() == player) {
						return arena;
					}
				}
			}
		}
		return null;
	}

}
