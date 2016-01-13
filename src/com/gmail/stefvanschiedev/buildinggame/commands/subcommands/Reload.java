package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.command.CommandSender;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.ConsoleCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public class Reload extends ConsoleCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		
		MessageManager.getInstance().send(sender, "Command disabled due to weird behavior");
		return CommandResult.ERROR;
		/*
		long start = System.nanoTime();
		MessageManager.getInstance().send(player, ChatColor.GOLD + "Loading files");
		SettingsManager.getInstance().setup(Main.getInstance());
		
		MessageManager.getInstance().send(player, ChatColor.GOLD + "Loading arenas");
		ArenaManager.getInstance().setup();
		LobbyManager.getInstance().setup();
		MinPlayersManager.getInstance().setup();
		MaxPlayersManager.getInstance().setup();
		
		MessageManager.getInstance().send(player, ChatColor.GOLD + "Loading plots");
		PlotManager.getInstance().setup();
		LocationManager.getInstance().setup();
		BoundaryManager.getInstance().setup();
		
		MessageManager.getInstance().send(player, ChatColor.GOLD + "Loading main spawn");
		MainSpawnManager.getInstance().setup();
		
		MessageManager.getInstance().send(player, ChatColor.GOLD + "Loading soft dependencies");
		if (Bukkit.getPluginManager().isPluginEnabled("BarAPI")) {
			SDBarApi.getInstance().setup();
		}
		if (Bukkit.getPluginManager().isPluginEnabled("Vault")) {
			SDVault.getInstance().setup();
		}
		
		MessageManager.getInstance().send(player, ChatColor.GOLD + "Loading listeners");
		Bukkit.getPluginManager().registerEvents(new VoteEvent(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new JoinSignCreate(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new LeaveSignCreate(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new ClickJoinSign(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new ClickLeaveSign(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new BlockBreak(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new BlockPlace(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new Leave(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new TakeDamage(), Main.getInstance());
		Bukkit.getPluginManager().registerEvents(new LoseFood(), Main.getInstance());
		
		MessageManager.getInstance().send(player, ChatColor.GOLD + "Loading commands");
		CommandManager command = new CommandManager();
		command.setup();
		
		Main.getInstance().getCommand("bg").setExecutor(command);
		Main.getInstance().getCommand("buildinggame").setExecutor(command);
		
		long end = System.nanoTime();
		double timeTaken = (end - start) / 1000000000;
		
		MessageManager.getInstance().send(player, ChatColor.GREEN + "Reloaded plugin in " + timeTaken + " seconds");
		return CommandResult.SUCCES;
		*/
	}

	@Override
	public String getName() {
		return "reload";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Reload the server";
	}

	@Override
	public String getPermission() {
		return "bg.reload";
	}
}