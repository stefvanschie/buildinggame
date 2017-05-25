package com.gmail.stefvanschiedev.buildinggame.managers.arenas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

public final class ArenaManager {

	private ArenaManager() {}
	
	private static final ArenaManager INSTANCE = new ArenaManager();
	
	@Contract(pure = true)
    public static ArenaManager getInstance() {
		return INSTANCE;
	}
	
	private final List<Arena> arenas = new ArrayList<>();
	
	public void setup() {
		arenas.clear();
		Set<String> arenas = SettingsManager.getInstance().getArenas().getKeys(false);
		for (String arena : arenas) {
			if (!arena.equals("main-spawn")) {
				this.arenas.add(new Arena(arena));
				if (SettingsManager.getInstance().getConfig().getBoolean("debug")) {
					Main.getInstance().getLogger().info("Loaded arena " + arena);
				}
			}
		}
	}
	
	@Contract(pure = true)
    public List<Arena> getArenas() {
		return arenas;
	}
	
	@Nullable
    public Arena getArena(String name) {
		for (Arena arena : arenas) {
			if (arena.getName().equals(name))
				return arena;
		}
		return null;
	}
	
	@Nullable
    public Arena getArena(Player player) {
		for (Arena arena : arenas) {
			for (Plot plot : arena.getUsedPlots()) {
				if (plot.getGamePlayer(player) != null) {
					if (plot.getGamePlayer(player).getPlayer().equals(player)) {
						return arena;
					}
				}
			}
		}
		return null;
	}

}