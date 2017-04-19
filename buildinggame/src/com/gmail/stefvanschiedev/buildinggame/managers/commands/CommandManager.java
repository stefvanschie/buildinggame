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
import org.bukkit.configuration.file.YamlConfiguration;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.SubCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class CommandManager implements CommandExecutor {

	private final Collection<SubCommand> subCommands = new ArrayList<>();
	
	public void setup() {
		subCommands.clear();
		subCommands.add(new CreateArena());
		subCommands.add(new DeleteArena());
		subCommands.add(new DeleteSpawn());
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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		YamlConfiguration messages = SettingsManager.getInstance().getMessages();
		
		if (cmd.getName().equalsIgnoreCase("bg") || cmd.getName().equalsIgnoreCase("buildinggame")) {
			if (args.length == 0) {
				for (SubCommand sc : subCommands) {
					if (sender.hasPermission(sc.getPermission())) {
						MessageManager.getInstance().sendWithoutPrefix(sender, ChatColor.AQUA + "/bg " + sc.getName() + " - " + ChatColor.GOLD + sc.getInfo());
					}
				}
				return false;
			}
			
			SubCommand target = getSubCommand(args[0]);
			
			if (target == null) {
				MessageManager.getInstance().send(sender, ChatColor.RED + args[0] + " is not valid.");
				return false;
			}
			
			if (!sender.hasPermission(target.getPermission())) {
				MessageManager.getInstance().send(sender, messages.getStringList("global.permissionNode"));
				return false;
			}
			
			List<String> arguments = new ArrayList<>(Arrays.asList(args));
            arguments.remove(0);
			
			args = arguments.toArray(new String[arguments.size()]);
			
			CommandResult result = target.onCommand(sender, args);

			return result == CommandResult.SUCCES;
		}
		return false;
	}

	private SubCommand getSubCommand(String name) {
		for (SubCommand subCommand : subCommands) {
			if (subCommand.getName().equalsIgnoreCase(name)) {
				return subCommand;
			}
		}
		return null;
	}
}
