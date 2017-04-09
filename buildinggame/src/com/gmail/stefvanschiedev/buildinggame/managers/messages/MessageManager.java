package com.gmail.stefvanschiedev.buildinggame.managers.messages;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;

public class MessageManager {

	private MessageManager() {}
	
	private static final MessageManager INSTANCE = new MessageManager();
	
	public static MessageManager getInstance() {
		return INSTANCE;
	}
	
	public void send(CommandSender sender, String message) {
		if (message.equals("")) {
			return;
		}
		
		sender.sendMessage(translate(SettingsManager.getInstance().getMessages().getString("global.prefix"))
				+ translate(message));
	}
	
	public void send(CommandSender sender, List<String> messages) {
		for (String message : messages) {
			if (message.equals("")) {
				return;
			}
		
			sender.sendMessage(translate(SettingsManager.getInstance().getMessages().getString("global.prefix")) 
					+ translate(message));
		}
	}
	
	public void sendWithoutPrefix(CommandSender sender, String message) {
		if (message.equals("")) {
			return;
		}
		
		sender.sendMessage(translate(message));
	}
	
	public static String translate(String s) {
		return ChatColor.translateAlternateColorCodes('&', s
                .replace("%:a%", "ä")
		        .replace("%:e%", "ë")
		        .replace("%:i%", "ï")
		        .replace("%:o%", "ö")
		        .replace("%:u%", "ü")
		        .replace("%:A%", "Ä")
		        .replace("%:E%", "Ë")
		        .replace("%:I%", "Ï")
		        .replace("%:O%", "Ö")
		        .replace("%:U%", "Ü")
		        .replace("%/a%", "á")
		        .replace("%/e%", "é")
		        .replace("%/i%", "í")
		        .replace("%/o%", "ó")
		        .replace("%/u%", "ú")
		        .replace("%ss%", "ß"));
	}
	
	public static List<String> translate(List<String> s) {
		List<String> list = new ArrayList<>();
		
		for (String text : s) {
			list.add(translate(text));
		}
		
		return list;
	}
}