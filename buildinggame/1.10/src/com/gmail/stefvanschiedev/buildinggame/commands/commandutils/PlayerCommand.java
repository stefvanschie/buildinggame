package com.gmail.stefvanschiedev.buildinggame.commands.commandutils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;

public abstract class PlayerCommand extends SubCommand {

	@Override
	public CommandResult onCommand(CommandSender sender, String[] args) {
		if (!(sender instanceof Player)) {
			MessageManager.getInstance().send(sender, ChatColor.RED + "Only players can perform this commmand");
			return CommandResult.ERROR;
		}
		
		return onCommand((Player) sender, args);
	}
	
	public abstract CommandResult onCommand(Player player, String[] args);
}
