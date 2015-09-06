package me.stefvanschie.buildinggame.events.block;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class LeaveSignCreate implements Listener {

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		Player player = e.getPlayer();
		
		if (!e.getLine(0).equalsIgnoreCase("[buildinggame]")) {
			return;
		}
		if (!e.getLine(1).equalsIgnoreCase("leave")) {
			return;
		}
		if (!player.hasPermission("bg.sign.create")) {
			MessageManager.getInstance().send(player, messages.getString("global.permissionNode"));
			return;
		}
		
		e.setLine(0, ChatColor.BOLD + "BuildingGame");
		e.setLine(1, ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + "leave");
		e.setLine(2, "");
		e.setLine(3, "");
	}
}
