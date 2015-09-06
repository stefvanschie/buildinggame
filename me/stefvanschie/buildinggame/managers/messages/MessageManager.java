package me.stefvanschie.buildinggame.managers.messages;

import me.stefvanschie.buildinggame.managers.files.SettingsManager;

import org.bukkit.command.CommandSender;

public class MessageManager {

	private MessageManager() {}
	
	private static MessageManager instance = new MessageManager();
	
	public static MessageManager getInstance() {
		return instance;
	}
	
	public void send(CommandSender sender, String message) {
		sender.sendMessage(SettingsManager.getInstance().getMessages().getString("global.prefix")
				.replaceAll("&", "§") + message
				.replaceAll("&", "§"));
	}
	
	public void sendWithoutPrefix(CommandSender sender, String message) {
		sender.sendMessage(message
				.replaceAll("&", "§"));
	}
	
}
