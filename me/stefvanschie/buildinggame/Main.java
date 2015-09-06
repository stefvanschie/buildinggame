package me.stefvanschie.buildinggame;

import me.stefvanschie.buildinggame.events.block.BlockBreak;
import me.stefvanschie.buildinggame.events.block.BlockPlace;
import me.stefvanschie.buildinggame.events.block.JoinSignCreate;
import me.stefvanschie.buildinggame.events.block.LeaveSignCreate;
import me.stefvanschie.buildinggame.events.player.ClickJoinSign;
import me.stefvanschie.buildinggame.events.player.ClickLeaveSign;
import me.stefvanschie.buildinggame.events.player.VoteEvent;
import me.stefvanschie.buildinggame.managers.arenas.ArenaManager;
import me.stefvanschie.buildinggame.managers.arenas.LobbyManager;
import me.stefvanschie.buildinggame.managers.arenas.MaxPlayersManager;
import me.stefvanschie.buildinggame.managers.arenas.MinPlayersManager;
import me.stefvanschie.buildinggame.managers.commands.CommandManager;
import me.stefvanschie.buildinggame.managers.files.SettingsManager;
import me.stefvanschie.buildinggame.managers.mainspawn.MainSpawnManager;
import me.stefvanschie.buildinggame.managers.plots.BoundaryManager;
import me.stefvanschie.buildinggame.managers.plots.LocationManager;
import me.stefvanschie.buildinggame.managers.plots.PlotManager;
import me.stefvanschie.buildinggame.managers.softdependencies.SDBarApi;
import me.stefvanschie.buildinggame.managers.softdependencies.SDVault;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		long start = System.nanoTime();
		getLogger().info("Loading files");
		SettingsManager.getInstance().setup(this);
		
		getLogger().info("Loading arenas");
		ArenaManager.getInstance().setup();
		LobbyManager.getInstance().setup();
		MinPlayersManager.getInstance().setup();
		MaxPlayersManager.getInstance().setup();
		
		getLogger().info("Loading plots");
		PlotManager.getInstance().setup();
		LocationManager.getInstance().setup();
		BoundaryManager.getInstance().setup();
		
		getLogger().info("Loading main spawn");
		MainSpawnManager.getInstance().setup();
		
		getLogger().info("Loading soft dependencies");
		if (Bukkit.getPluginManager().isPluginEnabled("BarAPI")) {
			SDBarApi.getInstance().setup();
		}
		if (Bukkit.getPluginManager().isPluginEnabled("Vault")) {
			SDVault.getInstance().setup();
		}
		
		getLogger().info("Loading listeners");
		Bukkit.getPluginManager().registerEvents(new VoteEvent(), this);
		Bukkit.getPluginManager().registerEvents(new JoinSignCreate(), this);
		Bukkit.getPluginManager().registerEvents(new LeaveSignCreate(), this);
		Bukkit.getPluginManager().registerEvents(new ClickJoinSign(), this);
		Bukkit.getPluginManager().registerEvents(new ClickLeaveSign(), this);
		Bukkit.getPluginManager().registerEvents(new BlockBreak(), this);
		Bukkit.getPluginManager().registerEvents(new BlockPlace(), this);
		
		getLogger().info("Loading commands");
		CommandManager command = new CommandManager();
		command.setup();
		
		getCommand("bg").setExecutor(command);
		getCommand("buildinggame").setExecutor(command);
		
		long end = System.nanoTime();
		double timeTaken = (end - start) / 1000000000;
		
		getLogger().info("BuildingGame has been enabled in " + timeTaken + " seconds!");
		
	}
	
	public void onDisable() {
		instance = null;
		getLogger().info("BuildingGame has been disabled");
	}
	
	public static Main getInstance() {
		return instance;
	}
}
