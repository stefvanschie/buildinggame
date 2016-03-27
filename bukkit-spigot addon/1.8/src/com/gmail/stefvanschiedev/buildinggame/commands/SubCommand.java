package com.gmail.stefvanschiedev.buildinggame.commands;

import org.bukkit.entity.Player;

public abstract class SubCommand {

	public abstract void onCommand(Player player, String[] args);
	
	public abstract String getName();
}
