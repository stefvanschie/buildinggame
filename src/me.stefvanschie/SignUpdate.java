package me.stefvanschie;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;

public class SignUpdate {

	public static void update() {
		if (BuildingGame.main.config.getBoolean("update-signs")) {
			for (World signWorld : Bukkit.getWorlds()) {
				for (Chunk chunk : signWorld.getLoadedChunks()) {
					for (BlockState blockState : chunk.getTileEntities()) {
						if (blockState.getBlock().getState() instanceof Sign) {
							Sign sign = (Sign) blockState.getBlock().getState();
							if (sign.getLine(0).equals(ChatColor.BOLD + "BuildingGame")) {
								if (sign.getLine(1).equals(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "join")) {
									sign.setLine(3, BuildingGame.main.playersInArena.get(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "")).toString() + "/" + BuildingGame.main.arenas.get(sign.getLine(2).replace(ChatColor.UNDERLINE + "Map: ", "") + ".maxplayers").toString());
									sign.update();
								}
							}
						}
					}
				}
			}
		}
	}
}
