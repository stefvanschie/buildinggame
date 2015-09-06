package me.stefvanschie.buildinggame.managers.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.stefvanschie.buildinggame.commands.commandutils.CommandResult;
import me.stefvanschie.buildinggame.commands.commandutils.SubCommand;
import me.stefvanschie.buildinggame.commands.subcommands.CreateArena;
import me.stefvanschie.buildinggame.commands.subcommands.Join;
import me.stefvanschie.buildinggame.commands.subcommands.Leave;
import me.stefvanschie.buildinggame.commands.subcommands.SetBounds;
import me.stefvanschie.buildinggame.commands.subcommands.SetLobby;
import me.stefvanschie.buildinggame.commands.subcommands.SetMainSpawn;
import me.stefvanschie.buildinggame.commands.subcommands.SetMinPlayers;
import me.stefvanschie.buildinggame.commands.subcommands.SetSpawn;
import me.stefvanschie.buildinggame.commands.subcommands.Setting;
import me.stefvanschie.buildinggame.commands.subcommands.VoteCommand;
import me.stefvanschie.buildinggame.managers.messages.MessageManager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager implements CommandExecutor {

	private List<SubCommand> subCommands = new ArrayList<SubCommand>();
	
	public void setup() {
		subCommands.add(new CreateArena());
		subCommands.add(new Join());
		subCommands.add(new Leave());
		subCommands.add(new SetBounds());
		subCommands.add(new SetLobby());
		subCommands.add(new SetMainSpawn());
		subCommands.add(new SetMinPlayers());
		subCommands.add(new SetSpawn());
		subCommands.add(new Setting());
		subCommands.add(new VoteCommand());
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			MessageManager.getInstance().send(sender, "&cOnly players can perform this command");
			return false;
		}
		
		Player player = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("bg")) {
			if (args.length == 0) {
				for (SubCommand sc : subCommands) {
					MessageManager.getInstance().sendWithoutPrefix(player, ChatColor.GREEN + "/bg " + sc.getName() + " - " + sc.getInfo());
				}
				return false;
			}
			
			SubCommand target = getSubCommand(args[0]);
			
			if (target == null) {
				MessageManager.getInstance().send(player, ChatColor.RED + args[0] + " is not valid.");
				return false;
			}
			
			List<String> arguments = new ArrayList<String>();
			arguments.addAll(Arrays.asList(args));
			arguments.remove(0);
			
			args = arguments.toArray(new String[arguments.size()]);
			
			CommandResult result = target.onCommand(player, args);
			
			if (result == CommandResult.SUCCES) {
				return true;
			}
			return false;
		}
		return false;
	}

	private SubCommand getSubCommand(String name) {
		for (SubCommand subCommand : subCommands) {
			if (subCommand.getName().equalsIgnoreCase(name))
				return subCommand;
		}
		return null;
	}
}
