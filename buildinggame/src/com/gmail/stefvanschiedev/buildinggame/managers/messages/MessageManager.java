package com.gmail.stefvanschiedev.buildinggame.managers.messages;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * Utility class for sending and modifying messages
 *
 * @since 2.1.0
 */
public final class MessageManager {

    /**
     * Constructs a new MessageManager. This shouldn't be called to keep this class a singleton.
     */
	private MessageManager() {}

	/**
     * An instance of this class for the singleton principle
     */
	private static final MessageManager INSTANCE = new MessageManager();

	/**
     * Returns the instance of this singleton class
     *
     * @return an instance of this class
     * @since 2.1.0
     */
	@NotNull
	@Contract(pure = true)
    public static MessageManager getInstance() {
		return INSTANCE;
	}

	/**
     * Sends a single message to the player with the prefix appended to the message and the message variables edited
     *
     * @param sender the sender to send the message to
     * @param message the message to send
     * @since 2.1.0
     */
	@Contract("_, null -> fail; null, !null -> fail")
	@SuppressWarnings("MethodMayBeStatic")
    public void send(CommandSender sender, String message) {
		if (message.isEmpty())
			return;
		
		sender.sendMessage(translate(SettingsManager.getInstance().getMessages().getString("global.prefix"))
				+ translate(message));
	}

	/**
     * Sends multiple messages to the player with the prefix appended to the message and the message variables edited
     *
     * @param sender the sender to send the message to
     * @param messages an iterable containing all messages
     * @since 2.1.0
     */
	@SuppressWarnings("MethodMayBeStatic")
    public void send(CommandSender sender, Iterable<String> messages) {
		for (String message : messages) {
			if (message.isEmpty())
				return;
		
			sender.sendMessage(translate(SettingsManager.getInstance().getMessages().getString("global.prefix")) 
					+ translate(message));
		}
	}

	/**
     * Sends a message to the player with edited message variables
     *
     * @param sender the sender to send the message to
     * @param message the message to send
     * @since 2.1.0
     */
	@Contract("_, null -> fail; null, !null -> fail")
	@SuppressWarnings("MethodMayBeStatic")
    public void sendWithoutPrefix(CommandSender sender, String message) {
		if (message.isEmpty())
			return;
		
		sender.sendMessage(translate(message));
	}

	/**
     * Returns the string provided with all variables edited to their values
     *
     * @param s the string to edit the variables in
     * @return the modified string
     * @since 2.1.0
     */
	@NotNull
    @Contract(value = "null -> fail", pure = true)
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
		        .replace("%ss%", "ß")
                .replace("%xayxay%", "Zelda's Lullaby")
                .replace("%axyaxy%", "Epona's Song")
                .replace("%ryxryx%", "Saria's Song")
                .replace("%yrayra%", "Sun's Song")
                .replace("%ylrylr%", "Song of Time")
                .replace("%lralra%", "Song of Storms")
                .replace("%laxyxy%", "Minuet of Forest")
                .replace("%rlrlyryr%", "Bolero of Fire")
                .replace("%lryyx%", "Serenade of Water")
                .replace("%lrlyrl%", "Requiem of Spirit")
                .replace("%xyylxyr%", "Nocturne of Shadow")
                .replace("%ayayxa%", "Prelude of Light"));
	}

	/**
     * Returns a list containing all provided strings with all variables edited to their corresponding values
     *
     * @param s an iterable containing all strings that should be modified
     * @return a list of strings which have been modified
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
	public static List<String> translate(Iterable<String> s) {
		List<String> list = new ArrayList<>();
		
		for (String text : s) {
			list.add(translate(text));
		}
		
		return list;
	}
}