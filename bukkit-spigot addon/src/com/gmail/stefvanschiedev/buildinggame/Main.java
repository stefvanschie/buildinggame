package com.gmail.stefvanschiedev.buildinggame;

import com.gmail.stefvanschiedev.buildinggame.utils.JoinSign;
import com.gmail.stefvanschiedev.buildinggame.utils.bungeecord.BungeeCordHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.stefvanschiedev.buildinggame.commands.BuildingGameCommand;
import com.gmail.stefvanschiedev.buildinggame.events.block.JoinSignBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.JoinSignCreate;
import com.gmail.stefvanschiedev.buildinggame.events.player.signs.ClickJoinSign;
import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		CommandExecutor cmd = new BuildingGameCommand();
		
		getCommand("bg").setExecutor(cmd);
		getCommand("buildinggame").setExecutor(cmd);
		
		Bukkit.getPluginManager().registerEvents(new JoinSignBreak(), this);
		Bukkit.getPluginManager().registerEvents(new JoinSignCreate(), this);
		
		Bukkit.getPluginManager().registerEvents(new ClickJoinSign(), this);

        Bukkit.getPluginManager().registerEvents(BungeeCordHandler.getInstance(), this);
	
		SettingsManager.getInstance().setup(this);
        JoinSign.load();
		
		getLogger().info("BuildingGame - BungeeCord Addon has been enabled");
	}
	
	@Override
	public void onDisable() {
		instance = null;
		
		getLogger().info("BuildingGame - BungeeCord Addon has been disabled");
	}
	
	public static Plugin getInstance() {
		return instance;
	}
}