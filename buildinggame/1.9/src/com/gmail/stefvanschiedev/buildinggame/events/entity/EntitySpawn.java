package com.gmail.stefvanschiedev.buildinggame.events.entity;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.entity.NbtFactory;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.entity.NmsClasses;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.entity.NbtFactory.NbtCompound;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;

public class EntitySpawn implements Listener {

	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		Entity entity = e.getEntity();
		
		if (!config.getBoolean("mobs.allow")) {
			e.setCancelled(true);
			return;
		}
		
		if (isInside(entity.getLocation())) {
			for (String ent : config.getStringList("blocked-entities")) {
				if (entity.getType() == EntityType.valueOf(ent.toUpperCase())) {
					entity.remove();
					return;
				}
			}
			
			if (config.getBoolean("mobs.enable-noai")) {
				NbtCompound nbt = NbtFactory.createCompound();
				nbt.put("NoAI", 1);
				NmsClasses.setTag(entity, nbt.getHandle());
			}
		}
	}
	
	public boolean isInside(Location location) {
		for (Arena arena : ArenaManager.getInstance().getArenas()) {
			for (Plot plot : arena.getPlots()) {
				if (plot.getBoundary() == null) 
					return false;
				if (plot.getBoundary().isInside(location)) {
					return true;
				}
			}
		}
		
		return false;
	}
}