package com.gmail.stefvanschiedev.buildinggame.events.player;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

public class Drop implements Listener {

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e) {
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		
		Player player = e.getPlayer();

		if (ArenaManager.getInstance().getArena(player) == null) {
			return;
		}
	
		if (!config.getBoolean("enable-item-drop"))
			e.setCancelled(true);
	}
}
