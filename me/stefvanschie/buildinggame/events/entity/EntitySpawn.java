package me.stefvanschie.buildinggame.events.entity;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;
import me.stefvanschie.buildinggame.utils.plot.Plot;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class EntitySpawn implements Listener {

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		Entity entity = e.getEntity();
		
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getBoundary().isInside(entity.getLocation())) {
					for (String ent : config.getStringList("blocked-entities")) {
						if (entity.getType() == EntityType.valueOf(ent.toUpperCase())) {
							entity.remove();
						}
					}
				}
			}
		}
	}
}