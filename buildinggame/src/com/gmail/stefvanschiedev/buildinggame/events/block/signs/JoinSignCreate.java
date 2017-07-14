package com.gmail.stefvanschiedev.buildinggame.events.block.signs;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;

/**
 * Handles players creating join signs
 *
 * @since 3.1.0
 */
public class JoinSignCreate implements Listener {

    /**
     * Handles players creating join signs
     *
     * @param e an event indicating that a sign's text has changed
     * @see SignChangeEvent
     * @since 3.1.0
     */
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		Player player = e.getPlayer();
		
		if (!e.getLine(0).equalsIgnoreCase("[buildinggame]"))
			return;
		
		if (!e.getLine(1).equalsIgnoreCase("join"))
			return;
		
		Arena arena = ArenaManager.getInstance().getArena(e.getLine(2));
		
		if (!player.hasPermission("bg.sign.create")) {
			MessageManager.getInstance().send(player, messages.getString("global.permissionNode"));
			return;
		}
		
		int number = 0;
		
		for (String string : signs.getKeys(false)) {
			try {
				number = Integer.parseInt(string);
			} catch (NumberFormatException nfe) {}
		}
		
		number++;
		
		signs.set(number + ".arena", arena == null ? "" : arena.getName());
		signs.set(number + ".type", "join");
		signs.set(number + ".world", e.getBlock().getLocation().getWorld().getName());
		signs.set(number + ".x", e.getBlock().getLocation().getBlockX());
		signs.set(number + ".y", e.getBlock().getLocation().getBlockY());
		signs.set(number + ".z", e.getBlock().getLocation().getBlockZ());
		SettingsManager.getInstance().save();
		
		SignManager.getInstance().setup();

		e.setCancelled(true);
	}
}