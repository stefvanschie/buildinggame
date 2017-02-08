package com.gmail.stefvanschiedev.buildinggame.events.player.signs;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.block.Sign;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;

import fr.rhaz.socket4mc.Socket4MC;

public class ClickJoinSign implements Listener {

	private Map<String, String> players = new HashMap<>();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		if (e.getAction() != Action.RIGHT_CLICK_BLOCK)
			return;

		if (!(e.getClickedBlock().getState() instanceof Sign))
			return;

		Sign sign = (Sign) e.getClickedBlock().getState();
		
		for (String key : signs.getKeys(false)) {
			if (!signs.getString(key + ".world").equals(sign.getWorld().getName()))
				continue;
			if (signs.getInt(key + ".x") != sign.getX())
				continue;
			if (signs.getInt(key + ".y") != sign.getY())
				continue;
			if (signs.getInt(key + ".z") != sign.getZ())
				continue;
			
			String arenaName = signs.getString(key + ".arena");
			String playerName = e.getPlayer().getName();
			
			Socket4MC.bukkit().getSocketClient().writeJSON("BuildingGame", "connect: " + playerName + ", " + SettingsManager.getInstance().getConfig().getString("main-plugin.server-name"));
			players.put(playerName, arenaName);
		}
	}
	
	@EventHandler
	public void onDisconnect(final PlayerQuitEvent e) {
		if (!players.containsKey(e.getPlayer().getName()))
			return;
		
		BukkitRunnable task = new BukkitRunnable() {
			@Override
			public void run() {
				Socket4MC.bukkit().getSocketClient().writeJSON("BuildingGame", "join: " + e.getPlayer().getName() + ", " + players.get(e.getPlayer().getName()));
			}
		};
		task.runTaskLater(Main.getInstance(), 2L);
	}
}