package com.gmail.stefvanschiedev.buildinggame.managers.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.*;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.SubCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

/**
 * This class handles all subcommands for the buildinggame command
 *
 * @since 2.1.0
 */
public class CommandManager implements CommandExecutor {

    /**
     * A collection of all registered subcommands
     */
	private final Collection<SubCommand> subCommands = new ArrayList<>();

	/**
     * Loads/Reloads all subcommands
     *
     * @since 2.1.0
     */
	public void setup() {
		subCommands.clear();
		subCommands.add(new BoosterCommand());
		subCommands.add(new CreateArena());
		subCommands.add(new DeleteArena());
		subCommands.add(new DeleteSpawn());
		subCommands.add(new EnableMoney());
		subCommands.add(new ForceStart());
		subCommands.add(new ForceTheme());
		subCommands.add(new Join());
		subCommands.add(new LeaveCommand());
		subCommands.add(new ListCommand());
		subCommands.add(new Reload());
		subCommands.add(new SetBounds());
		subCommands.add(new SetFloor());
		subCommands.add(new SetGameMode());
		subCommands.add(new SetLobby());
		subCommands.add(new SetLobbyTimer());
		subCommands.add(new SetMainSpawn());
		subCommands.add(new SetMatches());
		subCommands.add(new SetMaxPlayers());
		subCommands.add(new SetMinPlayers());
		subCommands.add(new SetSpawn());
		subCommands.add(new SetTimer());
		subCommands.add(new Setting());
		subCommands.add(new SetVoteTimer());
		subCommands.add(new SetWinTimer());
		subCommands.add(new Spectate());
		subCommands.add(new Stats());
		subCommands.add(new VoteCommand());
	}

	/**
     * This methods is called when the main buildinggame command is executed an dwill search for the correct subcommand
     * to execute
     *
     * @param sender the sender who executed the command
     * @param cmd the command executed
     * @param label the command name entered
     * @param args the arguments provided
     * @return a boolean indicating the result of this execution
     * @since 2.1.0
     */
	@Contract("null, _, _, _ -> fail; _, null, _, _ -> fail; _, _, _, null -> fail")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        YamlConfiguration messages = SettingsManager.getInstance().getMessages();

        String name = cmd.getName();

        if (name.equalsIgnoreCase("bg") || name.equalsIgnoreCase("buildinggame")) {
			if (args.length == 0) {
				for (SubCommand sc : subCommands) {
					if (sender.hasPermission(sc.getPermission()))
						MessageManager.getInstance().sendWithoutPrefix(sender, ChatColor.AQUA + "/bg " + sc.getName() + " - " + ChatColor.GOLD + sc.getInfo());
				}

				return false;
			}
			
			SubCommand target = getSubCommand(args[0]);
			
			if (target == null) {
                for (String message : messages.getStringList("commands.invalid"))
                    MessageManager.getInstance().send(sender, message.replace("%argument%", args[0]));

				return false;
			}
			
			if (!sender.hasPermission(target.getPermission())) {
				MessageManager.getInstance().send(sender, messages.getStringList("global.permissionNode"));
				return false;
			}
			
			List<String> arguments = new ArrayList<>(Arrays.asList(args));
            arguments.remove(0);

			return target.onCommand(sender, arguments.toArray(new String[arguments.size()])) == CommandResult.SUCCESS;
		}

		return false;
	}

    /**
     * Returns the subcommand by the given name or null if there is no registered subcommand with the given name
     *
     * @param name the name of the subcommand
     * @return the subcommand by the given name or null if there is no subcommand with the given name
     * @see SubCommand
     * @since 2.1.0
     */
	@Nullable
    @Contract("null -> null")
    private SubCommand getSubCommand(String name) {
		for (SubCommand subCommand : subCommands) {
			if (subCommand.getName().equalsIgnoreCase(name))
				return subCommand;
		}

		return null;
	}
}