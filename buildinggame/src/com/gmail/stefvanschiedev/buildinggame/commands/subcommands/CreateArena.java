package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Represents a command to create a new arena
 *
 * @since 2.1.0
 */
public class CreateArena extends ConsoleCommand {

    /**
     * The method which is called once the correct command is entered
     *
     * @param sender the sender who executed this command
     * @param args the arguments provided
     * @return the commandresult this execution yielded
     * @see CommandResult
     * @since 2.1.0
     */
	@NotNull
    @Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		YamlConfiguration arenas = SettingsManager.getInstance().getArenas();
		YamlConfiguration config = SettingsManager.getInstance().getConfig();
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (args.length == 0) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Please specify the arena name");
			return CommandResult.ARGUMENT_EXCEPTION;
		}
		
		if (arenas.contains(args[0])) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "That arena does already exists");
			return CommandResult.ERROR;
		}
		
		arenas.createSection(args[0]);
		arenas.set(args[0] + ".mode", "SOLO");
		arenas.set(args[0] + ".timer", config.getInt("timer"));
		arenas.set(args[0] + ".lobby-timer", config.getInt("waittimer"));
		arenas.set(args[0] + ".vote-timer", config.getInt("votetimer"));
		arenas.set(args[0] + ".win-timer", config.getInt("wintimer"));
		SettingsManager.getInstance().save();
		
		ArenaManager.getInstance().setup();
		
		for (String message : messages.getStringList("createArena.succes"))
			MessageManager.getInstance().send(sender, message
					.replace("%arena%", args[0]));
		
		return CommandResult.SUCCESS;
	}

	/**
     * Returns the name of this subcommand
     *
     * @return the name of this subcommand
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getName() {
		return "createarena";
	}

	/**
     * Returns the aliases for this subcommand
     *
     * @return an array of aliases for this subcommand
     * @since 2.1.0
     */
	@Nullable
    @Contract(pure = true)
	@Override
	public String[] getAliases() {
		return null;
	}

	/**
     * Returns an informational message about this subcommand
     *
     * @return an informational message
     * @since 2.1.0
     */
	@Nls
	@NotNull
    @Contract(pure = true)
    @Override
	public String getInfo() {
		return "Create an arena";
	}

	/**
     * Returns the permission node required for this subcommand
     *
     * @return the permission node for this subcommand
     * @since 2.1.0
     */
	@NotNull
    @Contract(pure = true)
    @Override
	public String getPermission() {
		return "bg.createarena";
	}

}