package com.gmail.stefvanschiedev.buildinggame.managers.messages;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class MessageManager {

	private MessageManager() {}
	
	private static final MessageManager INSTANCE = new MessageManager();
	
	@Contract(pure = true)
    public static MessageManager getInstance() {
		return INSTANCE;
	}
	
	@SuppressWarnings("MethodMayBeStatic")
    public void send(CommandSender sender, String message) {
		if (message.isEmpty())
			return;
		
		sender.sendMessage(translate(SettingsManager.getInstance().getMessages().getString("global.prefix"))
				+ translate(message));
	}
	
	@SuppressWarnings("MethodMayBeStatic")
    public void send(CommandSender sender, Iterable<String> messages) {
		for (String message : messages) {
			if (message.isEmpty())
				return;
		
			sender.sendMessage(translate(SettingsManager.getInstance().getMessages().getString("global.prefix")) 
					+ translate(message));
		}
	}
	
	@SuppressWarnings("MethodMayBeStatic")
    public void sendWithoutPrefix(CommandSender sender, String message) {
		if (message.isEmpty())
			return;
		
		sender.sendMessage(translate(message));
	}
	
	@NotNull
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
	
	public static List<String> translate(Iterable<String> s) {
		List<String> list = new ArrayList<>();
		
		for (String text : s) {
			list.add(translate(text));
		}
		
		return list;
	}
}