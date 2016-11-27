package com.gmail.stefvanschiedev.buildinggame.api;

import java.util.List;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

public class BuildingGame {

	public static Arena getArena(String name) {
		return ArenaManager.getInstance().getArena(name);
	}
	
	public static Arena getArena(Player player) {
		return ArenaManager.getInstance().getArena(player);
	}
	
	public static List<Arena> getArenas() {
		return ArenaManager.getInstance().getArenas();
	}
}