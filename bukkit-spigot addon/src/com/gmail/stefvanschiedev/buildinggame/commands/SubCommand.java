package com.gmail.stefvanschiedev.buildinggame.commands;

import org.bukkit.entity.Player;

public abstract class SubCommand {

	public abstract void onCommand(Player player, @SuppressWarnings("unused") String[] args);
	
	@SuppressWarnings("SameReturnValue")
    public abstract String getName();
}
