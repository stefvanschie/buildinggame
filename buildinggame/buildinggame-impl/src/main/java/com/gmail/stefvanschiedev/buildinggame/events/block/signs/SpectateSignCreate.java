package com.gmail.stefvanschiedev.buildinggame.events.block.signs;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.SignManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

/**
 * Handles players creating spectate signs
 *
 * @since 5.4.0
 */
public class SpectateSignCreate implements Listener {

    /**
     * Handles players creating spectate signs
     *
     * @param e an event indicating that a sign's text has changed
     * @see SignChangeEvent
     * @since 5.4.0
     */
	@SuppressWarnings("deprecation")
    @EventHandler
	public void onSignChange(SignChangeEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		var player = e.getPlayer();
		
		if (!e.getLine(0).equalsIgnoreCase("[buildinggame]"))
			return;
		
		if (!e.getLine(1).equalsIgnoreCase("spectate"))
			return;

		if (!player.hasPermission("bg.sign.create")) {
			MessageManager.getInstance().send(player, messages.getString("global.permissionNode"));
			return;
		}

        String line = e.getLine(2);

		if (line.isEmpty()) {
		    MessageManager.getInstance().send(player, ChatColor.RED + "Please specify a player");
		    return;
        }

		int number = 0;
		
		for (String string : signs.getKeys(false)) {
			try {
				number = Integer.parseInt(string);
			} catch (NumberFormatException ignore) {}
		}
		
		number++;

        var location = e.getBlock().getLocation();

        signs.set(number + ".player", Bukkit.getOfflinePlayer(line).getUniqueId().toString());
		signs.set(number + ".type", "spectate");
		signs.set(number + ".world", location.getWorld().getName());
		signs.set(number + ".x", location.getBlockX());
		signs.set(number + ".y", location.getBlockY());
		signs.set(number + ".z", location.getBlockZ());
		SettingsManager.getInstance().save();
		
		SignManager.getInstance().setup();

		e.setCancelled(true);
	}
}