package com.gmail.stefvanschiedev.buildinggame.api;

import java.util.List;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

@SuppressWarnings("WeakerAccess")
public class BuildingGame {

	@SuppressWarnings("unused")
    public static Arena getArena(String name) {
		return ArenaManager.getInstance().getArena(name);
	}
	
	@SuppressWarnings("unused")
    public static Arena getArena(Player player) {
		return ArenaManager.getInstance().getArena(player);
	}
	
	@SuppressWarnings("unused")
    public static List<Arena> getArenas() {
		return ArenaManager.getInstance().getArenas();
	}
}