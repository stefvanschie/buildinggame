package com.gmail.stefvanschiedev.buildinggame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.stefvanschiedev.buildinggame.commands.BuildingGameCommand;
import com.gmail.stefvanschiedev.buildinggame.events.block.JoinSignBreak;
import com.gmail.stefvanschiedev.buildinggame.events.block.JoinSignCreate;
import com.gmail.stefvanschiedev.buildinggame.events.bungeecord.ReceiveMessage;
import com.gmail.stefvanschiedev.buildinggame.events.player.signs.ClickJoinSign;
import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		BuildingGameCommand cmd = new BuildingGameCommand();
		
		getCommand("bg").setExecutor(cmd);
		getCommand("buildinggame").setExecutor(cmd);
		
		Bukkit.getPluginManager().registerEvents(new JoinSignBreak(), this);
		Bukkit.getPluginManager().registerEvents(new JoinSignCreate(), this);
		
		Bukkit.getPluginManager().registerEvents(new ReceiveMessage(), this);
		
		Bukkit.getPluginManager().registerEvents(new ClickJoinSign(), this);
	
		SettingsManager.getInstance().setup(this);
		
		getLogger().info("BuildingGame - BungeeCord Addon has been enabled");
	}
	
	@Override
	public void onDisable() {
		instance = null;
		
		getLogger().info("BuildingGame - BungeeCord Addon has been disabled");
	}
	
	public static Main getInstance() {
		return instance;
	}
}