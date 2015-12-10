package me.stefvanschie.buildinggame.events.block;

import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.arenas.SignManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;
import me.stefvanschie.buildinggame.utils.arena.Arena;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class JoinSignCreate implements Listener {

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		Player player = e.getPlayer();
		
		if (!e.getLine(0).equalsIgnoreCase("[buildinggame]")) {
			return;
		}
		if (!e.getLine(1).equalsIgnoreCase("join")) {
			return;
		}
		if (ArenaManager.getInstance().getArena(e.getLine(2)) == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "That's not a valid arena");
			return;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(e.getLine(2));
		
		if (!player.hasPermission("bg.sign.create")) {
			MessageManager.getInstance().send(player, messages.getString("global.permissionNode"));
			return;
		}
		
		int number = 0;
		
		for (String string : signs.getKeys(false)) {
			try {
				number = Integer.parseInt(string);
			} catch (NumberFormatException nfe) {
				continue;
			}
		}
		
		number++;
		
		signs.set(number + ".arena", arena.getName());
		signs.set(number + ".world", e.getBlock().getLocation().getWorld().getName());
		signs.set(number + ".x", e.getBlock().getLocation().getBlockX());
		signs.set(number + ".y", e.getBlock().getLocation().getBlockY());
		signs.set(number + ".z", e.getBlock().getLocation().getBlockZ());
		SettingsManager.getInstance().save();
		
		SignManager.getInstance().setup();
	}
}