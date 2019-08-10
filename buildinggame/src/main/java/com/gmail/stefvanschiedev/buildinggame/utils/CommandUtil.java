package com.gmail.stefvanschiedev.buildinggame.utils;

import org.bukkit.Bukkit;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * A class with utility methods for handling commands
 *
 * @since 7.0.1
 */
public final class CommandUtil {

    /**
     * Private constructor to avoid instantiating this utility class.
     *
     * @since 7.0.1
     */
    @Contract(pure = true)
    private CommandUtil() {}

    /**
     * Dispatches the specified command, with respect for any optionally specified target.
     *
     * @param command the command to disptach
     * @since 7.0.1
     */
    public static void dispatch(@NotNull String command) {
        if (!command.isEmpty() && command.charAt(0) == '@') {
            String targetText = command.split(" ")[0];

            Target.parse(targetText).execute(command.substring(targetText.length() + 1));
        } else {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
        }
    }
}
