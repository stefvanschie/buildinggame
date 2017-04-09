package com.gmail.stefvanschiedev.buildinggame.commands.subcommands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.CommandResult;
import com.gmail.stefvanschiedev.buildinggame.commands.commandutils.PlayerCommand;
import com.gmail.stefvanschiedev.buildinggame.managers.stats.StatManager;
import com.gmail.stefvanschiedev.buildinggame.utils.stats.StatType;

public class Stats extends PlayerCommand {

	@Override
	public CommandResult onCommand(Player player, String[] args) {
		player.sendMessage(ChatColor.GREEN + "Games played: " + (StatManager.getInstance().getStat(player, StatType.PLAYS) == null ? 0 : StatManager.getInstance().getStat(player, StatType.PLAYS).getValue()));
		player.sendMessage(ChatColor.GREEN + "First places: " + (StatManager.getInstance().getStat(player, StatType.FIRST) == null ? 0 : StatManager.getInstance().getStat(player, StatType.FIRST).getValue()));
		player.sendMessage(ChatColor.GREEN + "Second places: " + (StatManager.getInstance().getStat(player, StatType.SECOND) == null ? 0 : StatManager.getInstance().getStat(player, StatType.SECOND).getValue()));
		player.sendMessage(ChatColor.GREEN + "Third places: " + (StatManager.getInstance().getStat(player, StatType.THIRD) == null ? 0 : StatManager.getInstance().getStat(player, StatType.THIRD).getValue()));
		player.sendMessage(ChatColor.GREEN + "Blocks placed: " + (StatManager.getInstance().getStat(player, StatType.PLACED) == null ? 0 : StatManager.getInstance().getStat(player, StatType.PLACED).getValue()));
		player.sendMessage(ChatColor.GREEN + "Blocks broken: " + (StatManager.getInstance().getStat(player, StatType.BROKEN) == null ? 0 : StatManager.getInstance().getStat(player, StatType.BROKEN).getValue()));
		player.sendMessage(ChatColor.GREEN + "Distance walked: " + (StatManager.getInstance().getStat(player, StatType.WALKED) == null ? 0 : StatManager.getInstance().getStat(player, StatType.WALKED).getValue()));
		return CommandResult.SUCCES;
	}
	
	@Override
	public String getName() {
		return "stats";
	}

	@Override
	public String[] getAliases() {
		return null;
	}

	@Override
	public String getInfo() {
		return "Shows your stats";
	}

	@Override
	public String getPermission() {
		return "bg.stats";
	}
}