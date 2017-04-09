package com.gmail.stefvanschiedev.buildinggame.events.block;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import com.gmail.stefvanschiedev.buildinggame.files.SettingsManager;

public class JoinSignCreate implements Listener {

	@EventHandler
	public void onSignChange(SignChangeEvent e) {
		YamlConfiguration signs = SettingsManager.getInstance().getSigns();
		
		if (!e.getLine(0).equalsIgnoreCase("[buildinggame]"))
			return;
		if (!e.getLine(1).equalsIgnoreCase("join"))
			return;
		
		int number = signs.getKeys(false).size();
		
		signs.set(number + ".arena", e.getLine(2));
		signs.set(number + ".world", e.getBlock().getLocation().getWorld().getName());
		signs.set(number + ".x", e.getBlock().getLocation().getBlockX());
		signs.set(number + ".y", e.getBlock().getLocation().getBlockY());
		signs.set(number + ".z", e.getBlock().getLocation().getBlockZ());
		SettingsManager.getInstance().save();
	}
}