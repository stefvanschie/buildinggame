package com.gmail.stefvanschiedev.buildinggame.events.block.signs;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

import java.util.Locale;

/**
 * Handles players creating statistic signs
 *
 * @since 3.1.0
 */
public class StatSignCreate implements Listener {

    /**
     * Handles players creating statistic signs
     *
     * @param e an event indicating that a sign's text has changed
     * @see SignChangeEvent
     * @since 3.1.0
     */
	@EventHandler
	public static void onSignChange(SignChangeEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		if (!e.getLine(0).equalsIgnoreCase("[buildinggame]"))
			return;
		
		String lineOne = e.getLine(1);
		
		if (!lineOne.equalsIgnoreCase("stat") && !lineOne.equalsIgnoreCase("statistic"))
			return;

        var player = e.getPlayer();
		String lineTwo = e.getLine(2);
		StatType type;

		try {
			type = StatType.valueOf(lineTwo.toUpperCase(Locale.getDefault()));
		} catch (IllegalArgumentException ex) {
			MessageManager.getInstance().send(player,
                    ChatColor.RED + "'" + lineTwo + "' isn't a valid statistic");
			return;
		}
		
		String lineThree = e.getLine(3);
		int number;
		
		try {
			number = Integer.parseInt(lineThree);
		} catch (NumberFormatException ex) {
			MessageManager.getInstance().send(player, ChatColor.RED + "'" + lineThree + "' isn't a valid number");
			return;
		}
		
		if (!player.hasPermission("bg.sign.create")) {
			MessageManager.getInstance().send(player, messages.getString("global.permissionNode"));
			return;
		}
		
		int i = 0;
		
		for (var string : signs.getKeys(false)) {
			try {
				i = Integer.parseInt(string);
			} catch (NumberFormatException ignore) {}
		}
		
		i++;

        var location = e.getBlock().getLocation();

        signs.set(i + ".number", number);
		signs.set(i + ".stat", type.toString());
		signs.set(i + ".type", "stat");
		signs.set(i + ".world", location.getWorld().getName());
		signs.set(i + ".x", location.getBlockX());
		signs.set(i + ".y", location.getBlockY());
		signs.set(i + ".z", location.getBlockZ());
		SettingsManager.getInstance().save();

        SignManager.getInstance().setup();

		e.setCancelled(true);
	} 
}