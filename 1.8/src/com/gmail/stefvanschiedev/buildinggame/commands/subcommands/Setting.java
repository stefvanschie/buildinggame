package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.SubCommand;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.AllowFlyOutBounds;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.BlockedEntities;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.Blocks;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.CleanFiles;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.CommandWhitelist;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.Commands;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.Debug;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.EnableSubjectVoting;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.Gui;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.MaxParticles;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.MaxVoteChange;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.Mobs;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.Money;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.NamesAfterVoting;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.RestorePlots;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.ScoreboardUpdateDelay;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.Subjects;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.Timer;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.VoteTimer;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.WaitTimer;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.WinCommands;
import com.gmail.stefvanschiedev.buildinggame.commands.subcommands.settings.WinTimer;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class Setting extends ConsoleCommand {
	
	private List<SubCommand> subCommands = new ArrayList<SubCommand>();
	
	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {

		//add settings to list
		subCommands.add(new AllowFlyOutBounds());
		subCommands.add(new BlockedEntities());
		subCommands.add(new Blocks());
		subCommands.add(new CleanFiles());
		subCommands.add(new Commands());
		subCommands.add(new CommandWhitelist());
		subCommands.add(new Debug());
		subCommands.add(new EnableSubjectVoting());
		subCommands.add(new Gui());
		subCommands.add(new MaxParticles());
		subCommands.add(new MaxVoteChange());
		subCommands.add(new Mobs());
		subCommands.add(new Money());
		subCommands.add(new NamesAfterVoting());
		subCommands.add(new RestorePlots());
		subCommands.add(new ScoreboardUpdateDelay());
		subCommands.add(new Subjects());
		subCommands.add(new Timer());
		subCommands.add(new VoteTimer());
		subCommands.add(new WaitTimer());
		subCommands.add(new WinCommands());
		subCommands.add(new WinTimer());
		//test for right setting
		
		if (args.length == 0) {
			for (SubCommand sc : subCommands) {
				MessageManager.getInstance().sendWithoutPrefix(sender, ChatColor.GREEN + "/bg setting " + sc.getName() + " - " + sc.getInfo());
			}
			return CommandResult.ARGUMENTEXCEPTION;
		}
		
		for (SubCommand subCommand : subCommands) {
			if (subCommand.getName().equalsIgnoreCase(args[0])) {
				if (sender.hasPermission(subCommand.getPermission())) {
					//remove first argument
					
					List<String> arguments = new ArrayList<String>();
					arguments.addAll(Arrays.asList(args));
					arguments.remove(0);
					args = arguments.toArray(new String[arguments.size()]);
					
					CommandResult result = subCommand.onCommand(sender, args);
					return result;
				}
			}
		}
		
		MessageManager.getInstance().send(sender, ChatColor.RED + "That's not a setting");
		return CommandResult.ERROR;
	}

	@Override
	public String getName() {
		return "setting";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Change the settings";
	}

	@Override
	public String getPermission() {
		return "bg.setting";
	}

}
