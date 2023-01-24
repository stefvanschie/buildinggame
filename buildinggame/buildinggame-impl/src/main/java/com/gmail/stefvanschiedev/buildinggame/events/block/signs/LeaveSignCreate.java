package com.gmail.stefvanschiedev.buildinggame.events.block.signs;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

/**
 * Handles players creating leave signs
 *
 * @since 3.1.0
 */
public class LeaveSignCreate implements Listener {

    /**
     * Handles players breaking join signs
     *
     * @param e an event indicating that a sign's text has changed
     * @see SignChangeEvent
     * @since 3.1.0
     */
	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		var player = e.getPlayer();
		
		if (!e.getLine(0).equalsIgnoreCase("[buildinggame]") ||
                !e.getLine(1).equalsIgnoreCase("leave"))
			return;
			
		if (!player.hasPermission("bg.sign.create")) {
			MessageManager.getInstance().send(player, messages.getString("global.permissionNode"));
			return;
		}
		
		e.setLine(0, MessageManager.translate(messages.getString("signs.leave.line-1")));
		e.setLine(1, MessageManager.translate(messages.getString("signs.leave.line-2")));
		e.setLine(2, MessageManager.translate(messages.getString("signs.leave.line-3")));
		e.setLine(3, MessageManager.translate(messages.getString("signs.leave.line-4")));
		
		int number = 0;
		
		for (var string : signs.getKeys(false)) {
			try {
				number = Integer.parseInt(string);
			} catch (NumberFormatException ignore) {}
		}
		
		number++;

        var location = e.getBlock().getLocation();

        signs.set(number + ".type", "leave");
		signs.set(number + ".world", location.getWorld().getName());
		signs.set(number + ".x", location.getBlockX());
		signs.set(number + ".y", location.getBlockY());
		signs.set(number + ".z", location.getBlockZ());
		SettingsManager.getInstance().save();
		
		SignManager.getInstance().setup();
	}
}