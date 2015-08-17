package me.stefvanschie;

import java.util.HashMap;
import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;

public class Arena {
	
	static HashMap<BlockState, String> blocks = new HashMap<BlockState, String>();
	
	public static void save(String arena) {
		int maxplayers = BuildingGame.main.arenas.getInt(arena + ".maxplayers");
		
		for (int place = 1; place <= maxplayers; place++) {
			
			int minX = BuildingGame.main.arenas.getInt(arena + "." + place + ".low.x");
			int maxX = BuildingGame.main.arenas.getInt(arena + "." + place + ".high.x");
			int minY = BuildingGame.main.arenas.getInt(arena + "." + place + ".low.y");
			int maxY = BuildingGame.main.arenas.getInt(arena + "." + place + ".high.y");
			int minZ = BuildingGame.main.arenas.getInt(arena + "." + place + ".low.z");
			int maxZ = BuildingGame.main.arenas.getInt(arena + "." + place + ".high.z");
			
			for (int x = minX; x <= maxX; x++) {
				for (int y = minY; y <= maxY; y++) {
					for (int z = minZ; z <= maxZ; z++) {
						Location location = new Location(Bukkit.getWorld(BuildingGame.main.arenas.getString(arena + "." + place + ".high.world")), x, y, z);
						blocks.put(location.getBlock().getState(), arena);
					}
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void restore(String arena) {
		Iterator<BlockState> iterator = blocks.keySet().iterator();
		while (iterator.hasNext()) {
			BlockState block = iterator.next();
			if (blocks.get(block).equals(arena)) {
				Material material = block.getType();
				block.getLocation().getBlock().setType(material);
				byte md = block.getRawData();
				block.getLocation().getBlock().setData(md);
				iterator.remove();
			}
		}
	}
}
