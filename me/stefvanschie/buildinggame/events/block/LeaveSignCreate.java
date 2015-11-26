package me.stefvanschie.buildinggame.events.block;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

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
		
		String line1 = messages.getString("leave-sign.line-1");
		String line2 = messages.getString("leave-sign.line-2");
		String line3 = messages.getString("leave-sign.line-3");
		String line4 = messages.getString("leave-sign.line-4");
		
		e.setLine(0, line1
				.replaceAll("&", "§"));
		e.setLine(1, line2
				.replaceAll("&", "§"));
		e.setLine(2, line3
				.replaceAll("&", "§"));
		e.setLine(3, line4
				.replaceAll("&", "§"));
	}
}
