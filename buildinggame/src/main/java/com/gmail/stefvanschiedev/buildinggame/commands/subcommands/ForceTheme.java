package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a command to force a theme to be selected
 *
 * @since 4.0.4
 */
public class ForceTheme extends PlayerCommand {

    /**
     * The method which is called once the correct command is entered
     *
     * @param player the player who entered the command
     * @param args the arguments provided
     * @return the commandresult this execution yielded
     * @see CommandResult
     * @since 4.0.4
     */
	@NotNull
    @Override
	public CommandResult onCommand(Player player, String[] args) {
	    YamlConfiguration messages = SettingsManager.getInstance().getMessages();

		if (args.length < 1) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Please specify a theme");
			return CommandResult.ARGUMENT_EXCEPTION;
		}
		
		Arena arena = ArenaManager.getInstance().getArena(player);
		
		if (arena == null) {
			MessageManager.getInstance().send(player, ChatColor.RED + "You aren't in an arena");
			return CommandResult.ERROR;
		}
		
		String theme = StringUtils.join(args, " ");
		
		if (theme.trim().isEmpty()) {
			MessageManager.getInstance().send(player, ChatColor.RED + "Theme can't be blank");
			return CommandResult.ERROR;
		}
		
		arena.getSubjectMenu().forceTheme(theme);

        for (String message : messages.getStringList("commands.forcetheme.success"))
            MessageManager.getInstance().send(player, message.replace("%theme%", theme));
		
		return CommandResult.SUCCESS;
	}

    /**
     * Returns the name of this subcommand
     *
     * @return the name of this subcommand
     * @since 4.0.4
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getName() {
		return "forcetheme";
	}

    /**
     * Returns an informational message about this subcommand
     *
     * @return an informational message
     * @since 4.0.4
     */
    @Nls
	@NotNull
    @Contract(pure = true)
    @Override
	public String getInfo() {
		return "Forces a theme to be chosen";
	}

    /**
     * Returns the permission node required for this subcommand
     *
     * @return the permission node for this subcommand
     * @since 4.0.4
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getPermission() {
		return "bg.forcetheme";
	}
}